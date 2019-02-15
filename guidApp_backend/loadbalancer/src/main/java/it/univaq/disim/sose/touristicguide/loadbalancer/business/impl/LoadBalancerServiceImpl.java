package it.univaq.disim.sose.touristicguide.loadbalancer.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
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
import it.univaq.disim.sose.touristicguide.loadbalancer.business.UtilityJDBC;
import it.univaq.disim.sose.touristicguide.loadbalancer.business.model.Provider;
import it.univaq.disim.sose.touristicguide.loadbalancer.business.model.Server;


@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {
	
	@Autowired
	DataSource dataSource;
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoadBalancerServiceImpl.class);
	private ScheduledExecutorService executor;
	private List<Server> servers = new ArrayList<Server>();
	private List<Provider> providers = new ArrayList<Provider>();
	public  HashMap<String, HashMap<String,Double>> scoresMapGlobal = new HashMap<String, HashMap<String,Double>>();
	
	public HashMap<String, HashMap<String, Double>> getScoresMapGlobal() {
		return scoresMapGlobal;
	}

	public void setScoresMapGlobal(HashMap<String, HashMap<String, Double>> scoresMapGlobal) {
		this.scoresMapGlobal = scoresMapGlobal;
	}

	//Starts after service startup and runs a thread which builds an HashMap with server scores for each service
	@PostConstruct
	public void startThread() {
		UtilityJDBC utility = new UtilityJDBC();
		this.servers = utility.selectServers(dataSource);
		this.providers = utility.selectProviders(dataSource);
		executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new Runnable() {
			
			public void run() {
				
				try {
					// for each instance of the service calculates the response time, then "return" the better.
					LOGGER.info("Called 'run' method on checkServerScore");
					checkServerScore();
				} catch (GetServerInfoFault_Exception e) {
					new GetServerInfoFault_Exception(e.getMessage());
				}
			}
		}, 0, 500, TimeUnit.MILLISECONDS);
	
	}
	
	@Override
	public GetServerInfoResponse getServerInfo(GetServerInfoRequest request) throws GetServerInfoFault_Exception {
		
		GetServerInfoResponse response = new GetServerInfoResponse();
		response.setServerPort(getBestPort(this.getScoresMapGlobal().get(request.getServiceName())));
		LOGGER.info("Best server for service "+request.getServiceName()+" is "+response.getServerPort());
		response.setMessage("Best server for service "+request.getServiceName()+" is "+response.getServerPort() );
		return response;
	}


	private void checkServerScore() throws GetServerInfoFault_Exception  {
		HashMap<String,Double> serverScoresMap = new HashMap<String,Double>();
		HashMap<String, HashMap<String,Double>> scoresMap = new HashMap<String, HashMap<String,Double>>();
		
		for(Server server : this.servers) {

			String url = server.getUrl()+":"+server.getPort()+"/balanceagent/services/balanceagent";
			BalanceAgentService balanceAgentService = new BalanceAgentService();
			BalanceAgentPT balanceAgent = balanceAgentService.getBalanceAgentPort();
			GetServerScoreRequest getServerScoreRequest = new GetServerScoreRequest();

			BindingProvider bp = (BindingProvider)balanceAgent;

			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

			try {
				GetServerScoreResponse getServerScoreResponse = balanceAgent.getServerScore(getServerScoreRequest);
				serverScoresMap.put(server.getUrl()+":"+server.getPort(), getServerScoreResponse.getScore());
			} catch (GetServerScoreFault_Exception e) {
				e.printStackTrace();
				throw new GetServerInfoFault_Exception("Something went wrong with Get Server Info");
			}
		}
		for(Provider provider : this.providers) {
			scoresMap.put(provider.getName(), serverScoresMap);
		}
		this.setScoresMapGlobal(scoresMap);
		return;
	}

	//Method that returns the Server's port with higher score
	public String getBestPort(HashMap<String,Double> map) {

		Entry<String, Double> min = Collections.min(map.entrySet(), new Comparator<Entry<String, Double>>() {
			public int compare(Entry<String, Double> entry1, Entry<String, Double> entry2) {
				
				return entry1.getValue().compareTo(entry2.getValue());
			}
		});
		
		return min.getKey();
	}
}
