/*
 * An XML document type.
 * Localname: EnviarEmailComAnexoResponse
 * Namespace: http://tempuri.org/
 * Java type: org.tempuri.EnviarEmailComAnexoResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.tempuri.impl;
/**
 * A document containing one EnviarEmailComAnexoResponse(@http://tempuri.org/) element.
 *
 * This is a complex type.
 */
public class EnviarEmailComAnexoResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.tempuri.EnviarEmailComAnexoResponseDocument
{
    
    public EnviarEmailComAnexoResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENVIAREMAILCOMANEXORESPONSE$0 = 
        new javax.xml.namespace.QName("http://tempuri.org/", "EnviarEmailComAnexoResponse");
    
    
    /**
     * Gets the "EnviarEmailComAnexoResponse" element
     */
    public org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse getEnviarEmailComAnexoResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse target = null;
            target = (org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse)get_store().find_element_user(ENVIAREMAILCOMANEXORESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "EnviarEmailComAnexoResponse" element
     */
    public void setEnviarEmailComAnexoResponse(org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse enviarEmailComAnexoResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse target = null;
            target = (org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse)get_store().find_element_user(ENVIAREMAILCOMANEXORESPONSE$0, 0);
            if (target == null)
            {
                target = (org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse)get_store().add_element_user(ENVIAREMAILCOMANEXORESPONSE$0);
            }
            target.set(enviarEmailComAnexoResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "EnviarEmailComAnexoResponse" element
     */
    public org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse addNewEnviarEmailComAnexoResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse target = null;
            target = (org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse)get_store().add_element_user(ENVIAREMAILCOMANEXORESPONSE$0);
            return target;
        }
    }
    /**
     * An XML EnviarEmailComAnexoResponse(@http://tempuri.org/).
     *
     * This is a complex type.
     */
    public static class EnviarEmailComAnexoResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.tempuri.EnviarEmailComAnexoResponseDocument.EnviarEmailComAnexoResponse
    {
        
        public EnviarEmailComAnexoResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ENVIAREMAILCOMANEXORESULT$0 = 
            new javax.xml.namespace.QName("http://tempuri.org/", "EnviarEmailComAnexoResult");
        
        
        /**
         * Gets the "EnviarEmailComAnexoResult" element
         */
        public boolean getEnviarEmailComAnexoResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENVIAREMAILCOMANEXORESULT$0, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "EnviarEmailComAnexoResult" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetEnviarEmailComAnexoResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENVIAREMAILCOMANEXORESULT$0, 0);
                return target;
            }
        }
        
        /**
         * True if has "EnviarEmailComAnexoResult" element
         */
        public boolean isSetEnviarEmailComAnexoResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ENVIAREMAILCOMANEXORESULT$0) != 0;
            }
        }
        
        /**
         * Sets the "EnviarEmailComAnexoResult" element
         */
        public void setEnviarEmailComAnexoResult(boolean enviarEmailComAnexoResult)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENVIAREMAILCOMANEXORESULT$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENVIAREMAILCOMANEXORESULT$0);
                }
                target.setBooleanValue(enviarEmailComAnexoResult);
            }
        }
        
        /**
         * Sets (as xml) the "EnviarEmailComAnexoResult" element
         */
        public void xsetEnviarEmailComAnexoResult(org.apache.xmlbeans.XmlBoolean enviarEmailComAnexoResult)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENVIAREMAILCOMANEXORESULT$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ENVIAREMAILCOMANEXORESULT$0);
                }
                target.set(enviarEmailComAnexoResult);
            }
        }
        
        /**
         * Unsets the "EnviarEmailComAnexoResult" element
         */
        public void unsetEnviarEmailComAnexoResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ENVIAREMAILCOMANEXORESULT$0, 0);
            }
        }
    }
}
