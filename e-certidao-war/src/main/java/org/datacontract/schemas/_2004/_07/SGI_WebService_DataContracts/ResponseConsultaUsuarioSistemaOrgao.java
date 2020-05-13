/**
 * ResponseConsultaUsuarioSistemaOrgao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class ResponseConsultaUsuarioSistemaOrgao  implements java.io.Serializable {
    private java.lang.String codigoIbgeMunicipioOrgao;

    private java.lang.String errorDescription;

    private java.lang.Boolean hasError;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica[] pessoaFisica;

    public ResponseConsultaUsuarioSistemaOrgao() {
    }

    public ResponseConsultaUsuarioSistemaOrgao(
           java.lang.String codigoIbgeMunicipioOrgao,
           java.lang.String errorDescription,
           java.lang.Boolean hasError,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica[] pessoaFisica) {
           this.codigoIbgeMunicipioOrgao = codigoIbgeMunicipioOrgao;
           this.errorDescription = errorDescription;
           this.hasError = hasError;
           this.pessoaFisica = pessoaFisica;
    }


    /**
     * Gets the codigoIbgeMunicipioOrgao value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @return codigoIbgeMunicipioOrgao
     */
    public java.lang.String getCodigoIbgeMunicipioOrgao() {
        return codigoIbgeMunicipioOrgao;
    }


    /**
     * Sets the codigoIbgeMunicipioOrgao value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @param codigoIbgeMunicipioOrgao
     */
    public void setCodigoIbgeMunicipioOrgao(java.lang.String codigoIbgeMunicipioOrgao) {
        this.codigoIbgeMunicipioOrgao = codigoIbgeMunicipioOrgao;
    }


    /**
     * Gets the errorDescription value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the hasError value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the pessoaFisica value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @return pessoaFisica
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica[] getPessoaFisica() {
        return pessoaFisica;
    }


    /**
     * Sets the pessoaFisica value for this ResponseConsultaUsuarioSistemaOrgao.
     * 
     * @param pessoaFisica
     */
    public void setPessoaFisica(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica[] pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseConsultaUsuarioSistemaOrgao)) return false;
        ResponseConsultaUsuarioSistemaOrgao other = (ResponseConsultaUsuarioSistemaOrgao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoIbgeMunicipioOrgao==null && other.getCodigoIbgeMunicipioOrgao()==null) || 
             (this.codigoIbgeMunicipioOrgao!=null &&
              this.codigoIbgeMunicipioOrgao.equals(other.getCodigoIbgeMunicipioOrgao()))) &&
            ((this.errorDescription==null && other.getErrorDescription()==null) || 
             (this.errorDescription!=null &&
              this.errorDescription.equals(other.getErrorDescription()))) &&
            ((this.hasError==null && other.getHasError()==null) || 
             (this.hasError!=null &&
              this.hasError.equals(other.getHasError()))) &&
            ((this.pessoaFisica==null && other.getPessoaFisica()==null) || 
             (this.pessoaFisica!=null &&
              java.util.Arrays.equals(this.pessoaFisica, other.getPessoaFisica())));
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
        if (getCodigoIbgeMunicipioOrgao() != null) {
            _hashCode += getCodigoIbgeMunicipioOrgao().hashCode();
        }
        if (getErrorDescription() != null) {
            _hashCode += getErrorDescription().hashCode();
        }
        if (getHasError() != null) {
            _hashCode += getHasError().hashCode();
        }
        if (getPessoaFisica() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPessoaFisica());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPessoaFisica(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseConsultaUsuarioSistemaOrgao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseConsultaUsuarioSistemaOrgao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoIbgeMunicipioOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codigoIbgeMunicipioOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "errorDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "hasError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pessoaFisica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "pessoaFisica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisica"));
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
