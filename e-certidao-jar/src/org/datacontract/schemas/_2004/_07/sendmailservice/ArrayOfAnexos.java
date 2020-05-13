/*
 * XML Type:  ArrayOfAnexos
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice;


/**
 * An XML ArrayOfAnexos(@http://schemas.datacontract.org/2004/07/SendMailService).
 *
 * This is a complex type.
 */
public interface ArrayOfAnexos extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfAnexos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2ACC8733C8515A4642F7D6915DB69700").resolveHandle("arrayofanexos6a57type");
    
    /**
     * Gets array of all "Anexos" elements
     */
    org.datacontract.schemas._2004._07.sendmailservice.Anexos[] getAnexosArray();
    
    /**
     * Gets ith "Anexos" element
     */
    org.datacontract.schemas._2004._07.sendmailservice.Anexos getAnexosArray(int i);
    
    /**
     * Tests for nil ith "Anexos" element
     */
    boolean isNilAnexosArray(int i);
    
    /**
     * Returns number of "Anexos" element
     */
    int sizeOfAnexosArray();
    
    /**
     * Sets array of all "Anexos" element
     */
    void setAnexosArray(org.datacontract.schemas._2004._07.sendmailservice.Anexos[] anexosArray);
    
    /**
     * Sets ith "Anexos" element
     */
    void setAnexosArray(int i, org.datacontract.schemas._2004._07.sendmailservice.Anexos anexos);
    
    /**
     * Nils the ith "Anexos" element
     */
    void setNilAnexosArray(int i);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Anexos" element
     */
    org.datacontract.schemas._2004._07.sendmailservice.Anexos insertNewAnexos(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Anexos" element
     */
    org.datacontract.schemas._2004._07.sendmailservice.Anexos addNewAnexos();
    
    /**
     * Removes the ith "Anexos" element
     */
    void removeAnexos(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos newInstance() {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
