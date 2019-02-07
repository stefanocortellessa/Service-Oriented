package it.univaq.disim.sose.routingrequests.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.prosumer.AttractionDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionDeleteRequest;
import it.univaq.disim.sose.prosumer.AttractionDeleteResponse;
import it.univaq.disim.sose.prosumer.AttractionInsertFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionInsertRequest;
import it.univaq.disim.sose.prosumer.AttractionInsertResponse;
import it.univaq.disim.sose.prosumer.AttractionUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionUpdateRequest;
import it.univaq.disim.sose.prosumer.AttractionUpdateResponse;
import it.univaq.disim.sose.prosumer.ProsumerPT;
import it.univaq.disim.sose.prosumer.ProsumerService;
import it.univaq.disim.sose.routingrequests.model.Attraction;

@RestController
public class AttractionController {

	@PostMapping("/insertAttraction")
	public AttractionInsertResponse insertAttraction(@RequestBody Attraction attraction) throws AttractionInsertFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AttractionInsertResponse response = new AttractionInsertResponse();
		AttractionInsertRequest request = new AttractionInsertRequest();
		
		request.setName(attraction.getName());
		request.setLocality(attraction.getLocality());
		request.setCategoryName(attraction.getCategory().getName());
		request.setCategoryId(attraction.getCategory().getId());
		request.setCreatorId(attraction.getCreator().getId());
		
		response = prosumer.attractionInsert(request);
		
		return response;
	}
	
	@DeleteMapping("/deleteAttraction")
	public AttractionDeleteResponse deleteAttraction(@RequestBody Attraction attraction) throws AttractionDeleteFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AttractionDeleteResponse response = new AttractionDeleteResponse();
		AttractionDeleteRequest request = new AttractionDeleteRequest();
		
		request.setId(attraction.getId());
		request.setUserId(attraction.getCreator().getId());
		
		response = prosumer.attractionDelete(request);
		
		return response;
	}
	@PutMapping("/updateAttraction")
	public AttractionUpdateResponse updateAttraction(@RequestBody Attraction attraction) throws AttractionUpdateFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AttractionUpdateResponse response = new AttractionUpdateResponse();
		AttractionUpdateRequest request = new AttractionUpdateRequest();
		
		request.setId(attraction.getId());
		request.setName(attraction.getName());
		request.setLocality(attraction.getLocality());
		request.setCategoryId(attraction.getCategory().getId());
		request.setCategoryName(attraction.getCategory().getName());
		request.setCreatorId(attraction.getCreator().getId());
		
		
		response = prosumer.attractionUpdate(request);
		
		return response;
	}	
}
