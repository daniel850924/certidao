/**
 * _interface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class _interface  implements java.io.Serializable {
    private java.lang.String nomeInterface;

    private java.lang.String tituloInterface;

    public _interface() {
    }

    public _interface(
           java.lang.String nomeInterface,
           java.lang.String tituloInterface) {
           this.nomeInterface = nomeInterface;
           this.tituloInterface = tituloInterface;
    }


    /**
     * Gets the nomeInterface value for this _interface.
     * 
     * @return nomeInterface
     */
    public java.lang.String getNomeInterface() {
        return nomeInterface;
    }


    /**
     * Sets the nomeInterface value for this _interface.
     * 
     * @param nomeInterface
     */
    public void setNomeInterface(java.lang.String nomeInterface) {
        this.nomeInterface = nomeInterface;
    }


    /**
     * Gets the tituloInterface value for this _interface.
     * 
     * @return tituloInterface
     */
    public java.lang.String getTituloInterface() {
        return tituloInterface;
    }


    /**
     * Sets the tituloInterface value for this _interface.
     * 
     * @param tituloInterface
     */
    public void setTituloInterface(java.lang.String tituloInterface) {
        this.tituloInterface = tituloInterface;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof _interface)) return false;
        _interface other = (_interface) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nomeInterface==null && other.getNomeInterface()==null) || 
             (this.nomeInterface!=null &&
              this.nomeInterface.equals(other.getNomeInterface()))) &&
            ((this.tituloInterface==null && other.getTituloInterface()==null) || 
             (this.tituloInterface!=null &&
              this.tituloInterface.equals(other.getTituloInterface())));
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
        if (getNomeInterface() != null) {
            _hashCode += getNomeInterface().hashCode();
        }
        if (getTituloInterface() != null) {
            _hashCode += getTituloInterface().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(_interface.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Interface"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeInterface");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nomeInterface"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tituloInterface");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tituloInterface"));
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
