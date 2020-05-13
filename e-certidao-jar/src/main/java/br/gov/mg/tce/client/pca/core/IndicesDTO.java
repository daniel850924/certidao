
package br.gov.mg.tce.client.pca.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for indicesDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="indicesDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="percentInvEducacao" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalExecutivo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalExecutivoAtualizado" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalLegislativo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalLegislativoAtualizado" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvSaude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indicesDTO", propOrder = {
    "percentInvEducacao",
    "percentInvPessoalExecutivo",
    "percentInvPessoalExecutivoAtualizado",
    "percentInvPessoalLegislativo",
    "percentInvPessoalLegislativoAtualizado",
    "percentInvSaude"
})
public class IndicesDTO {

    protected Double percentInvEducacao;
    protected Double percentInvPessoalExecutivo;
    protected Double percentInvPessoalExecutivoAtualizado;
    protected Double percentInvPessoalLegislativo;
    protected Double percentInvPessoalLegislativoAtualizado;
    protected Double percentInvSaude;

    /**
     * Gets the value of the percentInvEducacao property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvEducacao() {
        return percentInvEducacao;
    }

    /**
     * Sets the value of the percentInvEducacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvEducacao(Double value) {
        this.percentInvEducacao = value;
    }

    /**
     * Gets the value of the percentInvPessoalExecutivo property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvPessoalExecutivo() {
        return percentInvPessoalExecutivo;
    }

    /**
     * Sets the value of the percentInvPessoalExecutivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvPessoalExecutivo(Double value) {
        this.percentInvPessoalExecutivo = value;
    }

    /**
     * Gets the value of the percentInvPessoalExecutivoAtualizado property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvPessoalExecutivoAtualizado() {
        return percentInvPessoalExecutivoAtualizado;
    }

    /**
     * Sets the value of the percentInvPessoalExecutivoAtualizado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvPessoalExecutivoAtualizado(Double value) {
        this.percentInvPessoalExecutivoAtualizado = value;
    }

    /**
     * Gets the value of the percentInvPessoalLegislativo property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvPessoalLegislativo() {
        return percentInvPessoalLegislativo;
    }

    /**
     * Sets the value of the percentInvPessoalLegislativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvPessoalLegislativo(Double value) {
        this.percentInvPessoalLegislativo = value;
    }

    /**
     * Gets the value of the percentInvPessoalLegislativoAtualizado property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvPessoalLegislativoAtualizado() {
        return percentInvPessoalLegislativoAtualizado;
    }

    /**
     * Sets the value of the percentInvPessoalLegislativoAtualizado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvPessoalLegislativoAtualizado(Double value) {
        this.percentInvPessoalLegislativoAtualizado = value;
    }

    /**
     * Gets the value of the percentInvSaude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvSaude() {
        return percentInvSaude;
    }

    /**
     * Sets the value of the percentInvSaude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvSaude(Double value) {
        this.percentInvSaude = value;
    }

}
