package it.univaq.disim.sose.accountmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.accountmanager.AccountManagerPT;
import it.univaq.disim.sose.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.accountmanager.UserLogoutResponse;
import it.univaq.disim.sose.accountmanager.UserSignupFault_Exception;
import it.univaq.disim.sose.accountmanager.UserSignupRequest;
import it.univaq.disim.sose.accountmanager.UserSignupResponse;
import it.univaq.disim.sose.accountmanager.business.AccountManagerService;



@Component(value = "AccountManagerPTImpl")
public class AccountManagerPTImpl implements AccountManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AccountManagerPTImpl.class);
	
	@Autowired
	AccountManagerService service;

	@Override
	public UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception {
		LOGGER.info("called User Login in Account Service");
		UserLoginResponse response = new UserLoginResponse();
		response = service.userLogin(parameters);
		return response;
	}

	@Override
	public UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception {
		LOGGER.info("called User Logout in Account Service");
		UserLogoutResponse response = new UserLogoutResponse();
		response = service.userLogout(parameters);
		return response;
	}

	@Override
	public CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception {
		LOGGER.info("called Check Session in Account Service");
		CheckSessionResponse response = new CheckSessionResponse();
		response = service.checkSession(parameters);
		return response;
	}

	@Override
	public UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception {
		LOGGER.info("called User Signup in Account Service");
		UserSignupResponse response = new UserSignupResponse();
		response = service.userSignup(parameters);
		return response;
	}

}
