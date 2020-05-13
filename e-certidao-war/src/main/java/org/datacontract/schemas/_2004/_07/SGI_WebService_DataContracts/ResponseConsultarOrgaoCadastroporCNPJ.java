/**
 * ResponseConsultarOrgaoCadastroporCNPJ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class ResponseConsultarOrgaoCadastroporCNPJ  implements java.io.Serializable {
    private java.lang.String errorDescription;

    private java.lang.Boolean hasError;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoCadastroporCNPJ[] orgaoCadastroporCNPJ;

    public ResponseConsultarOrgaoCadastroporCNPJ() {
    }

    public ResponseConsultarOrgaoCadastroporCNPJ(
           java.lang.String errorDescription,
           java.lang.Boolean hasError,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoCadastroporCNPJ[] orgaoCadastroporCNPJ) {
           this.errorDescription = errorDescription;
           this.hasError = hasError;
           this.orgaoCadastroporCNPJ = orgaoCadastroporCNPJ;
    }


    /**
     * Gets the errorDescription value for this ResponseConsultarOrgaoCadastroporCNPJ.
     * 
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this ResponseConsultarOrgaoCadastroporCNPJ.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the hasError value for this ResponseConsultarOrgaoCadastroporCNPJ.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this ResponseConsultarOrgaoCadastroporCNPJ.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the orgaoCadastroporCNPJ value for this ResponseConsultarOrgaoCadastroporCNPJ.
     * 
     * @return orgaoCadastroporCNPJ
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoCadastroporCNPJ[] getOrgaoCadastroporCNPJ() {
        return orgaoCadastroporCNPJ;
    }


    /**
     * Sets the orgaoCadastroporCNPJ value for this ResponseConsultarOrgaoCadastroporCNPJ.
     * 
     * @param orgaoCadastroporCNPJ
     */
    public void setOrgaoCadastroporCNPJ(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoCadastroporCNPJ[] orgaoCadastroporCNPJ) {
        this.orgaoCadastroporCNPJ = orgaoCadastroporCNPJ;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseConsultarOrgaoCadastroporCNPJ)) return false;
        ResponseConsultarOrgaoCadastroporCNPJ other = (ResponseConsultarOrgaoCadastroporCNPJ) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorDescription==null && other.getErrorDescription()==null) || 
             (this.errorDescription!=null &&
              this.errorDescription.equals(other.getErrorDescription()))) &&
            ((this.hasError==null && other.getHasError()==null) || 
             (this.hasError!=null &&
              this.hasError.equals(other.getHasError()))) &&
            ((this.orgaoCadastroporCNPJ==null && other.getOrgaoCadastroporCNPJ()==null) || 
             (this.orgaoCadastroporCNPJ!=null &&
              java.util.Arrays.equals(this.orgaoCadastroporCNPJ, other.getOrgaoCadastroporCNPJ())));
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
        if (getErrorDescription() != null) {
            _hashCode += getErrorDescription().hashCode();
        }
        if (getHasError() != null) {
            _hashCode += getHasError().hashCode();
        }
        if (getOrgaoCadastroporCNPJ() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrgaoCadastroporCNPJ());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrgaoCadastroporCNPJ(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseConsultarOrgaoCadastroporCNPJ.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseConsultarOrgaoCadastroporCNPJ"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgaoCadastroporCNPJ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "orgaoCadastroporCNPJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoCadastroporCNPJ"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoCadastroporCNPJ"));
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
