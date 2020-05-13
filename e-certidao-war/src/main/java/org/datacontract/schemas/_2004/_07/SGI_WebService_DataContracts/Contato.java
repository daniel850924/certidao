/**
 * Contato.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class Contato  implements java.io.Serializable {
    private java.lang.String dscContato;

    private java.lang.String tipoContato;

    public Contato() {
    }

    public Contato(
           java.lang.String dscContato,
           java.lang.String tipoContato) {
           this.dscContato = dscContato;
           this.tipoContato = tipoContato;
    }


    /**
     * Gets the dscContato value for this Contato.
     * 
     * @return dscContato
     */
    public java.lang.String getDscContato() {
        return dscContato;
    }


    /**
     * Sets the dscContato value for this Contato.
     * 
     * @param dscContato
     */
    public void setDscContato(java.lang.String dscContato) {
        this.dscContato = dscContato;
    }


    /**
     * Gets the tipoContato value for this Contato.
     * 
     * @return tipoContato
     */
    public java.lang.String getTipoContato() {
        return tipoContato;
    }


    /**
     * Sets the tipoContato value for this Contato.
     * 
     * @param tipoContato
     */
    public void setTipoContato(java.lang.String tipoContato) {
        this.tipoContato = tipoContato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Contato)) return false;
        Contato other = (Contato) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dscContato==null && other.getDscContato()==null) || 
             (this.dscContato!=null &&
              this.dscContato.equals(other.getDscContato()))) &&
            ((this.tipoContato==null && other.getTipoContato()==null) || 
             (this.tipoContato!=null &&
              this.tipoContato.equals(other.getTipoContato())));
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
        if (getDscContato() != null) {
            _hashCode += getDscContato().hashCode();
        }
        if (getTipoContato() != null) {
            _hashCode += getTipoContato().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Contato.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscContato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "dscContato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoContato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoContato"));
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
