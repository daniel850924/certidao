/*
 * An XML document type.
 * Localname: EnviarEmailResponse
 * Namespace: http://tempuri.org/
 * Java type: org.tempuri.EnviarEmailResponseDocument
 *
 * Automatically generated - do not modify.
 */
package org.tempuri.impl;
/**
 * A document containing one EnviarEmailResponse(@http://tempuri.org/) element.
 *
 * This is a complex type.
 */
public class EnviarEmailResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.tempuri.EnviarEmailResponseDocument
{
    
    public EnviarEmailResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENVIAREMAILRESPONSE$0 = 
        new javax.xml.namespace.QName("http://tempuri.org/", "EnviarEmailResponse");
    
    
    /**
     * Gets the "EnviarEmailResponse" element
     */
    public org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse getEnviarEmailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse target = null;
            target = (org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse)get_store().find_element_user(ENVIAREMAILRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "EnviarEmailResponse" element
     */
    public void setEnviarEmailResponse(org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse enviarEmailResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse target = null;
            target = (org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse)get_store().find_element_user(ENVIAREMAILRESPONSE$0, 0);
            if (target == null)
            {
                target = (org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse)get_store().add_element_user(ENVIAREMAILRESPONSE$0);
            }
            target.set(enviarEmailResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "EnviarEmailResponse" element
     */
    public org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse addNewEnviarEmailResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse target = null;
            target = (org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse)get_store().add_element_user(ENVIAREMAILRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML EnviarEmailResponse(@http://tempuri.org/).
     *
     * This is a complex type.
     */
    public static class EnviarEmailResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.tempuri.EnviarEmailResponseDocument.EnviarEmailResponse
    {
        
        public EnviarEmailResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ENVIAREMAILRESULT$0 = 
            new javax.xml.namespace.QName("http://tempuri.org/", "EnviarEmailResult");
        
        
        /**
         * Gets the "EnviarEmailResult" element
         */
        public boolean getEnviarEmailResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENVIAREMAILRESULT$0, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "EnviarEmailResult" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetEnviarEmailResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENVIAREMAILRESULT$0, 0);
                return target;
            }
        }
        
        /**
         * True if has "EnviarEmailResult" element
         */
        public boolean isSetEnviarEmailResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ENVIAREMAILRESULT$0) != 0;
            }
        }
        
        /**
         * Sets the "EnviarEmailResult" element
         */
        public void setEnviarEmailResult(boolean enviarEmailResult)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENVIAREMAILRESULT$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENVIAREMAILRESULT$0);
                }
                target.setBooleanValue(enviarEmailResult);
            }
        }
        
        /**
         * Sets (as xml) the "EnviarEmailResult" element
         */
        public void xsetEnviarEmailResult(org.apache.xmlbeans.XmlBoolean enviarEmailResult)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENVIAREMAILRESULT$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ENVIAREMAILRESULT$0);
                }
                target.set(enviarEmailResult);
            }
        }
        
        /**
         * Unsets the "EnviarEmailResult" element
         */
        public void unsetEnviarEmailResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ENVIAREMAILRESULT$0, 0);
            }
        }
    }
}
