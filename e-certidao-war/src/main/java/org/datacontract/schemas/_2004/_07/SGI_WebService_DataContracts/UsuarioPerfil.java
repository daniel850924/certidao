/**
 * UsuarioPerfil.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class UsuarioPerfil  implements java.io.Serializable {
    private java.util.Calendar inicioVigencia;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts._interface[] interfacesPerfil;

    private java.util.Calendar terminoVigencia;

    private java.lang.String tituloPerfil;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(
           java.util.Calendar inicioVigencia,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts._interface[] interfacesPerfil,
           java.util.Calendar terminoVigencia,
           java.lang.String tituloPerfil) {
           this.inicioVigencia = inicioVigencia;
           this.interfacesPerfil = interfacesPerfil;
           this.terminoVigencia = terminoVigencia;
           this.tituloPerfil = tituloPerfil;
    }


    /**
     * Gets the inicioVigencia value for this UsuarioPerfil.
     * 
     * @return inicioVigencia
     */
    public java.util.Calendar getInicioVigencia() {
        return inicioVigencia;
    }


    /**
     * Sets the inicioVigencia value for this UsuarioPerfil.
     * 
     * @param inicioVigencia
     */
    public void setInicioVigencia(java.util.Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }


    /**
     * Gets the interfacesPerfil value for this UsuarioPerfil.
     * 
     * @return interfacesPerfil
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts._interface[] getInterfacesPerfil() {
        return interfacesPerfil;
    }


    /**
     * Sets the interfacesPerfil value for this UsuarioPerfil.
     * 
     * @param interfacesPerfil
     */
    public void setInterfacesPerfil(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts._interface[] interfacesPerfil) {
        this.interfacesPerfil = interfacesPerfil;
    }


    /**
     * Gets the terminoVigencia value for this UsuarioPerfil.
     * 
     * @return terminoVigencia
     */
    public java.util.Calendar getTerminoVigencia() {
        return terminoVigencia;
    }


    /**
     * Sets the terminoVigencia value for this UsuarioPerfil.
     * 
     * @param terminoVigencia
     */
    public void setTerminoVigencia(java.util.Calendar terminoVigencia) {
        this.terminoVigencia = terminoVigencia;
    }


    /**
     * Gets the tituloPerfil value for this UsuarioPerfil.
     * 
     * @return tituloPerfil
     */
    public java.lang.String getTituloPerfil() {
        return tituloPerfil;
    }


    /**
     * Sets the tituloPerfil value for this UsuarioPerfil.
     * 
     * @param tituloPerfil
     */
    public void setTituloPerfil(java.lang.String tituloPerfil) {
        this.tituloPerfil = tituloPerfil;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UsuarioPerfil)) return false;
        UsuarioPerfil other = (UsuarioPerfil) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inicioVigencia==null && other.getInicioVigencia()==null) || 
             (this.inicioVigencia!=null &&
              this.inicioVigencia.equals(other.getInicioVigencia()))) &&
            ((this.interfacesPerfil==null && other.getInterfacesPerfil()==null) || 
             (this.interfacesPerfil!=null &&
              java.util.Arrays.equals(this.interfacesPerfil, other.getInterfacesPerfil()))) &&
            ((this.terminoVigencia==null && other.getTerminoVigencia()==null) || 
             (this.terminoVigencia!=null &&
              this.terminoVigencia.equals(other.getTerminoVigencia()))) &&
            ((this.tituloPerfil==null && other.getTituloPerfil()==null) || 
             (this.tituloPerfil!=null &&
              this.tituloPerfil.equals(other.getTituloPerfil())));
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
        if (getInicioVigencia() != null) {
            _hashCode += getInicioVigencia().hashCode();
        }
        if (getInterfacesPerfil() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInterfacesPerfil());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInterfacesPerfil(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTerminoVigencia() != null) {
            _hashCode += getTerminoVigencia().hashCode();
        }
        if (getTituloPerfil() != null) {
            _hashCode += getTituloPerfil().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UsuarioPerfil.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioVigencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "inicioVigencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interfacesPerfil");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "interfacesPerfil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Interface"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Interface"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminoVigencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "terminoVigencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tituloPerfil");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tituloPerfil"));
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
