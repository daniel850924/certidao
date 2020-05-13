/**
 * ResponseRetornarUsuarioPerfilOrgao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class ResponseRetornarUsuarioPerfilOrgao  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario dadosUsuario;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PermissaoUsuarioOrgao[] listaPermissaoUsuarioOrgao;

    private java.lang.String errorDescription;

    private java.lang.Boolean hasError;

    public ResponseRetornarUsuarioPerfilOrgao() {
    }

    public ResponseRetornarUsuarioPerfilOrgao(
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario dadosUsuario,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PermissaoUsuarioOrgao[] listaPermissaoUsuarioOrgao,
           java.lang.String errorDescription,
           java.lang.Boolean hasError) {
           this.dadosUsuario = dadosUsuario;
           this.listaPermissaoUsuarioOrgao = listaPermissaoUsuarioOrgao;
           this.errorDescription = errorDescription;
           this.hasError = hasError;
    }


    /**
     * Gets the dadosUsuario value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @return dadosUsuario
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario getDadosUsuario() {
        return dadosUsuario;
    }


    /**
     * Sets the dadosUsuario value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @param dadosUsuario
     */
    public void setDadosUsuario(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosUsuario dadosUsuario) {
        this.dadosUsuario = dadosUsuario;
    }


    /**
     * Gets the listaPermissaoUsuarioOrgao value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @return listaPermissaoUsuarioOrgao
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PermissaoUsuarioOrgao[] getListaPermissaoUsuarioOrgao() {
        return listaPermissaoUsuarioOrgao;
    }


    /**
     * Sets the listaPermissaoUsuarioOrgao value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @param listaPermissaoUsuarioOrgao
     */
    public void setListaPermissaoUsuarioOrgao(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PermissaoUsuarioOrgao[] listaPermissaoUsuarioOrgao) {
        this.listaPermissaoUsuarioOrgao = listaPermissaoUsuarioOrgao;
    }


    /**
     * Gets the errorDescription value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the hasError value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this ResponseRetornarUsuarioPerfilOrgao.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseRetornarUsuarioPerfilOrgao)) return false;
        ResponseRetornarUsuarioPerfilOrgao other = (ResponseRetornarUsuarioPerfilOrgao) obj;
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
            ((this.listaPermissaoUsuarioOrgao==null && other.getListaPermissaoUsuarioOrgao()==null) || 
             (this.listaPermissaoUsuarioOrgao!=null &&
              java.util.Arrays.equals(this.listaPermissaoUsuarioOrgao, other.getListaPermissaoUsuarioOrgao()))) &&
            ((this.errorDescription==null && other.getErrorDescription()==null) || 
             (this.errorDescription!=null &&
              this.errorDescription.equals(other.getErrorDescription()))) &&
            ((this.hasError==null && other.getHasError()==null) || 
             (this.hasError!=null &&
              this.hasError.equals(other.getHasError())));
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
        if (getListaPermissaoUsuarioOrgao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPermissaoUsuarioOrgao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPermissaoUsuarioOrgao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrorDescription() != null) {
            _hashCode += getErrorDescription().hashCode();
        }
        if (getHasError() != null) {
            _hashCode += getHasError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseRetornarUsuarioPerfilOrgao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseRetornarUsuarioPerfilOrgao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosUsuario"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPermissaoUsuarioOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ListaPermissaoUsuarioOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PermissaoUsuarioOrgao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PermissaoUsuarioOrgao"));
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
