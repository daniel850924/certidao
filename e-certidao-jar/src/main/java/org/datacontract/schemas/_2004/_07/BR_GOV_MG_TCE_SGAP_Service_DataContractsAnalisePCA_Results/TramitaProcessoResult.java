/**
 * TramitaProcessoResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results;

public class TramitaProcessoResult  extends org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_Base.BaseResult  implements java.io.Serializable {
    private java.math.BigDecimal codGuiaTramitacao;

    public TramitaProcessoResult() {
    }

    public TramitaProcessoResult(
           org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPMensagemErro[] erros,
           java.lang.Boolean sucesso,
           java.math.BigDecimal codGuiaTramitacao) {
        super(
            erros,
            sucesso);
        this.codGuiaTramitacao = codGuiaTramitacao;
    }


    /**
     * Gets the codGuiaTramitacao value for this TramitaProcessoResult.
     * 
     * @return codGuiaTramitacao
     */
    public java.math.BigDecimal getCodGuiaTramitacao() {
        return codGuiaTramitacao;
    }


    /**
     * Sets the codGuiaTramitacao value for this TramitaProcessoResult.
     * 
     * @param codGuiaTramitacao
     */
    public void setCodGuiaTramitacao(java.math.BigDecimal codGuiaTramitacao) {
        this.codGuiaTramitacao = codGuiaTramitacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TramitaProcessoResult)) return false;
        TramitaProcessoResult other = (TramitaProcessoResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.codGuiaTramitacao==null && other.getCodGuiaTramitacao()==null) || 
             (this.codGuiaTramitacao!=null &&
              this.codGuiaTramitacao.equals(other.getCodGuiaTramitacao())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCodGuiaTramitacao() != null) {
            _hashCode += getCodGuiaTramitacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TramitaProcessoResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "TramitaProcessoResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codGuiaTramitacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA.Results", "CodGuiaTramitacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
