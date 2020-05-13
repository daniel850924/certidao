
package br.gov.mg.tce.client.pca.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recuperaIndicePCA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recuperaIndicePCA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codAnalise" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="consolidado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recuperaIndicePCA", propOrder = {
    "codAnalise",
    "consolidado"
})
public class RecuperaIndicePCA {

    protected Long codAnalise;
    protected Boolean consolidado;

    /**
     * Gets the value of the codAnalise property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodAnalise() {
        return codAnalise;
    }

    /**
     * Sets the value of the codAnalise property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodAnalise(Long value) {
        this.codAnalise = value;
    }

    /**
     * Gets the value of the consolidado property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConsolidado() {
        return consolidado;
    }

    /**
     * Sets the value of the consolidado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConsolidado(Boolean value) {
        this.consolidado = value;
    }

}
