
package it.univaq.disim.sose.prosumer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per eventDetailResearchResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="eventDetailResearchResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eventElement" type="{http://it.univaq.disim.sose.touristicguide/prosumer}eventElement"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventDetailResearchResponse", propOrder = {
    "eventElement",
    "message"
})
public class EventDetailResearchResponse {

    @XmlElement(required = true)
    protected EventElement eventElement;
    @XmlElement(required = true)
    protected String message;

    /**
     * Recupera il valore della proprietà eventElement.
     * 
     * @return
     *     possible object is
     *     {@link EventElement }
     *     
     */
    public EventElement getEventElement() {
        return eventElement;
    }

    /**
     * Imposta il valore della proprietà eventElement.
     * 
     * @param value
     *     allowed object is
     *     {@link EventElement }
     *     
     */
    public void setEventElement(EventElement value) {
        this.eventElement = value;
    }

    /**
     * Recupera il valore della proprietà message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Imposta il valore della proprietà message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
