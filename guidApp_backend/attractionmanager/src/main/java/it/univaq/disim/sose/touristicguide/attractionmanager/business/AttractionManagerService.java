package it.univaq.disim.sose.touristicguide.attractionmanager.business;

import it.univaq.disim.sose.touristicguide.attractionmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.CheckSessionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.CheckSessionResponse;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionResponse;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionResponse;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionResponse;

public interface AttractionManagerService {
	
	InsertAttractionResponse insertAttraction(InsertAttractionRequest parameters) throws InsertAttractionFault_Exception;

	DeleteAttractionResponse deleteAttraction(DeleteAttractionRequest parameters) throws DeleteAttractionFault_Exception;
	
	UpdateAttractionResponse updateAttraction(UpdateAttractionRequest parameters) throws UpdateAttractionFault_Exception;

	CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception;
}
