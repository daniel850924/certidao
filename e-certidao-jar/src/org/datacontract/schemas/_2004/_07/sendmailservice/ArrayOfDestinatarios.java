/*
 * XML Type:  ArrayOfDestinatarios
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice;


/**
 * An XML ArrayOfDestinatarios(@http://schemas.datacontract.org/2004/07/SendMailService).
 *
 * This is a complex type.
 */
public interface ArrayOfDestinatarios extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfDestinatarios.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("arrayofdestinatarios1527type");
    
    /**
     * Gets array of all "Destinatarios" elements
     */
    org.datacontract.schemas._2004._07.sendmailservice.Destinatarios[] getDestinatariosArray();
    
    /**
     * Gets ith "Destinatarios" element
     */
    org.datacontract.schemas._2004._07.sendmailservice.Destinatarios getDestinatariosArray(int i);
    
    /**
     * Tests for nil ith "Destinatarios" element
     */
    boolean isNilDestinatariosArray(int i);
    
    /**
     * Returns number of "Destinatarios" element
     */
    int sizeOfDestinatariosArray();
    
    /**
     * Sets array of all "Destinatarios" element
     */
    void setDestinatariosArray(org.datacontract.schemas._2004._07.sendmailservice.Destinatarios[] destinatariosArray);
    
    /**
     * Sets ith "Destinatarios" element
     */
    void setDestinatariosArray(int i, org.datacontract.schemas._2004._07.sendmailservice.Destinatarios destinatarios);
    
    /**
     * Nils the ith "Destinatarios" element
     */
    void setNilDestinatariosArray(int i);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Destinatarios" element
     */
    org.datacontract.schemas._2004._07.sendmailservice.Destinatarios insertNewDestinatarios(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Destinatarios" element
     */
    org.datacontract.schemas._2004._07.sendmailservice.Destinatarios addNewDestinatarios();
    
    /**
     * Removes the ith "Destinatarios" element
     */
    void removeDestinatarios(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios newInstance() {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
