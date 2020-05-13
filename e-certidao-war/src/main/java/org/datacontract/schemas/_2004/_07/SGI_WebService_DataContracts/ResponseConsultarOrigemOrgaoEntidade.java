/**
 * ResponseConsultarOrigemOrgaoEntidade.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class ResponseConsultarOrigemOrgaoEntidade  implements java.io.Serializable {
    private java.lang.String errorDescription;

    private java.lang.Boolean hasError;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoOrigem[] orgaoEntidadeOrigem;

    public ResponseConsultarOrigemOrgaoEntidade() {
    }

    public ResponseConsultarOrigemOrgaoEntidade(
           java.lang.String errorDescription,
           java.lang.Boolean hasError,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoOrigem[] orgaoEntidadeOrigem) {
           this.errorDescription = errorDescription;
           this.hasError = hasError;
           this.orgaoEntidadeOrigem = orgaoEntidadeOrigem;
    }


    /**
     * Gets the errorDescription value for this ResponseConsultarOrigemOrgaoEntidade.
     * 
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this ResponseConsultarOrigemOrgaoEntidade.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the hasError value for this ResponseConsultarOrigemOrgaoEntidade.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this ResponseConsultarOrigemOrgaoEntidade.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the orgaoEntidadeOrigem value for this ResponseConsultarOrigemOrgaoEntidade.
     * 
     * @return orgaoEntidadeOrigem
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoOrigem[] getOrgaoEntidadeOrigem() {
        return orgaoEntidadeOrigem;
    }


    /**
     * Sets the orgaoEntidadeOrigem value for this ResponseConsultarOrigemOrgaoEntidade.
     * 
     * @param orgaoEntidadeOrigem
     */
    public void setOrgaoEntidadeOrigem(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoOrigem[] orgaoEntidadeOrigem) {
        this.orgaoEntidadeOrigem = orgaoEntidadeOrigem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseConsultarOrigemOrgaoEntidade)) return false;
        ResponseConsultarOrigemOrgaoEntidade other = (ResponseConsultarOrigemOrgaoEntidade) obj;
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
            ((this.orgaoEntidadeOrigem==null && other.getOrgaoEntidadeOrigem()==null) || 
             (this.orgaoEntidadeOrigem!=null &&
              java.util.Arrays.equals(this.orgaoEntidadeOrigem, other.getOrgaoEntidadeOrigem())));
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
        if (getOrgaoEntidadeOrigem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrgaoEntidadeOrigem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrgaoEntidadeOrigem(), i);
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
        new org.apache.axis.description.TypeDesc(ResponseConsultarOrigemOrgaoEntidade.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseConsultarOrigemOrgaoEntidade"));
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
        elemField.setFieldName("orgaoEntidadeOrigem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "orgaoEntidadeOrigem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoOrigem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoOrigem"));
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
