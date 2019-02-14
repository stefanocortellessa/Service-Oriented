package it.univaq.disim.sose.touristicguide.loadbalancer.business.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.touristicguide.balanceagent.BalanceAgentPT;
import it.univaq.disim.sose.touristicguide.balanceagent.BalanceAgentService;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreFault_Exception;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreRequest;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.business.LoadBalancerService;


@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {

	@Autowired
	private DataSource dataSource;

	private static Logger LOGGER = LoggerFactory.getLogger(LoadBalancerServiceImpl.class);
	private ScheduledExecutorService executor;

	private boolean threadStarted = false;
	private HashMap<String,Double> serverScoresMap = new HashMap<String,Double>();
	private HashMap<String, HashMap<String,Double>> scoresMap = new HashMap<String, HashMap<String,Double>>();
	private List<String> ports = Arrays.asList("8100", "8110");
	private List<String> providers = Arrays.asList("accountManager", "eventManager", "attractionManager", "researchManager");

	public List<String> selectProviders() {

		Connection con = null;
		List<String> return_list = new ArrayList<String>();

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String query = "SELECT name FROM providers";
		PreparedStatement sql = null;
		try {

			sql = con.prepareStatement(query);

			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				return_list.add(rs.getString("name"));
			}
			System.out.println(return_list.toString());
			return return_list;
		} catch (SQLException e) {
			return return_list;
		}finally {
			if (sql != null) {
				try {
					sql.close();
				} catch (SQLException e) {
				}
			}
		}						
	}


	@Override
	public GetServerInfoResponse getServerInfo(GetServerInfoRequest request) throws GetServerInfoFault_Exception {
		
		if(!threadStarted) {
			executor = Executors.newSingleThreadScheduledExecutor();
			executor.scheduleAtFixedRate(new Runnable() {
				public void run() {
					LOGGER.info("Called 'run' method on checkServerScore");

					try {
						// for each instance of the service calculates the response time, then "return" the better.
						checkServerScore(request);
					} catch (GetServerInfoFault_Exception e) {
						new GetServerInfoFault_Exception(e.getMessage());
					}

				}

			}, 0, 500, TimeUnit.MILLISECONDS);
		}
		threadStarted = true;
		checkServerScore(request);
		GetServerInfoResponse response = new GetServerInfoResponse();
		scoresMap = checkServerScore(request);		

		response.setServerPort(getBestPort(scoresMap.get(request.getServiceName())));
		return response;
	}


	private HashMap<String, HashMap<String,Double>> checkServerScore(GetServerInfoRequest request) throws GetServerInfoFault_Exception  {

		for(String port : ports) {

			String url = "http://localhost:"+port+"/balanceagent/services/balanceagent";
			BalanceAgentService balanceAgentService = new BalanceAgentService();
			BalanceAgentPT balanceAgent = balanceAgentService.getBalanceAgentPort();

			BindingProvider bp = (BindingProvider)balanceAgent;

			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

			GetServerScoreRequest getServerScoreRequest = new GetServerScoreRequest();

			try {
				GetServerScoreResponse getServerScoreResponse = balanceAgent.getServerScore(getServerScoreRequest);
				serverScoresMap.put(port, getServerScoreResponse.getScore());
			} catch (GetServerScoreFault_Exception e) {
				e.printStackTrace();
				throw new GetServerInfoFault_Exception("Something was wrong with Get Server Info");
			}

		}
		for(String provider : providers) {
			scoresMap.put(provider, serverScoresMap);
		}

		return scoresMap;
	}


	public String getBestPort(HashMap<String,Double> map) {

		Entry<String, Double> min = Collections.min(map.entrySet(), new Comparator<Entry<String, Double>>() {
			public int compare(Entry<String, Double> entry1, Entry<String, Double> entry2) {
				return entry1.getValue().compareTo(entry2.getValue());
			}
		});
		return min.getKey();

	}
}
