package it.univaq.disim.sose.touristicguide.balanceagent.business;

import javax.management.MalformedObjectNameException;

import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreFault_Exception;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreRequest;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreResponse;

public interface BalanceAgentService {
	
	GetServerScoreResponse getServerScore(GetServerScoreRequest parameters) throws GetServerScoreFault_Exception, MalformedObjectNameException;
}
