
package it.univaq.disim.sose.attractionmanager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.attractionmanager package. 
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

    private final static QName _InsertAttractionRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "insertAttractionRequest");
    private final static QName _InsertAttractionResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "insertAttractionResponse");
    private final static QName _InsertAttractionFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "insertAttractionFault");
    private final static QName _DeleteAttractionRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "deleteAttractionRequest");
    private final static QName _DeleteAttractionResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "deleteAttractionResponse");
    private final static QName _DeleteAttractionFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "deleteAttractionFault");
    private final static QName _UpdateAttractionRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "updateAttractionRequest");
    private final static QName _UpdateAttractionResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "updateAttractionResponse");
    private final static QName _UpdateAttractionFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "updateAttractionFault");
    private final static QName _CheckSessionRequest_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "checkSessionRequest");
    private final static QName _CheckSessionResponse_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "checkSessionResponse");
    private final static QName _CheckSessionFault_QNAME = new QName("http://it.univaq.disim.sose.touristicguide/attractionManager", "checkSessionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.attractionmanager
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertAttractionRequest }
     * 
     */
    public InsertAttractionRequest createInsertAttractionRequest() {
        return new InsertAttractionRequest();
    }

    /**
     * Create an instance of {@link InsertAttractionResponse }
     * 
     */
    public InsertAttractionResponse createInsertAttractionResponse() {
        return new InsertAttractionResponse();
    }

    /**
     * Create an instance of {@link InsertAttractionFault }
     * 
     */
    public InsertAttractionFault createInsertAttractionFault() {
        return new InsertAttractionFault();
    }

    /**
     * Create an instance of {@link DeleteAttractionRequest }
     * 
     */
    public DeleteAttractionRequest createDeleteAttractionRequest() {
        return new DeleteAttractionRequest();
    }

    /**
     * Create an instance of {@link DeleteAttractionResponse }
     * 
     */
    public DeleteAttractionResponse createDeleteAttractionResponse() {
        return new DeleteAttractionResponse();
    }

    /**
     * Create an instance of {@link DeleteAttractionFault }
     * 
     */
    public DeleteAttractionFault createDeleteAttractionFault() {
        return new DeleteAttractionFault();
    }

    /**
     * Create an instance of {@link UpdateAttractionRequest }
     * 
     */
    public UpdateAttractionRequest createUpdateAttractionRequest() {
        return new UpdateAttractionRequest();
    }

    /**
     * Create an instance of {@link UpdateAttractionResponse }
     * 
     */
    public UpdateAttractionResponse createUpdateAttractionResponse() {
        return new UpdateAttractionResponse();
    }

    /**
     * Create an instance of {@link UpdateAttractionFault }
     * 
     */
    public UpdateAttractionFault createUpdateAttractionFault() {
        return new UpdateAttractionFault();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertAttractionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "insertAttractionRequest")
    public JAXBElement<InsertAttractionRequest> createInsertAttractionRequest(InsertAttractionRequest value) {
        return new JAXBElement<InsertAttractionRequest>(_InsertAttractionRequest_QNAME, InsertAttractionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertAttractionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "insertAttractionResponse")
    public JAXBElement<InsertAttractionResponse> createInsertAttractionResponse(InsertAttractionResponse value) {
        return new JAXBElement<InsertAttractionResponse>(_InsertAttractionResponse_QNAME, InsertAttractionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertAttractionFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "insertAttractionFault")
    public JAXBElement<InsertAttractionFault> createInsertAttractionFault(InsertAttractionFault value) {
        return new JAXBElement<InsertAttractionFault>(_InsertAttractionFault_QNAME, InsertAttractionFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAttractionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "deleteAttractionRequest")
    public JAXBElement<DeleteAttractionRequest> createDeleteAttractionRequest(DeleteAttractionRequest value) {
        return new JAXBElement<DeleteAttractionRequest>(_DeleteAttractionRequest_QNAME, DeleteAttractionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAttractionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "deleteAttractionResponse")
    public JAXBElement<DeleteAttractionResponse> createDeleteAttractionResponse(DeleteAttractionResponse value) {
        return new JAXBElement<DeleteAttractionResponse>(_DeleteAttractionResponse_QNAME, DeleteAttractionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAttractionFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "deleteAttractionFault")
    public JAXBElement<DeleteAttractionFault> createDeleteAttractionFault(DeleteAttractionFault value) {
        return new JAXBElement<DeleteAttractionFault>(_DeleteAttractionFault_QNAME, DeleteAttractionFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAttractionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "updateAttractionRequest")
    public JAXBElement<UpdateAttractionRequest> createUpdateAttractionRequest(UpdateAttractionRequest value) {
        return new JAXBElement<UpdateAttractionRequest>(_UpdateAttractionRequest_QNAME, UpdateAttractionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAttractionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "updateAttractionResponse")
    public JAXBElement<UpdateAttractionResponse> createUpdateAttractionResponse(UpdateAttractionResponse value) {
        return new JAXBElement<UpdateAttractionResponse>(_UpdateAttractionResponse_QNAME, UpdateAttractionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAttractionFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "updateAttractionFault")
    public JAXBElement<UpdateAttractionFault> createUpdateAttractionFault(UpdateAttractionFault value) {
        return new JAXBElement<UpdateAttractionFault>(_UpdateAttractionFault_QNAME, UpdateAttractionFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "checkSessionRequest")
    public JAXBElement<CheckSessionRequest> createCheckSessionRequest(CheckSessionRequest value) {
        return new JAXBElement<CheckSessionRequest>(_CheckSessionRequest_QNAME, CheckSessionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "checkSessionResponse")
    public JAXBElement<CheckSessionResponse> createCheckSessionResponse(CheckSessionResponse value) {
        return new JAXBElement<CheckSessionResponse>(_CheckSessionResponse_QNAME, CheckSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.touristicguide/attractionManager", name = "checkSessionFault")
    public JAXBElement<CheckSessionFault> createCheckSessionFault(CheckSessionFault value) {
        return new JAXBElement<CheckSessionFault>(_CheckSessionFault_QNAME, CheckSessionFault.class, null, value);
    }

}
