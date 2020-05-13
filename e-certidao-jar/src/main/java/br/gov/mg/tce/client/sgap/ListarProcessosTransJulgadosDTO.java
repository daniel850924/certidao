
package br.gov.mg.tce.client.sgap;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listarProcessosTransJulgadosDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listarProcessosTransJulgadosDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDecisao" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="dscDecisao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroProcesso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sglSituacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarProcessosTransJulgadosDTO", propOrder = {
    "codDecisao",
    "dscDecisao",
    "numeroProcesso",
    "sglSituacao"
})
public class ListarProcessosTransJulgadosDTO {

    protected BigDecimal codDecisao;
    protected String dscDecisao;
    protected Long numeroProcesso;
    protected String sglSituacao;

    /**
     * Gets the value of the codDecisao property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodDecisao() {
        return codDecisao;
    }

    /**
     * Sets the value of the codDecisao property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodDecisao(BigDecimal value) {
        this.codDecisao = value;
    }

    /**
     * Gets the value of the dscDecisao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscDecisao() {
        return dscDecisao;
    }

    /**
     * Sets the value of the dscDecisao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscDecisao(String value) {
        this.dscDecisao = value;
    }

    /**
     * Gets the value of the numeroProcesso property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroProcesso() {
        return numeroProcesso;
    }

    /**
     * Sets the value of the numeroProcesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroProcesso(Long value) {
        this.numeroProcesso = value;
    }

    /**
     * Gets the value of the sglSituacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSglSituacao() {
        return sglSituacao;
    }

    /**
     * Sets the value of the sglSituacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSglSituacao(String value) {
        this.sglSituacao = value;
    }

}
