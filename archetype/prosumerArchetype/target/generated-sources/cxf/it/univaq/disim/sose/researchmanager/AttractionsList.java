
package it.univaq.disim.sose.researchmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per attractionsList complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="attractionsList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attractionElement" type="{http://it.univaq.disim.sose.touristicguide/researchManager}attractionElement" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attractionsList", propOrder = {
    "attractionElement"
})
public class AttractionsList {

    @XmlElement(required = true)
    protected List<AttractionElement> attractionElement;

    /**
     * Gets the value of the attractionElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attractionElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttractionElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttractionElement }
     * 
     * 
     */
    public List<AttractionElement> getAttractionElement() {
        if (attractionElement == null) {
            attractionElement = new ArrayList<AttractionElement>();
        }
        return this.attractionElement;
    }

}
