/**
 * TramitaProcessoParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Parameters;

public class TramitaProcessoParameter  implements java.io.Serializable {
    private java.lang.Long chave;

    private java.lang.Long codOcorrencia;

    private java.lang.Long codProcesso;

    private java.lang.Long codUnidadeDestino;

    private java.lang.Long numeroMatriculaServidor;

    public TramitaProcessoParameter() {
    }

    public TramitaProcessoParameter(
           java.lang.Long chave,
           java.lang.Long codOcorrencia,
           java.lang.Long codProcesso,
           java.lang.Long codUnidadeDestino,
           java.lang.Long numeroMatriculaServidor) {
           this.chave = chave;
           this.codOcorrencia = codOcorrencia;
           this.codProcesso = codProcesso;
           this.codUnidadeDestino = codUnidadeDestino;
           this.numeroMatriculaServidor = numeroMatriculaServidor;
    }


    /**
     * Gets the chave value for this TramitaProcessoParameter.
     * 
     * @return chave
     */
    public java.lang.Long getChave() {
        return chave;
    }


    /**
     * Sets the chave value for this TramitaProcessoParameter.
     * 
     * @param chave
     */
    public void setChave(java.lang.Long chave) {
        this.chave = chave;
    }


    /**
     * Gets the codOcorrencia value for this TramitaProcessoParameter.
     * 
     * @return codOcorrencia
     */
    public java.lang.Long getCodOcorrencia() {
        return codOcorrencia;
    }


    /**
     * Sets the codOcorrencia value for this TramitaProcessoParameter.
     * 
     * @param codOcorrencia
     */
    public void setCodOcorrencia(java.lang.Long codOcorrencia) {
        this.codOcorrencia = codOcorrencia;
    }


    /**
     * Gets the codProcesso value for this TramitaProcessoParameter.
     * 
     * @return codProcesso
     */
    public java.lang.Long getCodProcesso() {
        return codProcesso;
    }


    /**
     * Sets the codProcesso value for this TramitaProcessoParameter.
     * 
     * @param codProcesso
     */
    public void setCodProcesso(java.lang.Long codProcesso) {
        this.codProcesso = codProcesso;
    }


    /**
     * Gets the codUnidadeDestino value for this TramitaProcessoParameter.
     * 
     * @return codUnidadeDestino
     */
    public java.lang.Long getCodUnidadeDestino() {
        return codUnidadeDestino;
    }


    /**
     * Sets the codUnidadeDestino value for this TramitaProcessoParameter.
     * 
     * @param codUnidadeDestino
     */
    public void setCodUnidadeDestino(java.lang.Long codUnidadeDestino) {
        this.codUnidadeDestino = codUnidadeDestino;
    }


    /**
     * Gets the numeroMatriculaServidor value for this TramitaProcessoParameter.
     * 
     * @return numeroMatriculaServidor
     */
    public java.lang.Long getNumeroMatriculaServidor() {
        return numeroMatriculaServidor;
    }


    /**
     * Sets the numeroMatriculaServidor value for this TramitaProcessoParameter.
     * 
     * @param numeroMatriculaServidor
     */
    public void setNumeroMatriculaServidor(java.lang.Long numeroMatriculaServidor) {
        this.numeroMatriculaServidor = numeroMatriculaServidor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TramitaProcessoParameter)) return false;
        TramitaProcessoParameter other = (TramitaProcessoParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.chave==null && other.getChave()==null) || 
             (this.chave!=null &&
              this.chave.equals(other.getChave()))) &&
            ((this.codOcorrencia==null && other.getCodOcorrencia()==null) || 
             (this.codOcorrencia!=null &&
              this.codOcorrencia.equals(other.getCodOcorrencia()))) &&
            ((this.codProcesso==null && other.getCodProcesso()==null) || 
             (this.codProcesso!=null &&
              this.codProcesso.equals(other.getCodProcesso()))) &&
            ((this.codUnidadeDestino==null && other.getCodUnidadeDestino()==null) || 
             (this.codUnidadeDestino!=null &&
              this.codUnidadeDestino.equals(other.getCodUnidadeDestino()))) &&
            ((this.numeroMatriculaServidor==null && other.getNumeroMatriculaServidor()==null) || 
             (this.numeroMatriculaServidor!=null &&
              this.numeroMatriculaServidor.equals(other.getNumeroMatriculaServidor())));
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
        if (getChave() != null) {
            _hashCode += getChave().hashCode();
        }
        if (getCodOcorrencia() != null) {
            _hashCode += getCodOcorrencia().hashCode();
        }
        if (getCodProcesso() != null) {
            _hashCode += getCodProcesso().hashCode();
        }
        if (getCodUnidadeDestino() != null) {
            _hashCode += getCodUnidadeDestino().hashCode();
        }
        if (getNumeroMatriculaServidor() != null) {
            _hashCode += getNumeroMatriculaServidor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TramitaProcessoParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Parameters", "TramitaProcessoParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Parameters", "Chave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codOcorrencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Parameters", "CodOcorrencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codProcesso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Parameters", "CodProcesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codUnidadeDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Parameters", "CodUnidadeDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroMatriculaServidor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Parameters", "NumeroMatriculaServidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
