
package it.univaq.disim.sose.prosumer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per accountSignupFault complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="accountSignupFault"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="faultInsert" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "accountSignupFault", propOrder = {
    "faultInsert",
    "message"
})
public class AccountSignupFault {

    @XmlElement(required = true)
    protected String faultInsert;
    @XmlElement(required = true)
    protected String message;

    /**
     * Recupera il valore della proprietà faultInsert.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultInsert() {
        return faultInsert;
    }

    /**
     * Imposta il valore della proprietà faultInsert.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultInsert(String value) {
        this.faultInsert = value;
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