package it.univaq.disim.sose.attractionmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.attractionmanager.business.AttractionManagerService;
import it.univaq.disim.sose.attractionmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.attractionmanager.CheckSessionRequest;
import it.univaq.disim.sose.attractionmanager.CheckSessionResponse;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionRequest;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionResponse;
import it.univaq.disim.sose.attractionmanager.InsertAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.AttractionManagerPT;
import it.univaq.disim.sose.attractionmanager.InsertAttractionRequest;
import it.univaq.disim.sose.attractionmanager.InsertAttractionResponse;


@Component(value = "AttractionManagerPTImpl")
public class AttractionManagerPTImpl implements AttractionManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AttractionManagerPTImpl.class);
	
	@Autowired
	AttractionManagerService service;

	@Override
	public InsertAttractionResponse insertAttraction(InsertAttractionRequest parameters) throws InsertAttractionFault_Exception {
		
		LOGGER.info("called Insert Attraction in AttractionManger Service");
		InsertAttractionResponse response = new InsertAttractionResponse();
		response = service.insertAttraction(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}

	@Override
	public DeleteAttractionResponse deleteAttraction(DeleteAttractionRequest parameters) throws DeleteAttractionFault_Exception {
		
		LOGGER.info("called Delete Attraction in Insert Service");
		DeleteAttractionResponse response = new DeleteAttractionResponse();
		response = service.deleteAttraction(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}

	@Override
	public CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception {
		
		LOGGER.info("called Check Session in Insert Service");
		CheckSessionResponse response = new CheckSessionResponse();
		response = service.checkSession(parameters);
		return response;
	}

}
