package it.univaq.disim.sose.prosumer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-04T15:02:55.227+01:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://it.univaq.disim.sose/prosumer", name = "prosumerPT")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ProsumerPT {

    @WebMethod
    @WebResult(name = "accountLogoutResponse", targetNamespace = "http://it.univaq.disim.sose/prosumer", partName = "parameters")
    public AccountLogoutResponse userLogout(
        @WebParam(partName = "parameters", name = "accountLogoutRequest", targetNamespace = "http://it.univaq.disim.sose/prosumer")
        AccountLogoutRequest parameters
    ) throws AccountLogoutFault_Exception;

    @WebMethod
    @WebResult(name = "eventInsertResponse", targetNamespace = "http://it.univaq.disim.sose/prosumer", partName = "parameters")
    public EventInsertResponse eventInsert(
        @WebParam(partName = "parameters", name = "eventInsertRequest", targetNamespace = "http://it.univaq.disim.sose/prosumer")
        EventInsertRequest parameters
    ) throws EventInsertFault_Exception;

    @WebMethod
    @WebResult(name = "accountSignupResponse", targetNamespace = "http://it.univaq.disim.sose/prosumer", partName = "parameters")
    public AccountSignupResponse userSignup(
        @WebParam(partName = "parameters", name = "accountSignupRequest", targetNamespace = "http://it.univaq.disim.sose/prosumer")
        AccountSignupRequest parameters
    ) throws AccountSignupFault_Exception;

    @WebMethod
    @WebResult(name = "accountSessionResponse", targetNamespace = "http://it.univaq.disim.sose/prosumer", partName = "parameters")
    public AccountSessionResponse accountSession(
        @WebParam(partName = "parameters", name = "accountSessionRequest", targetNamespace = "http://it.univaq.disim.sose/prosumer")
        AccountSessionRequest parameters
    ) throws AccountSessionFault_Exception;

    @WebMethod
    @WebResult(name = "accountLoginResponse", targetNamespace = "http://it.univaq.disim.sose/prosumer", partName = "parameters")
    public AccountLoginResponse userLogin(
        @WebParam(partName = "parameters", name = "accountLoginRequest", targetNamespace = "http://it.univaq.disim.sose/prosumer")
        AccountLoginRequest parameters
    ) throws AccountLoginFault_Exception;

    @WebMethod
    @WebResult(name = "eventDeleteResponse", targetNamespace = "http://it.univaq.disim.sose/prosumer", partName = "parameters")
    public EventDeleteResponse eventDelete(
        @WebParam(partName = "parameters", name = "eventDeleteRequest", targetNamespace = "http://it.univaq.disim.sose/prosumer")
        EventDeleteRequest parameters
    ) throws EventDeleteFault_Exception;
}