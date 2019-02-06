package it.univaq.disim.sose.routingrequests.controller;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.prosumer.EventInsertRequest;
import it.univaq.disim.sose.prosumer.EventInsertResponse;
import it.univaq.disim.sose.prosumer.ProsumerPT;
import it.univaq.disim.sose.prosumer.ProsumerService;
import it.univaq.disim.sose.routingrequests.model.Event;

@RestController
public class EventController {
	

	@DeleteMapping("/deleteEvent")
	public EventDeleteResponse deleteEvent(@RequestBody Event event) throws EventDeleteFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventDeleteResponse response = new EventDeleteResponse();
		EventDeleteRequest request = new EventDeleteRequest();
		
		request.setId(event.getId());
		request.setUserId(event.getCreatorId());
		response = prosumer.eventDelete(request);
		
		return response;
	}
	
	@PostMapping("/insertEvent")
	public EventInsertResponse insertEvent(@RequestBody Event event) throws EventInsertFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		EventInsertResponse response = new EventInsertResponse();
		EventInsertRequest request = new EventInsertRequest();
		
		request.setTitle(event.getTitle());
		request.setLocality(event.getLocality());
		request.setCategoryId(event.getCategoryId());
		request.setCreatorId(event.getCreatorId());
		request.setStartDate(this.convertToXML(event.getStartDate()));
		request.setEndDate(this.convertToXML(event.getEndDate()));
		
		
		response = prosumer.eventInsert(request);
		
		return response;
	}
	
	public XMLGregorianCalendar convertToXML(Date date){
		
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
        }
        return xmlCalendar;
    }
}
