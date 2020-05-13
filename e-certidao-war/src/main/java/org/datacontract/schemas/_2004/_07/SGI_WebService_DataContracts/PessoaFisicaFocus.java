/**
 * PessoaFisicaFocus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class PessoaFisicaFocus  implements java.io.Serializable {
    private java.lang.String nomeCompleto;

    private java.lang.String numCpf;

    public PessoaFisicaFocus() {
    }

    public PessoaFisicaFocus(
           java.lang.String nomeCompleto,
           java.lang.String numCpf) {
           this.nomeCompleto = nomeCompleto;
           this.numCpf = numCpf;
    }


    /**
     * Gets the nomeCompleto value for this PessoaFisicaFocus.
     * 
     * @return nomeCompleto
     */
    public java.lang.String getNomeCompleto() {
        return nomeCompleto;
    }


    /**
     * Sets the nomeCompleto value for this PessoaFisicaFocus.
     * 
     * @param nomeCompleto
     */
    public void setNomeCompleto(java.lang.String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }


    /**
     * Gets the numCpf value for this PessoaFisicaFocus.
     * 
     * @return numCpf
     */
    public java.lang.String getNumCpf() {
        return numCpf;
    }


    /**
     * Sets the numCpf value for this PessoaFisicaFocus.
     * 
     * @param numCpf
     */
    public void setNumCpf(java.lang.String numCpf) {
        this.numCpf = numCpf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PessoaFisicaFocus)) return false;
        PessoaFisicaFocus other = (PessoaFisicaFocus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nomeCompleto==null && other.getNomeCompleto()==null) || 
             (this.nomeCompleto!=null &&
              this.nomeCompleto.equals(other.getNomeCompleto()))) &&
            ((this.numCpf==null && other.getNumCpf()==null) || 
             (this.numCpf!=null &&
              this.numCpf.equals(other.getNumCpf())));
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
        if (getNomeCompleto() != null) {
            _hashCode += getNomeCompleto().hashCode();
        }
        if (getNumCpf() != null) {
            _hashCode += getNumCpf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PessoaFisicaFocus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisicaFocus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeCompleto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NomeCompleto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numCpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NumCpf"));
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
