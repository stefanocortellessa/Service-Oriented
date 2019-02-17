package it.univaq.disim.sose.touristicguide.routingrequests.controller;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;

import it.univaq.disim.sose.touristicguide.prosumer.AttractionByCreatorResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionByCreatorResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionByCreatorResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDetailResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDetailResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDetailResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventByCreatorResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventByCreatorResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventByCreatorResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventDetailResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventDetailResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventDetailResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.ProsumerPT;
import it.univaq.disim.sose.touristicguide.prosumer.ProsumerService;

@RestController
public class ResearchController {
	
	@GetMapping("/user/{id}/events")
	@ResponseBody
	public EventByCreatorResearchResponse researchEventByCreator(@PathVariable(value = "id") Long id) throws EventByCreatorResearchFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventByCreatorResearchResponse response = new EventByCreatorResearchResponse();
		EventByCreatorResearchRequest request = new EventByCreatorResearchRequest();
		
		request.setCreatorId(id);
		
		response = prosumer.eventByCreatorResearch(request);
		
		return response;
	}
	
	
	@GetMapping("/user/{id}/attractions")
	@ResponseBody
	public AttractionByCreatorResearchResponse researchAttractionByCreator(@PathVariable(value = "id") Long id) throws AttractionByCreatorResearchFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AttractionByCreatorResearchResponse response = new AttractionByCreatorResearchResponse();
		AttractionByCreatorResearchRequest request = new AttractionByCreatorResearchRequest();
		
		request.setCreatorId(id);
		
		response = prosumer.attractionByCreatorResearch(request);
		
		return response;
	}
	
	
	@GetMapping("/attractions")
	@ResponseBody
	public AttractionResearchResponse researchAttraction(@RequestParam(required = false) String name, @RequestParam(required = false) String locality, @RequestParam(required = false) Long categoryId) throws AttractionResearchFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AttractionResearchResponse response = new AttractionResearchResponse();
		AttractionResearchRequest request = new AttractionResearchRequest();
		
		request.setName(name);
		request.setLocality(locality);
		request.setCategoryId(categoryId);
				
		response = prosumer.attractionResearch(request);
		
		return response;
	}
	
	@GetMapping("/events")
	@ResponseBody
	public EventResearchResponse researchEvent(@RequestParam(required = false) String title, @RequestParam(required = false) String locality, 
			@RequestParam(required = false) Long categoryId, @RequestParam(required = false) String date) throws EventResearchFault_Exception, DatatypeConfigurationException {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventResearchResponse response = new EventResearchResponse();
		EventResearchRequest request = new EventResearchRequest();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		Date dateString;
		
		request.setTitle(title);
		request.setLocality(locality);
		request.setCategoryId(categoryId);
		
		try {
			if(date != null) {
				dateString = format.parse(date);
	
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(dateString);
	
				XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
	
				request.setDate(xmlGregCal);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response = prosumer.eventResearch(request);
		
		return response;
	}
	
	
	@GetMapping("/attractions/{id}")
	@ResponseBody
	public AttractionDetailResearchResponse researchDetailAttraction(@PathVariable(value = "id") Long id) throws AttractionDetailResearchFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AttractionDetailResearchResponse response = new AttractionDetailResearchResponse();
		AttractionDetailResearchRequest request = new AttractionDetailResearchRequest();
		
		request.setId(id);
				
		response = prosumer.attractionDetailResearch(request);
		
		return response;
	}
	
	@GetMapping("/events/{id}")
	@ResponseBody
	public EventDetailResearchResponse researchDetailEvent(@PathVariable(value = "id") Long id) throws EventDetailResearchFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventDetailResearchResponse response = new EventDetailResearchResponse();
		EventDetailResearchRequest request = new EventDetailResearchRequest();
		
		request.setId(id);
				
		response = prosumer.eventDetailResearch(request);
		return response;
	}
	
	@GetMapping({"/categories/{id}", "/categories"})
	@ResponseBody
	public CategoryResearchResponse researchCategory(@PathVariable(value = "id") Optional<Long> id) throws CategoryResearchFault_Exception, ApiException, InterruptedException, IOException {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		CategoryResearchResponse response = new CategoryResearchResponse();
		CategoryResearchRequest request = new CategoryResearchRequest();
		if (id.isPresent()) {
			request.setId(id.get());
		}
		response = prosumer.categoryResearch(request);
		
		return response;
	}
}
