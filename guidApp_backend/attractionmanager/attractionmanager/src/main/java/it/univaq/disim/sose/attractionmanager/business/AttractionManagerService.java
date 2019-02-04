package it.univaq.disim.sose.attractionmanager.business;

import it.univaq.disim.sose.attractionmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.attractionmanager.CheckSessionRequest;
import it.univaq.disim.sose.attractionmanager.CheckSessionResponse;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionRequest;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionResponse;
import it.univaq.disim.sose.attractionmanager.InsertAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.InsertAttractionRequest;
import it.univaq.disim.sose.attractionmanager.InsertAttractionResponse;

public interface AttractionManagerService {
	
	InsertAttractionResponse insertAttraction(InsertAttractionRequest parameters) throws InsertAttractionFault_Exception;

	DeleteAttractionResponse deleteAttraction(DeleteAttractionRequest parameters) throws DeleteAttractionFault_Exception;
	
	CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception;
}
