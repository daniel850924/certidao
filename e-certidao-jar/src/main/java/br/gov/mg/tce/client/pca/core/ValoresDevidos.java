
package br.gov.mg.tce.client.pca.core;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for valoresDevidos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="valoresDevidos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vlrFundeb" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="vlrIcms" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valoresDevidos", propOrder = {
    "codMunicipio",
    "vlrFundeb",
    "vlrIcms"
})
public class ValoresDevidos {

    protected Integer codMunicipio;
    protected BigDecimal vlrFundeb;
    protected BigDecimal vlrIcms;

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
     * Gets the value of the vlrFundeb property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVlrFundeb() {
        return vlrFundeb;
    }

    /**
     * Sets the value of the vlrFundeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVlrFundeb(BigDecimal value) {
        this.vlrFundeb = value;
    }

    /**
     * Gets the value of the vlrIcms property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVlrIcms() {
        return vlrIcms;
    }

    /**
     * Sets the value of the vlrIcms property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVlrIcms(BigDecimal value) {
        this.vlrIcms = value;
    }

}
