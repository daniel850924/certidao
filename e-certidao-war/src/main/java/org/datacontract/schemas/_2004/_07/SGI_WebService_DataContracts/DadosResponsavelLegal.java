/**
 * DadosResponsavelLegal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class DadosResponsavelLegal  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos;

    private java.lang.String cpf;

    private java.util.Calendar dataFim;

    private java.util.Calendar dataInicio;

    private java.util.Calendar dataNascimento;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco;

    private java.lang.String estadoCivil;

    private java.lang.Boolean hasError;

    private java.lang.String mensagem;

    private java.lang.String nacionalidade;

    private java.lang.String naturalidade;

    private java.lang.String nome;

    private java.lang.String nomeMae;

    private java.lang.String nomePai;

    private java.lang.String numDocumentoIdentidade;

    private java.lang.String orgaoEmissor;

    private java.lang.String tipoCategoriaResponsavel;

    public DadosResponsavelLegal() {
    }

    public DadosResponsavelLegal(
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos,
           java.lang.String cpf,
           java.util.Calendar dataFim,
           java.util.Calendar dataInicio,
           java.util.Calendar dataNascimento,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco,
           java.lang.String estadoCivil,
           java.lang.Boolean hasError,
           java.lang.String mensagem,
           java.lang.String nacionalidade,
           java.lang.String naturalidade,
           java.lang.String nome,
           java.lang.String nomeMae,
           java.lang.String nomePai,
           java.lang.String numDocumentoIdentidade,
           java.lang.String orgaoEmissor,
           java.lang.String tipoCategoriaResponsavel) {
           this.contatos = contatos;
           this.cpf = cpf;
           this.dataFim = dataFim;
           this.dataInicio = dataInicio;
           this.dataNascimento = dataNascimento;
           this.endereco = endereco;
           this.estadoCivil = estadoCivil;
           this.hasError = hasError;
           this.mensagem = mensagem;
           this.nacionalidade = nacionalidade;
           this.naturalidade = naturalidade;
           this.nome = nome;
           this.nomeMae = nomeMae;
           this.nomePai = nomePai;
           this.numDocumentoIdentidade = numDocumentoIdentidade;
           this.orgaoEmissor = orgaoEmissor;
           this.tipoCategoriaResponsavel = tipoCategoriaResponsavel;
    }


    /**
     * Gets the contatos value for this DadosResponsavelLegal.
     * 
     * @return contatos
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] getContatos() {
        return contatos;
    }


    /**
     * Sets the contatos value for this DadosResponsavelLegal.
     * 
     * @param contatos
     */
    public void setContatos(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos) {
        this.contatos = contatos;
    }


    /**
     * Gets the cpf value for this DadosResponsavelLegal.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this DadosResponsavelLegal.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the dataFim value for this DadosResponsavelLegal.
     * 
     * @return dataFim
     */
    public java.util.Calendar getDataFim() {
        return dataFim;
    }


    /**
     * Sets the dataFim value for this DadosResponsavelLegal.
     * 
     * @param dataFim
     */
    public void setDataFim(java.util.Calendar dataFim) {
        this.dataFim = dataFim;
    }


    /**
     * Gets the dataInicio value for this DadosResponsavelLegal.
     * 
     * @return dataInicio
     */
    public java.util.Calendar getDataInicio() {
        return dataInicio;
    }


    /**
     * Sets the dataInicio value for this DadosResponsavelLegal.
     * 
     * @param dataInicio
     */
    public void setDataInicio(java.util.Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }


    /**
     * Gets the dataNascimento value for this DadosResponsavelLegal.
     * 
     * @return dataNascimento
     */
    public java.util.Calendar getDataNascimento() {
        return dataNascimento;
    }


    /**
     * Sets the dataNascimento value for this DadosResponsavelLegal.
     * 
     * @param dataNascimento
     */
    public void setDataNascimento(java.util.Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    /**
     * Gets the endereco value for this DadosResponsavelLegal.
     * 
     * @return endereco
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco getEndereco() {
        return endereco;
    }


    /**
     * Sets the endereco value for this DadosResponsavelLegal.
     * 
     * @param endereco
     */
    public void setEndereco(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco) {
        this.endereco = endereco;
    }


    /**
     * Gets the estadoCivil value for this DadosResponsavelLegal.
     * 
     * @return estadoCivil
     */
    public java.lang.String getEstadoCivil() {
        return estadoCivil;
    }


    /**
     * Sets the estadoCivil value for this DadosResponsavelLegal.
     * 
     * @param estadoCivil
     */
    public void setEstadoCivil(java.lang.String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    /**
     * Gets the hasError value for this DadosResponsavelLegal.
     * 
     * @return hasError
     */
    public java.lang.Boolean getHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this DadosResponsavelLegal.
     * 
     * @param hasError
     */
    public void setHasError(java.lang.Boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the mensagem value for this DadosResponsavelLegal.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this DadosResponsavelLegal.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }


    /**
     * Gets the nacionalidade value for this DadosResponsavelLegal.
     * 
     * @return nacionalidade
     */
    public java.lang.String getNacionalidade() {
        return nacionalidade;
    }


    /**
     * Sets the nacionalidade value for this DadosResponsavelLegal.
     * 
     * @param nacionalidade
     */
    public void setNacionalidade(java.lang.String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


    /**
     * Gets the naturalidade value for this DadosResponsavelLegal.
     * 
     * @return naturalidade
     */
    public java.lang.String getNaturalidade() {
        return naturalidade;
    }


    /**
     * Sets the naturalidade value for this DadosResponsavelLegal.
     * 
     * @param naturalidade
     */
    public void setNaturalidade(java.lang.String naturalidade) {
        this.naturalidade = naturalidade;
    }


    /**
     * Gets the nome value for this DadosResponsavelLegal.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this DadosResponsavelLegal.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the nomeMae value for this DadosResponsavelLegal.
     * 
     * @return nomeMae
     */
    public java.lang.String getNomeMae() {
        return nomeMae;
    }


    /**
     * Sets the nomeMae value for this DadosResponsavelLegal.
     * 
     * @param nomeMae
     */
    public void setNomeMae(java.lang.String nomeMae) {
        this.nomeMae = nomeMae;
    }


    /**
     * Gets the nomePai value for this DadosResponsavelLegal.
     * 
     * @return nomePai
     */
    public java.lang.String getNomePai() {
        return nomePai;
    }


    /**
     * Sets the nomePai value for this DadosResponsavelLegal.
     * 
     * @param nomePai
     */
    public void setNomePai(java.lang.String nomePai) {
        this.nomePai = nomePai;
    }


    /**
     * Gets the numDocumentoIdentidade value for this DadosResponsavelLegal.
     * 
     * @return numDocumentoIdentidade
     */
    public java.lang.String getNumDocumentoIdentidade() {
        return numDocumentoIdentidade;
    }


    /**
     * Sets the numDocumentoIdentidade value for this DadosResponsavelLegal.
     * 
     * @param numDocumentoIdentidade
     */
    public void setNumDocumentoIdentidade(java.lang.String numDocumentoIdentidade) {
        this.numDocumentoIdentidade = numDocumentoIdentidade;
    }


    /**
     * Gets the orgaoEmissor value for this DadosResponsavelLegal.
     * 
     * @return orgaoEmissor
     */
    public java.lang.String getOrgaoEmissor() {
        return orgaoEmissor;
    }


    /**
     * Sets the orgaoEmissor value for this DadosResponsavelLegal.
     * 
     * @param orgaoEmissor
     */
    public void setOrgaoEmissor(java.lang.String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }


    /**
     * Gets the tipoCategoriaResponsavel value for this DadosResponsavelLegal.
     * 
     * @return tipoCategoriaResponsavel
     */
    public java.lang.String getTipoCategoriaResponsavel() {
        return tipoCategoriaResponsavel;
    }


    /**
     * Sets the tipoCategoriaResponsavel value for this DadosResponsavelLegal.
     * 
     * @param tipoCategoriaResponsavel
     */
    public void setTipoCategoriaResponsavel(java.lang.String tipoCategoriaResponsavel) {
        this.tipoCategoriaResponsavel = tipoCategoriaResponsavel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosResponsavelLegal)) return false;
        DadosResponsavelLegal other = (DadosResponsavelLegal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contatos==null && other.getContatos()==null) || 
             (this.contatos!=null &&
              java.util.Arrays.equals(this.contatos, other.getContatos()))) &&
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.dataFim==null && other.getDataFim()==null) || 
             (this.dataFim!=null &&
              this.dataFim.equals(other.getDataFim()))) &&
            ((this.dataInicio==null && other.getDataInicio()==null) || 
             (this.dataInicio!=null &&
              this.dataInicio.equals(other.getDataInicio()))) &&
            ((this.dataNascimento==null && other.getDataNascimento()==null) || 
             (this.dataNascimento!=null &&
              this.dataNascimento.equals(other.getDataNascimento()))) &&
            ((this.endereco==null && other.getEndereco()==null) || 
             (this.endereco!=null &&
              this.endereco.equals(other.getEndereco()))) &&
            ((this.estadoCivil==null && other.getEstadoCivil()==null) || 
             (this.estadoCivil!=null &&
              this.estadoCivil.equals(other.getEstadoCivil()))) &&
            ((this.hasError==null && other.getHasError()==null) || 
             (this.hasError!=null &&
              this.hasError.equals(other.getHasError()))) &&
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem()))) &&
            ((this.nacionalidade==null && other.getNacionalidade()==null) || 
             (this.nacionalidade!=null &&
              this.nacionalidade.equals(other.getNacionalidade()))) &&
            ((this.naturalidade==null && other.getNaturalidade()==null) || 
             (this.naturalidade!=null &&
              this.naturalidade.equals(other.getNaturalidade()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.nomeMae==null && other.getNomeMae()==null) || 
             (this.nomeMae!=null &&
              this.nomeMae.equals(other.getNomeMae()))) &&
            ((this.nomePai==null && other.getNomePai()==null) || 
             (this.nomePai!=null &&
              this.nomePai.equals(other.getNomePai()))) &&
            ((this.numDocumentoIdentidade==null && other.getNumDocumentoIdentidade()==null) || 
             (this.numDocumentoIdentidade!=null &&
              this.numDocumentoIdentidade.equals(other.getNumDocumentoIdentidade()))) &&
            ((this.orgaoEmissor==null && other.getOrgaoEmissor()==null) || 
             (this.orgaoEmissor!=null &&
              this.orgaoEmissor.equals(other.getOrgaoEmissor()))) &&
            ((this.tipoCategoriaResponsavel==null && other.getTipoCategoriaResponsavel()==null) || 
             (this.tipoCategoriaResponsavel!=null &&
              this.tipoCategoriaResponsavel.equals(other.getTipoCategoriaResponsavel())));
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
        if (getContatos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContatos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContatos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCpf() != null) {
            _hashCode += getCpf().hashCode();
        }
        if (getDataFim() != null) {
            _hashCode += getDataFim().hashCode();
        }
        if (getDataInicio() != null) {
            _hashCode += getDataInicio().hashCode();
        }
        if (getDataNascimento() != null) {
            _hashCode += getDataNascimento().hashCode();
        }
        if (getEndereco() != null) {
            _hashCode += getEndereco().hashCode();
        }
        if (getEstadoCivil() != null) {
            _hashCode += getEstadoCivil().hashCode();
        }
        if (getHasError() != null) {
            _hashCode += getHasError().hashCode();
        }
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        if (getNacionalidade() != null) {
            _hashCode += getNacionalidade().hashCode();
        }
        if (getNaturalidade() != null) {
            _hashCode += getNaturalidade().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getNomeMae() != null) {
            _hashCode += getNomeMae().hashCode();
        }
        if (getNomePai() != null) {
            _hashCode += getNomePai().hashCode();
        }
        if (getNumDocumentoIdentidade() != null) {
            _hashCode += getNumDocumentoIdentidade().hashCode();
        }
        if (getOrgaoEmissor() != null) {
            _hashCode += getOrgaoEmissor().hashCode();
        }
        if (getTipoCategoriaResponsavel() != null) {
            _hashCode += getTipoCategoriaResponsavel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosResponsavelLegal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosResponsavelLegal"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contatos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "contatos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "dataFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "dataInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataNascimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "dataNascimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endereco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "endereco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Endereco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoCivil");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "estadoCivil"));
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
        elemField.setFieldName("mensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "mensagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nacionalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nacionalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("naturalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "naturalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeMae");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nomeMae"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomePai");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nomePai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numDocumentoIdentidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "numDocumentoIdentidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgaoEmissor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "orgaoEmissor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCategoriaResponsavel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "tipoCategoriaResponsavel"));
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
