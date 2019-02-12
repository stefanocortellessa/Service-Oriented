package it.univaq.disim.sose.touristicguide.loadbalancer.webservices;

import java.io.IOException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.touristicguide.loadbalancer.business.LoadBalancerService;
import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.LoadBalancerPT;

@Component(value = "LoadBalancerPTImpl")
public class LoadBalancerPTImpl implements LoadBalancerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoadBalancerPTImpl.class);

	@Autowired
	LoadBalancerService service;
	
	@Override
	public CheckBalanceResponse checkBalance(CheckBalanceRequest parameters) throws CheckBalanceFault_Exception, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException, MBeanException, IOException {
		LOGGER.info("called User Login in Account Service");
		CheckBalanceResponse response = new CheckBalanceResponse();
		response = service.checkBalance(parameters);
		return response;
	}

	
}
