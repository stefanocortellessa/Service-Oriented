package it.univaq.disim.sose.researchmanager;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-11T16:18:35.831+01:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "researchManagerService",
                  wsdlLocation = "file:/home/iacobs/eclipse-workspace-sose-project/Service-Oriented/archetype/prosumerArchetype/src/main/resources/clients/researchManager.wsdl",
                  targetNamespace = "http://it.univaq.disim.sose.touristicguide/researchManager")
public class ResearchManagerService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://it.univaq.disim.sose.touristicguide/researchManager", "researchManagerService");
    public final static QName ResearchManagerPort = new QName("http://it.univaq.disim.sose.touristicguide/researchManager", "researchManagerPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/iacobs/eclipse-workspace-sose-project/Service-Oriented/archetype/prosumerArchetype/src/main/resources/clients/researchManager.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ResearchManagerService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/iacobs/eclipse-workspace-sose-project/Service-Oriented/archetype/prosumerArchetype/src/main/resources/clients/researchManager.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ResearchManagerService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ResearchManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ResearchManagerService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ResearchManagerService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ResearchManagerService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ResearchManagerService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ResearchManagerPT
     */
    @WebEndpoint(name = "researchManagerPort")
    public ResearchManagerPT getResearchManagerPort() {
        return super.getPort(ResearchManagerPort, ResearchManagerPT.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ResearchManagerPT
     */
    @WebEndpoint(name = "researchManagerPort")
    public ResearchManagerPT getResearchManagerPort(WebServiceFeature... features) {
        return super.getPort(ResearchManagerPort, ResearchManagerPT.class, features);
    }

}
