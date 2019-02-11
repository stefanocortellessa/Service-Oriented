
package it.univaq.disim.sose.researchmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per researchAttractionByCreatorRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="researchAttractionByCreatorRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
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
@XmlType(name = "researchAttractionByCreatorRequest", propOrder = {
    "creatorId"
})
public class ResearchAttractionByCreatorRequest {

    protected long creatorId;

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
