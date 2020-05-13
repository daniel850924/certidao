
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="anoExercicio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio", propOrder = {
    "codMunicipio",
    "anoExercicio"
})
public class BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio {

    protected Long codMunicipio;
    protected Long anoExercicio;

    /**
     * Gets the value of the codMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * Sets the value of the codMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodMunicipio(Long value) {
        this.codMunicipio = value;
    }

    /**
     * Gets the value of the anoExercicio property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnoExercicio() {
        return anoExercicio;
    }

    /**
     * Sets the value of the anoExercicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnoExercicio(Long value) {
        this.anoExercicio = value;
    }

}
