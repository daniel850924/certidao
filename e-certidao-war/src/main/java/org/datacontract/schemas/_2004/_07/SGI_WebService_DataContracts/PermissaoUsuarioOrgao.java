/**
 * PermissaoUsuarioOrgao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.SGI_WebService_DataContracts;

public class PermissaoUsuarioOrgao  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] listaPerfilUsuario;

    private org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade orgaoEntidade;

    public PermissaoUsuarioOrgao() {
    }

    public PermissaoUsuarioOrgao(
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] listaPerfilUsuario,
           org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade orgaoEntidade) {
           this.listaPerfilUsuario = listaPerfilUsuario;
           this.orgaoEntidade = orgaoEntidade;
    }


    /**
     * Gets the listaPerfilUsuario value for this PermissaoUsuarioOrgao.
     * 
     * @return listaPerfilUsuario
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] getListaPerfilUsuario() {
        return listaPerfilUsuario;
    }


    /**
     * Sets the listaPerfilUsuario value for this PermissaoUsuarioOrgao.
     * 
     * @param listaPerfilUsuario
     */
    public void setListaPerfilUsuario(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[] listaPerfilUsuario) {
        this.listaPerfilUsuario = listaPerfilUsuario;
    }


    /**
     * Gets the orgaoEntidade value for this PermissaoUsuarioOrgao.
     * 
     * @return orgaoEntidade
     */
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade getOrgaoEntidade() {
        return orgaoEntidade;
    }


    /**
     * Sets the orgaoEntidade value for this PermissaoUsuarioOrgao.
     * 
     * @param orgaoEntidade
     */
    public void setOrgaoEntidade(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade orgaoEntidade) {
        this.orgaoEntidade = orgaoEntidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PermissaoUsuarioOrgao)) return false;
        PermissaoUsuarioOrgao other = (PermissaoUsuarioOrgao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaPerfilUsuario==null && other.getListaPerfilUsuario()==null) || 
             (this.listaPerfilUsuario!=null &&
              java.util.Arrays.equals(this.listaPerfilUsuario, other.getListaPerfilUsuario()))) &&
            ((this.orgaoEntidade==null && other.getOrgaoEntidade()==null) || 
             (this.orgaoEntidade!=null &&
              this.orgaoEntidade.equals(other.getOrgaoEntidade())));
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
        if (getListaPerfilUsuario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPerfilUsuario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPerfilUsuario(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrgaoEntidade() != null) {
            _hashCode += getOrgaoEntidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PermissaoUsuarioOrgao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PermissaoUsuarioOrgao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPerfilUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ListaPerfilUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgaoEntidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoEntidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoEntidade"));
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
