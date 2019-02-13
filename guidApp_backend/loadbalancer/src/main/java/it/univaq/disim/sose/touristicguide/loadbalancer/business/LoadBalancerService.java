package it.univaq.disim.sose.touristicguide.loadbalancer.business;

import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoResponse;

public interface LoadBalancerService {
	
	GetServerInfoResponse getServerInfo(GetServerInfoRequest parameters) throws GetServerInfoFault_Exception;

}
