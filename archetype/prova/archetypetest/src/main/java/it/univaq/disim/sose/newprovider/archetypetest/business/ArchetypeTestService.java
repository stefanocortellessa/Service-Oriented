package it.univaq.disim.sose.newprovider.archetypetest.business;

import it.univaq.disim.sose.newprovider.archetypetest.Fault_Exception;
import it.univaq.disim.sose.newprovider.archetypetest.Request;
import it.univaq.disim.sose.newprovider.archetypetest.Response;

public interface ArchetypeTestService {
	
	Response operationName(Request parameters) throws Fault_Exception;	

}
