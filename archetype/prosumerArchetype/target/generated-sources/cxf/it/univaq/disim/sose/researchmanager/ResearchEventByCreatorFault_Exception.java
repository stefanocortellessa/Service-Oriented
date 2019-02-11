
package it.univaq.disim.sose.researchmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-11T16:18:35.821+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "researchEventByCreatorFault", targetNamespace = "http://it.univaq.disim.sose.touristicguide/researchManager")
public class ResearchEventByCreatorFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.researchmanager.ResearchEventByCreatorFault researchEventByCreatorFault;

    public ResearchEventByCreatorFault_Exception() {
        super();
    }

    public ResearchEventByCreatorFault_Exception(String message) {
        super(message);
    }

    public ResearchEventByCreatorFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ResearchEventByCreatorFault_Exception(String message, it.univaq.disim.sose.researchmanager.ResearchEventByCreatorFault researchEventByCreatorFault) {
        super(message);
        this.researchEventByCreatorFault = researchEventByCreatorFault;
    }

    public ResearchEventByCreatorFault_Exception(String message, it.univaq.disim.sose.researchmanager.ResearchEventByCreatorFault researchEventByCreatorFault, java.lang.Throwable cause) {
        super(message, cause);
        this.researchEventByCreatorFault = researchEventByCreatorFault;
    }

    public it.univaq.disim.sose.researchmanager.ResearchEventByCreatorFault getFaultInfo() {
        return this.researchEventByCreatorFault;
    }
}
