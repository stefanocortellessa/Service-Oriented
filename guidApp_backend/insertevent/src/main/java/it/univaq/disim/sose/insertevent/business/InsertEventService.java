package it.univaq.disim.sose.insertevent.business;

import it.univaq.disim.sose.insertevent.CheckSessionFault_Exception;
import it.univaq.disim.sose.insertevent.CheckSessionRequest;
import it.univaq.disim.sose.insertevent.CheckSessionResponse;
import it.univaq.disim.sose.insertevent.DeleteEventFault_Exception;
import it.univaq.disim.sose.insertevent.DeleteEventRequest;
import it.univaq.disim.sose.insertevent.DeleteEventResponse;
import it.univaq.disim.sose.insertevent.InsertEventFault_Exception;
import it.univaq.disim.sose.insertevent.InsertEventRequest;
import it.univaq.disim.sose.insertevent.InsertEventResponse;

public interface InsertEventService {
	
	InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception;

	DeleteEventResponse deleteEvent(DeleteEventRequest parameters) throws DeleteEventFault_Exception;
	
	CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception;
}
