
package it.univaq.disim.sose.researchmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per researchAttractionResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="researchAttractionResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="attractionsList" type="{http://it.univaq.disim.sose.touristicguide/researchManager}attractionsList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researchAttractionResponse", propOrder = {
    "message",
    "attractionsList"
})
public class ResearchAttractionResponse {

    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected AttractionsList attractionsList;

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
     * Recupera il valore della proprietà attractionsList.
     * 
     * @return
     *     possible object is
     *     {@link AttractionsList }
     *     
     */
    public AttractionsList getAttractionsList() {
        return attractionsList;
    }

    /**
     * Imposta il valore della proprietà attractionsList.
     * 
     * @param value
     *     allowed object is
     *     {@link AttractionsList }
     *     
     */
    public void setAttractionsList(AttractionsList value) {
        this.attractionsList = value;
    }

}
