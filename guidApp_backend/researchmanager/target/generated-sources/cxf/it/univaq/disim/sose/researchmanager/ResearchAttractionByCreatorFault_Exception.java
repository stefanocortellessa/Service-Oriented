
package it.univaq.disim.sose.researchmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-06T16:33:06.367+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "researchAttractionByCreatorFault", targetNamespace = "http://it.univaq.disim.sose/researchManager")
public class ResearchAttractionByCreatorFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorFault researchAttractionByCreatorFault;

    public ResearchAttractionByCreatorFault_Exception() {
        super();
    }

    public ResearchAttractionByCreatorFault_Exception(String message) {
        super(message);
    }

    public ResearchAttractionByCreatorFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ResearchAttractionByCreatorFault_Exception(String message, it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorFault researchAttractionByCreatorFault) {
        super(message);
        this.researchAttractionByCreatorFault = researchAttractionByCreatorFault;
    }

    public ResearchAttractionByCreatorFault_Exception(String message, it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorFault researchAttractionByCreatorFault, java.lang.Throwable cause) {
        super(message, cause);
        this.researchAttractionByCreatorFault = researchAttractionByCreatorFault;
    }

    public it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorFault getFaultInfo() {
        return this.researchAttractionByCreatorFault;
    }
}
