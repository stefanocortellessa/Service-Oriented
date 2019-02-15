
package it.univaq.disim.sose.touristicguide.prosumer.business.impl.ws;

import java.io.IOException;

import javax.xml.ws.BindingProvider;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import it.univaq.disim.sose.touristicguide.accountmanager.AccountManagerPT;
import it.univaq.disim.sose.touristicguide.accountmanager.AccountManagerService;
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
import it.univaq.disim.sose.touristicguide.attractionmanager.AttractionManagerPT;
import it.univaq.disim.sose.touristicguide.attractionmanager.AttractionManagerService;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.DeleteAttractionResponse;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.InsertAttractionResponse;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionRequest;
import it.univaq.disim.sose.touristicguide.attractionmanager.UpdateAttractionResponse;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.EventManagerPT;
import it.univaq.disim.sose.touristicguide.eventmanager.EventManagerService;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventResponse;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoFault_Exception;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoRequest;
import it.univaq.disim.sose.touristicguide.loadbalancer.GetServerInfoResponse;
import it.univaq.disim.sose.touristicguide.loadbalancer.LoadBalancerPT;
import it.univaq.disim.sose.touristicguide.loadbalancer.LoadBalancerService;
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
import it.univaq.disim.sose.touristicguide.prosumer.AttractionElement;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionInsertFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionInsertRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionInsertResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionUpdateFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionUpdateRequest;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionUpdateResponse;
import it.univaq.disim.sose.touristicguide.prosumer.AttractionsList;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryElement;
import it.univaq.disim.sose.touristicguide.prosumer.CategoryList;
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
import it.univaq.disim.sose.touristicguide.prosumer.EventElement;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventInsertResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventResearchResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateRequest;
import it.univaq.disim.sose.touristicguide.prosumer.EventUpdateResponse;
import it.univaq.disim.sose.touristicguide.prosumer.EventsList;
import it.univaq.disim.sose.touristicguide.prosumer.GetBestServerFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.GetBestServerRequest;
import it.univaq.disim.sose.touristicguide.prosumer.GetBestServerResponse;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingFault_Exception;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingRequest;
import it.univaq.disim.sose.touristicguide.prosumer.GoogleGeocodingResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionByCreatorFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionByCreatorRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionByCreatorResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionDetailFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionDetailRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionDetailResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchAttractionResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchCategoryFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchCategoryRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchCategoryResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventByCreatorFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventByCreatorRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventByCreatorResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventDetailFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventDetailRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventDetailResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventFault_Exception;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventRequest;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchEventResponse;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchManagerPT;
import it.univaq.disim.sose.touristicguide.researchmanager.ResearchManagerService;
import it.univaq.disim.sose.touristicguide.prosumer.business.ProsumerService;


@Service
public class WebServiceProsumerServiceImpl implements ProsumerService {
	
	//Method that returns the Server's port with higher score
	public String getBestPort (String serviceName) {
		
		GetBestServerRequest loadRequest = new GetBestServerRequest();
		GetBestServerResponse loadResponse = new GetBestServerResponse();
		
		loadRequest.setServiceName(serviceName);
		
		try {
			
			loadResponse = this.getBestServer(loadRequest);
		} catch (GetBestServerFault_Exception e1) {
			e1.printStackTrace();
		}
		return loadResponse.getServerPort();
	}
	
	@Override
	public AccountSignupResponse userSignup(AccountSignupRequest request) throws AccountSignupFault_Exception {
		
		String bestPort = this.getBestPort("accountManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/accountmanager/services/accountmanager";
		AccountSignupResponse response = new AccountSignupResponse();
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserSignupRequest userSignupRequest = new UserSignupRequest();
		
		BindingProvider bp = (BindingProvider)accountManager;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
		userSignupRequest.setEmail(request.getEmail());
		userSignupRequest.setName(request.getName());
		userSignupRequest.setPassword(request.getPassword());
		userSignupRequest.setSurname(request.getSurname());
		
		try {
			
			UserSignupResponse userSignupResponse = accountManager.userSignup(userSignupRequest);
			
			response.setId(userSignupResponse.getId());
			response.setToken(userSignupResponse.getToken());
			response.setMessage(userSignupResponse.getMessage());			
		} catch (UserSignupFault_Exception e) {
			e.printStackTrace();
			throw new AccountSignupFault_Exception("Something went wrong with User Signup Prosumer");
		}
		return response;
	}
	
	@Override
	public AccountLoginResponse userLogin(AccountLoginRequest request) throws AccountLoginFault_Exception {
		
		String bestPort = this.getBestPort("accountManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/accountmanager/services/accountmanager";
		AccountLoginResponse response = new AccountLoginResponse();
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		BindingProvider bp = (BindingProvider)accountManager;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
		userLoginRequest.setEmail(request.getEmail());
		userLoginRequest.setPassword(request.getPassword());
		
		try {
			UserLoginResponse userLoginResponse = accountManager.userLogin(userLoginRequest);
			
			response.setId(userLoginResponse.getId());
			response.setToken(userLoginResponse.getToken());
			
		} catch (UserLoginFault_Exception e) {
			e.printStackTrace();
			throw new AccountLoginFault_Exception("Something was wrong with Account Login Prosumer");
		}
		
		return response;
	}

	@Override
	public AccountLogoutResponse userLogout(AccountLogoutRequest request) throws AccountLogoutFault_Exception {
		
		String bestPort = this.getBestPort("accountManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/accountmanager/services/accountmanager";
		AccountLogoutResponse response = new AccountLogoutResponse();
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLogoutRequest userLogoutRequest = new UserLogoutRequest();

		BindingProvider bp = (BindingProvider)accountManager;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

		userLogoutRequest.setToken(request.getToken());
		
		try {
			
			UserLogoutResponse userLogoutResponse = accountManager.userLogout(userLogoutRequest);
			
			response.setResponse(userLogoutResponse.getResponse());
		} catch (UserLogoutFault_Exception e) {
			e.printStackTrace();
			throw new AccountLogoutFault_Exception("Something was wrong with Account Logout Prosumer");
		}
		return response;
	}

	@Override
	public AccountSessionResponse accountSession(AccountSessionRequest request) throws AccountSessionFault_Exception {
		
		String bestPort = this.getBestPort("accountManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/accountmanager/services/accountmanager";
		AccountSessionResponse response = new AccountSessionResponse();
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		CheckSessionRequest checkSessionRequest = new CheckSessionRequest();
		
		BindingProvider bp = (BindingProvider)accountManager;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

		checkSessionRequest.setToken(request.getToken());
		
		try {
		
			CheckSessionResponse checkSessionResponse = accountManager.checkSession(checkSessionRequest);
			
			response.setResponse(checkSessionResponse.isResponse());
		} catch (CheckSessionFault_Exception e) {
			e.printStackTrace();
			throw new AccountSessionFault_Exception("Something was wrong with Account Session Prosumer");
		}
		return response;
	}

	@Override
	public EventInsertResponse eventInsert(EventInsertRequest request) throws EventInsertFault_Exception {
		
		String bestPort = this.getBestPort("eventManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/eventmanager/services/eventmanager";
		
		EventInsertResponse response = new EventInsertResponse();
		EventManagerService insertEventService = new EventManagerService();
		EventManagerPT insertEvent = insertEventService.getEventManagerPort();
		InsertEventRequest insertEventRequest = new InsertEventRequest();
		
		BindingProvider bp = (BindingProvider)insertEvent;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

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
				throw new InsertEventFault_Exception("Something was wrong with Insert Event Prosumer");
			} catch (InsertEventFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@Override
	public EventDeleteResponse eventDelete(EventDeleteRequest request) throws EventDeleteFault_Exception {
		
		String bestPort = this.getBestPort("eventManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/eventmanager/services/eventmanager";
		EventDeleteResponse response = new EventDeleteResponse();
		EventManagerService insertEventService = new EventManagerService();
		EventManagerPT deleteEvent = insertEventService.getEventManagerPort();
		DeleteEventRequest deleteEventRequest = new DeleteEventRequest();
		BindingProvider bp = (BindingProvider)deleteEvent;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
		deleteEventRequest.setId(request.getId());    
		deleteEventRequest.setUserId(request.getUserId());
		
		try {
			
			DeleteEventResponse deleteEventResponse = deleteEvent.deleteEvent(deleteEventRequest);
			
			response.setMessage(deleteEventResponse.getMessage());
		} catch (DeleteEventFault_Exception e) {
			e.printStackTrace();
			try {
				throw new DeleteEventFault_Exception("Something was wrong with Delete Event Prosumer");
			} catch (DeleteEventFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}	
	
	@Override
	public EventUpdateResponse eventUpdate(EventUpdateRequest request) throws EventUpdateFault_Exception {
		
		String bestPort = this.getBestPort("eventManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/eventmanager/services/eventmanager";
		EventUpdateResponse response = new EventUpdateResponse();
		EventManagerService updateEventService = new EventManagerService();
		EventManagerPT updateEvent = updateEventService.getEventManagerPort();
		UpdateEventRequest updateEventRequest = new UpdateEventRequest();
		
		BindingProvider bp = (BindingProvider)updateEvent;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
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
				throw new DeleteEventFault_Exception("Something was wrong with Update Event Prosumer");
			} catch (DeleteEventFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}
	
	@Override
	public AttractionInsertResponse attractionInsert(AttractionInsertRequest request) throws AttractionInsertFault_Exception {
		
		String bestPort = this.getBestPort("attractionManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/attractionmanager/services/attractionmanager";
		AttractionInsertResponse response = new AttractionInsertResponse();
		AttractionManagerService insertAttractionService = new AttractionManagerService();
		AttractionManagerPT insertAttr = insertAttractionService.getAttractionManagerPort();
		InsertAttractionRequest insertAttractionRequest = new InsertAttractionRequest();
	
		BindingProvider bp = (BindingProvider)insertAttr;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
	
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
				throw new InsertEventFault_Exception("Something was wrong with Insert Attraction Prosumer");
			} catch (InsertEventFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		
		return response;
	}
	
	@Override
	public AttractionDeleteResponse attractionDelete(AttractionDeleteRequest request) throws AttractionDeleteFault_Exception {
		

		String bestPort = this.getBestPort("attractionManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/attractionmanager/services/attractionmanager";
		AttractionDeleteResponse response = new AttractionDeleteResponse();
		AttractionManagerService deleteAttractionService = new AttractionManagerService();
		AttractionManagerPT deleteAttr = deleteAttractionService.getAttractionManagerPort();
		DeleteAttractionRequest deleteAttractionRequest = new DeleteAttractionRequest();
		
		BindingProvider bp = (BindingProvider)deleteAttr;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

		deleteAttractionRequest.setId(request.getId());
		deleteAttractionRequest.setUserId(request.getUserId());
		
		try { 
			
			DeleteAttractionResponse deleteEventResponse = deleteAttr.deleteAttraction(deleteAttractionRequest);
			
			response.setMessage(deleteEventResponse.getMessage());
		} catch (DeleteAttractionFault_Exception e) {
			e.printStackTrace();
			try {
				throw new DeleteEventFault_Exception("Something was wrong with Attraction Delete Prosumer");
			} catch (DeleteEventFault_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return response;
	}
	
	@Override
	public AttractionUpdateResponse attractionUpdate(AttractionUpdateRequest request) throws AttractionUpdateFault_Exception {
		
		String bestPort = this.getBestPort("attractionManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/attractionmanager/services/attractionmanager";
		AttractionUpdateResponse response = new AttractionUpdateResponse();
		AttractionManagerService updateAttractionService = new AttractionManagerService();
		AttractionManagerPT updateAttr = updateAttractionService.getAttractionManagerPort();
		UpdateAttractionRequest updateAttractionRequest = new UpdateAttractionRequest();
		
		BindingProvider bp = (BindingProvider)updateAttr;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
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
				throw new UpdateAttractionFault_Exception("Something was wrong with Attraction Update Prosumer");
			} catch (UpdateAttractionFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}
	
	//Method that build the Element Event
	public EventElement buildEventElement(it.univaq.disim.sose.touristicguide.researchmanager.EventElement response_element) {
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
	
	//Method that build the Element Attraction
	public AttractionElement buildAttractionElement(it.univaq.disim.sose.touristicguide.researchmanager.AttractionElement response_element) {
		
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
	
	//Method that build the Element Category
	public CategoryElement buildCategoryElement(it.univaq.disim.sose.touristicguide.researchmanager.CategoryElement response_element) {
		CategoryElement category = new CategoryElement();
		
		category.setId(response_element.getId());
		category.setName(response_element.getName());
		
		return category;
	}
	
	//Method that build the List Event
	public EventsList buildEventsList(it.univaq.disim.sose.touristicguide.researchmanager.EventsList response_list) {
		
		EventsList l = new EventsList();
		
		for (int i = 0; i<response_list.getEventElement().size(); i++ ) {
		
			l.getEventElement().add(buildEventElement(response_list.getEventElement().get(i)));
		}
		return l;
	}

	//Method that build the List Attraction
	public AttractionsList buildAttractionsList(it.univaq.disim.sose.touristicguide.researchmanager.AttractionsList response_list) {
		
		AttractionsList l = new AttractionsList();
		
		for (int i = 0; i<response_list.getAttractionElement().size(); i++ ) {
		
			l.getAttractionElement().add(buildAttractionElement(response_list.getAttractionElement().get(i)));
		}
		return l;
	}

	//Method that build the List Category
	public CategoryList buildCategoryList(it.univaq.disim.sose.touristicguide.researchmanager.CategoryList response_list) {
		CategoryList l = new CategoryList();
		
		for (int i = 0; i<response_list.getCategoryElement().size(); i++ ) {
			l.getCategoryElement().add(buildCategoryElement(response_list.getCategoryElement().get(i)));
		}
		return l;
	}
	
	@Override
	public EventByCreatorResearchResponse eventByCreatorResearch(EventByCreatorResearchRequest request)
			throws EventByCreatorResearchFault_Exception {		

		String bestPort = this.getBestPort("researchManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/researchmanager/services/researchmanager";
		EventByCreatorResearchResponse response = new EventByCreatorResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchEventByCreatorRequest researchRequest = new ResearchEventByCreatorRequest();
		
		BindingProvider bp = (BindingProvider)research;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
	
		researchRequest.setCreatorId(request.getCreatorId());
		
		try { 
			
			ResearchEventByCreatorResponse researchResponse = research.researchEventByCreator(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			response.setEventsList(buildEventsList(researchResponse.getEventsList()));
		} catch (ResearchEventByCreatorFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchEventByCreatorFault_Exception("Something was wrong with Research Event By Creator Prosumer");
			} catch (ResearchEventByCreatorFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@Override
	public AttractionDetailResearchResponse attractionDetailResearch(AttractionDetailResearchRequest request)
			throws AttractionDetailResearchFault_Exception {
		
		String bestPort = this.getBestPort("researchManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/researchmanager/services/researchmanager";
		AttractionDetailResearchResponse response = new AttractionDetailResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchAttractionDetailRequest researchRequest = new ResearchAttractionDetailRequest();
		
		BindingProvider bp = (BindingProvider)research;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

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
				throw new ResearchAttractionDetailFault_Exception("Something was wrong with Research Attraction Detail Prosumer");
			} catch (ResearchAttractionDetailFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@Override
	public EventDetailResearchResponse eventDetailResearch(EventDetailResearchRequest request)
			throws EventDetailResearchFault_Exception {

		String bestPort = this.getBestPort("researchManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/researchmanager/services/researchmanager";
		EventDetailResearchResponse response = new EventDetailResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchEventDetailRequest researchRequest = new ResearchEventDetailRequest();
		
		BindingProvider bp = (BindingProvider)research;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
	
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
				throw new ResearchEventDetailFault_Exception("Something was wrong with Research Event Detail Prosumer");
			} catch (ResearchEventDetailFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@Override
	public AttractionResearchResponse attractionResearch(AttractionResearchRequest request)
			throws AttractionResearchFault_Exception {

		String bestPort = this.getBestPort("researchManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/researchmanager/services/researchmanager";
		AttractionResearchResponse response = new AttractionResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchAttractionRequest researchRequest = new ResearchAttractionRequest();
		
		BindingProvider bp = (BindingProvider)research;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

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
				throw new ResearchAttractionFault_Exception("Something was wrong with Research Attraction Prosumer");
			} catch (ResearchAttractionFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@Override
	public EventResearchResponse eventResearch(EventResearchRequest request) throws EventResearchFault_Exception {

		String bestPort = this.getBestPort("researchManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/researchmanager/services/researchmanager";
		EventResearchResponse response = new EventResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchEventRequest researchRequest = new ResearchEventRequest();
		
		BindingProvider bp = (BindingProvider)research;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

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
				throw new ResearchEventFault_Exception("Something was wrong with Research Event Prosumer");
			} catch (ResearchEventFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@Override
	public AttractionByCreatorResearchResponse attractionByCreatorResearch(
			AttractionByCreatorResearchRequest request) throws AttractionByCreatorResearchFault_Exception {

		String bestPort = this.getBestPort("researchManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/researchmanager/services/researchmanager";
		AttractionByCreatorResearchResponse response = new AttractionByCreatorResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchAttractionByCreatorRequest researchRequest = new ResearchAttractionByCreatorRequest();
		
		BindingProvider bp = (BindingProvider)research;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

		researchRequest.setCreatorId(request.getCreatorId());
		
		try { 
			
			ResearchAttractionByCreatorResponse researchResponse = research.researchAttractionByCreator(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			response.setAttractionsList(buildAttractionsList(researchResponse.getAttractionsList()));
		} catch (ResearchAttractionByCreatorFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchAttractionByCreatorFault_Exception("Something was wrong with Research Attraction By Creator Prosumer");
			} catch (ResearchAttractionByCreatorFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}
 
	@Override
	public GoogleGeocodingResponse googleGeocoding(GoogleGeocodingRequest parameters)
			throws GoogleGeocodingFault_Exception{
		
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBa5iuW05l3hyHLGDr1fnumGssMI-Yombw").build();	
		GoogleGeocodingResponse response = new GoogleGeocodingResponse();

		try {
			GeocodingResult[] results;
			results = GeocodingApi.geocode(context, parameters.getLocality()).await();

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			response.setLat(gson.toJson(results[0].geometry.location.lat));
			response.setLng(gson.toJson(results[0].geometry.location.lng));
		} catch (ApiException | InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public CategoryResearchResponse categoryResearch(CategoryResearchRequest request)
			throws CategoryResearchFault_Exception{

		String bestPort = this.getBestPort("researchManager");
		System.out.println("BEST PORT: " + bestPort);
		String url = bestPort+"/researchmanager/services/researchmanager";
		CategoryResearchResponse response = new CategoryResearchResponse();
		ResearchManagerService researchManagerService = new ResearchManagerService();
		ResearchManagerPT research = researchManagerService.getResearchManagerPort();
		ResearchCategoryRequest researchRequest = new ResearchCategoryRequest();
		
		BindingProvider bp = (BindingProvider)research;

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

		researchRequest.setId(request.getId());
		
		try { 
			
			ResearchCategoryResponse researchResponse = research.researchCategory(researchRequest);
			
			response.setMessage(researchResponse.getMessage());
			response.setCategoryList(buildCategoryList(researchResponse.getCategoryList()));
		} catch (ResearchCategoryFault_Exception e) {
			e.printStackTrace();
			try {
				throw new ResearchCategoryFault_Exception("Something was wrong with Research Category Prosumer");
			} catch (ResearchCategoryFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		
		return response;
	}

	@Override
	public GetBestServerResponse getBestServer(GetBestServerRequest request) throws GetBestServerFault_Exception {
		
		GetBestServerResponse response = new GetBestServerResponse();
		LoadBalancerService LoadBalancerService = new LoadBalancerService();
		LoadBalancerPT balancer = LoadBalancerService.getLoadBalancerPort();
		GetServerInfoRequest balancerRequest = new GetServerInfoRequest();

		balancerRequest.setServiceName(request.getServiceName());
		
		try { 
		
			GetServerInfoResponse balancerResponse = balancer.getServerInfo(balancerRequest);
			
			response.setMessage(balancerResponse.getMessage());
			response.setServerPort(balancerResponse.getServerPort());
		} catch (GetServerInfoFault_Exception e) {
			e.printStackTrace();
			try {
				throw new GetServerInfoFault_Exception("Something was wrong with Get Best Server Prosumer");
			} catch (GetServerInfoFault_Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}
}
