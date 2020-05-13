
package br.gov.mg.tce.client.pca.web;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for municipio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="municipio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codMesoRegiao" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="codMicroRegiao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codMunicipioSgap" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="codMunicipioSgapCidade" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="codMunicipioTse" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="codTcemg" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codUf" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="dscRegiaoPlanejamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomMesoRegiao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomMicroRegiao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomMunicipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomUf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seqDimCoordenadorias" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="sglUf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "municipio", propOrder = {
    "codMesoRegiao",
    "codMicroRegiao",
    "codMunicipio",
    "codMunicipioSgap",
    "codMunicipioSgapCidade",
    "codMunicipioTse",
    "codTcemg",
    "codUf",
    "dscRegiaoPlanejamento",
    "nomMesoRegiao",
    "nomMicroRegiao",
    "nomMunicipio",
    "nomUf",
    "seqDimCoordenadorias",
    "sglUf"
})
public class Municipio {

    protected Short codMesoRegiao;
    protected Integer codMicroRegiao;
    protected Integer codMunicipio;
    protected BigInteger codMunicipioSgap;
    protected BigInteger codMunicipioSgapCidade;
    protected BigInteger codMunicipioTse;
    protected Integer codTcemg;
    protected Short codUf;
    protected String dscRegiaoPlanejamento;
    protected String nomMesoRegiao;
    protected String nomMicroRegiao;
    protected String nomMunicipio;
    protected String nomUf;
    protected BigInteger seqDimCoordenadorias;
    protected String sglUf;

    /**
     * Gets the value of the codMesoRegiao property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodMesoRegiao() {
        return codMesoRegiao;
    }

    /**
     * Sets the value of the codMesoRegiao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodMesoRegiao(Short value) {
        this.codMesoRegiao = value;
    }

    /**
     * Gets the value of the codMicroRegiao property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodMicroRegiao() {
        return codMicroRegiao;
    }

    /**
     * Sets the value of the codMicroRegiao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodMicroRegiao(Integer value) {
        this.codMicroRegiao = value;
    }

    /**
     * Gets the value of the codMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * Sets the value of the codMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodMunicipio(Integer value) {
        this.codMunicipio = value;
    }

    /**
     * Gets the value of the codMunicipioSgap property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodMunicipioSgap() {
        return codMunicipioSgap;
    }

    /**
     * Sets the value of the codMunicipioSgap property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodMunicipioSgap(BigInteger value) {
        this.codMunicipioSgap = value;
    }

    /**
     * Gets the value of the codMunicipioSgapCidade property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodMunicipioSgapCidade() {
        return codMunicipioSgapCidade;
    }

    /**
     * Sets the value of the codMunicipioSgapCidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodMunicipioSgapCidade(BigInteger value) {
        this.codMunicipioSgapCidade = value;
    }

    /**
     * Gets the value of the codMunicipioTse property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodMunicipioTse() {
        return codMunicipioTse;
    }

    /**
     * Sets the value of the codMunicipioTse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodMunicipioTse(BigInteger value) {
        this.codMunicipioTse = value;
    }

    /**
     * Gets the value of the codTcemg property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodTcemg() {
        return codTcemg;
    }

    /**
     * Sets the value of the codTcemg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodTcemg(Integer value) {
        this.codTcemg = value;
    }

    /**
     * Gets the value of the codUf property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodUf() {
        return codUf;
    }

    /**
     * Sets the value of the codUf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodUf(Short value) {
        this.codUf = value;
    }

    /**
     * Gets the value of the dscRegiaoPlanejamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscRegiaoPlanejamento() {
        return dscRegiaoPlanejamento;
    }

    /**
     * Sets the value of the dscRegiaoPlanejamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscRegiaoPlanejamento(String value) {
        this.dscRegiaoPlanejamento = value;
    }

    /**
     * Gets the value of the nomMesoRegiao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomMesoRegiao() {
        return nomMesoRegiao;
    }

    /**
     * Sets the value of the nomMesoRegiao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomMesoRegiao(String value) {
        this.nomMesoRegiao = value;
    }

    /**
     * Gets the value of the nomMicroRegiao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomMicroRegiao() {
        return nomMicroRegiao;
    }

    /**
     * Sets the value of the nomMicroRegiao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomMicroRegiao(String value) {
        this.nomMicroRegiao = value;
    }

    /**
     * Gets the value of the nomMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomMunicipio() {
        return nomMunicipio;
    }

    /**
     * Sets the value of the nomMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomMunicipio(String value) {
        this.nomMunicipio = value;
    }

    /**
     * Gets the value of the nomUf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomUf() {
        return nomUf;
    }

    /**
     * Sets the value of the nomUf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomUf(String value) {
        this.nomUf = value;
    }

    /**
     * Gets the value of the seqDimCoordenadorias property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSeqDimCoordenadorias() {
        return seqDimCoordenadorias;
    }

    /**
     * Sets the value of the seqDimCoordenadorias property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSeqDimCoordenadorias(BigInteger value) {
        this.seqDimCoordenadorias = value;
    }

    /**
     * Gets the value of the sglUf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSglUf() {
        return sglUf;
    }

    /**
     * Sets the value of the sglUf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSglUf(String value) {
        this.sglUf = value;
    }

}
