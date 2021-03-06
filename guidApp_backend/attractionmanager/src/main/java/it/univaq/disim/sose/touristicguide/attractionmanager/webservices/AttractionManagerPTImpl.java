package it.univaq.disim.sose.touristicguide.attractionmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionResponse;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionResponse;
import it.univaq.disim.sose.touristicguide.attractionmanager.business.AttractionManagerService;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.AttractionManagerPT;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionResponse;

@Component(value = "AttractionManagerPTImpl")
public class AttractionManagerPTImpl implements AttractionManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AttractionManagerPTImpl.class);
	
	@Autowired
	AttractionManagerService service;

	@Override
	public InsertAttractionResponse insertAttraction(InsertAttractionRequest parameters) throws InsertAttractionFault_Exception {
		
		LOGGER.info("called Insert Attraction in Attraction Manager");
		
		InsertAttractionResponse response = new InsertAttractionResponse();
		response = service.insertAttraction(parameters);
		
		return response;
	}

	@Override
	public DeleteAttractionResponse deleteAttraction(DeleteAttractionRequest parameters) throws DeleteAttractionFault_Exception {
		
		LOGGER.info("called Delete Attraction in Attraction Manager");
		
		DeleteAttractionResponse response = new DeleteAttractionResponse();
		response = service.deleteAttraction(parameters);
		
		return response;
	}
	
	@Override
	public UpdateAttractionResponse updateAttraction(UpdateAttractionRequest parameters) throws UpdateAttractionFault_Exception {
		
		LOGGER.info("called Update Attraction in Attraction Manager");
		
		UpdateAttractionResponse response = new UpdateAttractionResponse();
		response = service.updateAttraction(parameters);
		
		return response;
	}

}
