
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
import it.univaq.disim.sose.attractionmanager.AttractionManagerPT;
import it.univaq.disim.sose.attractionmanager.AttractionManagerService;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionRequest;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionResponse;
import it.univaq.disim.sose.attractionmanager.InsertAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.InsertAttractionRequest;
import it.univaq.disim.sose.attractionmanager.InsertAttractionResponse;
import it.univaq.disim.sose.attractionmanager.UpdateAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.UpdateAttractionRequest;
import it.univaq.disim.sose.attractionmanager.UpdateAttractionResponse;
import it.univaq.disim.sose.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.eventmanager.EventManagerPT;
import it.univaq.disim.sose.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.eventmanager.InsertEventResponse;
import it.univaq.disim.sose.eventmanager.UpdateEventFault_Exception;
import it.univaq.disim.sose.eventmanager.UpdateEventRequest;
import it.univaq.disim.sose.eventmanager.UpdateEventResponse;
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
	
	@Override
	public EventUpdateResponse eventUpdate(EventUpdateRequest request) throws EventUpdateFault_Exception {
		
		EventUpdateResponse response = new EventUpdateResponse();
		EventManagerService updateEventService = new EventManagerService();
		EventManagerPT updateEvent = updateEventService.getEventManagerPort();
		UpdateEventRequest updateEventRequest = new UpdateEventRequest();
		
		updateEventRequest.setId(request.getId());
		updateEventRequest.setTitle(request.getTitle());
		updateEventRequest.setLocality(request.getLocality());
		updateEventRequest.setStartDate(request.getStartDate());
		updateEventRequest.setEndDate(request.getEndDate());
		updateEventRequest.setCategoryName(request.getCategoryName());
		updateEventRequest.setCategoryId(request.getCategoryId());
		updateEventRequest.setCreatorId(request.getCreatorId());
		
		try {
			UpdateEventResponse updateEventResponse = updateEvent.updateEvent(updateEventRequest);
			
			response.setMessage(updateEventResponse.getMessage());
			
		} catch (UpdateEventFault_Exception e) {
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
	@Override
	public AttractionInsertResponse attractionInsert(AttractionInsertRequest request) throws AttractionInsertFault_Exception {
		
		AttractionInsertResponse response = new AttractionInsertResponse();
		AttractionManagerService insertAttractionService = new AttractionManagerService();
		AttractionManagerPT insertAttr = insertAttractionService.getAttractionManagerPort();
		InsertAttractionRequest insertAttractionRequest = new InsertAttractionRequest();

		insertAttractionRequest.setName(request.getName());
		insertAttractionRequest.setLocality(request.getLocality());
		insertAttractionRequest.setCategoryId(request.getCategoryId());
		insertAttractionRequest.setCategoryName(request.getCategoryName());
		insertAttractionRequest.setCreatorId(request.getCreatorId());
		
		
		try { 
			InsertAttractionResponse insertEventResponse = insertAttr.insertAttraction(insertAttractionRequest);
			
			response.setMessage(insertEventResponse.getMessage());
			
		} catch (InsertAttractionFault_Exception e) {
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
	public AttractionDeleteResponse attractionDelete(AttractionDeleteRequest request) throws AttractionDeleteFault_Exception {
		
		AttractionDeleteResponse response = new AttractionDeleteResponse();
		AttractionManagerService deleteAttractionService = new AttractionManagerService();
		AttractionManagerPT deleteAttr = deleteAttractionService.getAttractionManagerPort();
		DeleteAttractionRequest deleteAttractionRequest = new DeleteAttractionRequest();

		deleteAttractionRequest.setId(request.getId());
		deleteAttractionRequest.setUserId(request.getUserId());
		
		try { 
			DeleteAttractionResponse deleteEventResponse = deleteAttr.deleteAttraction(deleteAttractionRequest);
			
			response.setMessage(deleteEventResponse.getMessage());
			
		} catch (DeleteAttractionFault_Exception e) {
			e.printStackTrace();
			try {
				throw new DeleteEventFault_Exception("Something was wrong with Insert Event");
			} catch (DeleteEventFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}
	@Override
	public AttractionUpdateResponse attractionUpdate(AttractionUpdateRequest request) throws AttractionUpdateFault_Exception {
		
		AttractionUpdateResponse response = new AttractionUpdateResponse();
		AttractionManagerService updateAttractionService = new AttractionManagerService();
		AttractionManagerPT updateAttr = updateAttractionService.getAttractionManagerPort();
		UpdateAttractionRequest updateAttractionRequest = new UpdateAttractionRequest();

		updateAttractionRequest.setId(request.getId());
		updateAttractionRequest.setName(request.getName());
		updateAttractionRequest.setLocality(request.getLocality());
		updateAttractionRequest.setCategoryId(request.getCategoryId());
		updateAttractionRequest.setCategoryName(request.getCategoryName());
		updateAttractionRequest.setCreatorId(request.getCreatorId());
		
		try { 
			UpdateAttractionResponse updateEventResponse = updateAttr.updateAttraction(updateAttractionRequest);
			
			response.setMessage(updateEventResponse.getMessage());
			
		} catch (UpdateAttractionFault_Exception e) {
			e.printStackTrace();
			try {
				throw new UpdateEventFault_Exception("Something was wrong with Insert Event");
			} catch (UpdateEventFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}
}
