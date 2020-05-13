
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for indiceParecerPrevio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="indiceParecerPrevio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codIndiceInvObrig" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="datCadastro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="indInsignificancia" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="indObsEducacao" type="{http://integracaoweb.ecertidao.tcemg/}indiceObservacao" minOccurs="0"/>
 *         &lt;element name="indObsPessoal" type="{http://integracaoweb.ecertidao.tcemg/}indiceObservacao" minOccurs="0"/>
 *         &lt;element name="indObsSaude" type="{http://integracaoweb.ecertidao.tcemg/}indiceObservacao" minOccurs="0"/>
 *         &lt;element name="indReconduzido" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="loginUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numProcesso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="percentInvEducacao" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvFundeb" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentInvPessoal" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
@XmlType(name = "indiceParecerPrevio", propOrder = {
    "codIndiceInvObrig",
    "codMunicipio",
    "datCadastro",
    "indInsignificancia",
    "indObsEducacao",
    "indObsPessoal",
    "indObsSaude",
    "indReconduzido",
    "loginUsuario",
    "numAno",
    "numProcesso",
    "percentInvEducacao",
    "percentInvFundeb",
    "percentInvPessoal",
    "percentInvPessoalExecutivo",
    "percentInvPessoalLegislativo",
    "percentInvSaude"
})
public class IndiceParecerPrevio {

    protected Long codIndiceInvObrig;
    protected Long codMunicipio;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datCadastro;
    protected Boolean indInsignificancia;
    protected IndiceObservacao indObsEducacao;
    protected IndiceObservacao indObsPessoal;
    protected IndiceObservacao indObsSaude;
    protected Boolean indReconduzido;
    protected String loginUsuario;
    protected Long numAno;
    protected Long numProcesso;
    protected Double percentInvEducacao;
    protected Double percentInvFundeb;
    protected Double percentInvPessoal;
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
     * Gets the value of the datCadastro property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatCadastro() {
        return datCadastro;
    }

    /**
     * Sets the value of the datCadastro property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatCadastro(XMLGregorianCalendar value) {
        this.datCadastro = value;
    }

    /**
     * Gets the value of the indInsignificancia property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndInsignificancia() {
        return indInsignificancia;
    }

    /**
     * Sets the value of the indInsignificancia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndInsignificancia(Boolean value) {
        this.indInsignificancia = value;
    }

    /**
     * Gets the value of the indObsEducacao property.
     * 
     * @return
     *     possible object is
     *     {@link IndiceObservacao }
     *     
     */
    public IndiceObservacao getIndObsEducacao() {
        return indObsEducacao;
    }

    /**
     * Sets the value of the indObsEducacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndiceObservacao }
     *     
     */
    public void setIndObsEducacao(IndiceObservacao value) {
        this.indObsEducacao = value;
    }

    /**
     * Gets the value of the indObsPessoal property.
     * 
     * @return
     *     possible object is
     *     {@link IndiceObservacao }
     *     
     */
    public IndiceObservacao getIndObsPessoal() {
        return indObsPessoal;
    }

    /**
     * Sets the value of the indObsPessoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndiceObservacao }
     *     
     */
    public void setIndObsPessoal(IndiceObservacao value) {
        this.indObsPessoal = value;
    }

    /**
     * Gets the value of the indObsSaude property.
     * 
     * @return
     *     possible object is
     *     {@link IndiceObservacao }
     *     
     */
    public IndiceObservacao getIndObsSaude() {
        return indObsSaude;
    }

    /**
     * Sets the value of the indObsSaude property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndiceObservacao }
     *     
     */
    public void setIndObsSaude(IndiceObservacao value) {
        this.indObsSaude = value;
    }

    /**
     * Gets the value of the indReconduzido property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndReconduzido() {
        return indReconduzido;
    }

    /**
     * Sets the value of the indReconduzido property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndReconduzido(Boolean value) {
        this.indReconduzido = value;
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
     * Gets the value of the percentInvPessoal property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentInvPessoal() {
        return percentInvPessoal;
    }

    /**
     * Sets the value of the percentInvPessoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentInvPessoal(Double value) {
        this.percentInvPessoal = value;
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
