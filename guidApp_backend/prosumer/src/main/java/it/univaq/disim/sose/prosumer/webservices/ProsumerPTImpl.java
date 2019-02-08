package it.univaq.disim.sose.prosumer.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.prosumer.AccountLoginFault_Exception;
import it.univaq.disim.sose.prosumer.AccountLoginRequest;
import it.univaq.disim.sose.prosumer.AccountLoginResponse;
import it.univaq.disim.sose.prosumer.AccountLogoutFault_Exception;
import it.univaq.disim.sose.prosumer.AccountLogoutRequest;
import it.univaq.disim.sose.prosumer.AccountLogoutResponse;
import it.univaq.disim.sose.prosumer.AccountSessionFault_Exception;
import it.univaq.disim.sose.prosumer.AccountSessionRequest;
import it.univaq.disim.sose.prosumer.AccountSessionResponse;
import it.univaq.disim.sose.prosumer.AccountSignupFault_Exception;
import it.univaq.disim.sose.prosumer.AccountSignupRequest;
import it.univaq.disim.sose.prosumer.AccountSignupResponse;
import it.univaq.disim.sose.prosumer.AttractionByCreatorResearchFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionByCreatorResearchRequest;
import it.univaq.disim.sose.prosumer.AttractionByCreatorResearchResponse;
import it.univaq.disim.sose.prosumer.AttractionDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionDeleteRequest;
import it.univaq.disim.sose.prosumer.AttractionDeleteResponse;
import it.univaq.disim.sose.prosumer.AttractionDetailResearchFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionDetailResearchRequest;
import it.univaq.disim.sose.prosumer.AttractionDetailResearchResponse;
import it.univaq.disim.sose.prosumer.AttractionInsertFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionInsertRequest;
import it.univaq.disim.sose.prosumer.AttractionInsertResponse;
import it.univaq.disim.sose.prosumer.AttractionResearchFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionResearchRequest;
import it.univaq.disim.sose.prosumer.AttractionResearchResponse;
import it.univaq.disim.sose.prosumer.AttractionUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionUpdateRequest;
import it.univaq.disim.sose.prosumer.AttractionUpdateResponse;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchFault_Exception;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchRequest;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchResponse;
import it.univaq.disim.sose.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.prosumer.EventDetailResearchFault_Exception;
import it.univaq.disim.sose.prosumer.EventDetailResearchRequest;
import it.univaq.disim.sose.prosumer.EventDetailResearchResponse;
import it.univaq.disim.sose.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.prosumer.EventInsertRequest;
import it.univaq.disim.sose.prosumer.EventInsertResponse;
import it.univaq.disim.sose.prosumer.EventResearchFault_Exception;
import it.univaq.disim.sose.prosumer.EventResearchRequest;
import it.univaq.disim.sose.prosumer.EventResearchResponse;
import it.univaq.disim.sose.prosumer.EventUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.EventUpdateRequest;
import it.univaq.disim.sose.prosumer.EventUpdateResponse;
import it.univaq.disim.sose.prosumer.ProsumerPT;
import it.univaq.disim.sose.prosumer.business.ProsumerService;

@Component(value = "ProsumerPTImpl")
public class ProsumerPTImpl implements ProsumerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProsumerPTImpl.class);
	
	@Autowired
	ProsumerService service;

	@Override
	public AccountSignupResponse userSignup(AccountSignupRequest parameters) throws AccountSignupFault_Exception {
		LOGGER.info("CALLED userSignup ON prosumer");
		AccountSignupResponse response = service.userSignup(parameters);
		return response;
	}
	@Override
	public AccountLoginResponse userLogin(AccountLoginRequest parameters) throws AccountLoginFault_Exception {
		LOGGER.info("CALLED userLogin ON prosumer");
		AccountLoginResponse response = service.userLogin(parameters);
		return response;
	}
	@Override
	public AccountSessionResponse accountSession(AccountSessionRequest parameters) throws AccountSessionFault_Exception {
		LOGGER.info("CALLED checkSession ON prosumer");
		AccountSessionResponse response = service.accountSession(parameters);
		return response;
	}
	@Override
	public AccountLogoutResponse userLogout(AccountLogoutRequest parameters) throws AccountLogoutFault_Exception {
		LOGGER.info("CALLED userLogout ON prosumer");
		AccountLogoutResponse response = service.userLogout(parameters);
		return response;
	}
	@Override
	public EventInsertResponse eventInsert(EventInsertRequest parameters) throws EventInsertFault_Exception {
		LOGGER.info("CALLED eventInsert ON prosumer");
		EventInsertResponse response = service.eventInsert(parameters);
		return response;
	}
	@Override
	public EventDeleteResponse eventDelete(EventDeleteRequest parameters) throws EventDeleteFault_Exception {
		LOGGER.info("CALLED eventDelete ON prosumer");
		EventDeleteResponse response = service.eventDelete(parameters);
		return response;
	}
	@Override
	public EventUpdateResponse eventUpdate(EventUpdateRequest parameters) throws EventUpdateFault_Exception {
		LOGGER.info("CALLED eventUpdate ON prosumer");
		EventUpdateResponse response = service.eventUpdate(parameters);
		return response;
	}	
	@Override
	public AttractionInsertResponse attractionInsert(AttractionInsertRequest parameters) throws AttractionInsertFault_Exception {
		LOGGER.info("CALLED attractionInsert ON prosumer");
		AttractionInsertResponse response = service.attractionInsert(parameters);
		return response;
	}	
	@Override
	public AttractionDeleteResponse attractionDelete(AttractionDeleteRequest parameters) throws AttractionDeleteFault_Exception {
		LOGGER.info("CALLED attractionDelete ON prosumer");
		AttractionDeleteResponse response = service.attractionDelete(parameters);
		return response;
	}	
	@Override
	public AttractionUpdateResponse attractionUpdate(AttractionUpdateRequest parameters) throws AttractionUpdateFault_Exception {
		LOGGER.info("CALLED attractionUpdate ON prosumer");
		AttractionUpdateResponse response = service.attractionUpdate(parameters);
		return response;
	}
	@Override
	public EventByCreatorResearchResponse eventByCreatorResearch(EventByCreatorResearchRequest parameters)
			throws EventByCreatorResearchFault_Exception {
		LOGGER.info("CALLED eventByCreatorResearch ON prosumer");
		EventByCreatorResearchResponse response = service.eventByCreatorResearch(parameters);
		return response;
	}
	@Override
	public AttractionDetailResearchResponse attractionDetailResearch(AttractionDetailResearchRequest parameters)
			throws AttractionDetailResearchFault_Exception {
		LOGGER.info("CALLED attractionDetailResearch ON prosumer");
		AttractionDetailResearchResponse response = service.attractionDetailResearch(parameters);
		return response;
	}
	@Override
	public EventDetailResearchResponse eventDetailResearch(EventDetailResearchRequest parameters)
			throws EventDetailResearchFault_Exception {
		LOGGER.info("CALLED eventDetailResearch ON prosumer");
		EventDetailResearchResponse response = service.eventDetailResearch(parameters);
		return response;
	}
	@Override
	public AttractionResearchResponse attractionResearch(AttractionResearchRequest parameters)
			throws AttractionResearchFault_Exception {
		LOGGER.info("CALLED attractionResearch ON prosumer");
		AttractionResearchResponse response = service.attractionResearch(parameters);
		return response;
	}
	@Override
	public EventResearchResponse eventResearch(EventResearchRequest parameters) throws EventResearchFault_Exception {
		LOGGER.info("CALLED eventResearch ON prosumer");
		EventResearchResponse response = service.eventResearch(parameters);
		return response;
	}
	@Override
	public AttractionByCreatorResearchResponse attractionByCreatorResearch(
			AttractionByCreatorResearchRequest parameters) throws AttractionByCreatorResearchFault_Exception {
		LOGGER.info("CALLED attractionByCreatorResearch ON prosumer");
		AttractionByCreatorResearchResponse response = service.attractionByCreatorResearch(parameters);
		return response;
	}	
}