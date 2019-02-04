package it.univaq.disim.sose.accountmanager.business;

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

public interface AccountManagerService {
	 
	UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception;

	UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception;
	
	CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception;
	
	UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception;
}
