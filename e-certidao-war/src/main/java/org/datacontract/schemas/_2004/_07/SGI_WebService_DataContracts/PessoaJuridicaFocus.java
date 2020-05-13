/**
 * PessoaJuridicaFocus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class PessoaJuridicaFocus  implements java.io.Serializable {
    private java.lang.String dscLogradouro;

    private java.lang.String nomeBairro;

    private java.lang.String nomeCidade;

    private java.lang.String nomeUf;

    private java.lang.String numCep;

    private java.lang.String numCnpj;

    private java.lang.String numLogradouro;

    private java.lang.String razaoSocial;

    private java.lang.String tipoLogradouro;

    public PessoaJuridicaFocus() {
    }

    public PessoaJuridicaFocus(
           java.lang.String dscLogradouro,
           java.lang.String nomeBairro,
           java.lang.String nomeCidade,
           java.lang.String nomeUf,
           java.lang.String numCep,
           java.lang.String numCnpj,
           java.lang.String numLogradouro,
           java.lang.String razaoSocial,
           java.lang.String tipoLogradouro) {
           this.dscLogradouro = dscLogradouro;
           this.nomeBairro = nomeBairro;
           this.nomeCidade = nomeCidade;
           this.nomeUf = nomeUf;
           this.numCep = numCep;
           this.numCnpj = numCnpj;
           this.numLogradouro = numLogradouro;
           this.razaoSocial = razaoSocial;
           this.tipoLogradouro = tipoLogradouro;
    }


    /**
     * Gets the dscLogradouro value for this PessoaJuridicaFocus.
     * 
     * @return dscLogradouro
     */
    public java.lang.String getDscLogradouro() {
        return dscLogradouro;
    }


    /**
     * Sets the dscLogradouro value for this PessoaJuridicaFocus.
     * 
     * @param dscLogradouro
     */
    public void setDscLogradouro(java.lang.String dscLogradouro) {
        this.dscLogradouro = dscLogradouro;
    }


    /**
     * Gets the nomeBairro value for this PessoaJuridicaFocus.
     * 
     * @return nomeBairro
     */
    public java.lang.String getNomeBairro() {
        return nomeBairro;
    }


    /**
     * Sets the nomeBairro value for this PessoaJuridicaFocus.
     * 
     * @param nomeBairro
     */
    public void setNomeBairro(java.lang.String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }


    /**
     * Gets the nomeCidade value for this PessoaJuridicaFocus.
     * 
     * @return nomeCidade
     */
    public java.lang.String getNomeCidade() {
        return nomeCidade;
    }


    /**
     * Sets the nomeCidade value for this PessoaJuridicaFocus.
     * 
     * @param nomeCidade
     */
    public void setNomeCidade(java.lang.String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }


    /**
     * Gets the nomeUf value for this PessoaJuridicaFocus.
     * 
     * @return nomeUf
     */
    public java.lang.String getNomeUf() {
        return nomeUf;
    }


    /**
     * Sets the nomeUf value for this PessoaJuridicaFocus.
     * 
     * @param nomeUf
     */
    public void setNomeUf(java.lang.String nomeUf) {
        this.nomeUf = nomeUf;
    }


    /**
     * Gets the numCep value for this PessoaJuridicaFocus.
     * 
     * @return numCep
     */
    public java.lang.String getNumCep() {
        return numCep;
    }


    /**
     * Sets the numCep value for this PessoaJuridicaFocus.
     * 
     * @param numCep
     */
    public void setNumCep(java.lang.String numCep) {
        this.numCep = numCep;
    }


    /**
     * Gets the numCnpj value for this PessoaJuridicaFocus.
     * 
     * @return numCnpj
     */
    public java.lang.String getNumCnpj() {
        return numCnpj;
    }


    /**
     * Sets the numCnpj value for this PessoaJuridicaFocus.
     * 
     * @param numCnpj
     */
    public void setNumCnpj(java.lang.String numCnpj) {
        this.numCnpj = numCnpj;
    }


    /**
     * Gets the numLogradouro value for this PessoaJuridicaFocus.
     * 
     * @return numLogradouro
     */
    public java.lang.String getNumLogradouro() {
        return numLogradouro;
    }


    /**
     * Sets the numLogradouro value for this PessoaJuridicaFocus.
     * 
     * @param numLogradouro
     */
    public void setNumLogradouro(java.lang.String numLogradouro) {
        this.numLogradouro = numLogradouro;
    }


    /**
     * Gets the razaoSocial value for this PessoaJuridicaFocus.
     * 
     * @return razaoSocial
     */
    public java.lang.String getRazaoSocial() {
        return razaoSocial;
    }


    /**
     * Sets the razaoSocial value for this PessoaJuridicaFocus.
     * 
     * @param razaoSocial
     */
    public void setRazaoSocial(java.lang.String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    /**
     * Gets the tipoLogradouro value for this PessoaJuridicaFocus.
     * 
     * @return tipoLogradouro
     */
    public java.lang.String getTipoLogradouro() {
        return tipoLogradouro;
    }


    /**
     * Sets the tipoLogradouro value for this PessoaJuridicaFocus.
     * 
     * @param tipoLogradouro
     */
    public void setTipoLogradouro(java.lang.String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PessoaJuridicaFocus)) return false;
        PessoaJuridicaFocus other = (PessoaJuridicaFocus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dscLogradouro==null && other.getDscLogradouro()==null) || 
             (this.dscLogradouro!=null &&
              this.dscLogradouro.equals(other.getDscLogradouro()))) &&
            ((this.nomeBairro==null && other.getNomeBairro()==null) || 
             (this.nomeBairro!=null &&
              this.nomeBairro.equals(other.getNomeBairro()))) &&
            ((this.nomeCidade==null && other.getNomeCidade()==null) || 
             (this.nomeCidade!=null &&
              this.nomeCidade.equals(other.getNomeCidade()))) &&
            ((this.nomeUf==null && other.getNomeUf()==null) || 
             (this.nomeUf!=null &&
              this.nomeUf.equals(other.getNomeUf()))) &&
            ((this.numCep==null && other.getNumCep()==null) || 
             (this.numCep!=null &&
              this.numCep.equals(other.getNumCep()))) &&
            ((this.numCnpj==null && other.getNumCnpj()==null) || 
             (this.numCnpj!=null &&
              this.numCnpj.equals(other.getNumCnpj()))) &&
            ((this.numLogradouro==null && other.getNumLogradouro()==null) || 
             (this.numLogradouro!=null &&
              this.numLogradouro.equals(other.getNumLogradouro()))) &&
            ((this.razaoSocial==null && other.getRazaoSocial()==null) || 
             (this.razaoSocial!=null &&
              this.razaoSocial.equals(other.getRazaoSocial()))) &&
            ((this.tipoLogradouro==null && other.getTipoLogradouro()==null) || 
             (this.tipoLogradouro!=null &&
              this.tipoLogradouro.equals(other.getTipoLogradouro())));
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
        if (getDscLogradouro() != null) {
            _hashCode += getDscLogradouro().hashCode();
        }
        if (getNomeBairro() != null) {
            _hashCode += getNomeBairro().hashCode();
        }
        if (getNomeCidade() != null) {
            _hashCode += getNomeCidade().hashCode();
        }
        if (getNomeUf() != null) {
            _hashCode += getNomeUf().hashCode();
        }
        if (getNumCep() != null) {
            _hashCode += getNumCep().hashCode();
        }
        if (getNumCnpj() != null) {
            _hashCode += getNumCnpj().hashCode();
        }
        if (getNumLogradouro() != null) {
            _hashCode += getNumLogradouro().hashCode();
        }
        if (getRazaoSocial() != null) {
            _hashCode += getRazaoSocial().hashCode();
        }
        if (getTipoLogradouro() != null) {
            _hashCode += getTipoLogradouro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PessoaJuridicaFocus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaJuridicaFocus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscLogradouro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DscLogradouro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeBairro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NomeBairro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeCidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NomeCidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeUf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NomeUf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numCep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NumCep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numCnpj");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NumCnpj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numLogradouro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "NumLogradouro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razaoSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "RazaoSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoLogradouro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "TipoLogradouro"));
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
