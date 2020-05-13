/**
 * DadosUsuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class DadosUsuario  implements java.io.Serializable {
    private java.lang.Integer codCidade;

    private java.lang.String codIbge;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos;

    private java.lang.String cpf;

    private java.lang.String nome;

    private java.lang.String nomeCidadeAutenticacao;

    public DadosUsuario() {
    }

    public DadosUsuario(
           java.lang.Integer codCidade,
           java.lang.String codIbge,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos,
           java.lang.String cpf,
           java.lang.String nome,
           java.lang.String nomeCidadeAutenticacao) {
           this.codCidade = codCidade;
           this.codIbge = codIbge;
           this.contatos = contatos;
           this.cpf = cpf;
           this.nome = nome;
           this.nomeCidadeAutenticacao = nomeCidadeAutenticacao;
    }


    /**
     * Gets the codCidade value for this DadosUsuario.
     * 
     * @return codCidade
     */
    public java.lang.Integer getCodCidade() {
        return codCidade;
    }


    /**
     * Sets the codCidade value for this DadosUsuario.
     * 
     * @param codCidade
     */
    public void setCodCidade(java.lang.Integer codCidade) {
        this.codCidade = codCidade;
    }


    /**
     * Gets the codIbge value for this DadosUsuario.
     * 
     * @return codIbge
     */
    public java.lang.String getCodIbge() {
        return codIbge;
    }


    /**
     * Sets the codIbge value for this DadosUsuario.
     * 
     * @param codIbge
     */
    public void setCodIbge(java.lang.String codIbge) {
        this.codIbge = codIbge;
    }


    /**
     * Gets the contatos value for this DadosUsuario.
     * 
     * @return contatos
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] getContatos() {
        return contatos;
    }


    /**
     * Sets the contatos value for this DadosUsuario.
     * 
     * @param contatos
     */
    public void setContatos(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[] contatos) {
        this.contatos = contatos;
    }


    /**
     * Gets the cpf value for this DadosUsuario.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this DadosUsuario.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the nome value for this DadosUsuario.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this DadosUsuario.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the nomeCidadeAutenticacao value for this DadosUsuario.
     * 
     * @return nomeCidadeAutenticacao
     */
    public java.lang.String getNomeCidadeAutenticacao() {
        return nomeCidadeAutenticacao;
    }


    /**
     * Sets the nomeCidadeAutenticacao value for this DadosUsuario.
     * 
     * @param nomeCidadeAutenticacao
     */
    public void setNomeCidadeAutenticacao(java.lang.String nomeCidadeAutenticacao) {
        this.nomeCidadeAutenticacao = nomeCidadeAutenticacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosUsuario)) return false;
        DadosUsuario other = (DadosUsuario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codCidade==null && other.getCodCidade()==null) || 
             (this.codCidade!=null &&
              this.codCidade.equals(other.getCodCidade()))) &&
            ((this.codIbge==null && other.getCodIbge()==null) || 
             (this.codIbge!=null &&
              this.codIbge.equals(other.getCodIbge()))) &&
            ((this.contatos==null && other.getContatos()==null) || 
             (this.contatos!=null &&
              java.util.Arrays.equals(this.contatos, other.getContatos()))) &&
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.nomeCidadeAutenticacao==null && other.getNomeCidadeAutenticacao()==null) || 
             (this.nomeCidadeAutenticacao!=null &&
              this.nomeCidadeAutenticacao.equals(other.getNomeCidadeAutenticacao())));
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
        if (getCodCidade() != null) {
            _hashCode += getCodCidade().hashCode();
        }
        if (getCodIbge() != null) {
            _hashCode += getCodIbge().hashCode();
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
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getNomeCidadeAutenticacao() != null) {
            _hashCode += getNomeCidadeAutenticacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosUsuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosUsuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codCidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codIbge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "codIbge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeCidadeAutenticacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "nomeCidadeAutenticacao"));
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
