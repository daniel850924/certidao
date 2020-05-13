/**
 * Anexos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SendMailService;

public class Anexos  implements java.io.Serializable {
    private byte[] arquivo;

    private java.lang.String nomeArquivo;

    public Anexos() {
    }

    public Anexos(
           byte[] arquivo,
           java.lang.String nomeArquivo) {
           this.arquivo = arquivo;
           this.nomeArquivo = nomeArquivo;
    }


    /**
     * Gets the arquivo value for this Anexos.
     * 
     * @return arquivo
     */
    public byte[] getArquivo() {
        return arquivo;
    }


    /**
     * Sets the arquivo value for this Anexos.
     * 
     * @param arquivo
     */
    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }


    /**
     * Gets the nomeArquivo value for this Anexos.
     * 
     * @return nomeArquivo
     */
    public java.lang.String getNomeArquivo() {
        return nomeArquivo;
    }


    /**
     * Sets the nomeArquivo value for this Anexos.
     * 
     * @param nomeArquivo
     */
    public void setNomeArquivo(java.lang.String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Anexos)) return false;
        Anexos other = (Anexos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arquivo==null && other.getArquivo()==null) || 
             (this.arquivo!=null &&
              java.util.Arrays.equals(this.arquivo, other.getArquivo()))) &&
            ((this.nomeArquivo==null && other.getNomeArquivo()==null) || 
             (this.nomeArquivo!=null &&
              this.nomeArquivo.equals(other.getNomeArquivo())));
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
        if (getArquivo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArquivo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArquivo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNomeArquivo() != null) {
            _hashCode += getNomeArquivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Anexos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "Anexos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "arquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "nomeArquivo"));
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
