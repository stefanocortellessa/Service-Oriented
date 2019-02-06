
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
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="locality" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="categoryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="creatorId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "message",
    "name",
    "locality",
    "categoryName",
    "categoryId",
    "creatorId"
})
public class ResearchAttractionDetailResponse {

    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String locality;
    @XmlElement(required = true)
    protected String categoryName;
    protected long categoryId;
    protected long creatorId;

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
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà locality.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Imposta il valore della proprietà locality.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocality(String value) {
        this.locality = value;
    }

    /**
     * Recupera il valore della proprietà categoryName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Imposta il valore della proprietà categoryName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryName(String value) {
        this.categoryName = value;
    }

    /**
     * Recupera il valore della proprietà categoryId.
     * 
     */
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Imposta il valore della proprietà categoryId.
     * 
     */
    public void setCategoryId(long value) {
        this.categoryId = value;
    }

    /**
     * Recupera il valore della proprietà creatorId.
     * 
     */
    public long getCreatorId() {
        return creatorId;
    }

    /**
     * Imposta il valore della proprietà creatorId.
     * 
     */
    public void setCreatorId(long value) {
        this.creatorId = value;
    }

}
