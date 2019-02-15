package it.univaq.disim.sose.touristicguide.prosumer.business;

import java.io.IOException;

import com.google.maps.errors.ApiException;

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

public interface ProsumerService {
	
	AccountSignupResponse userSignup(AccountSignupRequest request) throws AccountSignupFault_Exception;
	
	AccountLoginResponse userLogin(AccountLoginRequest request) throws AccountLoginFault_Exception;
	
	AccountLogoutResponse userLogout(AccountLogoutRequest request) throws AccountLogoutFault_Exception;
	
	AccountSessionResponse accountSession(AccountSessionRequest request) throws AccountSessionFault_Exception;
	
	EventInsertResponse eventInsert(EventInsertRequest request) throws EventInsertFault_Exception;
	
	EventDeleteResponse eventDelete(EventDeleteRequest request) throws EventDeleteFault_Exception;
	
	EventUpdateResponse eventUpdate(EventUpdateRequest request) throws EventUpdateFault_Exception;
	
	AttractionInsertResponse attractionInsert(AttractionInsertRequest request) throws AttractionInsertFault_Exception;
	
	AttractionDeleteResponse attractionDelete(AttractionDeleteRequest request) throws AttractionDeleteFault_Exception;
	
	AttractionUpdateResponse attractionUpdate(AttractionUpdateRequest request) throws AttractionUpdateFault_Exception;

	EventByCreatorResearchResponse eventByCreatorResearch(EventByCreatorResearchRequest parameters) throws EventByCreatorResearchFault_Exception;

	AttractionDetailResearchResponse attractionDetailResearch(AttractionDetailResearchRequest parameters) throws AttractionDetailResearchFault_Exception;

	EventDetailResearchResponse eventDetailResearch(EventDetailResearchRequest parameters) throws EventDetailResearchFault_Exception;
	
	AttractionResearchResponse attractionResearch(AttractionResearchRequest parameters) throws AttractionResearchFault_Exception;
	
	EventResearchResponse eventResearch(EventResearchRequest parameters) throws EventResearchFault_Exception;

	AttractionByCreatorResearchResponse attractionByCreatorResearch(AttractionByCreatorResearchRequest parameters) throws AttractionByCreatorResearchFault_Exception;
	
	GoogleGeocodingResponse googleGeocoding(GoogleGeocodingRequest parameters) throws GoogleGeocodingFault_Exception;
	
	CategoryResearchResponse categoryResearch(CategoryResearchRequest parameters) throws CategoryResearchFault_Exception;

	GetBestServerResponse getBestServer(GetBestServerRequest parameters) throws GetBestServerFault_Exception;
}
