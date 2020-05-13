/*
 * An XML document type.
 * Localname: EnviarEmailComAnexo
 * Namespace: http://tempuri.org/
 * Java type: org.tempuri.EnviarEmailComAnexoDocument
 *
 * Automatically generated - do not modify.
 */
package org.tempuri;


/**
 * A document containing one EnviarEmailComAnexo(@http://tempuri.org/) element.
 *
 * This is a complex type.
 */
public interface EnviarEmailComAnexoDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EnviarEmailComAnexoDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("enviaremailcomanexodcb7doctype");
    
    /**
     * Gets the "EnviarEmailComAnexo" element
     */
    org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo getEnviarEmailComAnexo();
    
    /**
     * Sets the "EnviarEmailComAnexo" element
     */
    void setEnviarEmailComAnexo(org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo enviarEmailComAnexo);
    
    /**
     * Appends and returns a new empty "EnviarEmailComAnexo" element
     */
    org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo addNewEnviarEmailComAnexo();
    
    /**
     * An XML EnviarEmailComAnexo(@http://tempuri.org/).
     *
     * This is a complex type.
     */
    public interface EnviarEmailComAnexo extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EnviarEmailComAnexo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("enviaremailcomanexo9200elemtype");
        
        /**
         * Gets the "destinatarios" element
         */
        org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios getDestinatarios();
        
        /**
         * Tests for nil "destinatarios" element
         */
        boolean isNilDestinatarios();
        
        /**
         * True if has "destinatarios" element
         */
        boolean isSetDestinatarios();
        
        /**
         * Sets the "destinatarios" element
         */
        void setDestinatarios(org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios destinatarios);
        
        /**
         * Appends and returns a new empty "destinatarios" element
         */
        org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios addNewDestinatarios();
        
        /**
         * Nils the "destinatarios" element
         */
        void setNilDestinatarios();
        
        /**
         * Unsets the "destinatarios" element
         */
        void unsetDestinatarios();
        
        /**
         * Gets the "assunto" element
         */
        java.lang.String getAssunto();
        
        /**
         * Gets (as xml) the "assunto" element
         */
        org.apache.xmlbeans.XmlString xgetAssunto();
        
        /**
         * Tests for nil "assunto" element
         */
        boolean isNilAssunto();
        
        /**
         * True if has "assunto" element
         */
        boolean isSetAssunto();
        
        /**
         * Sets the "assunto" element
         */
        void setAssunto(java.lang.String assunto);
        
        /**
         * Sets (as xml) the "assunto" element
         */
        void xsetAssunto(org.apache.xmlbeans.XmlString assunto);
        
        /**
         * Nils the "assunto" element
         */
        void setNilAssunto();
        
        /**
         * Unsets the "assunto" element
         */
        void unsetAssunto();
        
        /**
         * Gets the "mensagem" element
         */
        java.lang.String getMensagem();
        
        /**
         * Gets (as xml) the "mensagem" element
         */
        org.apache.xmlbeans.XmlString xgetMensagem();
        
        /**
         * Tests for nil "mensagem" element
         */
        boolean isNilMensagem();
        
        /**
         * True if has "mensagem" element
         */
        boolean isSetMensagem();
        
        /**
         * Sets the "mensagem" element
         */
        void setMensagem(java.lang.String mensagem);
        
        /**
         * Sets (as xml) the "mensagem" element
         */
        void xsetMensagem(org.apache.xmlbeans.XmlString mensagem);
        
        /**
         * Nils the "mensagem" element
         */
        void setNilMensagem();
        
        /**
         * Unsets the "mensagem" element
         */
        void unsetMensagem();
        
        /**
         * Gets the "anexos" element
         */
        org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos getAnexos();
        
        /**
         * Tests for nil "anexos" element
         */
        boolean isNilAnexos();
        
        /**
         * True if has "anexos" element
         */
        boolean isSetAnexos();
        
        /**
         * Sets the "anexos" element
         */
        void setAnexos(org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos anexos);
        
        /**
         * Appends and returns a new empty "anexos" element
         */
        org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos addNewAnexos();
        
        /**
         * Nils the "anexos" element
         */
        void setNilAnexos();
        
        /**
         * Unsets the "anexos" element
         */
        void unsetAnexos();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo newInstance() {
              return (org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.tempuri.EnviarEmailComAnexoDocument newInstance() {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.tempuri.EnviarEmailComAnexoDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.tempuri.EnviarEmailComAnexoDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.tempuri.EnviarEmailComAnexoDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
