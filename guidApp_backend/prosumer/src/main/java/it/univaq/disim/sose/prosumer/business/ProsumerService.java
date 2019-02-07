package it.univaq.disim.sose.prosumer.business;

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
import it.univaq.disim.sose.prosumer.AttractionDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionDeleteRequest;
import it.univaq.disim.sose.prosumer.AttractionDeleteResponse;
import it.univaq.disim.sose.prosumer.AttractionInsertFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionInsertRequest;
import it.univaq.disim.sose.prosumer.AttractionInsertResponse;
import it.univaq.disim.sose.prosumer.AttractionUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionUpdateRequest;
import it.univaq.disim.sose.prosumer.AttractionUpdateResponse;
import it.univaq.disim.sose.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.prosumer.EventInsertRequest;
import it.univaq.disim.sose.prosumer.EventInsertResponse;
import it.univaq.disim.sose.prosumer.EventUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.EventUpdateRequest;
import it.univaq.disim.sose.prosumer.EventUpdateResponse;

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

	
}
