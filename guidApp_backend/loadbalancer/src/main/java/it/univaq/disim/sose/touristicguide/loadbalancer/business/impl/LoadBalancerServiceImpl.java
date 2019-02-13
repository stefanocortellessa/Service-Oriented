package it.univaq.disim.sose.touristicguide.loadbalancer.business.impl;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.touristicguide.balanceAgent.BalanceAgentPT;
import it.univaq.disim.sose.touristicguide.balanceAgent.BalanceAgentService;
import it.univaq.disim.sose.touristicguide.balanceAgent.GetServerScoreFault_Exception;
import it.univaq.disim.sose.touristicguide.balanceAgent.GetServerScoreRequest;
import it.univaq.disim.sose.touristicguide.balanceAgent.GetServerScoreResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.business.LoadBalancerService;


@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {

	private static Logger LOGGER = LoggerFactory.getLogger(LoadBalancerServiceImpl.class);
	private ScheduledExecutorService executor;
	
	private HashMap<String,Double> serverScoresMap = new HashMap<String,Double>();
	private HashMap<String, HashMap<String,Double>> scoresMap = new HashMap<String, HashMap<String,Double>>();
	private List<String> ports = Arrays.asList("8080","8100");
	private List<String> services = Arrays.asList("accountManager","attractionManager", "eventManager",
			"researchManager");
	

	@Override
	public GetServerInfoResponse getServerInfo(GetServerInfoRequest request) throws GetServerInfoFault_Exception {
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

		}, 0, 5000, TimeUnit.MILLISECONDS);
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
		for(String service : services) {
			scoresMap.put(service, serverScoresMap);
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
