package it.univaq.disim.sose.insertevent.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.insertevent.CheckSessionFault_Exception;
import it.univaq.disim.sose.insertevent.CheckSessionRequest;
import it.univaq.disim.sose.insertevent.CheckSessionResponse;
import it.univaq.disim.sose.insertevent.DeleteEventFault_Exception;
import it.univaq.disim.sose.insertevent.DeleteEventRequest;
import it.univaq.disim.sose.insertevent.DeleteEventResponse;
import it.univaq.disim.sose.insertevent.InsertEventFault_Exception;
import it.univaq.disim.sose.insertevent.InsertEventPT;
import it.univaq.disim.sose.insertevent.InsertEventRequest;
import it.univaq.disim.sose.insertevent.InsertEventResponse;
import it.univaq.disim.sose.insertevent.business.InsertEventService;

@Component(value = "InsertEventPTImpl")
public class InsertEventPTImpl implements InsertEventPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(InsertEventPTImpl.class);
	
	@Autowired
	InsertEventService service;

	@Override
	public InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception {
		
		LOGGER.info("called Insert Event in Insert Service");
		InsertEventResponse response = new InsertEventResponse();
		response = service.insertEvent(parameters);
		
		return response;
	}

	@Override
	public DeleteEventResponse deleteEvent(DeleteEventRequest parameters) throws DeleteEventFault_Exception {
		
		LOGGER.info("called Delete Event in Insert Service");
		DeleteEventResponse response = new DeleteEventResponse();
		response = service.deleteEvent(parameters);
		
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
