
package it.univaq.disim.sose.prosumer.business.impl.ws;

import org.springframework.stereotype.Service;
	
import it.univaq.disim.sose.accountmanager.AccountManagerPT;
import it.univaq.disim.sose.accountmanager.AccountManagerService;
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
import it.univaq.disim.sose.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.eventmanager.EventManagerPT;
import it.univaq.disim.sose.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.eventmanager.InsertEventResponse;
import it.univaq.disim.sose.eventmanager.EventManagerService;
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
import it.univaq.disim.sose.prosumer.business.ProsumerService;


@Service
public class WebServiceProsumerServiceImpl implements ProsumerService {
	
	
	@Override
	public AccountSignupResponse userSignup(AccountSignupRequest request) throws AccountSignupFault_Exception {
		AccountSignupResponse response = new AccountSignupResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserSignupRequest userSignupRequest = new UserSignupRequest();
		
		userSignupRequest.setEmail(request.getEmail());
		userSignupRequest.setName(request.getName());
		userSignupRequest.setPassword(request.getPassword());
		userSignupRequest.setSurname(request.getSurname());
		userSignupRequest.setUsername(request.getUsername());
		
		try {
			UserSignupResponse userSignupResponse = accountManager.userSignup(userSignupRequest);
			
			response.setId(userSignupResponse.getId());
			response.setToken(userSignupResponse.getToken());
		} catch (UserSignupFault_Exception e) {
			e.printStackTrace();
			throw new AccountSignupFault_Exception("Something was wrong with Account Signup");
		}
		return response;
	}
	
	@Override
	public AccountLoginResponse userLogin(AccountLoginRequest request) throws AccountLoginFault_Exception {
		AccountLoginResponse response = new AccountLoginResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		
		userLoginRequest.setEmail(request.getEmail());
		userLoginRequest.setPassword(request.getPassword());
		
		try {
			UserLoginResponse userLoginResponse = accountManager.userLogin(userLoginRequest);
			
			response.setId(userLoginResponse.getId());
			response.setToken(userLoginResponse.getToken());
			
		} catch (UserLoginFault_Exception e) {
			e.printStackTrace();
			throw new AccountLoginFault_Exception("Something was wrong with Account Login");
		}
		return response;
	}

	@Override
	public AccountLogoutResponse userLogout(AccountLogoutRequest request) throws AccountLogoutFault_Exception {
		AccountLogoutResponse response = new AccountLogoutResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLogoutRequest userLogoutRequest = new UserLogoutRequest();
		
		userLogoutRequest.setToken(request.getToken());
		
		try {
			UserLogoutResponse userLogoutResponse = accountManager.userLogout(userLogoutRequest);
			response.setResponse(userLogoutResponse.getResponse());
			
		} catch (UserLogoutFault_Exception e) {
			e.printStackTrace();
			throw new AccountLogoutFault_Exception("Something was wrong with Account Logout");
		}
		return response;
	}

	@Override
	public AccountSessionResponse accountSession(AccountSessionRequest request) throws AccountSessionFault_Exception {
		AccountSessionResponse response = new AccountSessionResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		CheckSessionRequest checkSessionRequest = new CheckSessionRequest();
		
		checkSessionRequest.setToken(request.getToken());
		
		try {
			CheckSessionResponse checkSessionResponse = accountManager.checkSession(checkSessionRequest);
			response.setResponse(checkSessionResponse.isResponse());
			
		} catch (CheckSessionFault_Exception e) {
			e.printStackTrace();
			throw new AccountSessionFault_Exception("Something was wrong with Account Session");
		}
		
		return response;
	}

	@Override
	public EventInsertResponse eventInsert(EventInsertRequest request) throws EventInsertFault_Exception {
		EventInsertResponse response = new EventInsertResponse();
		
		EventManagerService insertEventService = new EventManagerService();
		EventManagerPT insertEvent = insertEventService.getEventManagerPort();
		InsertEventRequest insertEventRequest = new InsertEventRequest();
		

		insertEventRequest.setTitle(request.getTitle());
		insertEventRequest.setLocality(request.getLocality());
		insertEventRequest.setStartDate(request.getStartDate());
		insertEventRequest.setEndDate(request.getEndDate());
		insertEventRequest.setCategoryName(request.getCategoryName());
		insertEventRequest.setCategoryId(request.getCategoryId());
		insertEventRequest.setCreatorId(request.getCreatorId());
		
		try { 
			InsertEventResponse insertEventResponse = insertEvent.insertEvent(insertEventRequest);
			response.setMessage(insertEventResponse.getMessage());
			
		} catch (InsertEventFault_Exception e) {
			e.printStackTrace();
			try {
				throw new InsertEventFault_Exception("Something was wrong with Insert Event");
			} catch (InsertEventFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public EventDeleteResponse eventDelete(EventDeleteRequest request) throws EventDeleteFault_Exception {
		
		EventDeleteResponse response = new EventDeleteResponse();
		
		EventManagerService insertEventService = new EventManagerService();
		EventManagerPT deleteEvent = insertEventService.getEventManagerPort();
		DeleteEventRequest deleteEventRequest = new DeleteEventRequest();
		
		deleteEventRequest.setId(request.getId());    
		deleteEventRequest.setUserId(request.getUserId());
		
		try {
			DeleteEventResponse deleteEventResponse = deleteEvent.deleteEvent(deleteEventRequest);
			response.setMessage(deleteEventResponse.getMessage());
			
		} catch (DeleteEventFault_Exception e) {
			e.printStackTrace();
			try {
				throw new DeleteEventFault_Exception("Something was wrong with Delete Event");
			} catch (DeleteEventFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return response;
	}	
}
