
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for analiseDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="analiseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codAnalise" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{http://integracaoweb.ecertidao.tcemg/}indiceDelibInv" minOccurs="0"/>
 *         &lt;element ref="{http://integracaoweb.ecertidao.tcemg/}indiceInvPrePca" minOccurs="0"/>
 *         &lt;element ref="{http://integracaoweb.ecertidao.tcemg/}indiceParecerPrevio" minOccurs="0"/>
 *         &lt;element ref="{http://integracaoweb.ecertidao.tcemg/}indiceSubstituta" minOccurs="0"/>
 *         &lt;element name="nomMunicipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numAnoExercicio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numProcesso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tipoAnalise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "analiseDTO", propOrder = {
    "codAnalise",
    "codMunicipio",
    "indiceDelibInv",
    "indiceInvPrePca",
    "indiceParecerPrevio",
    "indiceSubstituta",
    "nomMunicipio",
    "numAnoExercicio",
    "numProcesso",
    "tipoAnalise"
})
public class AnaliseDTO {

    protected Long codAnalise;
    protected Integer codMunicipio;
    @XmlElement(namespace = "http://integracaoweb.ecertidao.tcemg/")
    protected IndiceDelibInv indiceDelibInv;
    @XmlElement(namespace = "http://integracaoweb.ecertidao.tcemg/")
    protected IndiceInvPrePca indiceInvPrePca;
    @XmlElement(namespace = "http://integracaoweb.ecertidao.tcemg/")
    protected IndiceParecerPrevio indiceParecerPrevio;
    @XmlElement(namespace = "http://integracaoweb.ecertidao.tcemg/")
    protected IndiceSubstituta indiceSubstituta;
    protected String nomMunicipio;
    protected Long numAnoExercicio;
    protected Long numProcesso;
    protected String tipoAnalise;

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
     * Gets the value of the indiceDelibInv property.
     * 
     * @return
     *     possible object is
     *     {@link IndiceDelibInv }
     *     
     */
    public IndiceDelibInv getIndiceDelibInv() {
        return indiceDelibInv;
    }

    /**
     * Sets the value of the indiceDelibInv property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndiceDelibInv }
     *     
     */
    public void setIndiceDelibInv(IndiceDelibInv value) {
        this.indiceDelibInv = value;
    }

    /**
     * Gets the value of the indiceInvPrePca property.
     * 
     * @return
     *     possible object is
     *     {@link IndiceInvPrePca }
     *     
     */
    public IndiceInvPrePca getIndiceInvPrePca() {
        return indiceInvPrePca;
    }

    /**
     * Sets the value of the indiceInvPrePca property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndiceInvPrePca }
     *     
     */
    public void setIndiceInvPrePca(IndiceInvPrePca value) {
        this.indiceInvPrePca = value;
    }

    /**
     * Gets the value of the indiceParecerPrevio property.
     * 
     * @return
     *     possible object is
     *     {@link IndiceParecerPrevio }
     *     
     */
    public IndiceParecerPrevio getIndiceParecerPrevio() {
        return indiceParecerPrevio;
    }

    /**
     * Sets the value of the indiceParecerPrevio property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndiceParecerPrevio }
     *     
     */
    public void setIndiceParecerPrevio(IndiceParecerPrevio value) {
        this.indiceParecerPrevio = value;
    }

    /**
     * Gets the value of the indiceSubstituta property.
     * 
     * @return
     *     possible object is
     *     {@link IndiceSubstituta }
     *     
     */
    public IndiceSubstituta getIndiceSubstituta() {
        return indiceSubstituta;
    }

    /**
     * Sets the value of the indiceSubstituta property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndiceSubstituta }
     *     
     */
    public void setIndiceSubstituta(IndiceSubstituta value) {
        this.indiceSubstituta = value;
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
     * Gets the value of the numAnoExercicio property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumAnoExercicio() {
        return numAnoExercicio;
    }

    /**
     * Sets the value of the numAnoExercicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumAnoExercicio(Long value) {
        this.numAnoExercicio = value;
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
     * Gets the value of the tipoAnalise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAnalise() {
        return tipoAnalise;
    }

    /**
     * Sets the value of the tipoAnalise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAnalise(String value) {
        this.tipoAnalise = value;
    }

}
