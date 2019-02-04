
package it.univaq.disim.sose.insertevent;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-04T14:03:56.664+01:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "deleteEventFault", targetNamespace = "http://it.univaq.disim.sose/insertEvent")
public class DeleteEventFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;

    private it.univaq.disim.sose.insertevent.DeleteEventFault deleteEventFault;

    public DeleteEventFault_Exception() {
        super();
    }

    public DeleteEventFault_Exception(String message) {
        super(message);
    }

    public DeleteEventFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public DeleteEventFault_Exception(String message, it.univaq.disim.sose.insertevent.DeleteEventFault deleteEventFault) {
        super(message);
        this.deleteEventFault = deleteEventFault;
    }

    public DeleteEventFault_Exception(String message, it.univaq.disim.sose.insertevent.DeleteEventFault deleteEventFault, java.lang.Throwable cause) {
        super(message, cause);
        this.deleteEventFault = deleteEventFault;
    }

    public it.univaq.disim.sose.insertevent.DeleteEventFault getFaultInfo() {
        return this.deleteEventFault;
    }
}