/*
 * An XML document type.
 * Localname: EnviarEmailComAnexoResponse
 * Namespace: http://tempuri.org/
 * Java type: org.tempuri.EnviarEmailComAnexoResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.tempuri;


/**
 * A document containing one EnviarEmailComAnexoResponse(@http://tempuri.org/) element.
 *
 * This is a complex type.
 */
public interface EnviarEmailComAnexoResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EnviarEmailComAnexoResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("enviaremailcomanexoresponse1698doctype");
    
    /**
     * Gets the "EnviarEmailComAnexoResponse" element
     */
    org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse getEnviarEmailComAnexoResponse();
    
    /**
     * Sets the "EnviarEmailComAnexoResponse" element
     */
    void setEnviarEmailComAnexoResponse(org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse enviarEmailComAnexoResponse);
    
    /**
     * Appends and returns a new empty "EnviarEmailComAnexoResponse" element
     */
    org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse addNewEnviarEmailComAnexoResponse();
    
    /**
     * An XML EnviarEmailComAnexoResponse(@http://tempuri.org/).
     *
     * This is a complex type.
     */
    public interface EnviarEmailComAnexoResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EnviarEmailComAnexoResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("enviaremailcomanexoresponse1c02elemtype");
        
        /**
         * Gets the "EnviarEmailComAnexoResult" element
         */
        boolean getEnviarEmailComAnexoResult();
        
        /**
         * Gets (as xml) the "EnviarEmailComAnexoResult" element
         */
        org.apache.xmlbeans.XmlBoolean xgetEnviarEmailComAnexoResult();
        
        /**
         * True if has "EnviarEmailComAnexoResult" element
         */
        boolean isSetEnviarEmailComAnexoResult();
        
        /**
         * Sets the "EnviarEmailComAnexoResult" element
         */
        void setEnviarEmailComAnexoResult(boolean enviarEmailComAnexoResult);
        
        /**
         * Sets (as xml) the "EnviarEmailComAnexoResult" element
         */
        void xsetEnviarEmailComAnexoResult(org.apache.xmlbeans.XmlBoolean enviarEmailComAnexoResult);
        
        /**
         * Unsets the "EnviarEmailComAnexoResult" element
         */
        void unsetEnviarEmailComAnexoResult();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse newInstance() {
              return (org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.tempuri.EnviarEmailComAnexoResponseDocument newInstance() {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.tempuri.EnviarEmailComAnexoResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.tempuri.EnviarEmailComAnexoResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
