package it.univaq.disim.sose.touristicguide.loadbalancer.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.touristicguide.loadbalancer.business.LoadBalancerService;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.LoadBalancerPT;

@Component(value = "LoadBalancerPTImpl")
public class LoadBalancerPTImpl implements LoadBalancerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoadBalancerPTImpl.class);

	@Autowired
	LoadBalancerService service;

	@Override
	public GetServerInfoResponse getServerInfo(GetServerInfoRequest parameters) throws GetServerInfoFault_Exception {
		
		LOGGER.info("CALLED getServerInfo ON Load Balancer");
		
		GetServerInfoResponse response = service.getServerInfo(parameters);
		
		return response;
	}
}
