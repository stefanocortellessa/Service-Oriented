package it.univaq.disim.sose.touristicguide.eventmanager.business;

import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventResponse;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventResponse;

public interface EventManagerService {
	
	InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception;

	DeleteEventResponse deleteEvent(DeleteEventRequest parameters) throws DeleteEventFault_Exception;
	
	UpdateEventResponse updateEvent(UpdateEventRequest parameters) throws UpdateEventFault_Exception;

}
