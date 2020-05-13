/**
 * OrgaoEntidadeServiceDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_DAL_DTO;

public class OrgaoEntidadeServiceDto  implements java.io.Serializable {
    private java.lang.String bairro;

    private java.lang.String CEP;

    private java.lang.String cidade;

    private java.lang.Long codigo;

    private java.lang.String complemento;

    private org.datacontract.schemas._2004._07.SGI_DAL_DTO.ContatoServiceDto[] contatos;

    private java.lang.String cpfResponsavelLegalAtual;

    private java.lang.String dscEndereco;

    private java.lang.String estado;

    private java.lang.String nomEntidade;

    private java.lang.String nomeLogradouro;

    private java.lang.String nomeResponsavelLegalAtual;

    private java.lang.String numCnpj;

    private java.lang.String numero;

    private java.lang.String tipoEntidade;

    public OrgaoEntidadeServiceDto() {
    }

    public OrgaoEntidadeServiceDto(
           java.lang.String bairro,
           java.lang.String CEP,
           java.lang.String cidade,
           java.lang.Long codigo,
           java.lang.String complemento,
           org.datacontract.schemas._2004._07.SGI_DAL_DTO.ContatoServiceDto[] contatos,
           java.lang.String cpfResponsavelLegalAtual,
           java.lang.String dscEndereco,
           java.lang.String estado,
           java.lang.String nomEntidade,
           java.lang.String nomeLogradouro,
           java.lang.String nomeResponsavelLegalAtual,
           java.lang.String numCnpj,
           java.lang.String numero,
           java.lang.String tipoEntidade) {
           this.bairro = bairro;
           this.CEP = CEP;
           this.cidade = cidade;
           this.codigo = codigo;
           this.complemento = complemento;
           this.contatos = contatos;
           this.cpfResponsavelLegalAtual = cpfResponsavelLegalAtual;
           this.dscEndereco = dscEndereco;
           this.estado = estado;
           this.nomEntidade = nomEntidade;
           this.nomeLogradouro = nomeLogradouro;
           this.nomeResponsavelLegalAtual = nomeResponsavelLegalAtual;
           this.numCnpj = numCnpj;
           this.numero = numero;
           this.tipoEntidade = tipoEntidade;
    }


    /**
     * Gets the bairro value for this OrgaoEntidadeServiceDto.
     * 
     * @return bairro
     */
    public java.lang.String getBairro() {
        return bairro;
    }


    /**
     * Sets the bairro value for this OrgaoEntidadeServiceDto.
     * 
     * @param bairro
     */
    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }


    /**
     * Gets the CEP value for this OrgaoEntidadeServiceDto.
     * 
     * @return CEP
     */
    public java.lang.String getCEP() {
        return CEP;
    }


    /**
     * Sets the CEP value for this OrgaoEntidadeServiceDto.
     * 
     * @param CEP
     */
    public void setCEP(java.lang.String CEP) {
        this.CEP = CEP;
    }


    /**
     * Gets the cidade value for this OrgaoEntidadeServiceDto.
     * 
     * @return cidade
     */
    public java.lang.String getCidade() {
        return cidade;
    }


    /**
     * Sets the cidade value for this OrgaoEntidadeServiceDto.
     * 
     * @param cidade
     */
    public void setCidade(java.lang.String cidade) {
        this.cidade = cidade;
    }


    /**
     * Gets the codigo value for this OrgaoEntidadeServiceDto.
     * 
     * @return codigo
     */
    public java.lang.Long getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this OrgaoEntidadeServiceDto.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.Long codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the complemento value for this OrgaoEntidadeServiceDto.
     * 
     * @return complemento
     */
    public java.lang.String getComplemento() {
        return complemento;
    }


    /**
     * Sets the complemento value for this OrgaoEntidadeServiceDto.
     * 
     * @param complemento
     */
    public void setComplemento(java.lang.String complemento) {
        this.complemento = complemento;
    }


    /**
     * Gets the contatos value for this OrgaoEntidadeServiceDto.
     * 
     * @return contatos
     */
    public org.datacontract.schemas._2004._07.SGI_DAL_DTO.ContatoServiceDto[] getContatos() {
        return contatos;
    }


    /**
     * Sets the contatos value for this OrgaoEntidadeServiceDto.
     * 
     * @param contatos
     */
    public void setContatos(org.datacontract.schemas._2004._07.SGI_DAL_DTO.ContatoServiceDto[] contatos) {
        this.contatos = contatos;
    }


    /**
     * Gets the cpfResponsavelLegalAtual value for this OrgaoEntidadeServiceDto.
     * 
     * @return cpfResponsavelLegalAtual
     */
    public java.lang.String getCpfResponsavelLegalAtual() {
        return cpfResponsavelLegalAtual;
    }


    /**
     * Sets the cpfResponsavelLegalAtual value for this OrgaoEntidadeServiceDto.
     * 
     * @param cpfResponsavelLegalAtual
     */
    public void setCpfResponsavelLegalAtual(java.lang.String cpfResponsavelLegalAtual) {
        this.cpfResponsavelLegalAtual = cpfResponsavelLegalAtual;
    }


    /**
     * Gets the dscEndereco value for this OrgaoEntidadeServiceDto.
     * 
     * @return dscEndereco
     */
    public java.lang.String getDscEndereco() {
        return dscEndereco;
    }


    /**
     * Sets the dscEndereco value for this OrgaoEntidadeServiceDto.
     * 
     * @param dscEndereco
     */
    public void setDscEndereco(java.lang.String dscEndereco) {
        this.dscEndereco = dscEndereco;
    }


    /**
     * Gets the estado value for this OrgaoEntidadeServiceDto.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this OrgaoEntidadeServiceDto.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the nomEntidade value for this OrgaoEntidadeServiceDto.
     * 
     * @return nomEntidade
     */
    public java.lang.String getNomEntidade() {
        return nomEntidade;
    }


    /**
     * Sets the nomEntidade value for this OrgaoEntidadeServiceDto.
     * 
     * @param nomEntidade
     */
    public void setNomEntidade(java.lang.String nomEntidade) {
        this.nomEntidade = nomEntidade;
    }


    /**
     * Gets the nomeLogradouro value for this OrgaoEntidadeServiceDto.
     * 
     * @return nomeLogradouro
     */
    public java.lang.String getNomeLogradouro() {
        return nomeLogradouro;
    }


    /**
     * Sets the nomeLogradouro value for this OrgaoEntidadeServiceDto.
     * 
     * @param nomeLogradouro
     */
    public void setNomeLogradouro(java.lang.String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }


    /**
     * Gets the nomeResponsavelLegalAtual value for this OrgaoEntidadeServiceDto.
     * 
     * @return nomeResponsavelLegalAtual
     */
    public java.lang.String getNomeResponsavelLegalAtual() {
        return nomeResponsavelLegalAtual;
    }


    /**
     * Sets the nomeResponsavelLegalAtual value for this OrgaoEntidadeServiceDto.
     * 
     * @param nomeResponsavelLegalAtual
     */
    public void setNomeResponsavelLegalAtual(java.lang.String nomeResponsavelLegalAtual) {
        this.nomeResponsavelLegalAtual = nomeResponsavelLegalAtual;
    }


    /**
     * Gets the numCnpj value for this OrgaoEntidadeServiceDto.
     * 
     * @return numCnpj
     */
    public java.lang.String getNumCnpj() {
        return numCnpj;
    }


    /**
     * Sets the numCnpj value for this OrgaoEntidadeServiceDto.
     * 
     * @param numCnpj
     */
    public void setNumCnpj(java.lang.String numCnpj) {
        this.numCnpj = numCnpj;
    }


    /**
     * Gets the numero value for this OrgaoEntidadeServiceDto.
     * 
     * @return numero
     */
    public java.lang.String getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this OrgaoEntidadeServiceDto.
     * 
     * @param numero
     */
    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }


    /**
     * Gets the tipoEntidade value for this OrgaoEntidadeServiceDto.
     * 
     * @return tipoEntidade
     */
    public java.lang.String getTipoEntidade() {
        return tipoEntidade;
    }


    /**
     * Sets the tipoEntidade value for this OrgaoEntidadeServiceDto.
     * 
     * @param tipoEntidade
     */
    public void setTipoEntidade(java.lang.String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrgaoEntidadeServiceDto)) return false;
        OrgaoEntidadeServiceDto other = (OrgaoEntidadeServiceDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bairro==null && other.getBairro()==null) || 
             (this.bairro!=null &&
              this.bairro.equals(other.getBairro()))) &&
            ((this.CEP==null && other.getCEP()==null) || 
             (this.CEP!=null &&
              this.CEP.equals(other.getCEP()))) &&
            ((this.cidade==null && other.getCidade()==null) || 
             (this.cidade!=null &&
              this.cidade.equals(other.getCidade()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.complemento==null && other.getComplemento()==null) || 
             (this.complemento!=null &&
              this.complemento.equals(other.getComplemento()))) &&
            ((this.contatos==null && other.getContatos()==null) || 
             (this.contatos!=null &&
              java.util.Arrays.equals(this.contatos, other.getContatos()))) &&
            ((this.cpfResponsavelLegalAtual==null && other.getCpfResponsavelLegalAtual()==null) || 
             (this.cpfResponsavelLegalAtual!=null &&
              this.cpfResponsavelLegalAtual.equals(other.getCpfResponsavelLegalAtual()))) &&
            ((this.dscEndereco==null && other.getDscEndereco()==null) || 
             (this.dscEndereco!=null &&
              this.dscEndereco.equals(other.getDscEndereco()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.nomEntidade==null && other.getNomEntidade()==null) || 
             (this.nomEntidade!=null &&
              this.nomEntidade.equals(other.getNomEntidade()))) &&
            ((this.nomeLogradouro==null && other.getNomeLogradouro()==null) || 
             (this.nomeLogradouro!=null &&
              this.nomeLogradouro.equals(other.getNomeLogradouro()))) &&
            ((this.nomeResponsavelLegalAtual==null && other.getNomeResponsavelLegalAtual()==null) || 
             (this.nomeResponsavelLegalAtual!=null &&
              this.nomeResponsavelLegalAtual.equals(other.getNomeResponsavelLegalAtual()))) &&
            ((this.numCnpj==null && other.getNumCnpj()==null) || 
             (this.numCnpj!=null &&
              this.numCnpj.equals(other.getNumCnpj()))) &&
            ((this.numero==null && other.getNumero()==null) || 
             (this.numero!=null &&
              this.numero.equals(other.getNumero()))) &&
            ((this.tipoEntidade==null && other.getTipoEntidade()==null) || 
             (this.tipoEntidade!=null &&
              this.tipoEntidade.equals(other.getTipoEntidade())));
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
        if (getBairro() != null) {
            _hashCode += getBairro().hashCode();
        }
        if (getCEP() != null) {
            _hashCode += getCEP().hashCode();
        }
        if (getCidade() != null) {
            _hashCode += getCidade().hashCode();
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getComplemento() != null) {
            _hashCode += getComplemento().hashCode();
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
        if (getCpfResponsavelLegalAtual() != null) {
            _hashCode += getCpfResponsavelLegalAtual().hashCode();
        }
        if (getDscEndereco() != null) {
            _hashCode += getDscEndereco().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getNomEntidade() != null) {
            _hashCode += getNomEntidade().hashCode();
        }
        if (getNomeLogradouro() != null) {
            _hashCode += getNomeLogradouro().hashCode();
        }
        if (getNomeResponsavelLegalAtual() != null) {
            _hashCode += getNomeResponsavelLegalAtual().hashCode();
        }
        if (getNumCnpj() != null) {
            _hashCode += getNumCnpj().hashCode();
        }
        if (getNumero() != null) {
            _hashCode += getNumero().hashCode();
        }
        if (getTipoEntidade() != null) {
            _hashCode += getTipoEntidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrgaoEntidadeServiceDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "OrgaoEntidadeServiceDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bairro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "Bairro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CEP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "CEP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "Cidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "Codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complemento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "Complemento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contatos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "Contatos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "ContatoServiceDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "ContatoServiceDto"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpfResponsavelLegalAtual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "CpfResponsavelLegalAtual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dscEndereco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "DscEndereco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "NomEntidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeLogradouro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "NomeLogradouro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeResponsavelLegalAtual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "NomeResponsavelLegalAtual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numCnpj");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "NumCnpj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "Numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "TipoEntidade"));
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
