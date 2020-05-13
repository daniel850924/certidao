/**
 * OrgaosPorMunicipio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class OrgaosPorMunicipio  implements java.io.Serializable {
    private java.lang.String nomMunicipio;

    private org.datacontract.schemas._2004._07.SGI_DAL_DTO.OrgaoEntidadeServiceDto[] orgaosRelacionados;

    private java.lang.String errorDescription;

    private java.lang.Boolean hasError;

    public OrgaosPorMunicipio() {
    }

    public OrgaosPorMunicipio(
           java.lang.String nomMunicipio,
           org.datacontract.schemas._2004._07.SGI_DAL_DTO.OrgaoEntidadeServiceDto[] orgaosRelacionados,
           java.lang.String errorDescription,
           java.lang.Boolean hasError) {
           this.nomMunicipio = nomMunicipio;
           this.orgaosRelacionados = orgaosRelacionados;
           this.errorDescription = errorDescription;
           this.hasError = hasError;
    }


    /**
     * Gets the nomMunicipio value for this OrgaosPorMunicipio.
     * 
     * @return nomMunicipio
     */
    public java.lang.String getNomMunicipio() {
        return nomMunicipio;
    }


    /**
     * Sets the nomMunicipio value for this OrgaosPorMunicipio.
     * 
     * @param nomMunicipio
     */
    public void setNomMunicipio(java.lang.String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }


    /**
     * Gets the orgaosRelacionados value for this OrgaosPorMunicipio.
     * 
     * @return orgaosRelacionados
     */
    public org.datacontract.schemas._2004._07.SGI_DAL_DTO.OrgaoEntidadeServiceDto[] getOrgaosRelacionados() {
        return orgaosRelacionados;
    }


    /**
     * Sets the orgaosRelacionados value for this OrgaosPorMunicipio.
     * 
     * @param orgaosRelacionados
     */
    public void setOrgaosRelacionados(org.datacontract.schemas._2004._07.SGI_DAL_DTO.OrgaoEntidadeServiceDto[] orgaosRelacionados) {
        this.orgaosRelacionados = orgaosRelacionados;
    }


    /**
     * Gets the errorDescription value for this OrgaosPorMunicipio.
     * 
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this OrgaosPorMunicipio.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the hasError value for this OrgaosPorMunicipio.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this OrgaosPorMunicipio.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrgaosPorMunicipio)) return false;
        OrgaosPorMunicipio other = (OrgaosPorMunicipio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nomMunicipio==null && other.getNomMunicipio()==null) || 
             (this.nomMunicipio!=null &&
              this.nomMunicipio.equals(other.getNomMunicipio()))) &&
            ((this.orgaosRelacionados==null && other.getOrgaosRelacionados()==null) || 
             (this.orgaosRelacionados!=null &&
              java.util.Arrays.equals(this.orgaosRelacionados, other.getOrgaosRelacionados()))) &&
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
        if (getNomMunicipio() != null) {
            _hashCode += getNomMunicipio().hashCode();
        }
        if (getOrgaosRelacionados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrgaosRelacionados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrgaosRelacionados(), i);
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
        new org.apache.axis.description.TypeDesc(OrgaosPorMunicipio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaosPorMunicipio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomMunicipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NomMunicipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgaosRelacionados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaosRelacionados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "OrgaoEntidadeServiceDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "OrgaoEntidadeServiceDto"));
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
