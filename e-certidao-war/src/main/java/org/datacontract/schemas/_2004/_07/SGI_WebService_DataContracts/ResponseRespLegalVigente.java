/**
 * ResponseRespLegalVigente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class ResponseRespLegalVigente  implements java.io.Serializable {
    private java.lang.String cpf;

    private java.lang.String email;

    private java.lang.String errorDescription;

    private java.lang.Boolean hasError;

    private java.lang.String municipio;

    private java.lang.String nomeResponsavelLegal;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal[] orgaosResponsavelLegal;

    public ResponseRespLegalVigente() {
    }

    public ResponseRespLegalVigente(
           java.lang.String cpf,
           java.lang.String email,
           java.lang.String errorDescription,
           java.lang.Boolean hasError,
           java.lang.String municipio,
           java.lang.String nomeResponsavelLegal,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal[] orgaosResponsavelLegal) {
           this.cpf = cpf;
           this.email = email;
           this.errorDescription = errorDescription;
           this.hasError = hasError;
           this.municipio = municipio;
           this.nomeResponsavelLegal = nomeResponsavelLegal;
           this.orgaosResponsavelLegal = orgaosResponsavelLegal;
    }


    /**
     * Gets the cpf value for this ResponseRespLegalVigente.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this ResponseRespLegalVigente.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the email value for this ResponseRespLegalVigente.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ResponseRespLegalVigente.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the errorDescription value for this ResponseRespLegalVigente.
     * 
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return errorDescription;
    }


    /**
     * Sets the errorDescription value for this ResponseRespLegalVigente.
     * 
     * @param errorDescription
     */
    public void setErrorDescription(java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }


    /**
     * Gets the hasError value for this ResponseRespLegalVigente.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this ResponseRespLegalVigente.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the municipio value for this ResponseRespLegalVigente.
     * 
     * @return municipio
     */
    public java.lang.String getMunicipio() {
        return municipio;
    }


    /**
     * Sets the municipio value for this ResponseRespLegalVigente.
     * 
     * @param municipio
     */
    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }


    /**
     * Gets the nomeResponsavelLegal value for this ResponseRespLegalVigente.
     * 
     * @return nomeResponsavelLegal
     */
    public java.lang.String getNomeResponsavelLegal() {
        return nomeResponsavelLegal;
    }


    /**
     * Sets the nomeResponsavelLegal value for this ResponseRespLegalVigente.
     * 
     * @param nomeResponsavelLegal
     */
    public void setNomeResponsavelLegal(java.lang.String nomeResponsavelLegal) {
        this.nomeResponsavelLegal = nomeResponsavelLegal;
    }


    /**
     * Gets the orgaosResponsavelLegal value for this ResponseRespLegalVigente.
     * 
     * @return orgaosResponsavelLegal
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal[] getOrgaosResponsavelLegal() {
        return orgaosResponsavelLegal;
    }


    /**
     * Sets the orgaosResponsavelLegal value for this ResponseRespLegalVigente.
     * 
     * @param orgaosResponsavelLegal
     */
    public void setOrgaosResponsavelLegal(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal[] orgaosResponsavelLegal) {
        this.orgaosResponsavelLegal = orgaosResponsavelLegal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseRespLegalVigente)) return false;
        ResponseRespLegalVigente other = (ResponseRespLegalVigente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.errorDescription==null && other.getErrorDescription()==null) || 
             (this.errorDescription!=null &&
              this.errorDescription.equals(other.getErrorDescription()))) &&
            ((this.hasError==null && other.getHasError()==null) || 
             (this.hasError!=null &&
              this.hasError.equals(other.getHasError()))) &&
            ((this.municipio==null && other.getMunicipio()==null) || 
             (this.municipio!=null &&
              this.municipio.equals(other.getMunicipio()))) &&
            ((this.nomeResponsavelLegal==null && other.getNomeResponsavelLegal()==null) || 
             (this.nomeResponsavelLegal!=null &&
              this.nomeResponsavelLegal.equals(other.getNomeResponsavelLegal()))) &&
            ((this.orgaosResponsavelLegal==null && other.getOrgaosResponsavelLegal()==null) || 
             (this.orgaosResponsavelLegal!=null &&
              java.util.Arrays.equals(this.orgaosResponsavelLegal, other.getOrgaosResponsavelLegal())));
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
        if (getCpf() != null) {
            _hashCode += getCpf().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getErrorDescription() != null) {
            _hashCode += getErrorDescription().hashCode();
        }
        if (getHasError() != null) {
            _hashCode += getHasError().hashCode();
        }
        if (getMunicipio() != null) {
            _hashCode += getMunicipio().hashCode();
        }
        if (getNomeResponsavelLegal() != null) {
            _hashCode += getNomeResponsavelLegal().hashCode();
        }
        if (getOrgaosResponsavelLegal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrgaosResponsavelLegal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrgaosResponsavelLegal(), i);
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
        new org.apache.axis.description.TypeDesc(ResponseRespLegalVigente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseRespLegalVigente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("municipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "municipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeResponsavelLegal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nomeResponsavelLegal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgaosResponsavelLegal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "orgaosResponsavelLegal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoResponsaveLegal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoResponsaveLegal"));
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
