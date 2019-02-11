
package it.univaq.disim.sose.eventmanager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.eventmanager package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InsertEventRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "insertEventRequest");
    private final static QName _InsertEventResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "insertEventResponse");
    private final static QName _InsertEventFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "insertEventFault");
    private final static QName _DeleteEventRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "deleteEventRequest");
    private final static QName _DeleteEventResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "deleteEventResponse");
    private final static QName _DeleteEventFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "deleteEventFault");
    private final static QName _UpdateEventRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "updateEventRequest");
    private final static QName _UpdateEventResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "updateEventResponse");
    private final static QName _UpdateEventFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "updateEventFault");
    private final static QName _CheckSessionRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "checkSessionRequest");
    private final static QName _CheckSessionResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "checkSessionResponse");
    private final static QName _CheckSessionFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/eventManager", "checkSessionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.eventmanager
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertEventRequest }
     * 
     */
    public InsertEventRequest createInsertEventRequest() {
        return new InsertEventRequest();
    }

    /**
     * Create an instance of {@link InsertEventResponse }
     * 
     */
    public InsertEventResponse createInsertEventResponse() {
        return new InsertEventResponse();
    }

    /**
     * Create an instance of {@link InsertEventFault }
     * 
     */
    public InsertEventFault createInsertEventFault() {
        return new InsertEventFault();
    }

    /**
     * Create an instance of {@link DeleteEventRequest }
     * 
     */
    public DeleteEventRequest createDeleteEventRequest() {
        return new DeleteEventRequest();
    }

    /**
     * Create an instance of {@link DeleteEventResponse }
     * 
     */
    public DeleteEventResponse createDeleteEventResponse() {
        return new DeleteEventResponse();
    }

    /**
     * Create an instance of {@link DeleteEventFault }
     * 
     */
    public DeleteEventFault createDeleteEventFault() {
        return new DeleteEventFault();
    }

    /**
     * Create an instance of {@link UpdateEventRequest }
     * 
     */
    public UpdateEventRequest createUpdateEventRequest() {
        return new UpdateEventRequest();
    }

    /**
     * Create an instance of {@link UpdateEventResponse }
     * 
     */
    public UpdateEventResponse createUpdateEventResponse() {
        return new UpdateEventResponse();
    }

    /**
     * Create an instance of {@link UpdateEventFault }
     * 
     */
    public UpdateEventFault createUpdateEventFault() {
        return new UpdateEventFault();
    }

    /**
     * Create an instance of {@link CheckSessionRequest }
     * 
     */
    public CheckSessionRequest createCheckSessionRequest() {
        return new CheckSessionRequest();
    }

    /**
     * Create an instance of {@link CheckSessionResponse }
     * 
     */
    public CheckSessionResponse createCheckSessionResponse() {
        return new CheckSessionResponse();
    }

    /**
     * Create an instance of {@link CheckSessionFault }
     * 
     */
    public CheckSessionFault createCheckSessionFault() {
        return new CheckSessionFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "insertEventRequest")
    public JAXBElement<InsertEventRequest> createInsertEventRequest(InsertEventRequest value) {
        return new JAXBElement<InsertEventRequest>(_InsertEventRequest_QNAME, InsertEventRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "insertEventResponse")
    public JAXBElement<InsertEventResponse> createInsertEventResponse(InsertEventResponse value) {
        return new JAXBElement<InsertEventResponse>(_InsertEventResponse_QNAME, InsertEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertEventFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "insertEventFault")
    public JAXBElement<InsertEventFault> createInsertEventFault(InsertEventFault value) {
        return new JAXBElement<InsertEventFault>(_InsertEventFault_QNAME, InsertEventFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "deleteEventRequest")
    public JAXBElement<DeleteEventRequest> createDeleteEventRequest(DeleteEventRequest value) {
        return new JAXBElement<DeleteEventRequest>(_DeleteEventRequest_QNAME, DeleteEventRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "deleteEventResponse")
    public JAXBElement<DeleteEventResponse> createDeleteEventResponse(DeleteEventResponse value) {
        return new JAXBElement<DeleteEventResponse>(_DeleteEventResponse_QNAME, DeleteEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEventFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "deleteEventFault")
    public JAXBElement<DeleteEventFault> createDeleteEventFault(DeleteEventFault value) {
        return new JAXBElement<DeleteEventFault>(_DeleteEventFault_QNAME, DeleteEventFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEventRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "updateEventRequest")
    public JAXBElement<UpdateEventRequest> createUpdateEventRequest(UpdateEventRequest value) {
        return new JAXBElement<UpdateEventRequest>(_UpdateEventRequest_QNAME, UpdateEventRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "updateEventResponse")
    public JAXBElement<UpdateEventResponse> createUpdateEventResponse(UpdateEventResponse value) {
        return new JAXBElement<UpdateEventResponse>(_UpdateEventResponse_QNAME, UpdateEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEventFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "updateEventFault")
    public JAXBElement<UpdateEventFault> createUpdateEventFault(UpdateEventFault value) {
        return new JAXBElement<UpdateEventFault>(_UpdateEventFault_QNAME, UpdateEventFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "checkSessionRequest")
    public JAXBElement<CheckSessionRequest> createCheckSessionRequest(CheckSessionRequest value) {
        return new JAXBElement<CheckSessionRequest>(_CheckSessionRequest_QNAME, CheckSessionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "checkSessionResponse")
    public JAXBElement<CheckSessionResponse> createCheckSessionResponse(CheckSessionResponse value) {
        return new JAXBElement<CheckSessionResponse>(_CheckSessionResponse_QNAME, CheckSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/eventManager", name = "checkSessionFault")
    public JAXBElement<CheckSessionFault> createCheckSessionFault(CheckSessionFault value) {
        return new JAXBElement<CheckSessionFault>(_CheckSessionFault_QNAME, CheckSessionFault.class, null, value);
    }

}
