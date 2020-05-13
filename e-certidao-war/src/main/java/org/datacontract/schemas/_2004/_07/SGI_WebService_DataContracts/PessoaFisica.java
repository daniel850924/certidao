/**
 * PessoaFisica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class PessoaFisica  implements java.io.Serializable {
    private java.lang.String area;

    private java.lang.Long codigoPessoa;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos;

    private java.lang.String cpf;

    private java.lang.String dataNascimento;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco;

    private java.lang.String nome;

    private java.lang.String nomeMae;

    private java.lang.String numDocumentoIdentidade;

    private java.lang.String orgaoEmissor;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] perfisUsuario;

    private java.lang.String sexo;

    private java.lang.String vinculoFuncional;

    public PessoaFisica() {
    }

    public PessoaFisica(
           java.lang.String area,
           java.lang.Long codigoPessoa,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos,
           java.lang.String cpf,
           java.lang.String dataNascimento,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco,
           java.lang.String nome,
           java.lang.String nomeMae,
           java.lang.String numDocumentoIdentidade,
           java.lang.String orgaoEmissor,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] perfisUsuario,
           java.lang.String sexo,
           java.lang.String vinculoFuncional) {
           this.area = area;
           this.codigoPessoa = codigoPessoa;
           this.contatos = contatos;
           this.cpf = cpf;
           this.dataNascimento = dataNascimento;
           this.endereco = endereco;
           this.nome = nome;
           this.nomeMae = nomeMae;
           this.numDocumentoIdentidade = numDocumentoIdentidade;
           this.orgaoEmissor = orgaoEmissor;
           this.perfisUsuario = perfisUsuario;
           this.sexo = sexo;
           this.vinculoFuncional = vinculoFuncional;
    }


    /**
     * Gets the area value for this PessoaFisica.
     * 
     * @return area
     */
    public java.lang.String getArea() {
        return area;
    }


    /**
     * Sets the area value for this PessoaFisica.
     * 
     * @param area
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }


    /**
     * Gets the codigoPessoa value for this PessoaFisica.
     * 
     * @return codigoPessoa
     */
    public java.lang.Long getCodigoPessoa() {
        return codigoPessoa;
    }


    /**
     * Sets the codigoPessoa value for this PessoaFisica.
     * 
     * @param codigoPessoa
     */
    public void setCodigoPessoa(java.lang.Long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }


    /**
     * Gets the contatos value for this PessoaFisica.
     * 
     * @return contatos
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] getContatos() {
        return contatos;
    }


    /**
     * Sets the contatos value for this PessoaFisica.
     * 
     * @param contatos
     */
    public void setContatos(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos) {
        this.contatos = contatos;
    }


    /**
     * Gets the cpf value for this PessoaFisica.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this PessoaFisica.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the dataNascimento value for this PessoaFisica.
     * 
     * @return dataNascimento
     */
    public java.lang.String getDataNascimento() {
        return dataNascimento;
    }


    /**
     * Sets the dataNascimento value for this PessoaFisica.
     * 
     * @param dataNascimento
     */
    public void setDataNascimento(java.lang.String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    /**
     * Gets the endereco value for this PessoaFisica.
     * 
     * @return endereco
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco getEndereco() {
        return endereco;
    }


    /**
     * Sets the endereco value for this PessoaFisica.
     * 
     * @param endereco
     */
    public void setEndereco(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco endereco) {
        this.endereco = endereco;
    }


    /**
     * Gets the nome value for this PessoaFisica.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this PessoaFisica.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the nomeMae value for this PessoaFisica.
     * 
     * @return nomeMae
     */
    public java.lang.String getNomeMae() {
        return nomeMae;
    }


    /**
     * Sets the nomeMae value for this PessoaFisica.
     * 
     * @param nomeMae
     */
    public void setNomeMae(java.lang.String nomeMae) {
        this.nomeMae = nomeMae;
    }


    /**
     * Gets the numDocumentoIdentidade value for this PessoaFisica.
     * 
     * @return numDocumentoIdentidade
     */
    public java.lang.String getNumDocumentoIdentidade() {
        return numDocumentoIdentidade;
    }


    /**
     * Sets the numDocumentoIdentidade value for this PessoaFisica.
     * 
     * @param numDocumentoIdentidade
     */
    public void setNumDocumentoIdentidade(java.lang.String numDocumentoIdentidade) {
        this.numDocumentoIdentidade = numDocumentoIdentidade;
    }


    /**
     * Gets the orgaoEmissor value for this PessoaFisica.
     * 
     * @return orgaoEmissor
     */
    public java.lang.String getOrgaoEmissor() {
        return orgaoEmissor;
    }


    /**
     * Sets the orgaoEmissor value for this PessoaFisica.
     * 
     * @param orgaoEmissor
     */
    public void setOrgaoEmissor(java.lang.String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }


    /**
     * Gets the perfisUsuario value for this PessoaFisica.
     * 
     * @return perfisUsuario
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] getPerfisUsuario() {
        return perfisUsuario;
    }


    /**
     * Sets the perfisUsuario value for this PessoaFisica.
     * 
     * @param perfisUsuario
     */
    public void setPerfisUsuario(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] perfisUsuario) {
        this.perfisUsuario = perfisUsuario;
    }


    /**
     * Gets the sexo value for this PessoaFisica.
     * 
     * @return sexo
     */
    public java.lang.String getSexo() {
        return sexo;
    }


    /**
     * Sets the sexo value for this PessoaFisica.
     * 
     * @param sexo
     */
    public void setSexo(java.lang.String sexo) {
        this.sexo = sexo;
    }


    /**
     * Gets the vinculoFuncional value for this PessoaFisica.
     * 
     * @return vinculoFuncional
     */
    public java.lang.String getVinculoFuncional() {
        return vinculoFuncional;
    }


    /**
     * Sets the vinculoFuncional value for this PessoaFisica.
     * 
     * @param vinculoFuncional
     */
    public void setVinculoFuncional(java.lang.String vinculoFuncional) {
        this.vinculoFuncional = vinculoFuncional;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PessoaFisica)) return false;
        PessoaFisica other = (PessoaFisica) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.codigoPessoa==null && other.getCodigoPessoa()==null) || 
             (this.codigoPessoa!=null &&
              this.codigoPessoa.equals(other.getCodigoPessoa()))) &&
            ((this.contatos==null && other.getContatos()==null) || 
             (this.contatos!=null &&
              java.util.Arrays.equals(this.contatos, other.getContatos()))) &&
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.dataNascimento==null && other.getDataNascimento()==null) || 
             (this.dataNascimento!=null &&
              this.dataNascimento.equals(other.getDataNascimento()))) &&
            ((this.endereco==null && other.getEndereco()==null) || 
             (this.endereco!=null &&
              this.endereco.equals(other.getEndereco()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.nomeMae==null && other.getNomeMae()==null) || 
             (this.nomeMae!=null &&
              this.nomeMae.equals(other.getNomeMae()))) &&
            ((this.numDocumentoIdentidade==null && other.getNumDocumentoIdentidade()==null) || 
             (this.numDocumentoIdentidade!=null &&
              this.numDocumentoIdentidade.equals(other.getNumDocumentoIdentidade()))) &&
            ((this.orgaoEmissor==null && other.getOrgaoEmissor()==null) || 
             (this.orgaoEmissor!=null &&
              this.orgaoEmissor.equals(other.getOrgaoEmissor()))) &&
            ((this.perfisUsuario==null && other.getPerfisUsuario()==null) || 
             (this.perfisUsuario!=null &&
              java.util.Arrays.equals(this.perfisUsuario, other.getPerfisUsuario()))) &&
            ((this.sexo==null && other.getSexo()==null) || 
             (this.sexo!=null &&
              this.sexo.equals(other.getSexo()))) &&
            ((this.vinculoFuncional==null && other.getVinculoFuncional()==null) || 
             (this.vinculoFuncional!=null &&
              this.vinculoFuncional.equals(other.getVinculoFuncional())));
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
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getCodigoPessoa() != null) {
            _hashCode += getCodigoPessoa().hashCode();
        }
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
        if (getDataNascimento() != null) {
            _hashCode += getDataNascimento().hashCode();
        }
        if (getEndereco() != null) {
            _hashCode += getEndereco().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getNomeMae() != null) {
            _hashCode += getNomeMae().hashCode();
        }
        if (getNumDocumentoIdentidade() != null) {
            _hashCode += getNumDocumentoIdentidade().hashCode();
        }
        if (getOrgaoEmissor() != null) {
            _hashCode += getOrgaoEmissor().hashCode();
        }
        if (getPerfisUsuario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPerfisUsuario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPerfisUsuario(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSexo() != null) {
            _hashCode += getSexo().hashCode();
        }
        if (getVinculoFuncional() != null) {
            _hashCode += getVinculoFuncional().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PessoaFisica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoPessoa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codigoPessoa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("dataNascimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "dataNascimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endereco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "endereco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Endereco"));
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
        elemField.setFieldName("perfisUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "perfisUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sexo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "sexo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vinculoFuncional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "vinculoFuncional"));
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
