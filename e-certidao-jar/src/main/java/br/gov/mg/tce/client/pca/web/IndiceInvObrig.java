
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for indiceInvObrig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="indiceInvObrig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codIndiceInvObrig" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="loginUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numProcesso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numProtocolo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="percentInvEducacao" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvFundeb" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalExecutivo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalLegislativo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
@XmlType(name = "indiceInvObrig", propOrder = {
    "codIndiceInvObrig",
    "codMunicipio",
    "loginUsuario",
    "numAno",
    "numProcesso",
    "numProtocolo",
    "percentInvEducacao",
    "percentInvFundeb",
    "percentInvPessoalExecutivo",
    "percentInvPessoalLegislativo",
    "percentInvSaude"
})
public class IndiceInvObrig {

    protected Long codIndiceInvObrig;
    protected Long codMunicipio;
    protected String loginUsuario;
    protected Long numAno;
    protected Long numProcesso;
    protected Long numProtocolo;
    protected Double percentInvEducacao;
    protected Double percentInvFundeb;
    protected Double percentInvPessoalExecutivo;
    protected Double percentInvPessoalLegislativo;
    protected Double percentInvSaude;

    /**
     * Gets the value of the codIndiceInvObrig property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodIndiceInvObrig() {
        return codIndiceInvObrig;
    }

    /**
     * Sets the value of the codIndiceInvObrig property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodIndiceInvObrig(Long value) {
        this.codIndiceInvObrig = value;
    }

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
     * Gets the value of the loginUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginUsuario() {
        return loginUsuario;
    }

    /**
     * Sets the value of the loginUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginUsuario(String value) {
        this.loginUsuario = value;
    }

    /**
     * Gets the value of the numAno property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumAno() {
        return numAno;
    }

    /**
     * Sets the value of the numAno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumAno(Long value) {
        this.numAno = value;
    }

    /**
     * Gets the value of the numProcesso property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumProcesso() {
        return numProcesso;
    }

    /**
     * Sets the value of the numProcesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumProcesso(Long value) {
        this.numProcesso = value;
    }

    /**
     * Gets the value of the numProtocolo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumProtocolo() {
        return numProtocolo;
    }

    /**
     * Sets the value of the numProtocolo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumProtocolo(Long value) {
        this.numProtocolo = value;
    }

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
     * Gets the value of the percentInvFundeb property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvFundeb() {
        return percentInvFundeb;
    }

    /**
     * Sets the value of the percentInvFundeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvFundeb(Double value) {
        this.percentInvFundeb = value;
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
