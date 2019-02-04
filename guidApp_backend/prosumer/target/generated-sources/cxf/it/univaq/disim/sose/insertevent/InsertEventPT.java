package it.univaq.disim.sose.insertevent;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-04T11:56:38.224+01:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://it.univaq.disim.sose/insertEvent", name = "insertEventPT")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface InsertEventPT {

    @WebMethod
    @WebResult(name = "deleteEventResponse", targetNamespace = "http://it.univaq.disim.sose/insertEvent", partName = "parameters")
    public DeleteEventResponse deleteEvent(
        @WebParam(partName = "parameters", name = "deleteEventRequest", targetNamespace = "http://it.univaq.disim.sose/insertEvent")
        DeleteEventRequest parameters
    ) throws DeleteEventFault_Exception;

    @WebMethod
    @WebResult(name = "insertEventResponse", targetNamespace = "http://it.univaq.disim.sose/insertEvent", partName = "parameters")
    public InsertEventResponse insertEvent(
        @WebParam(partName = "parameters", name = "insertEventRequest", targetNamespace = "http://it.univaq.disim.sose/insertEvent")
        InsertEventRequest parameters
    ) throws InsertEventFault_Exception;

    @WebMethod
    @WebResult(name = "checkSessionResponse", targetNamespace = "http://it.univaq.disim.sose/insertEvent", partName = "parameters")
    public CheckSessionResponse checkSession(
        @WebParam(partName = "parameters", name = "checkSessionRequest", targetNamespace = "http://it.univaq.disim.sose/insertEvent")
        CheckSessionRequest parameters
    ) throws CheckSessionFault_Exception;
}
