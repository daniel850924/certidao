/**
 * SGAPMensagemErro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service;

public class SGAPMensagemErro  implements java.io.Serializable {
    private java.lang.String codErro;

    private java.lang.String mensagemErro;

    public SGAPMensagemErro() {
    }

    public SGAPMensagemErro(
           java.lang.String codErro,
           java.lang.String mensagemErro) {
           this.codErro = codErro;
           this.mensagemErro = mensagemErro;
    }


    /**
     * Gets the codErro value for this SGAPMensagemErro.
     * 
     * @return codErro
     */
    public java.lang.String getCodErro() {
        return codErro;
    }


    /**
     * Sets the codErro value for this SGAPMensagemErro.
     * 
     * @param codErro
     */
    public void setCodErro(java.lang.String codErro) {
        this.codErro = codErro;
    }


    /**
     * Gets the mensagemErro value for this SGAPMensagemErro.
     * 
     * @return mensagemErro
     */
    public java.lang.String getMensagemErro() {
        return mensagemErro;
    }


    /**
     * Sets the mensagemErro value for this SGAPMensagemErro.
     * 
     * @param mensagemErro
     */
    public void setMensagemErro(java.lang.String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SGAPMensagemErro)) return false;
        SGAPMensagemErro other = (SGAPMensagemErro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codErro==null && other.getCodErro()==null) || 
             (this.codErro!=null &&
              this.codErro.equals(other.getCodErro()))) &&
            ((this.mensagemErro==null && other.getMensagemErro()==null) || 
             (this.mensagemErro!=null &&
              this.mensagemErro.equals(other.getMensagemErro())));
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
        if (getCodErro() != null) {
            _hashCode += getCodErro().hashCode();
        }
        if (getMensagemErro() != null) {
            _hashCode += getMensagemErro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SGAPMensagemErro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SGAPMensagemErro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codErro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "CodErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagemErro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "MensagemErro"));
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
