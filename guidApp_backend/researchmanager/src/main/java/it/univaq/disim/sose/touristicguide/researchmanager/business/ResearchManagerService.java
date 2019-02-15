package it.univaq.disim.sose.touristicguide.researchmanager.business;

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

public interface ResearchManagerService {
	
	ResearchAttractionResponse researchAttraction(ResearchAttractionRequest parameters) throws ResearchAttractionFault_Exception;

	ResearchAttractionDetailResponse researchAttractionDetail(ResearchAttractionDetailRequest parameters) throws ResearchAttractionDetailFault_Exception;

	ResearchAttractionByCreatorResponse researchAttractionByCreator(ResearchAttractionByCreatorRequest parameters) throws ResearchAttractionByCreatorFault_Exception;
	
	ResearchEventResponse researchEvent(ResearchEventRequest parameters) throws ResearchEventFault_Exception;

	ResearchEventDetailResponse researchEventDetail(ResearchEventDetailRequest parameters) throws ResearchEventDetailFault_Exception;

	ResearchEventByCreatorResponse researchEventByCreator(ResearchEventByCreatorRequest parameters) throws ResearchEventByCreatorFault_Exception;
	
	ResearchCategoryResponse researchCategory(ResearchCategoryRequest parameters) throws ResearchCategoryFault_Exception;
}
