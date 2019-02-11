
package it.univaq.disim.sose.prosumer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per eventByCreatorResearchResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="eventByCreatorResearchResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="eventsList" type="{http://it.univaq.disim.sose.touristicguide/prosumer}eventsList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventByCreatorResearchResponse", propOrder = {
    "message",
    "eventsList"
})
public class EventByCreatorResearchResponse {

    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected EventsList eventsList;

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

    /**
     * Recupera il valore della proprietà eventsList.
     * 
     * @return
     *     possible object is
     *     {@link EventsList }
     *     
     */
    public EventsList getEventsList() {
        return eventsList;
    }

    /**
     * Imposta il valore della proprietà eventsList.
     * 
     * @param value
     *     allowed object is
     *     {@link EventsList }
     *     
     */
    public void setEventsList(EventsList value) {
        this.eventsList = value;
    }

}
