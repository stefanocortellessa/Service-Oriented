package it.univaq.disim.sose.researchmanager.business;

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

public interface ResearchManagerService {
	
	ResearchAttractionResponse researchAttraction(ResearchAttractionRequest parameters) throws ResearchAttractionFault_Exception;

	ResearchAttractionDetailResponse researchAttractionDetail(ResearchAttractionDetailRequest parameters) throws ResearchAttractionDetailFault_Exception;

	ResearchAttractionByCreatorResponse researchAttractionByCreator(ResearchAttractionByCreatorRequest parameters) throws ResearchAttractionByCreatorFault_Exception;
	
	ResearchEventResponse researchEvent(ResearchEventRequest parameters) throws ResearchEventFault_Exception;

	ResearchEventDetailResponse researchEventDetail(ResearchEventDetailRequest parameters) throws ResearchEventDetailFault_Exception;

	ResearchEventByCreatorResponse researchEventByCreator(ResearchEventByCreatorRequest parameters) throws ResearchEventByCreatorFault_Exception;

}
