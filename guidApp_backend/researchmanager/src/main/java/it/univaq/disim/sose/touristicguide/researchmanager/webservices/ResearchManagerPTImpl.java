package it.univaq.disim.sose.touristicguide.researchmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionByCreatorFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionByCreatorRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionByCreatorResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionDetailFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionDetailRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionDetailResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchCategoryFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchCategoryRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchCategoryResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventByCreatorFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventByCreatorRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventByCreatorResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventDetailFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventDetailRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventDetailResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchManagerPT;
import it.univaq.disim.sose.touristicguide.researchmanager.business.ResearchManagerService;


@Component(value = "ResearchManagerPTImpl")
public class ResearchManagerPTImpl implements ResearchManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ResearchManagerPTImpl.class);
	
	@Autowired
	ResearchManagerService service;

	@Override
	public ResearchAttractionResponse researchAttraction(ResearchAttractionRequest parameters) throws ResearchAttractionFault_Exception {
		
		LOGGER.info("called Research Attraction in Research Manager");
		
		ResearchAttractionResponse response = new ResearchAttractionResponse();
		response = service.researchAttraction(parameters);
		
		LOGGER.info(response.getMessage());
		
		return response;
	}
	
	@Override
	public ResearchAttractionByCreatorResponse researchAttractionByCreator(ResearchAttractionByCreatorRequest parameters) throws ResearchAttractionByCreatorFault_Exception {
		
		LOGGER.info("called Research Attraction By Creator in Research Manager");
		
		ResearchAttractionByCreatorResponse response = new ResearchAttractionByCreatorResponse();
		response = service.researchAttractionByCreator(parameters);
		
		LOGGER.info(response.getMessage());
		LOGGER.info(response.getAttractionsList().getAttractionElement().toString());
		
		return response;
	}

	@Override
	public ResearchAttractionDetailResponse researchAttractionDetail(ResearchAttractionDetailRequest parameters)
			throws ResearchAttractionDetailFault_Exception {
		
		LOGGER.info("called Research Attraction Detail in Research Manager");
		
		ResearchAttractionDetailResponse response = new ResearchAttractionDetailResponse();
		response = service.researchAttractionDetail(parameters);
		
		LOGGER.info(response.getMessage());
		
		return response;
	}
	
	@Override
	public ResearchEventResponse researchEvent(ResearchEventRequest parameters) throws ResearchEventFault_Exception {
		
		LOGGER.info("called Research Event in Research Manager");
		
		ResearchEventResponse response = new ResearchEventResponse();
		response = service.researchEvent(parameters);
		
		LOGGER.info(response.getMessage());
		
		return response;
	}


	@Override
	public ResearchEventByCreatorResponse researchEventByCreator(ResearchEventByCreatorRequest parameters)
			throws ResearchEventByCreatorFault_Exception {
		
		LOGGER.info("called Research Event By Creator in Research Manager");
		
		ResearchEventByCreatorResponse response = new ResearchEventByCreatorResponse();
		response = service.researchEventByCreator(parameters);
		
		LOGGER.info(response.getMessage());
		
		return response;
	}


	@Override
	public ResearchEventDetailResponse researchEventDetail(ResearchEventDetailRequest parameters)
			throws ResearchEventDetailFault_Exception {
		
		LOGGER.info("called Research Event Details in Research Manager");
		
		ResearchEventDetailResponse response = new ResearchEventDetailResponse();
		response = service.researchEventDetail(parameters);
		
		LOGGER.info(response.getMessage());
		
		return response;
	}

	@Override
	public ResearchCategoryResponse researchCategory(ResearchCategoryRequest parameters)
			throws ResearchCategoryFault_Exception {
		
		LOGGER.info("called Research Category in Research Manager");
		
		ResearchCategoryResponse response = new ResearchCategoryResponse();
		response = service.researchCategory(parameters);
		
		LOGGER.info(response.getMessage());
		
		return response;
	}
}
