
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for indiceInvPrePca complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="indiceInvPrePca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bolNaoIndice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="codIndiceInvPrePca" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="indiceDentroLimite" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="loginUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numProcesso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="percentInvEducacao" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvFundeb" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalExecutivo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoalLegislativo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvSaude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="vlrRestoPagEducacao" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="vlrRestoPagSaude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indiceInvPrePca", propOrder = {
    "bolNaoIndice",
    "codIndiceInvPrePca",
    "codMunicipio",
    "indiceDentroLimite",
    "loginUsuario",
    "numAno",
    "numProcesso",
    "percentInvEducacao",
    "percentInvFundeb",
    "percentInvPessoalExecutivo",
    "percentInvPessoalLegislativo",
    "percentInvSaude",
    "vlrRestoPagEducacao",
    "vlrRestoPagSaude"
})
public class IndiceInvPrePca {

    protected Boolean bolNaoIndice;
    protected Long codIndiceInvPrePca;
    protected Long codMunicipio;
    protected Boolean indiceDentroLimite;
    protected String loginUsuario;
    protected Long numAno;
    protected Long numProcesso;
    protected Double percentInvEducacao;
    protected Double percentInvFundeb;
    protected Double percentInvPessoalExecutivo;
    protected Double percentInvPessoalLegislativo;
    protected Double percentInvSaude;
    protected Double vlrRestoPagEducacao;
    protected Double vlrRestoPagSaude;

    /**
     * Gets the value of the bolNaoIndice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBolNaoIndice() {
        return bolNaoIndice;
    }

    /**
     * Sets the value of the bolNaoIndice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBolNaoIndice(Boolean value) {
        this.bolNaoIndice = value;
    }

    /**
     * Gets the value of the codIndiceInvPrePca property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodIndiceInvPrePca() {
        return codIndiceInvPrePca;
    }

    /**
     * Sets the value of the codIndiceInvPrePca property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodIndiceInvPrePca(Long value) {
        this.codIndiceInvPrePca = value;
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
     * Gets the value of the indiceDentroLimite property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndiceDentroLimite() {
        return indiceDentroLimite;
    }

    /**
     * Sets the value of the indiceDentroLimite property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndiceDentroLimite(Boolean value) {
        this.indiceDentroLimite = value;
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

    /**
     * Gets the value of the vlrRestoPagEducacao property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVlrRestoPagEducacao() {
        return vlrRestoPagEducacao;
    }

    /**
     * Sets the value of the vlrRestoPagEducacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVlrRestoPagEducacao(Double value) {
        this.vlrRestoPagEducacao = value;
    }

    /**
     * Gets the value of the vlrRestoPagSaude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVlrRestoPagSaude() {
        return vlrRestoPagSaude;
    }

    /**
     * Sets the value of the vlrRestoPagSaude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVlrRestoPagSaude(Double value) {
        this.vlrRestoPagSaude = value;
    }

}
