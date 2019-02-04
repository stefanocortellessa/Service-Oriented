
package it.univaq.disim.sose.accountmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-04T15:31:48.421+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "userSignupFault", targetNamespace = "http://it.univaq.disim.sose/accountManager")
public class UserSignupFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.accountmanager.UserSignupFault userSignupFault;

    public UserSignupFault_Exception() {
        super();
    }

    public UserSignupFault_Exception(String message) {
        super(message);
    }

    public UserSignupFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UserSignupFault_Exception(String message, it.univaq.disim.sose.accountmanager.UserSignupFault userSignupFault) {
        super(message);
        this.userSignupFault = userSignupFault;
    }

    public UserSignupFault_Exception(String message, it.univaq.disim.sose.accountmanager.UserSignupFault userSignupFault, java.lang.Throwable cause) {
        super(message, cause);
        this.userSignupFault = userSignupFault;
    }

    public it.univaq.disim.sose.accountmanager.UserSignupFault getFaultInfo() {
        return this.userSignupFault;
    }
}
