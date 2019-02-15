package it.univaq.disim.sose.touristicguide.accountmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.touristicguide.accountmanager.AccountManagerPT;
import it.univaq.disim.sose.touristicguide.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLogoutResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.UserSignupFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.UserSignupRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.UserSignupResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.business.AccountManagerService;



@Component(value = "AccountManagerPTImpl")
public class AccountManagerPTImpl implements AccountManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AccountManagerPTImpl.class);
	
	@Autowired
	AccountManagerService service;

	@Override
	public UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception {
		
		LOGGER.info("called User Login in Account Manager");
		
		UserLoginResponse response = new UserLoginResponse();
		response = service.userLogin(parameters);
		
		return response;
	}

	@Override
	public UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception {
		
		LOGGER.info("called User Logout in Account Manager");
		UserLogoutResponse response = new UserLogoutResponse();
		response = service.userLogout(parameters);
		
		return response;
	}

	@Override
	public UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception {
		
		LOGGER.info("called User Signup in Account Manager");
		
		UserSignupResponse response = new UserSignupResponse();
		response = service.userSignup(parameters);
		
		return response;
	}
	
	@Override
	public CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception {
		
		LOGGER.info("called Check Session in Account Manager");
		
		CheckSessionResponse response = new CheckSessionResponse();
		response = service.checkSession(parameters);
		
		return response;
	}
}
