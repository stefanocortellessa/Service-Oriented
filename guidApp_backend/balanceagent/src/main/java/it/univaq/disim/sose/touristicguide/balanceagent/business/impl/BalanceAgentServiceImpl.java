package it.univaq.disim.sose.touristicguide.balanceagent.business.impl;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.springframework.stereotype.Service;

import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreFault_Exception;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreRequest;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreResponse;
import it.univaq.disim.sose.touristicguide.balanceagent.business.BalanceAgentService;

@Service
public class BalanceAgentServiceImpl implements BalanceAgentService {

	@Override
	public GetServerScoreResponse getServerScore(GetServerScoreRequest parameters)
			throws GetServerScoreFault_Exception, MalformedObjectNameException {
		//LOGGER.info("Called GetServerInfo method on LoadBalancerServiceImpl");
		GetServerScoreResponse response = new GetServerScoreResponse();
		response.setScore(getServersInfo());
		response.setMessage("Server score returned correctly");
		return response;
	}
	
	private double getServersInfo() throws MalformedObjectNameException {
		//LOGGER.info("Called getServersInfo method on LoadBalancerServiceImpl");
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
	    ObjectName mbeanNameMem = new ObjectName("java.lang:type=Memory");
	    ObjectName mbeanNameThread = new ObjectName("java.lang:type=Threading");
	    ObjectName mbeanNameOS = new ObjectName("java.lang:type=OperatingSystem");

	    MemoryMXBean mxbeanMemory = JMX.newMXBeanProxy(mbs, mbeanNameMem, MemoryMXBean.class, true);
	    ThreadMXBean mxbeanThread = JMX.newMXBeanProxy(mbs, mbeanNameThread, ThreadMXBean.class, true);
	    OperatingSystemMXBean mxbeanOS = JMX.newMXBeanProxy(mbs, mbeanNameOS, OperatingSystemMXBean.class, true);

	    MemoryUsage memUsage = mxbeanMemory.getHeapMemoryUsage();
	    int threadCount = mxbeanThread.getThreadCount();
	    double load = mxbeanOS.getSystemLoadAverage();   
	    System.out.println("\nMemory Utilization: " + (memUsage.getUsed()/(double)memUsage.getMax()) * 100 +  "%");
	    System.out.println("\nThread Count: " + threadCount);
	    System.out.println("\nServer load: " + load);
	    System.out.println("Server Score: " + ((load*1) + ((memUsage.getUsed()/(double)memUsage.getMax())*1) + ((threadCount/100)*1)));
		return ((load*0.1) + ((memUsage.getUsed()/(double)memUsage.getMax())*0.5) + ((threadCount/100)*0.4));
	    //return ((memUsage.getUsed()/(double)memUsage.getMax()) + threadCount);
	}

}
