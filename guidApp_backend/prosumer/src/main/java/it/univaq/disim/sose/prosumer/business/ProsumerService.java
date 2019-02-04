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
import it.univaq.disim.sose.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.prosumer.EventInsertRequest;
import it.univaq.disim.sose.prosumer.EventInsertResponse;

public interface ProsumerService {
	
	
	AccountSignupResponse userSignup(AccountSignupRequest request) throws AccountSignupFault_Exception;
	
	AccountLoginResponse userLogin(AccountLoginRequest request) throws AccountLoginFault_Exception;
	
	AccountLogoutResponse userLogout(AccountLogoutRequest request) throws AccountLogoutFault_Exception;
	
	AccountSessionResponse accountSession(AccountSessionRequest request) throws AccountSessionFault_Exception;
	
	EventInsertResponse eventInsert(EventInsertRequest request) throws EventInsertFault_Exception;
	
	EventDeleteResponse eventDelete(EventDeleteRequest request) throws EventDeleteFault_Exception;
}
