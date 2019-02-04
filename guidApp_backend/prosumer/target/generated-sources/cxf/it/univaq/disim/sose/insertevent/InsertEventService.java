package it.univaq.disim.sose.insertevent;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-04T14:03:56.677+01:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "InsertEventService",
                  wsdlLocation = "file:/home/iacobs/eclipse-workspace-sose-project/Service-Oriented/guidApp_backend/prosumer/src/main/resources/clients/insertEvent.wsdl",
                  targetNamespace = "http://it.univaq.disim.sose/insertEvent")
public class InsertEventService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://it.univaq.disim.sose/insertEvent", "InsertEventService");
    public final static QName InsertEventPort = new QName("http://it.univaq.disim.sose/insertEvent", "insertEventPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/iacobs/eclipse-workspace-sose-project/Service-Oriented/guidApp_backend/prosumer/src/main/resources/clients/insertEvent.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(InsertEventService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/iacobs/eclipse-workspace-sose-project/Service-Oriented/guidApp_backend/prosumer/src/main/resources/clients/insertEvent.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public InsertEventService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public InsertEventService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InsertEventService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public InsertEventService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public InsertEventService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public InsertEventService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns InsertEventPT
     */
    @WebEndpoint(name = "insertEventPort")
    public InsertEventPT getInsertEventPort() {
        return super.getPort(InsertEventPort, InsertEventPT.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InsertEventPT
     */
    @WebEndpoint(name = "insertEventPort")
    public InsertEventPT getInsertEventPort(WebServiceFeature... features) {
        return super.getPort(InsertEventPort, InsertEventPT.class, features);
    }

}