package it.univaq.disim.sose.eventmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.eventmanager.business.EventManagerService;
import it.univaq.disim.sose.eventmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.eventmanager.CheckSessionRequest;
import it.univaq.disim.sose.eventmanager.CheckSessionResponse;
import it.univaq.disim.sose.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.eventmanager.UpdateEventFault_Exception;
import it.univaq.disim.sose.eventmanager.UpdateEventRequest;
import it.univaq.disim.sose.eventmanager.UpdateEventResponse;
import it.univaq.disim.sose.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.eventmanager.EventManagerPT;
import it.univaq.disim.sose.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.eventmanager.InsertEventResponse;

@Component(value = "EventManagerPTImpl")
public class EventManagerPTImpl implements EventManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(EventManagerPTImpl.class);
	
	@Autowired
	EventManagerService service;

	@Override
	public InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception {
		
		LOGGER.info("called Insert Event in Event Manager Service");
		InsertEventResponse response = new InsertEventResponse();
		response = service.insertEvent(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}

	@Override
	public DeleteEventResponse deleteEvent(DeleteEventRequest parameters) throws DeleteEventFault_Exception {
		
		LOGGER.info("called Delete Event in Event Manager Service");
		DeleteEventResponse response = new DeleteEventResponse();
		response = service.deleteEvent(parameters);
		LOGGER.info(response.getMessage());
		return response;
	}
	
	@Override
	public UpdateEventResponse updateEvent(UpdateEventRequest parameters) throws UpdateEventFault_Exception {
		
		LOGGER.info("called Update Event in Event Manager Service");
		UpdateEventResponse response = new UpdateEventResponse();
		response = service.updateEvent(parameters);
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
