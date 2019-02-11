
package it.univaq.disim.sose.prosumer;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-11T16:18:35.328+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "eventResearchFault", targetNamespace = "http://it.univaq.disim.sose.touristicguide/prosumer")
public class EventResearchFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.prosumer.EventResearchFault eventResearchFault;

    public EventResearchFault_Exception() {
        super();
    }

    public EventResearchFault_Exception(String message) {
        super(message);
    }

    public EventResearchFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public EventResearchFault_Exception(String message, it.univaq.disim.sose.prosumer.EventResearchFault eventResearchFault) {
        super(message);
        this.eventResearchFault = eventResearchFault;
    }

    public EventResearchFault_Exception(String message, it.univaq.disim.sose.prosumer.EventResearchFault eventResearchFault, java.lang.Throwable cause) {
        super(message, cause);
        this.eventResearchFault = eventResearchFault;
    }

    public it.univaq.disim.sose.prosumer.EventResearchFault getFaultInfo() {
        return this.eventResearchFault;
    }
}
