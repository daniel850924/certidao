/**
 * Regime.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class Regime  implements java.io.Serializable {
    private java.util.Calendar inicioVigencia;

    private java.lang.String siglaRegime;

    private java.util.Calendar terminoVigencia;

    private java.lang.String tipoRegime;

    public Regime() {
    }

    public Regime(
           java.util.Calendar inicioVigencia,
           java.lang.String siglaRegime,
           java.util.Calendar terminoVigencia,
           java.lang.String tipoRegime) {
           this.inicioVigencia = inicioVigencia;
           this.siglaRegime = siglaRegime;
           this.terminoVigencia = terminoVigencia;
           this.tipoRegime = tipoRegime;
    }


    /**
     * Gets the inicioVigencia value for this Regime.
     * 
     * @return inicioVigencia
     */
    public java.util.Calendar getInicioVigencia() {
        return inicioVigencia;
    }


    /**
     * Sets the inicioVigencia value for this Regime.
     * 
     * @param inicioVigencia
     */
    public void setInicioVigencia(java.util.Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }


    /**
     * Gets the siglaRegime value for this Regime.
     * 
     * @return siglaRegime
     */
    public java.lang.String getSiglaRegime() {
        return siglaRegime;
    }


    /**
     * Sets the siglaRegime value for this Regime.
     * 
     * @param siglaRegime
     */
    public void setSiglaRegime(java.lang.String siglaRegime) {
        this.siglaRegime = siglaRegime;
    }


    /**
     * Gets the terminoVigencia value for this Regime.
     * 
     * @return terminoVigencia
     */
    public java.util.Calendar getTerminoVigencia() {
        return terminoVigencia;
    }


    /**
     * Sets the terminoVigencia value for this Regime.
     * 
     * @param terminoVigencia
     */
    public void setTerminoVigencia(java.util.Calendar terminoVigencia) {
        this.terminoVigencia = terminoVigencia;
    }


    /**
     * Gets the tipoRegime value for this Regime.
     * 
     * @return tipoRegime
     */
    public java.lang.String getTipoRegime() {
        return tipoRegime;
    }


    /**
     * Sets the tipoRegime value for this Regime.
     * 
     * @param tipoRegime
     */
    public void setTipoRegime(java.lang.String tipoRegime) {
        this.tipoRegime = tipoRegime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Regime)) return false;
        Regime other = (Regime) obj;
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
            ((this.siglaRegime==null && other.getSiglaRegime()==null) || 
             (this.siglaRegime!=null &&
              this.siglaRegime.equals(other.getSiglaRegime()))) &&
            ((this.terminoVigencia==null && other.getTerminoVigencia()==null) || 
             (this.terminoVigencia!=null &&
              this.terminoVigencia.equals(other.getTerminoVigencia()))) &&
            ((this.tipoRegime==null && other.getTipoRegime()==null) || 
             (this.tipoRegime!=null &&
              this.tipoRegime.equals(other.getTipoRegime())));
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
        if (getSiglaRegime() != null) {
            _hashCode += getSiglaRegime().hashCode();
        }
        if (getTerminoVigencia() != null) {
            _hashCode += getTerminoVigencia().hashCode();
        }
        if (getTipoRegime() != null) {
            _hashCode += getTipoRegime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Regime.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Regime"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inicioVigencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "inicioVigencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaRegime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "siglaRegime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminoVigencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "terminoVigencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRegime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoRegime"));
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
