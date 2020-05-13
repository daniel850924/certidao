/**
 * DocumentoJuntadaParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA;

public class DocumentoJuntadaParameter  implements java.io.Serializable {
    private java.util.Calendar dataFimPrazo;

    private java.util.Calendar dataInicioPrazo;

    private java.lang.String numeroProcesso;

    public DocumentoJuntadaParameter() {
    }

    public DocumentoJuntadaParameter(
           java.util.Calendar dataFimPrazo,
           java.util.Calendar dataInicioPrazo,
           java.lang.String numeroProcesso) {
           this.dataFimPrazo = dataFimPrazo;
           this.dataInicioPrazo = dataInicioPrazo;
           this.numeroProcesso = numeroProcesso;
    }


    /**
     * Gets the dataFimPrazo value for this DocumentoJuntadaParameter.
     * 
     * @return dataFimPrazo
     */
    public java.util.Calendar getDataFimPrazo() {
        return dataFimPrazo;
    }


    /**
     * Sets the dataFimPrazo value for this DocumentoJuntadaParameter.
     * 
     * @param dataFimPrazo
     */
    public void setDataFimPrazo(java.util.Calendar dataFimPrazo) {
        this.dataFimPrazo = dataFimPrazo;
    }


    /**
     * Gets the dataInicioPrazo value for this DocumentoJuntadaParameter.
     * 
     * @return dataInicioPrazo
     */
    public java.util.Calendar getDataInicioPrazo() {
        return dataInicioPrazo;
    }


    /**
     * Sets the dataInicioPrazo value for this DocumentoJuntadaParameter.
     * 
     * @param dataInicioPrazo
     */
    public void setDataInicioPrazo(java.util.Calendar dataInicioPrazo) {
        this.dataInicioPrazo = dataInicioPrazo;
    }


    /**
     * Gets the numeroProcesso value for this DocumentoJuntadaParameter.
     * 
     * @return numeroProcesso
     */
    public java.lang.String getNumeroProcesso() {
        return numeroProcesso;
    }


    /**
     * Sets the numeroProcesso value for this DocumentoJuntadaParameter.
     * 
     * @param numeroProcesso
     */
    public void setNumeroProcesso(java.lang.String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoJuntadaParameter)) return false;
        DocumentoJuntadaParameter other = (DocumentoJuntadaParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataFimPrazo==null && other.getDataFimPrazo()==null) || 
             (this.dataFimPrazo!=null &&
              this.dataFimPrazo.equals(other.getDataFimPrazo()))) &&
            ((this.dataInicioPrazo==null && other.getDataInicioPrazo()==null) || 
             (this.dataInicioPrazo!=null &&
              this.dataInicioPrazo.equals(other.getDataInicioPrazo()))) &&
            ((this.numeroProcesso==null && other.getNumeroProcesso()==null) || 
             (this.numeroProcesso!=null &&
              this.numeroProcesso.equals(other.getNumeroProcesso())));
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
        if (getDataFimPrazo() != null) {
            _hashCode += getDataFimPrazo().hashCode();
        }
        if (getDataInicioPrazo() != null) {
            _hashCode += getDataInicioPrazo().hashCode();
        }
        if (getNumeroProcesso() != null) {
            _hashCode += getNumeroProcesso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoJuntadaParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "DocumentoJuntadaParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFimPrazo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "DataFimPrazo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicioPrazo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "DataInicioPrazo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroProcesso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "NumeroProcesso"));
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
