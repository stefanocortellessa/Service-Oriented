package it.univaq.disim.sose.newprovider.archetypetest.webservices;

import org.springframework.stereotype.Component;

import it.univaq.disim.sose.newprovider.archetypetest.Fault_Exception;
import it.univaq.disim.sose.newprovider.archetypetest.Request;
import it.univaq.disim.sose.newprovider.archetypetest.Response;
import it.univaq.disim.sose.newprovider.archetypetest.ArchetypeTestPT;

@Component(value = "ArchetypeTestPTImpl")
public class ArchetypeTestPTImpl implements ArchetypeTestPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ArchetypeTestPTImpl.class);

	@Override
	public Response operationName(Request parameters) throws Fault_Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
