
package it.univaq.disim.sose.prosumer;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-04T15:02:55.214+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "accountLoginFault", targetNamespace = "http://it.univaq.disim.sose/prosumer")
public class AccountSignupFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.prosumer.AccountLoginFault accountLoginFault;

    public AccountSignupFault_Exception() {
        super();
    }

    public AccountSignupFault_Exception(String message) {
        super(message);
    }

    public AccountSignupFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public AccountSignupFault_Exception(String message, it.univaq.disim.sose.prosumer.AccountLoginFault accountLoginFault) {
        super(message);
        this.accountLoginFault = accountLoginFault;
    }

    public AccountSignupFault_Exception(String message, it.univaq.disim.sose.prosumer.AccountLoginFault accountLoginFault, java.lang.Throwable cause) {
        super(message, cause);
        this.accountLoginFault = accountLoginFault;
    }

    public it.univaq.disim.sose.prosumer.AccountLoginFault getFaultInfo() {
        return this.accountLoginFault;
    }
}