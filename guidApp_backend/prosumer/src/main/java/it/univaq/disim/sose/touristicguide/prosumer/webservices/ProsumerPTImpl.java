package it.univaq.disim.sose.touristicguide.prosumer.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.touristicguide.prosumer.AccountLoginFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AccountLoginRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AccountLoginResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AccountLogoutFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AccountLogoutRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AccountLogoutResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AccountSessionFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AccountSessionRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AccountSessionResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AccountSignupFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AccountSignupRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AccountSignupResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionByCreatorResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionByCreatorResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionByCreatorResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDeleteFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDeleteRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDeleteResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDetailResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDetailResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionDetailResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionInsertFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionInsertRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionInsertResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionUpdateFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionUpdateRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionUpdateResponse;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventByCreatorResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventByCreatorResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventByCreatorResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventDetailResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventDetailResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventDetailResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateResponse;
import it.univaq.disim.sose.touristicguide.prosumer.GetBestServerFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.GetBestServerRequest;
import it.univaq.disim.sose.touristicguide.prosumer.GetBestServerResponse;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingRequest;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingResponse;
import it.univaq.disim.sose.touristicguide.prosumer.ProsumerPT;
import it.univaq.disim.sose.touristicguide.prosumer.business.ProsumerService;

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
	@Override
	public GoogleGeocodingResponse googleGeocoding(GoogleGeocodingRequest parameters)
			throws GoogleGeocodingFault_Exception {
		LOGGER.info("CALLED googleGeocoding ON prosumer");
		GoogleGeocodingResponse response = service.googleGeocoding(parameters);
		return response;
	}
	@Override
	public CategoryResearchResponse categoryResearch(CategoryResearchRequest parameters)
			throws CategoryResearchFault_Exception{
		LOGGER.info("CALLED category Research ON prosumer");
		CategoryResearchResponse response = service.categoryResearch(parameters);
		return response;
	}
	@Override
	public GetBestServerResponse getBestServer(GetBestServerRequest parameters) throws GetBestServerFault_Exception {
		LOGGER.info("CALLED getBestServer ON prosumer");
		GetBestServerResponse response = service.getBestServer(parameters);
		return response;
	}
}