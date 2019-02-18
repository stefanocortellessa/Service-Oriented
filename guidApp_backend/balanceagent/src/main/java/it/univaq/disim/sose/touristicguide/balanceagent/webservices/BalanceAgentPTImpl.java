package it.univaq.disim.sose.touristicguide.balanceagent.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.touristicguide.balanceagent.BalanceAgentPT;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreFault_Exception;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreRequest;
import it.univaq.disim.sose.touristicguide.balanceagent.GetServerScoreResponse;
import it.univaq.disim.sose.touristicguide.balanceagent.business.BalanceAgentService;

@Component(value = "BalanceAgentPTImpl")
public class BalanceAgentPTImpl implements BalanceAgentPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BalanceAgentPTImpl.class);
	
	@Autowired
	BalanceAgentService service;

	@Override
	public GetServerScoreResponse getServerScore(GetServerScoreRequest parameters)
			throws GetServerScoreFault_Exception {
		
		LOGGER.info("called Check Session in Insert Service");
		
		GetServerScoreResponse response = new GetServerScoreResponse();
		response = service.getServerScore(parameters);
		
		return response;
	}
}

