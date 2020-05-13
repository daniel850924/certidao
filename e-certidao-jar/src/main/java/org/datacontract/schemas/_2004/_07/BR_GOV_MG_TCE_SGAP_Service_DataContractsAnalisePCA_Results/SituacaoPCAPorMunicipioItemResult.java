/**
 * SituacaoPCAPorMunicipioItemResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results;

public class SituacaoPCAPorMunicipioItemResult  implements java.io.Serializable {
    private java.lang.String codMunicipio;

    private java.lang.Long codProcesso;

    private java.lang.String decisao;

    private java.lang.Integer exercicio;

    private java.lang.String municipio;

    private java.lang.String transitoEmJulgado;

    public SituacaoPCAPorMunicipioItemResult() {
    }

    public SituacaoPCAPorMunicipioItemResult(
           java.lang.String codMunicipio,
           java.lang.Long codProcesso,
           java.lang.String decisao,
           java.lang.Integer exercicio,
           java.lang.String municipio,
           java.lang.String transitoEmJulgado) {
           this.codMunicipio = codMunicipio;
           this.codProcesso = codProcesso;
           this.decisao = decisao;
           this.exercicio = exercicio;
           this.municipio = municipio;
           this.transitoEmJulgado = transitoEmJulgado;
    }


    /**
     * Gets the codMunicipio value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @return codMunicipio
     */
    public java.lang.String getCodMunicipio() {
        return codMunicipio;
    }


    /**
     * Sets the codMunicipio value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @param codMunicipio
     */
    public void setCodMunicipio(java.lang.String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }


    /**
     * Gets the codProcesso value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @return codProcesso
     */
    public java.lang.Long getCodProcesso() {
        return codProcesso;
    }


    /**
     * Sets the codProcesso value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @param codProcesso
     */
    public void setCodProcesso(java.lang.Long codProcesso) {
        this.codProcesso = codProcesso;
    }


    /**
     * Gets the decisao value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @return decisao
     */
    public java.lang.String getDecisao() {
        return decisao;
    }


    /**
     * Sets the decisao value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @param decisao
     */
    public void setDecisao(java.lang.String decisao) {
        this.decisao = decisao;
    }


    /**
     * Gets the exercicio value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @return exercicio
     */
    public java.lang.Integer getExercicio() {
        return exercicio;
    }


    /**
     * Sets the exercicio value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @param exercicio
     */
    public void setExercicio(java.lang.Integer exercicio) {
        this.exercicio = exercicio;
    }


    /**
     * Gets the municipio value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @return municipio
     */
    public java.lang.String getMunicipio() {
        return municipio;
    }


    /**
     * Sets the municipio value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @param municipio
     */
    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }


    /**
     * Gets the transitoEmJulgado value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @return transitoEmJulgado
     */
    public java.lang.String getTransitoEmJulgado() {
        return transitoEmJulgado;
    }


    /**
     * Sets the transitoEmJulgado value for this SituacaoPCAPorMunicipioItemResult.
     * 
     * @param transitoEmJulgado
     */
    public void setTransitoEmJulgado(java.lang.String transitoEmJulgado) {
        this.transitoEmJulgado = transitoEmJulgado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SituacaoPCAPorMunicipioItemResult)) return false;
        SituacaoPCAPorMunicipioItemResult other = (SituacaoPCAPorMunicipioItemResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codMunicipio==null && other.getCodMunicipio()==null) || 
             (this.codMunicipio!=null &&
              this.codMunicipio.equals(other.getCodMunicipio()))) &&
            ((this.codProcesso==null && other.getCodProcesso()==null) || 
             (this.codProcesso!=null &&
              this.codProcesso.equals(other.getCodProcesso()))) &&
            ((this.decisao==null && other.getDecisao()==null) || 
             (this.decisao!=null &&
              this.decisao.equals(other.getDecisao()))) &&
            ((this.exercicio==null && other.getExercicio()==null) || 
             (this.exercicio!=null &&
              this.exercicio.equals(other.getExercicio()))) &&
            ((this.municipio==null && other.getMunicipio()==null) || 
             (this.municipio!=null &&
              this.municipio.equals(other.getMunicipio()))) &&
            ((this.transitoEmJulgado==null && other.getTransitoEmJulgado()==null) || 
             (this.transitoEmJulgado!=null &&
              this.transitoEmJulgado.equals(other.getTransitoEmJulgado())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCodMunicipio() != null) {
            _hashCode += getCodMunicipio().hashCode();
        }
        if (getCodProcesso() != null) {
            _hashCode += getCodProcesso().hashCode();
        }
        if (getDecisao() != null) {
            _hashCode += getDecisao().hashCode();
        }
        if (getExercicio() != null) {
            _hashCode += getExercicio().hashCode();
        }
        if (getMunicipio() != null) {
            _hashCode += getMunicipio().hashCode();
        }
        if (getTransitoEmJulgado() != null) {
            _hashCode += getTransitoEmJulgado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SituacaoPCAPorMunicipioItemResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "SituacaoPCAPorMunicipioItemResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codMunicipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "CodMunicipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codProcesso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "CodProcesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decisao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "Decisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exercicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "Exercicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("municipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "Municipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transitoEmJulgado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "TransitoEmJulgado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
