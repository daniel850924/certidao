
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://integracaoweb.ecertidao.tcemg/}analiseDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse", propOrder = {
    "_return"
})
public class BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse {

    @XmlElement(name = "return")
    protected AnaliseDTO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link AnaliseDTO }
     *     
     */
    public AnaliseDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnaliseDTO }
     *     
     */
    public void setReturn(AnaliseDTO value) {
        this._return = value;
    }

}
