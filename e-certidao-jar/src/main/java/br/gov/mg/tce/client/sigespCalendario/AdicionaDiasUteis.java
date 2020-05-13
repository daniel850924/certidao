
package br.gov.mg.tce.client.sigespCalendario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for adicionaDiasUteis complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="adicionaDiasUteis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataRef" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="quantDias" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adicionaDiasUteis", propOrder = {
    "dataRef",
    "quantDias"
})
public class AdicionaDiasUteis {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRef;
    protected long quantDias;

    /**
     * Gets the value of the dataRef property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRef() {
        return dataRef;
    }

    /**
     * Sets the value of the dataRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRef(XMLGregorianCalendar value) {
        this.dataRef = value;
    }

    /**
     * Gets the value of the quantDias property.
     * 
     */
    public long getQuantDias() {
        return quantDias;
    }

    /**
     * Sets the value of the quantDias property.
     * 
     */
    public void setQuantDias(long value) {
        this.quantDias = value;
    }

}
