package it.univaq.disim.sose.routingrequests.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.prosumer.EventInsertRequest;
import it.univaq.disim.sose.prosumer.EventInsertResponse;
import it.univaq.disim.sose.prosumer.EventUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.EventUpdateRequest;
import it.univaq.disim.sose.prosumer.EventUpdateResponse;
import it.univaq.disim.sose.prosumer.ProsumerPT;
import it.univaq.disim.sose.prosumer.ProsumerService;
import it.univaq.disim.sose.routingrequests.model.Event;
import it.univaq.disim.sose.routingrequests.model.Utility.Utility;

@RestController
public class EventController {
	
	Utility utility = new Utility();
		
	@PostMapping("/insertEvent")
	public EventInsertResponse insertEvent(@RequestBody Event event) throws EventInsertFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventInsertResponse response = new EventInsertResponse();
		EventInsertRequest request = new EventInsertRequest();
		
		request.setTitle(event.getTitle());
		request.setLocality(event.getLocality());
		request.setCategoryId(event.getCategory().getId());
		request.setCategoryName(event.getCategory().getName());

		request.setCreatorId(event.getCreator().getId());
		request.setStartDate(utility.convertToXML(event.getStartDate()));
		request.setEndDate(utility.convertToXML(event.getEndDate()));
		
		
		response = prosumer.eventInsert(request);
		
		return response;
	}
	
	@DeleteMapping("/deleteEvent")
	public EventDeleteResponse deleteEvent(@RequestBody Event event) throws EventDeleteFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventDeleteResponse response = new EventDeleteResponse();
		EventDeleteRequest request = new EventDeleteRequest();
		
		request.setId(event.getId());
		request.setUserId(event.getCreator().getId());
		response = prosumer.eventDelete(request);
		
		return response;
	}
	
	@PutMapping("/updateEvent")
	public EventUpdateResponse updateEvent(@RequestBody Event event) throws EventUpdateFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventUpdateResponse response = new EventUpdateResponse();
		EventUpdateRequest request = new EventUpdateRequest();
		
		request.setId(event.getId());
		request.setTitle(event.getTitle());
		request.setLocality(event.getLocality());
		request.setStartDate(utility.convertToXML(event.getStartDate()));
		request.setEndDate(utility.convertToXML(event.getEndDate()));
		request.setCategoryName(event.getCategory().getName());
		request.setCategoryId(event.getCategory().getId());
		request.setCreatorId(event.getCreator().getId());
		
		response = prosumer.eventUpdate(request);
		
		return response;
	}
}
