/**
 * DocumentoJuntadaResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA;

public class DocumentoJuntadaResult  extends org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_Base.BaseResult  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaItem[] documentoJuntadaItens;

    public DocumentoJuntadaResult() {
    }

    public DocumentoJuntadaResult(
           org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPMensagemErro[] erros,
           java.lang.Boolean sucesso,
           org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaItem[] documentoJuntadaItens) {
        super(
            erros,
            sucesso);
        this.documentoJuntadaItens = documentoJuntadaItens;
    }


    /**
     * Gets the documentoJuntadaItens value for this DocumentoJuntadaResult.
     * 
     * @return documentoJuntadaItens
     */
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaItem[] getDocumentoJuntadaItens() {
        return documentoJuntadaItens;
    }


    /**
     * Sets the documentoJuntadaItens value for this DocumentoJuntadaResult.
     * 
     * @param documentoJuntadaItens
     */
    public void setDocumentoJuntadaItens(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaItem[] documentoJuntadaItens) {
        this.documentoJuntadaItens = documentoJuntadaItens;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoJuntadaResult)) return false;
        DocumentoJuntadaResult other = (DocumentoJuntadaResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.documentoJuntadaItens==null && other.getDocumentoJuntadaItens()==null) || 
             (this.documentoJuntadaItens!=null &&
              java.util.Arrays.equals(this.documentoJuntadaItens, other.getDocumentoJuntadaItens())));
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
        if (getDocumentoJuntadaItens() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentoJuntadaItens());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentoJuntadaItens(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoJuntadaResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "DocumentoJuntadaResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoJuntadaItens");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "DocumentoJuntadaItens"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "DocumentoJuntadaItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service.DataContractsAnalisePCA", "DocumentoJuntadaItem"));
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
