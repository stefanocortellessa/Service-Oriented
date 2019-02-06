package it.univaq.disim.sose.routingrequests.controller;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.routingrequests.model.Event;
import it.univaq.disim.sose.routingrequests.model.User;
import it.univaq.disim.sose.prosumer.AccountLoginFault_Exception;
import it.univaq.disim.sose.prosumer.AccountLoginRequest;
import it.univaq.disim.sose.prosumer.AccountLoginResponse;
import it.univaq.disim.sose.prosumer.AccountLogoutFault_Exception;
import it.univaq.disim.sose.prosumer.AccountLogoutRequest;
import it.univaq.disim.sose.prosumer.AccountLogoutResponse;
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
import it.univaq.disim.sose.prosumer.ProsumerService;

@RestController
public class AccountController {
	
	@PostMapping("/signup")
	public AccountSignupResponse signup(@RequestBody User user) throws AccountSignupFault_Exception  {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AccountSignupResponse response = new AccountSignupResponse();
		AccountSignupRequest request = new AccountSignupRequest();
		
		request.setEmail(user.getEmail());
		request.setPassword(user.getPassword());
		request.setName(user.getName());
		request.setSurname(user.getSurname());
		request.setUsername(user.getUsername());
		response = prosumer.userSignup(request);
	
		return response;
	}
	
	@PostMapping("/login")
	public AccountLoginResponse login(@RequestBody User user) throws AccountLoginFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AccountLoginResponse response = new AccountLoginResponse();
		AccountLoginRequest request = new AccountLoginRequest();
		
		request.setEmail(user.getEmail());
		request.setPassword(user.getPassword());
		response = prosumer.userLogin(request);
		
		return response;
	}
	
	@DeleteMapping("/logout/{token}")
	public AccountLogoutResponse logout(@PathVariable String token) throws AccountLogoutFault_Exception {
		
		ProsumerService prosumerService = new ProsumerService();
		ProsumerPT prosumer = prosumerService.getProsumerPort();
		AccountLogoutResponse response = new AccountLogoutResponse();
		AccountLogoutRequest request = new AccountLogoutRequest();
		
		request.setToken(token);
		response = prosumer.userLogout(request);
	
		return response;
	}
}
