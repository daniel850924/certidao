/**
 * SituacaoPCAPorMunicipioResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results;

public class SituacaoPCAPorMunicipioResult  implements java.io.Serializable {
    private java.lang.String mensagem;

    private org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioItemResult[] situacoes;

    private java.lang.Boolean sucesso;

    public SituacaoPCAPorMunicipioResult() {
    }

    public SituacaoPCAPorMunicipioResult(
           java.lang.String mensagem,
           org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioItemResult[] situacoes,
           java.lang.Boolean sucesso) {
           this.mensagem = mensagem;
           this.situacoes = situacoes;
           this.sucesso = sucesso;
    }


    /**
     * Gets the mensagem value for this SituacaoPCAPorMunicipioResult.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this SituacaoPCAPorMunicipioResult.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }


    /**
     * Gets the situacoes value for this SituacaoPCAPorMunicipioResult.
     * 
     * @return situacoes
     */
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioItemResult[] getSituacoes() {
        return situacoes;
    }


    /**
     * Sets the situacoes value for this SituacaoPCAPorMunicipioResult.
     * 
     * @param situacoes
     */
    public void setSituacoes(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioItemResult[] situacoes) {
        this.situacoes = situacoes;
    }


    /**
     * Gets the sucesso value for this SituacaoPCAPorMunicipioResult.
     * 
     * @return sucesso
     */
    public java.lang.Boolean getSucesso() {
        return sucesso;
    }


    /**
     * Sets the sucesso value for this SituacaoPCAPorMunicipioResult.
     * 
     * @param sucesso
     */
    public void setSucesso(java.lang.Boolean sucesso) {
        this.sucesso = sucesso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SituacaoPCAPorMunicipioResult)) return false;
        SituacaoPCAPorMunicipioResult other = (SituacaoPCAPorMunicipioResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem()))) &&
            ((this.situacoes==null && other.getSituacoes()==null) || 
             (this.situacoes!=null &&
              java.util.Arrays.equals(this.situacoes, other.getSituacoes()))) &&
            ((this.sucesso==null && other.getSucesso()==null) || 
             (this.sucesso!=null &&
              this.sucesso.equals(other.getSucesso())));
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
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        if (getSituacoes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSituacoes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSituacoes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSucesso() != null) {
            _hashCode += getSucesso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SituacaoPCAPorMunicipioResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "SituacaoPCAPorMunicipioResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "Mensagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "Situacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "SituacaoPCAPorMunicipioItemResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "SituacaoPCAPorMunicipioItemResult"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucesso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "Sucesso"));
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
