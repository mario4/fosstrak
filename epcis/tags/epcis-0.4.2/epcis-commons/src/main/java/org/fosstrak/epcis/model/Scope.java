package org.fosstrak.epcis.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Scope complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;Scope&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref=&quot;{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}ScopeAttributes&quot;/&gt;
 *         &lt;element ref=&quot;{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}ScopeInformation&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Scope", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", propOrder = {
        "type", "instanceIdentifier", "identifier", "scopeInformation" })
public class Scope {

    @XmlElement(name = "Type", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
    protected String type;
    @XmlElement(name = "InstanceIdentifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", required = true)
    protected String instanceIdentifier;
    @XmlElement(name = "Identifier", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
    protected String identifier;
    @XmlElementRef(name = "ScopeInformation", namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", type = JAXBElement.class)
    protected List<JAXBElement<?>> scopeInformation;

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *            allowed object is {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the instanceIdentifier property.
     * 
     * @return possible object is {@link String }
     */
    public String getInstanceIdentifier() {
        return instanceIdentifier;
    }

    /**
     * Sets the value of the instanceIdentifier property.
     * 
     * @param value
     *            allowed object is {@link String }
     */
    public void setInstanceIdentifier(String value) {
        this.instanceIdentifier = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return possible object is {@link String }
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *            allowed object is {@link String }
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the scopeInformation property.
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the scopeInformation property.
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getScopeInformation().add(newItem);
     * </pre>
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BusinessService }{@code >}
     * {@link JAXBElement }{@code <}{@link CorrelationInformation }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    public List<JAXBElement<?>> getScopeInformation() {
        if (scopeInformation == null) {
            scopeInformation = new ArrayList<JAXBElement<?>>();
        }
        return this.scopeInformation;
    }

}
