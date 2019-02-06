
package it.univaq.disim.sose.researchmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per researchAttractionDetailResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="researchAttractionDetailResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attractionElement" type="{http://it.univaq.disim.sose/researchManager}attractionElement"/&gt;
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
@XmlType(name = "researchAttractionDetailResponse", propOrder = {
    "attractionElement",
    "message"
})
public class ResearchAttractionDetailResponse {

    @XmlElement(required = true)
    protected AttractionElement attractionElement;
    @XmlElement(required = true)
    protected String message;

    /**
     * Recupera il valore della proprietà attractionElement.
     * 
     * @return
     *     possible object is
     *     {@link AttractionElement }
     *     
     */
    public AttractionElement getAttractionElement() {
        return attractionElement;
    }

    /**
     * Imposta il valore della proprietà attractionElement.
     * 
     * @param value
     *     allowed object is
     *     {@link AttractionElement }
     *     
     */
    public void setAttractionElement(AttractionElement value) {
        this.attractionElement = value;
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
