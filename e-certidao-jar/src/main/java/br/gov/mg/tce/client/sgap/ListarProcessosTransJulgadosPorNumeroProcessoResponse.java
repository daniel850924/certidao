
package br.gov.mg.tce.client.sgap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listarProcessosTransJulgadosPorNumeroProcessoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listarProcessosTransJulgadosPorNumeroProcessoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://processoTransJulgado.sgap.tcemg/}listarProcessosTransJulgadosDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarProcessosTransJulgadosPorNumeroProcessoResponse", propOrder = {
    "_return"
})
public class ListarProcessosTransJulgadosPorNumeroProcessoResponse {

    @XmlElement(name = "return")
    protected ListarProcessosTransJulgadosDTO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ListarProcessosTransJulgadosDTO }
     *     
     */
    public ListarProcessosTransJulgadosDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListarProcessosTransJulgadosDTO }
     *     
     */
    public void setReturn(ListarProcessosTransJulgadosDTO value) {
        this._return = value;
    }

}
