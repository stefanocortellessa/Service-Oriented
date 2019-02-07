package it.univaq.disim.sose.researchmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorResponse;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailResponse;
import it.univaq.disim.sose.researchmanager.ResearchAttractionFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventResponse;
import it.univaq.disim.sose.researchmanager.ResearchManagerPT;
import it.univaq.disim.sose.researchmanager.business.ResearchManagerService;


@Component(value = "ResearchManagerPTImpl")
public class ResearchManagerPTImpl implements ResearchManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ResearchManagerPTImpl.class);
	
	@Autowired
	ResearchManagerService service;

	@Override
	public ResearchAttractionResponse researchAttraction(ResearchAttractionRequest parameters) throws ResearchAttractionFault_Exception {
		
		LOGGER.info("called Research Attraction in Research Manager Service");
		ResearchAttractionResponse response = new ResearchAttractionResponse();
		response = service.researchAttraction(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}
	
	@Override
	public ResearchAttractionByCreatorResponse researchAttractionByCreator(ResearchAttractionByCreatorRequest parameters) throws ResearchAttractionByCreatorFault_Exception {
		
		LOGGER.info("called Research Attraction By Creator in Research Manager Service");
		ResearchAttractionByCreatorResponse response = new ResearchAttractionByCreatorResponse();
		response = service.researchAttractionByCreator(parameters);
		LOGGER.info(response.getMessage());
		LOGGER.info(response.getAttractionsList().getAttractionElement().toString());
		return response;
	}

	@Override
	public ResearchAttractionDetailResponse researchAttractionDetail(ResearchAttractionDetailRequest parameters)
			throws ResearchAttractionDetailFault_Exception {
		
		LOGGER.info("called Research Attraction Detail in Research Manager Service");
		ResearchAttractionDetailResponse response = new ResearchAttractionDetailResponse();
		response = service.researchAttractionDetail(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}
	
	@Override
	public ResearchEventResponse researchEvent(ResearchEventRequest parameters) throws ResearchEventFault_Exception {
		
		LOGGER.info("called Research Event in Research Manager Service");
		ResearchEventResponse response = new ResearchEventResponse();
		response = service.researchEvent(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}


	@Override
	public ResearchEventByCreatorResponse researchEventByCreator(ResearchEventByCreatorRequest parameters)
			throws ResearchEventByCreatorFault_Exception {
		
		LOGGER.info("called Research Event By Creator in Research Manager Service");
		ResearchEventByCreatorResponse response = new ResearchEventByCreatorResponse();
		response = service.researchEventByCreator(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}


	@Override
	public ResearchEventDetailResponse researchEventDetail(ResearchEventDetailRequest parameters)
			throws ResearchEventDetailFault_Exception {
		LOGGER.info("called Research Event Details in Research Manager Service");
		ResearchEventDetailResponse response = new ResearchEventDetailResponse();
		response = service.researchEventDetail(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}


}
