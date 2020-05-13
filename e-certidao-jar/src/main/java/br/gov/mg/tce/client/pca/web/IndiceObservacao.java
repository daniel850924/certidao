
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for indiceObservacao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="indiceObservacao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codIndiceObservacao" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dscObservacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dscTipoObservacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="indTipoIndice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indiceObservacao", propOrder = {
    "codIndiceObservacao",
    "dscObservacao",
    "dscTipoObservacao",
    "id",
    "indTipoIndice"
})
public class IndiceObservacao {

    protected Long codIndiceObservacao;
    protected String dscObservacao;
    protected String dscTipoObservacao;
    protected Long id;
    protected String indTipoIndice;

    /**
     * Gets the value of the codIndiceObservacao property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodIndiceObservacao() {
        return codIndiceObservacao;
    }

    /**
     * Sets the value of the codIndiceObservacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodIndiceObservacao(Long value) {
        this.codIndiceObservacao = value;
    }

    /**
     * Gets the value of the dscObservacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscObservacao() {
        return dscObservacao;
    }

    /**
     * Sets the value of the dscObservacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscObservacao(String value) {
        this.dscObservacao = value;
    }

    /**
     * Gets the value of the dscTipoObservacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscTipoObservacao() {
        return dscTipoObservacao;
    }

    /**
     * Sets the value of the dscTipoObservacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscTipoObservacao(String value) {
        this.dscTipoObservacao = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the indTipoIndice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndTipoIndice() {
        return indTipoIndice;
    }

    /**
     * Sets the value of the indTipoIndice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndTipoIndice(String value) {
        this.indTipoIndice = value;
    }

}
