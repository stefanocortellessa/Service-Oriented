package it.univaq.disim.sose.eventmanager.business;

import it.univaq.disim.sose.eventmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.eventmanager.CheckSessionRequest;
import it.univaq.disim.sose.eventmanager.CheckSessionResponse;
import it.univaq.disim.sose.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.eventmanager.InsertEventResponse;

public interface EventManagerService {
	
	InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception;

	DeleteEventResponse deleteEvent(DeleteEventRequest parameters) throws DeleteEventFault_Exception;
	
	CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception;
}
