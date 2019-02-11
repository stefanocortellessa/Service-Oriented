package it.univaq.disim.sose.touristicguide.routingrequests.controller;


import java.io.IOException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;

import it.univaq.disim.sose.touristicguide.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateResponse;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingRequest;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingResponse;
import it.univaq.disim.sose.touristicguide.prosumer.ProsumerPT;
import it.univaq.disim.sose.touristicguide.prosumer.ProsumerService;
import it.univaq.disim.sose.touristicguide.routingrequests.model.Event;
import it.univaq.disim.sose.touristicguide.routingrequests.model.Utility.Utility;

@RestController
public class EventController {
	
	Utility utility = new Utility();
		
	@PostMapping("/events")
	public EventInsertResponse insertEvent(@RequestBody Event event) throws EventInsertFault_Exception, GoogleGeocodingFault_Exception, ApiException, InterruptedException, IOException {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventInsertResponse response = new EventInsertResponse();
		EventInsertRequest request = new EventInsertRequest();
		
		GoogleGeocodingResponse geocoding_response = new GoogleGeocodingResponse();
		GoogleGeocodingRequest geocoding_request = new GoogleGeocodingRequest();
		geocoding_request.setLocality(event.getLocality());
		geocoding_response = prosumer.googleGeocoding(geocoding_request);
		
		request.setTitle(event.getTitle());
		request.setLocality(event.getLocality());
		request.setCategoryId(event.getCategory().getId());
		request.setCategoryName(event.getCategory().getName());

		request.setCreatorId(event.getCreator().getId());
		request.setStartDate(utility.convertToXML(event.getStartDate()));
		request.setEndDate(utility.convertToXML(event.getEndDate()));
		
		request.setLat(geocoding_response.getLat());
		request.setLng(geocoding_response.getLng());
		
		response = prosumer.eventInsert(request);
		
		return response;
	}
	
	
	
	@DeleteMapping("/events")
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
	
	@PutMapping("/events")
	public EventUpdateResponse updateEvent(@RequestBody Event event) throws EventUpdateFault_Exception, GoogleGeocodingFault_Exception, ApiException, InterruptedException, IOException {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventUpdateResponse response = new EventUpdateResponse();
		EventUpdateRequest request = new EventUpdateRequest();
	
		GoogleGeocodingResponse geocoding_response = new GoogleGeocodingResponse();
		GoogleGeocodingRequest geocoding_request = new GoogleGeocodingRequest();
		geocoding_request.setLocality(event.getLocality());
		geocoding_response = prosumer.googleGeocoding(geocoding_request);
		
		request.setId(event.getId());
		request.setTitle(event.getTitle());
		request.setLocality(event.getLocality());
		request.setStartDate(utility.convertToXML(event.getStartDate()));
		request.setEndDate(utility.convertToXML(event.getEndDate()));
		request.setCategoryName(event.getCategory().getName());
		request.setCategoryId(event.getCategory().getId());
		request.setCreatorId(event.getCreator().getId());

		request.setLat(geocoding_response.getLat());
		request.setLng(geocoding_response.getLng());
		
		response = prosumer.eventUpdate(request);
		
		return response;
	}
}
