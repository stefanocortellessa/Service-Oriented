
package it.univaq.disim.sose.researchmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-06T22:49:07.425+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "researchEventFault", targetNamespace = "http://it.univaq.disim.sose/researchManager")
public class ResearchEventFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.researchmanager.ResearchEventFault researchEventFault;

    public ResearchEventFault_Exception() {
        super();
    }

    public ResearchEventFault_Exception(String message) {
        super(message);
    }

    public ResearchEventFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ResearchEventFault_Exception(String message, it.univaq.disim.sose.researchmanager.ResearchEventFault researchEventFault) {
        super(message);
        this.researchEventFault = researchEventFault;
    }

    public ResearchEventFault_Exception(String message, it.univaq.disim.sose.researchmanager.ResearchEventFault researchEventFault, java.lang.Throwable cause) {
        super(message, cause);
        this.researchEventFault = researchEventFault;
    }

    public it.univaq.disim.sose.researchmanager.ResearchEventFault getFaultInfo() {
        return this.researchEventFault;
    }
}