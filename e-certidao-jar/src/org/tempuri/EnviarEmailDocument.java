/*
 * An XML document type.
 * Localname: EnviarEmail
 * Namespace: http://tempuri.org/
 * Java type: org.tempuri.EnviarEmailDocument
 *
 * Automatically generated - do not modify.
 */
package org.tempuri;


/**
 * A document containing one EnviarEmail(@http://tempuri.org/) element.
 *
 * This is a complex type.
 */
public interface EnviarEmailDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EnviarEmailDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("enviaremail67c9doctype");
    
    /**
     * Gets the "EnviarEmail" element
     */
    org.tempuri.EnviarEmailDocument.EnviarEmail getEnviarEmail();
    
    /**
     * Sets the "EnviarEmail" element
     */
    void setEnviarEmail(org.tempuri.EnviarEmailDocument.EnviarEmail enviarEmail);
    
    /**
     * Appends and returns a new empty "EnviarEmail" element
     */
    org.tempuri.EnviarEmailDocument.EnviarEmail addNewEnviarEmail();
    
    /**
     * An XML EnviarEmail(@http://tempuri.org/).
     *
     * This is a complex type.
     */
    public interface EnviarEmail extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EnviarEmail.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("enviaremail0aa4elemtype");
        
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
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.tempuri.EnviarEmailDocument.EnviarEmail newInstance() {
              return (org.tempuri.EnviarEmailDocument.EnviarEmail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.tempuri.EnviarEmailDocument.EnviarEmail newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.tempuri.EnviarEmailDocument.EnviarEmail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.tempuri.EnviarEmailDocument newInstance() {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.tempuri.EnviarEmailDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.tempuri.EnviarEmailDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.tempuri.EnviarEmailDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.tempuri.EnviarEmailDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.tempuri.EnviarEmailDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.tempuri.EnviarEmailDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.tempuri.EnviarEmailDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.tempuri.EnviarEmailDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.tempuri.EnviarEmailDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.tempuri.EnviarEmailDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.tempuri.EnviarEmailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
