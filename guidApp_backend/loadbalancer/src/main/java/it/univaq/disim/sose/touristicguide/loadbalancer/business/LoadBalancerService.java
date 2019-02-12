package it.univaq.disim.sose.touristicguide.loadbalancer.business;

import java.io.IOException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;

import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceResponse;

public interface LoadBalancerService {
	
	CheckBalanceResponse checkBalance(CheckBalanceRequest parameters) throws CheckBalanceFault_Exception, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException, MBeanException, IOException;
	
}
