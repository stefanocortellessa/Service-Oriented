package it.univaq.disim.sose.routingrequests.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.prosumer.EventByCreatorResearchFault_Exception;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchRequest;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchResponse;
import it.univaq.disim.sose.prosumer.ProsumerPT;
import it.univaq.disim.sose.prosumer.ProsumerService;

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
	
	
	
}
