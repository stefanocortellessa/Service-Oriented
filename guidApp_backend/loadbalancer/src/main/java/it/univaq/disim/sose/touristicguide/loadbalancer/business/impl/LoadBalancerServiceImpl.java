package it.univaq.disim.sose.touristicguide.loadbalancer.business.impl;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.net.MalformedURLException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.CheckBalanceResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.business.LoadBalancerService;


@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {

	private static Logger LOGGER = LoggerFactory.getLogger(LoadBalancerServiceImpl.class);

	@Override
	public CheckBalanceResponse checkBalance(CheckBalanceRequest parameters) throws CheckBalanceFault_Exception, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException, MBeanException, IOException {
		LOGGER.info("Called checkBalance method on LoadBalancerServiceImpl");
		CheckBalanceResponse response = new CheckBalanceResponse();
		response.setServerPort(String.valueOf(getServersInfo()));
		response.setMessage("Server stats returned correctly");
		return response;
	}
	
	private double getServersInfo() throws CheckBalanceFault_Exception, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException, MBeanException, IOException {
		LOGGER.info("Called getServersInfo method on LoadBalancerServiceImpl");
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
	    ObjectName mbeanNameMem = new ObjectName("java.lang:type=Memory");
	    ObjectName mbeanNameThread = new ObjectName("java.lang:type=Threading");
	    MemoryMXBean mxbeanMemory = JMX.newMXBeanProxy(mbs, mbeanNameMem, MemoryMXBean.class, true);
	    ThreadMXBean mxbeanThread = JMX.newMXBeanProxy(mbs, mbeanNameThread, ThreadMXBean.class, true);
	    MemoryUsage memUsage = mxbeanMemory.getHeapMemoryUsage();
	    int threadCount = mxbeanThread.getThreadCount();
	    System.out.println("\nMemory Utilization: " + (memUsage.getUsed()/(double)memUsage.getMax()) * 100 +  "%");
	    System.out.println("\nThread Count: " + threadCount);
	    
		return (memUsage.getUsed()/(double)memUsage.getMax() * 100) + threadCount;
		

	}
}
