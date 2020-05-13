/**
 * BaseResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_Base;

public class BaseResult  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPMensagemErro[] erros;

    private java.lang.Boolean sucesso;

    public BaseResult() {
    }

    public BaseResult(
           org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPMensagemErro[] erros,
           java.lang.Boolean sucesso) {
           this.erros = erros;
           this.sucesso = sucesso;
    }


    /**
     * Gets the erros value for this BaseResult.
     * 
     * @return erros
     */
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPMensagemErro[] getErros() {
        return erros;
    }


    /**
     * Sets the erros value for this BaseResult.
     * 
     * @param erros
     */
    public void setErros(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPMensagemErro[] erros) {
        this.erros = erros;
    }


    /**
     * Gets the sucesso value for this BaseResult.
     * 
     * @return sucesso
     */
    public java.lang.Boolean getSucesso() {
        return sucesso;
    }


    /**
     * Sets the sucesso value for this BaseResult.
     * 
     * @param sucesso
     */
    public void setSucesso(java.lang.Boolean sucesso) {
        this.sucesso = sucesso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseResult)) return false;
        BaseResult other = (BaseResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.erros==null && other.getErros()==null) || 
             (this.erros!=null &&
              java.util.Arrays.equals(this.erros, other.getErros()))) &&
            ((this.sucesso==null && other.getSucesso()==null) || 
             (this.sucesso!=null &&
              this.sucesso.equals(other.getSucesso())));
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
        if (getErros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSucesso() != null) {
            _hashCode += getSucesso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.Base", "BaseResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("erros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.Base", "Erros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SGAPMensagemErro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SGAPMensagemErro"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucesso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.Base", "Sucesso"));
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
