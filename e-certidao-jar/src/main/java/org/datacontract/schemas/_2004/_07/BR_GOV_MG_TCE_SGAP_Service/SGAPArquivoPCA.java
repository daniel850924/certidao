/**
 * SGAPArquivoPCA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service;

public class SGAPArquivoPCA  implements java.io.Serializable {
    private byte[] bytesArquivo;

    private java.lang.String extensaoArquivo;

    private java.lang.String siglaSituacaoDocumento;

    private java.lang.String siglaTipoArquivo;

    public SGAPArquivoPCA() {
    }

    public SGAPArquivoPCA(
           byte[] bytesArquivo,
           java.lang.String extensaoArquivo,
           java.lang.String siglaSituacaoDocumento,
           java.lang.String siglaTipoArquivo) {
           this.bytesArquivo = bytesArquivo;
           this.extensaoArquivo = extensaoArquivo;
           this.siglaSituacaoDocumento = siglaSituacaoDocumento;
           this.siglaTipoArquivo = siglaTipoArquivo;
    }


    /**
     * Gets the bytesArquivo value for this SGAPArquivoPCA.
     * 
     * @return bytesArquivo
     */
    public byte[] getBytesArquivo() {
        return bytesArquivo;
    }


    /**
     * Sets the bytesArquivo value for this SGAPArquivoPCA.
     * 
     * @param bytesArquivo
     */
    public void setBytesArquivo(byte[] bytesArquivo) {
        this.bytesArquivo = bytesArquivo;
    }


    /**
     * Gets the extensaoArquivo value for this SGAPArquivoPCA.
     * 
     * @return extensaoArquivo
     */
    public java.lang.String getExtensaoArquivo() {
        return extensaoArquivo;
    }


    /**
     * Sets the extensaoArquivo value for this SGAPArquivoPCA.
     * 
     * @param extensaoArquivo
     */
    public void setExtensaoArquivo(java.lang.String extensaoArquivo) {
        this.extensaoArquivo = extensaoArquivo;
    }


    /**
     * Gets the siglaSituacaoDocumento value for this SGAPArquivoPCA.
     * 
     * @return siglaSituacaoDocumento
     */
    public java.lang.String getSiglaSituacaoDocumento() {
        return siglaSituacaoDocumento;
    }


    /**
     * Sets the siglaSituacaoDocumento value for this SGAPArquivoPCA.
     * 
     * @param siglaSituacaoDocumento
     */
    public void setSiglaSituacaoDocumento(java.lang.String siglaSituacaoDocumento) {
        this.siglaSituacaoDocumento = siglaSituacaoDocumento;
    }


    /**
     * Gets the siglaTipoArquivo value for this SGAPArquivoPCA.
     * 
     * @return siglaTipoArquivo
     */
    public java.lang.String getSiglaTipoArquivo() {
        return siglaTipoArquivo;
    }


    /**
     * Sets the siglaTipoArquivo value for this SGAPArquivoPCA.
     * 
     * @param siglaTipoArquivo
     */
    public void setSiglaTipoArquivo(java.lang.String siglaTipoArquivo) {
        this.siglaTipoArquivo = siglaTipoArquivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SGAPArquivoPCA)) return false;
        SGAPArquivoPCA other = (SGAPArquivoPCA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bytesArquivo==null && other.getBytesArquivo()==null) || 
             (this.bytesArquivo!=null &&
              java.util.Arrays.equals(this.bytesArquivo, other.getBytesArquivo()))) &&
            ((this.extensaoArquivo==null && other.getExtensaoArquivo()==null) || 
             (this.extensaoArquivo!=null &&
              this.extensaoArquivo.equals(other.getExtensaoArquivo()))) &&
            ((this.siglaSituacaoDocumento==null && other.getSiglaSituacaoDocumento()==null) || 
             (this.siglaSituacaoDocumento!=null &&
              this.siglaSituacaoDocumento.equals(other.getSiglaSituacaoDocumento()))) &&
            ((this.siglaTipoArquivo==null && other.getSiglaTipoArquivo()==null) || 
             (this.siglaTipoArquivo!=null &&
              this.siglaTipoArquivo.equals(other.getSiglaTipoArquivo())));
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
        if (getBytesArquivo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBytesArquivo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBytesArquivo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtensaoArquivo() != null) {
            _hashCode += getExtensaoArquivo().hashCode();
        }
        if (getSiglaSituacaoDocumento() != null) {
            _hashCode += getSiglaSituacaoDocumento().hashCode();
        }
        if (getSiglaTipoArquivo() != null) {
            _hashCode += getSiglaTipoArquivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SGAPArquivoPCA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SGAPArquivoPCA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bytesArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "BytesArquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extensaoArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "ExtensaoArquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaSituacaoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SiglaSituacaoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaTipoArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SiglaTipoArquivo"));
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
