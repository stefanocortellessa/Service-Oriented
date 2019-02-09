
package it.univaq.disim.sose.prosumer.business.impl.ws;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

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
import it.univaq.disim.sose.prosumer.AttractionByCreatorResearchFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionByCreatorResearchRequest;
import it.univaq.disim.sose.prosumer.AttractionByCreatorResearchResponse;
import it.univaq.disim.sose.prosumer.AttractionDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionDeleteRequest;
import it.univaq.disim.sose.prosumer.AttractionDeleteResponse;
import it.univaq.disim.sose.prosumer.AttractionDetailResearchFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionDetailResearchRequest;
import it.univaq.disim.sose.prosumer.AttractionDetailResearchResponse;
import it.univaq.disim.sose.prosumer.AttractionElement;
import it.univaq.disim.sose.prosumer.AttractionInsertFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionInsertRequest;
import it.univaq.disim.sose.prosumer.AttractionInsertResponse;
import it.univaq.disim.sose.prosumer.AttractionResearchFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionResearchRequest;
import it.univaq.disim.sose.prosumer.AttractionResearchResponse;
import it.univaq.disim.sose.prosumer.AttractionUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.AttractionUpdateRequest;
import it.univaq.disim.sose.prosumer.AttractionUpdateResponse;
import it.univaq.disim.sose.prosumer.AttractionsList;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchFault_Exception;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchRequest;
import it.univaq.disim.sose.prosumer.EventByCreatorResearchResponse;
import it.univaq.disim.sose.prosumer.EventDeleteFault_Exception;
import it.univaq.disim.sose.prosumer.EventDeleteRequest;
import it.univaq.disim.sose.prosumer.EventDeleteResponse;
import it.univaq.disim.sose.prosumer.EventDetailResearchFault_Exception;
import it.univaq.disim.sose.prosumer.EventDetailResearchRequest;
import it.univaq.disim.sose.prosumer.EventDetailResearchResponse;
import it.univaq.disim.sose.prosumer.EventElement;
import it.univaq.disim.sose.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.prosumer.EventInsertRequest;
import it.univaq.disim.sose.prosumer.EventInsertResponse;
import it.univaq.disim.sose.prosumer.EventResearchFault_Exception;
import it.univaq.disim.sose.prosumer.EventResearchRequest;
import it.univaq.disim.sose.prosumer.EventResearchResponse;
import it.univaq.disim.sose.prosumer.EventUpdateFault_Exception;
import it.univaq.disim.sose.prosumer.EventUpdateRequest;
import it.univaq.disim.sose.prosumer.EventUpdateResponse;
import it.univaq.disim.sose.prosumer.EventsList;
import it.univaq.disim.sose.prosumer.GoogleGeocodingFault_Exception;
import it.univaq.disim.sose.prosumer.GoogleGeocodingRequest;
import it.univaq.disim.sose.prosumer.GoogleGeocodingResponse;
import it.univaq.disim.sose.prosumer.business.ProsumerService;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorResponse;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailResponse;
import it.univaq.disim.sose.researchmanager.ResearchAttractionFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventResponse;
import it.univaq.disim.sose.researchmanager.ResearchManagerPT;
import it.univaq.disim.sose.researchmanager.ResearchManagerService;


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
		insertEventRequest.setLat(request.getLat());
		insertEventRequest.setLng(request.getLng());
		
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
		updateEventRequest.setLat(request.getLat());
		updateEventRequest.setLng(request.getLng());
		
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
		insertAttractionRequest.setLat(request.getLat());
		insertAttractionRequest.setLng(request.getLng());
		
		
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
		updateAttractionRequest.setLat(request.getLat());
		updateAttractionRequest.setLng(request.getLng());
		
		try { 
			UpdateAttractionResponse updateEventResponse = updateAttr.updateAttraction(updateAttractionRequest);
			
			response.setMessage(updateEventResponse.getMessage());
			
		} catch (UpdateAttractionFault_Exception e) {
			e.printStackTrace();
			try {
				throw new UpdateAttractionFault_Exception("Something was wrong with Insert Event");
			} catch (UpdateAttractionFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}
	
	public EventElement buildEventElement(it.univaq.disim.sose.researchmanager.EventElement response_element) {
		EventElement event = new EventElement();
		
		event.setId(response_element.getId());
		event.setLocality(response_element.getLocality());
		event.setCategoryId(response_element.getCategoryId());
		event.setCategoryName(response_element.getCategoryName());
		event.setCreatorId(response_element.getCreatorId());
		event.setStartDate(response_element.getStartDate());
		event.setEndDate(response_element.getEndDate());
		event.setTitle(response_element.getTitle());
		event.setLat(response_element.getLat());
		event.setLng(response_element.getLng());
		return event;
	}
	
	public AttractionElement buildAttractionElement(it.univaq.disim.sose.researchmanager.AttractionElement response_element) {
		AttractionElement attraction = new AttractionElement();
		
		attraction.setId(response_element.getId());
		attraction.setLocality(response_element.getLocality());
		attraction.setCategoryId(response_element.getCategoryId());
		attraction.setCategoryName(response_element.getCategoryName());
		attraction.setCreatorId(response_element.getCreatorId());
		attraction.setName(response_element.getName());

		attraction.setLat(response_element.getLat());
		attraction.setLng(response_element.getLng());
	
		return attraction;
	}
	
	public EventsList buildEventsList(it.univaq.disim.sose.researchmanager.EventsList response_list) {
		EventsList l = new EventsList();
		
		for (int i = 0; i<response_list.getEventElement().size(); i++ ) {
			l.getEventElement().add(buildEventElement(response_list.getEventElement().get(i)));
		}
		return l;
	}
	

	public AttractionsList buildAttractionsList(it.univaq.disim.sose.researchmanager.AttractionsList response_list) {
		AttractionsList l = new AttractionsList();
		
		for (int i = 0; i<response_list.getAttractionElement().size(); i++ ) {
			l.getAttractionElement().add(buildAttractionElement(response_list.getAttractionElement().get(i)));
		}
		return l;
	}
	
	
	@Override
	public EventByCreatorResearchResponse eventByCreatorResearch(EventByCreatorResearchRequest request)
			throws EventByCreatorResearchFault_Exception {
		
		EventByCreatorResearchResponse response = new EventByCreatorResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchEventByCreatorRequest researchRequest = new ResearchEventByCreatorRequest();

		researchRequest.setCreatorId(request.getCreatorId());
		
		try { 
			ResearchEventByCreatorResponse researchResponse = research.researchEventByCreator(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			response.setEventsList(buildEventsList(researchResponse.getEventsList()));
			
		} catch (ResearchEventByCreatorFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchEventByCreatorFault_Exception("Something was wrong with Research Event for this user");
			} catch (ResearchEventByCreatorFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public AttractionDetailResearchResponse attractionDetailResearch(AttractionDetailResearchRequest request)
			throws AttractionDetailResearchFault_Exception {
		
		AttractionDetailResearchResponse response = new AttractionDetailResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchAttractionDetailRequest researchRequest = new ResearchAttractionDetailRequest();

		researchRequest.setId(request.getId());
		
		try { 
			ResearchAttractionDetailResponse researchResponse = research.researchAttractionDetail(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			if(researchResponse.getAttractionElement() != null) {
				response.setAttractionElement(buildAttractionElement(researchResponse.getAttractionElement()));
			}
		} catch (ResearchAttractionDetailFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchAttractionDetailFault_Exception("Something was wrong with Research Attraction");
			} catch (ResearchAttractionDetailFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public EventDetailResearchResponse eventDetailResearch(EventDetailResearchRequest request)
			throws EventDetailResearchFault_Exception {
		
		EventDetailResearchResponse response = new EventDetailResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchEventDetailRequest researchRequest = new ResearchEventDetailRequest();

		researchRequest.setId(request.getId());
		
		try { 
			ResearchEventDetailResponse researchResponse = research.researchEventDetail(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			if(researchResponse.getEventElement() != null) {
				response.setEventElement(buildEventElement(researchResponse.getEventElement()));

			}
		} catch (ResearchEventDetailFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchEventDetailFault_Exception("Something was wrong with Research Event");
			} catch (ResearchEventDetailFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public AttractionResearchResponse attractionResearch(AttractionResearchRequest request)
			throws AttractionResearchFault_Exception {
		
		AttractionResearchResponse response = new AttractionResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchAttractionRequest researchRequest = new ResearchAttractionRequest();

		researchRequest.setLocality(request.getLocality());
		researchRequest.setName(request.getName());
		researchRequest.setCategoryId(request.getCategoryId());
		
		try { 
			ResearchAttractionResponse researchResponse = research.researchAttraction(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			response.setAttractionsList(buildAttractionsList(researchResponse.getAttractionsList()));

			
		} catch (ResearchAttractionFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchAttractionFault_Exception("Something was wrong with Research Attraction");
			} catch (ResearchAttractionFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public EventResearchResponse eventResearch(EventResearchRequest request) throws EventResearchFault_Exception {
		
		EventResearchResponse response = new EventResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchEventRequest researchRequest = new ResearchEventRequest();

		researchRequest.setLocality(request.getLocality());
		researchRequest.setTitle(request.getTitle());
		researchRequest.setCategoryId(request.getCategoryId());
		if(request.getDate() != null) {
			researchRequest.setDate(request.getDate());
		}
		
		try { 
			ResearchEventResponse researchResponse = research.researchEvent(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			response.setEventsList(buildEventsList(researchResponse.getEventsList()));

			
		} catch (ResearchEventFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchEventFault_Exception("Something was wrong with Research Event");
			} catch (ResearchEventFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public AttractionByCreatorResearchResponse attractionByCreatorResearch(
			AttractionByCreatorResearchRequest request) throws AttractionByCreatorResearchFault_Exception {
		
		AttractionByCreatorResearchResponse response = new AttractionByCreatorResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchAttractionByCreatorRequest researchRequest = new ResearchAttractionByCreatorRequest();

		researchRequest.setCreatorId(request.getCreatorId());
		
		try { 
			ResearchAttractionByCreatorResponse researchResponse = research.researchAttractionByCreator(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			response.setAttractionsList(buildAttractionsList(researchResponse.getAttractionsList()));

			
		} catch (ResearchAttractionByCreatorFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchAttractionByCreatorFault_Exception("Something was wrong with Research Attraction for this user");
			} catch (ResearchAttractionByCreatorFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return response;
	}
 
	@Override
	public GoogleGeocodingResponse googleGeocoding(GoogleGeocodingRequest parameters)
			throws GoogleGeocodingFault_Exception, ApiException, InterruptedException, IOException {
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBa5iuW05l3hyHLGDr1fnumGssMI-Yombw").build();
			GeocodingResult[] results;
			results = GeocodingApi.geocode(context, parameters.getLocality()).await();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			GoogleGeocodingResponse response = new GoogleGeocodingResponse();
			response.setLat(gson.toJson(results[0].geometry.location.lat));
			response.setLng(gson.toJson(results[0].geometry.location.lng));
			
			return response;
		
	}
}
