
package it.univaq.disim.sose.accountmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-04T11:56:21.365+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "checkSessionFault", targetNamespace = "http://it.univaq.disim.sose/accountManager")
public class CheckSessionFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.accountmanager.CheckSessionFault checkSessionFault;

    public CheckSessionFault_Exception() {
        super();
    }

    public CheckSessionFault_Exception(String message) {
        super(message);
    }

    public CheckSessionFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public CheckSessionFault_Exception(String message, it.univaq.disim.sose.accountmanager.CheckSessionFault checkSessionFault) {
        super(message);
        this.checkSessionFault = checkSessionFault;
    }

    public CheckSessionFault_Exception(String message, it.univaq.disim.sose.accountmanager.CheckSessionFault checkSessionFault, java.lang.Throwable cause) {
        super(message, cause);
        this.checkSessionFault = checkSessionFault;
    }

    public it.univaq.disim.sose.accountmanager.CheckSessionFault getFaultInfo() {
        return this.checkSessionFault;
    }
}
