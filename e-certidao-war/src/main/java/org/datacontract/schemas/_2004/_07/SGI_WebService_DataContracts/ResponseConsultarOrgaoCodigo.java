/**
 * ResponseConsultarOrgaoCodigo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class ResponseConsultarOrgaoCodigo  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario dadosUsuario;

    private java.lang.String errorDescription;

    private java.lang.Boolean hasError;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade orgaoEntidade;

    public ResponseConsultarOrgaoCodigo() {
    }

    public ResponseConsultarOrgaoCodigo(
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario dadosUsuario,
           java.lang.String errorDescription,
           java.lang.Boolean hasError,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade orgaoEntidade) {
           this.dadosUsuario = dadosUsuario;
           this.errorDescription = errorDescription;
           this.hasError = hasError;
           this.orgaoEntidade = orgaoEntidade;
    }


    /**
     * Gets the dadosUsuario value for this ResponseConsultarOrgaoCodigo.
     * 
     * @return dadosUsuario
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario getDadosUsuario() {
        return dadosUsuario;
    }


    /**
     * Sets the dadosUsuario value for this ResponseConsultarOrgaoCodigo.
     * 
     * @param dadosUsuario
     */
    public void setDadosUsuario(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario dadosUsuario) {
        this.dadosUsuario = dadosUsuario;
    }


    /**
     * Gets the errorDescription value for this ResponseConsultarOrgaoCodigo.
     * 
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this ResponseConsultarOrgaoCodigo.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the hasError value for this ResponseConsultarOrgaoCodigo.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this ResponseConsultarOrgaoCodigo.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the orgaoEntidade value for this ResponseConsultarOrgaoCodigo.
     * 
     * @return orgaoEntidade
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade getOrgaoEntidade() {
        return orgaoEntidade;
    }


    /**
     * Sets the orgaoEntidade value for this ResponseConsultarOrgaoCodigo.
     * 
     * @param orgaoEntidade
     */
    public void setOrgaoEntidade(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade orgaoEntidade) {
        this.orgaoEntidade = orgaoEntidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseConsultarOrgaoCodigo)) return false;
        ResponseConsultarOrgaoCodigo other = (ResponseConsultarOrgaoCodigo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosUsuario==null && other.getDadosUsuario()==null) || 
             (this.dadosUsuario!=null &&
              this.dadosUsuario.equals(other.getDadosUsuario()))) &&
            ((this.errorDescription==null && other.getErrorDescription()==null) || 
             (this.errorDescription!=null &&
              this.errorDescription.equals(other.getErrorDescription()))) &&
            ((this.hasError==null && other.getHasError()==null) || 
             (this.hasError!=null &&
              this.hasError.equals(other.getHasError()))) &&
            ((this.orgaoEntidade==null && other.getOrgaoEntidade()==null) || 
             (this.orgaoEntidade!=null &&
              this.orgaoEntidade.equals(other.getOrgaoEntidade())));
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
        if (getDadosUsuario() != null) {
            _hashCode += getDadosUsuario().hashCode();
        }
        if (getErrorDescription() != null) {
            _hashCode += getErrorDescription().hashCode();
        }
        if (getHasError() != null) {
            _hashCode += getHasError().hashCode();
        }
        if (getOrgaoEntidade() != null) {
            _hashCode += getOrgaoEntidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseConsultarOrgaoCodigo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseConsultarOrgaoCodigo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosUsuario"));
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
        elemField.setFieldName("orgaoEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "orgaoEntidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoEntidade"));
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
