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
import it.univaq.disim.sose.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.prosumer.EventInsertRequest;
import it.univaq.disim.sose.prosumer.EventInsertResponse;
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
}