/**
 * ResponsavelLegalOrgao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class ResponsavelLegalOrgao  implements java.io.Serializable {
    private java.lang.String cpf;

    private java.util.Calendar dataInicioVigencia;

    private java.util.Calendar dataTerminoVigencia;

    private java.lang.Boolean hasError;

    private java.lang.String mensagem;

    private java.lang.String nomeOrgao;

    private java.lang.String nomeResponsavel;

    private java.lang.String tipoResponsavel;

    public ResponsavelLegalOrgao() {
    }

    public ResponsavelLegalOrgao(
           java.lang.String cpf,
           java.util.Calendar dataInicioVigencia,
           java.util.Calendar dataTerminoVigencia,
           java.lang.Boolean hasError,
           java.lang.String mensagem,
           java.lang.String nomeOrgao,
           java.lang.String nomeResponsavel,
           java.lang.String tipoResponsavel) {
           this.cpf = cpf;
           this.dataInicioVigencia = dataInicioVigencia;
           this.dataTerminoVigencia = dataTerminoVigencia;
           this.hasError = hasError;
           this.mensagem = mensagem;
           this.nomeOrgao = nomeOrgao;
           this.nomeResponsavel = nomeResponsavel;
           this.tipoResponsavel = tipoResponsavel;
    }


    /**
     * Gets the cpf value for this ResponsavelLegalOrgao.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this ResponsavelLegalOrgao.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the dataInicioVigencia value for this ResponsavelLegalOrgao.
     * 
     * @return dataInicioVigencia
     */
    public java.util.Calendar getDataInicioVigencia() {
        return dataInicioVigencia;
    }


    /**
     * Sets the dataInicioVigencia value for this ResponsavelLegalOrgao.
     * 
     * @param dataInicioVigencia
     */
    public void setDataInicioVigencia(java.util.Calendar dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }


    /**
     * Gets the dataTerminoVigencia value for this ResponsavelLegalOrgao.
     * 
     * @return dataTerminoVigencia
     */
    public java.util.Calendar getDataTerminoVigencia() {
        return dataTerminoVigencia;
    }


    /**
     * Sets the dataTerminoVigencia value for this ResponsavelLegalOrgao.
     * 
     * @param dataTerminoVigencia
     */
    public void setDataTerminoVigencia(java.util.Calendar dataTerminoVigencia) {
        this.dataTerminoVigencia = dataTerminoVigencia;
    }


    /**
     * Gets the hasError value for this ResponsavelLegalOrgao.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this ResponsavelLegalOrgao.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the mensagem value for this ResponsavelLegalOrgao.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this ResponsavelLegalOrgao.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }


    /**
     * Gets the nomeOrgao value for this ResponsavelLegalOrgao.
     * 
     * @return nomeOrgao
     */
    public java.lang.String getNomeOrgao() {
        return nomeOrgao;
    }


    /**
     * Sets the nomeOrgao value for this ResponsavelLegalOrgao.
     * 
     * @param nomeOrgao
     */
    public void setNomeOrgao(java.lang.String nomeOrgao) {
        this.nomeOrgao = nomeOrgao;
    }


    /**
     * Gets the nomeResponsavel value for this ResponsavelLegalOrgao.
     * 
     * @return nomeResponsavel
     */
    public java.lang.String getNomeResponsavel() {
        return nomeResponsavel;
    }


    /**
     * Sets the nomeResponsavel value for this ResponsavelLegalOrgao.
     * 
     * @param nomeResponsavel
     */
    public void setNomeResponsavel(java.lang.String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }


    /**
     * Gets the tipoResponsavel value for this ResponsavelLegalOrgao.
     * 
     * @return tipoResponsavel
     */
    public java.lang.String getTipoResponsavel() {
        return tipoResponsavel;
    }


    /**
     * Sets the tipoResponsavel value for this ResponsavelLegalOrgao.
     * 
     * @param tipoResponsavel
     */
    public void setTipoResponsavel(java.lang.String tipoResponsavel) {
        this.tipoResponsavel = tipoResponsavel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponsavelLegalOrgao)) return false;
        ResponsavelLegalOrgao other = (ResponsavelLegalOrgao) obj;
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
            ((this.dataInicioVigencia==null && other.getDataInicioVigencia()==null) || 
             (this.dataInicioVigencia!=null &&
              this.dataInicioVigencia.equals(other.getDataInicioVigencia()))) &&
            ((this.dataTerminoVigencia==null && other.getDataTerminoVigencia()==null) || 
             (this.dataTerminoVigencia!=null &&
              this.dataTerminoVigencia.equals(other.getDataTerminoVigencia()))) &&
            ((this.hasError==null && other.getHasError()==null) || 
             (this.hasError!=null &&
              this.hasError.equals(other.getHasError()))) &&
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem()))) &&
            ((this.nomeOrgao==null && other.getNomeOrgao()==null) || 
             (this.nomeOrgao!=null &&
              this.nomeOrgao.equals(other.getNomeOrgao()))) &&
            ((this.nomeResponsavel==null && other.getNomeResponsavel()==null) || 
             (this.nomeResponsavel!=null &&
              this.nomeResponsavel.equals(other.getNomeResponsavel()))) &&
            ((this.tipoResponsavel==null && other.getTipoResponsavel()==null) || 
             (this.tipoResponsavel!=null &&
              this.tipoResponsavel.equals(other.getTipoResponsavel())));
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
        if (getDataInicioVigencia() != null) {
            _hashCode += getDataInicioVigencia().hashCode();
        }
        if (getDataTerminoVigencia() != null) {
            _hashCode += getDataTerminoVigencia().hashCode();
        }
        if (getHasError() != null) {
            _hashCode += getHasError().hashCode();
        }
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        if (getNomeOrgao() != null) {
            _hashCode += getNomeOrgao().hashCode();
        }
        if (getNomeResponsavel() != null) {
            _hashCode += getNomeResponsavel().hashCode();
        }
        if (getTipoResponsavel() != null) {
            _hashCode += getTipoResponsavel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponsavelLegalOrgao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponsavelLegalOrgao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicioVigencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "dataInicioVigencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataTerminoVigencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "dataTerminoVigencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("mensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "mensagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nomeOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nomeResponsavel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoResponsavel"));
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
