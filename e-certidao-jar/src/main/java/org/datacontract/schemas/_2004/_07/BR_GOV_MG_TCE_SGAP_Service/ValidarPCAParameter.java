/**
 * ValidarPCAParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service;

public class ValidarPCAParameter  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPArquivoPCA[] arquivos;

    private java.lang.Long codProcesso;

    private java.lang.String numMatriculaUsuarioSGAP;

    private java.lang.String siglaTipoConclusaoPCA;

    private java.lang.String usuarioPCA;

    public ValidarPCAParameter() {
    }

    public ValidarPCAParameter(
           org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPArquivoPCA[] arquivos,
           java.lang.Long codProcesso,
           java.lang.String numMatriculaUsuarioSGAP,
           java.lang.String siglaTipoConclusaoPCA,
           java.lang.String usuarioPCA) {
           this.arquivos = arquivos;
           this.codProcesso = codProcesso;
           this.numMatriculaUsuarioSGAP = numMatriculaUsuarioSGAP;
           this.siglaTipoConclusaoPCA = siglaTipoConclusaoPCA;
           this.usuarioPCA = usuarioPCA;
    }


    /**
     * Gets the arquivos value for this ValidarPCAParameter.
     * 
     * @return arquivos
     */
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPArquivoPCA[] getArquivos() {
        return arquivos;
    }


    /**
     * Sets the arquivos value for this ValidarPCAParameter.
     * 
     * @param arquivos
     */
    public void setArquivos(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.SGAPArquivoPCA[] arquivos) {
        this.arquivos = arquivos;
    }


    /**
     * Gets the codProcesso value for this ValidarPCAParameter.
     * 
     * @return codProcesso
     */
    public java.lang.Long getCodProcesso() {
        return codProcesso;
    }


    /**
     * Sets the codProcesso value for this ValidarPCAParameter.
     * 
     * @param codProcesso
     */
    public void setCodProcesso(java.lang.Long codProcesso) {
        this.codProcesso = codProcesso;
    }


    /**
     * Gets the numMatriculaUsuarioSGAP value for this ValidarPCAParameter.
     * 
     * @return numMatriculaUsuarioSGAP
     */
    public java.lang.String getNumMatriculaUsuarioSGAP() {
        return numMatriculaUsuarioSGAP;
    }


    /**
     * Sets the numMatriculaUsuarioSGAP value for this ValidarPCAParameter.
     * 
     * @param numMatriculaUsuarioSGAP
     */
    public void setNumMatriculaUsuarioSGAP(java.lang.String numMatriculaUsuarioSGAP) {
        this.numMatriculaUsuarioSGAP = numMatriculaUsuarioSGAP;
    }


    /**
     * Gets the siglaTipoConclusaoPCA value for this ValidarPCAParameter.
     * 
     * @return siglaTipoConclusaoPCA
     */
    public java.lang.String getSiglaTipoConclusaoPCA() {
        return siglaTipoConclusaoPCA;
    }


    /**
     * Sets the siglaTipoConclusaoPCA value for this ValidarPCAParameter.
     * 
     * @param siglaTipoConclusaoPCA
     */
    public void setSiglaTipoConclusaoPCA(java.lang.String siglaTipoConclusaoPCA) {
        this.siglaTipoConclusaoPCA = siglaTipoConclusaoPCA;
    }


    /**
     * Gets the usuarioPCA value for this ValidarPCAParameter.
     * 
     * @return usuarioPCA
     */
    public java.lang.String getUsuarioPCA() {
        return usuarioPCA;
    }


    /**
     * Sets the usuarioPCA value for this ValidarPCAParameter.
     * 
     * @param usuarioPCA
     */
    public void setUsuarioPCA(java.lang.String usuarioPCA) {
        this.usuarioPCA = usuarioPCA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValidarPCAParameter)) return false;
        ValidarPCAParameter other = (ValidarPCAParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arquivos==null && other.getArquivos()==null) || 
             (this.arquivos!=null &&
              java.util.Arrays.equals(this.arquivos, other.getArquivos()))) &&
            ((this.codProcesso==null && other.getCodProcesso()==null) || 
             (this.codProcesso!=null &&
              this.codProcesso.equals(other.getCodProcesso()))) &&
            ((this.numMatriculaUsuarioSGAP==null && other.getNumMatriculaUsuarioSGAP()==null) || 
             (this.numMatriculaUsuarioSGAP!=null &&
              this.numMatriculaUsuarioSGAP.equals(other.getNumMatriculaUsuarioSGAP()))) &&
            ((this.siglaTipoConclusaoPCA==null && other.getSiglaTipoConclusaoPCA()==null) || 
             (this.siglaTipoConclusaoPCA!=null &&
              this.siglaTipoConclusaoPCA.equals(other.getSiglaTipoConclusaoPCA()))) &&
            ((this.usuarioPCA==null && other.getUsuarioPCA()==null) || 
             (this.usuarioPCA!=null &&
              this.usuarioPCA.equals(other.getUsuarioPCA())));
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
        if (getArquivos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArquivos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArquivos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodProcesso() != null) {
            _hashCode += getCodProcesso().hashCode();
        }
        if (getNumMatriculaUsuarioSGAP() != null) {
            _hashCode += getNumMatriculaUsuarioSGAP().hashCode();
        }
        if (getSiglaTipoConclusaoPCA() != null) {
            _hashCode += getSiglaTipoConclusaoPCA().hashCode();
        }
        if (getUsuarioPCA() != null) {
            _hashCode += getUsuarioPCA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValidarPCAParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "ValidarPCAParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arquivos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "Arquivos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SGAPArquivoPCA"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SGAPArquivoPCA"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codProcesso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "CodProcesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numMatriculaUsuarioSGAP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "NumMatriculaUsuarioSGAP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaTipoConclusaoPCA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "SiglaTipoConclusaoPCA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuarioPCA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BR.GOV.MG.TCE.SGAP.Service", "UsuarioPCA"));
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
