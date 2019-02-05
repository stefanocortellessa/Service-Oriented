
package it.univaq.disim.sose.insertevent;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-05T15:38:55.359+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "insertEventFault", targetNamespace = "http://it.univaq.disim.sose/insertEvent")
public class InsertEventFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.insertevent.InsertEventFault insertEventFault;

    public InsertEventFault_Exception() {
        super();
    }

    public InsertEventFault_Exception(String message) {
        super(message);
    }

    public InsertEventFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public InsertEventFault_Exception(String message, it.univaq.disim.sose.insertevent.InsertEventFault insertEventFault) {
        super(message);
        this.insertEventFault = insertEventFault;
    }

    public InsertEventFault_Exception(String message, it.univaq.disim.sose.insertevent.InsertEventFault insertEventFault, java.lang.Throwable cause) {
        super(message, cause);
        this.insertEventFault = insertEventFault;
    }

    public it.univaq.disim.sose.insertevent.InsertEventFault getFaultInfo() {
        return this.insertEventFault;
    }
}
