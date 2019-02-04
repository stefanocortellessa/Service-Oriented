
package it.univaq.disim.sose.prosumer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.prosumer package. 
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

    private final static QName _AccountSignupRequest_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountSignupRequest");
    private final static QName _AccountLoginRequest_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountLoginRequest");
    private final static QName _AccountLogoutRequest_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountLogoutRequest");
    private final static QName _AccountSessionRequest_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountSessionRequest");
    private final static QName _EventInsertRequest_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "eventInsertRequest");
    private final static QName _EventDeleteRequest_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "eventDeleteRequest");
    private final static QName _AccountSignupResponse_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountSignupResponse");
    private final static QName _AccountLoginResponse_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountLoginResponse");
    private final static QName _AccountLogoutResponse_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountLogoutResponse");
    private final static QName _AccountSessionResponse_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountSessionResponse");
    private final static QName _EventInsertResponse_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "eventInsertResponse");
    private final static QName _EventDeleteResponse_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "eventDeleteResponse");
    private final static QName _AccountSignupFault_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountSignupFault");
    private final static QName _AccountLoginFault_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountLoginFault");
    private final static QName _AccountLogoutFault_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountLogoutFault");
    private final static QName _AccountSessionFault_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "accountSessionFault");
    private final static QName _EventInsertFault_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "eventInsertFault");
    private final static QName _EventDeleteFault_QNAME = new QName("http://it.univaq.disim.sose/prosumer", "eventDeleteFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.prosumer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountSignupRequest }
     * 
     */
    public AccountSignupRequest createAccountSignupRequest() {
        return new AccountSignupRequest();
    }

    /**
     * Create an instance of {@link AccountLoginRequest }
     * 
     */
    public AccountLoginRequest createAccountLoginRequest() {
        return new AccountLoginRequest();
    }

    /**
     * Create an instance of {@link AccountLogoutRequest }
     * 
     */
    public AccountLogoutRequest createAccountLogoutRequest() {
        return new AccountLogoutRequest();
    }

    /**
     * Create an instance of {@link AccountSessionRequest }
     * 
     */
    public AccountSessionRequest createAccountSessionRequest() {
        return new AccountSessionRequest();
    }

    /**
     * Create an instance of {@link EventInsertRequest }
     * 
     */
    public EventInsertRequest createEventInsertRequest() {
        return new EventInsertRequest();
    }

    /**
     * Create an instance of {@link EventDeleteRequest }
     * 
     */
    public EventDeleteRequest createEventDeleteRequest() {
        return new EventDeleteRequest();
    }

    /**
     * Create an instance of {@link AccountSignupResponse }
     * 
     */
    public AccountSignupResponse createAccountSignupResponse() {
        return new AccountSignupResponse();
    }

    /**
     * Create an instance of {@link AccountLoginResponse }
     * 
     */
    public AccountLoginResponse createAccountLoginResponse() {
        return new AccountLoginResponse();
    }

    /**
     * Create an instance of {@link AccountLogoutResponse }
     * 
     */
    public AccountLogoutResponse createAccountLogoutResponse() {
        return new AccountLogoutResponse();
    }

    /**
     * Create an instance of {@link AccountSessionResponse }
     * 
     */
    public AccountSessionResponse createAccountSessionResponse() {
        return new AccountSessionResponse();
    }

    /**
     * Create an instance of {@link EventInsertResponse }
     * 
     */
    public EventInsertResponse createEventInsertResponse() {
        return new EventInsertResponse();
    }

    /**
     * Create an instance of {@link EventDeleteResponse }
     * 
     */
    public EventDeleteResponse createEventDeleteResponse() {
        return new EventDeleteResponse();
    }

    /**
     * Create an instance of {@link AccountSignupFault }
     * 
     */
    public AccountSignupFault createAccountSignupFault() {
        return new AccountSignupFault();
    }

    /**
     * Create an instance of {@link AccountLoginFault }
     * 
     */
    public AccountLoginFault createAccountLoginFault() {
        return new AccountLoginFault();
    }

    /**
     * Create an instance of {@link AccountLogoutFault }
     * 
     */
    public AccountLogoutFault createAccountLogoutFault() {
        return new AccountLogoutFault();
    }

    /**
     * Create an instance of {@link AccountSessionFault }
     * 
     */
    public AccountSessionFault createAccountSessionFault() {
        return new AccountSessionFault();
    }

    /**
     * Create an instance of {@link EventInsertFault }
     * 
     */
    public EventInsertFault createEventInsertFault() {
        return new EventInsertFault();
    }

    /**
     * Create an instance of {@link EventDeleteFault }
     * 
     */
    public EventDeleteFault createEventDeleteFault() {
        return new EventDeleteFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountSignupRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountSignupRequest")
    public JAXBElement<AccountSignupRequest> createAccountSignupRequest(AccountSignupRequest value) {
        return new JAXBElement<AccountSignupRequest>(_AccountSignupRequest_QNAME, AccountSignupRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountLoginRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountLoginRequest")
    public JAXBElement<AccountLoginRequest> createAccountLoginRequest(AccountLoginRequest value) {
        return new JAXBElement<AccountLoginRequest>(_AccountLoginRequest_QNAME, AccountLoginRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountLogoutRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountLogoutRequest")
    public JAXBElement<AccountLogoutRequest> createAccountLogoutRequest(AccountLogoutRequest value) {
        return new JAXBElement<AccountLogoutRequest>(_AccountLogoutRequest_QNAME, AccountLogoutRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountSessionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountSessionRequest")
    public JAXBElement<AccountSessionRequest> createAccountSessionRequest(AccountSessionRequest value) {
        return new JAXBElement<AccountSessionRequest>(_AccountSessionRequest_QNAME, AccountSessionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventInsertRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "eventInsertRequest")
    public JAXBElement<EventInsertRequest> createEventInsertRequest(EventInsertRequest value) {
        return new JAXBElement<EventInsertRequest>(_EventInsertRequest_QNAME, EventInsertRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventDeleteRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "eventDeleteRequest")
    public JAXBElement<EventDeleteRequest> createEventDeleteRequest(EventDeleteRequest value) {
        return new JAXBElement<EventDeleteRequest>(_EventDeleteRequest_QNAME, EventDeleteRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountSignupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountSignupResponse")
    public JAXBElement<AccountSignupResponse> createAccountSignupResponse(AccountSignupResponse value) {
        return new JAXBElement<AccountSignupResponse>(_AccountSignupResponse_QNAME, AccountSignupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountLoginResponse")
    public JAXBElement<AccountLoginResponse> createAccountLoginResponse(AccountLoginResponse value) {
        return new JAXBElement<AccountLoginResponse>(_AccountLoginResponse_QNAME, AccountLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountLogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountLogoutResponse")
    public JAXBElement<AccountLogoutResponse> createAccountLogoutResponse(AccountLogoutResponse value) {
        return new JAXBElement<AccountLogoutResponse>(_AccountLogoutResponse_QNAME, AccountLogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountSessionResponse")
    public JAXBElement<AccountSessionResponse> createAccountSessionResponse(AccountSessionResponse value) {
        return new JAXBElement<AccountSessionResponse>(_AccountSessionResponse_QNAME, AccountSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventInsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "eventInsertResponse")
    public JAXBElement<EventInsertResponse> createEventInsertResponse(EventInsertResponse value) {
        return new JAXBElement<EventInsertResponse>(_EventInsertResponse_QNAME, EventInsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "eventDeleteResponse")
    public JAXBElement<EventDeleteResponse> createEventDeleteResponse(EventDeleteResponse value) {
        return new JAXBElement<EventDeleteResponse>(_EventDeleteResponse_QNAME, EventDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountSignupFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountSignupFault")
    public JAXBElement<AccountSignupFault> createAccountSignupFault(AccountSignupFault value) {
        return new JAXBElement<AccountSignupFault>(_AccountSignupFault_QNAME, AccountSignupFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountLoginFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountLoginFault")
    public JAXBElement<AccountLoginFault> createAccountLoginFault(AccountLoginFault value) {
        return new JAXBElement<AccountLoginFault>(_AccountLoginFault_QNAME, AccountLoginFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountLogoutFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountLogoutFault")
    public JAXBElement<AccountLogoutFault> createAccountLogoutFault(AccountLogoutFault value) {
        return new JAXBElement<AccountLogoutFault>(_AccountLogoutFault_QNAME, AccountLogoutFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountSessionFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "accountSessionFault")
    public JAXBElement<AccountSessionFault> createAccountSessionFault(AccountSessionFault value) {
        return new JAXBElement<AccountSessionFault>(_AccountSessionFault_QNAME, AccountSessionFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventInsertFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "eventInsertFault")
    public JAXBElement<EventInsertFault> createEventInsertFault(EventInsertFault value) {
        return new JAXBElement<EventInsertFault>(_EventInsertFault_QNAME, EventInsertFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventDeleteFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose/prosumer", name = "eventDeleteFault")
    public JAXBElement<EventDeleteFault> createEventDeleteFault(EventDeleteFault value) {
        return new JAXBElement<EventDeleteFault>(_EventDeleteFault_QNAME, EventDeleteFault.class, null, value);
    }

}
