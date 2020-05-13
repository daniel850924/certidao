/*
 * An XML document type.
 * Localname: EnviarEmailComAnexo
 * Namespace: http://tempuri.org/
 * Java type: org.tempuri.EnviarEmailComAnexoDocument
 *
 * Automatically generated - do not modify.
 */
package org.tempuri.impl;
/**
 * A document containing one EnviarEmailComAnexo(@http://tempuri.org/) element.
 *
 * This is a complex type.
 */
public class EnviarEmailComAnexoDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.tempuri.EnviarEmailComAnexoDocument
{
    
    public EnviarEmailComAnexoDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENVIAREMAILCOMANEXO$0 = 
        new javax.xml.namespace.QName("http://tempuri.org/", "EnviarEmailComAnexo");
    
    
    /**
     * Gets the "EnviarEmailComAnexo" element
     */
    public org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo getEnviarEmailComAnexo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo target = null;
            target = (org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo)get_store().find_element_user(ENVIAREMAILCOMANEXO$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "EnviarEmailComAnexo" element
     */
    public void setEnviarEmailComAnexo(org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo enviarEmailComAnexo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo target = null;
            target = (org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo)get_store().find_element_user(ENVIAREMAILCOMANEXO$0, 0);
            if (target == null)
            {
                target = (org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo)get_store().add_element_user(ENVIAREMAILCOMANEXO$0);
            }
            target.set(enviarEmailComAnexo);
        }
    }
    
    /**
     * Appends and returns a new empty "EnviarEmailComAnexo" element
     */
    public org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo addNewEnviarEmailComAnexo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo target = null;
            target = (org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo)get_store().add_element_user(ENVIAREMAILCOMANEXO$0);
            return target;
        }
    }
    /**
     * An XML EnviarEmailComAnexo(@http://tempuri.org/).
     *
     * This is a complex type.
     */
    public static class EnviarEmailComAnexoImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.tempuri.EnviarEmailComAnexoDocument.EnviarEmailComAnexo
    {
        
        public EnviarEmailComAnexoImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DESTINATARIOS$0 = 
            new javax.xml.namespace.QName("http://tempuri.org/", "destinatarios");
        private static final javax.xml.namespace.QName ASSUNTO$2 = 
            new javax.xml.namespace.QName("http://tempuri.org/", "assunto");
        private static final javax.xml.namespace.QName MENSAGEM$4 = 
            new javax.xml.namespace.QName("http://tempuri.org/", "mensagem");
        private static final javax.xml.namespace.QName ANEXOS$6 = 
            new javax.xml.namespace.QName("http://tempuri.org/", "anexos");
        
        
        /**
         * Gets the "destinatarios" element
         */
        public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios getDestinatarios()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Tests for nil "destinatarios" element
         */
        public boolean isNilDestinatarios()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "destinatarios" element
         */
        public boolean isSetDestinatarios()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DESTINATARIOS$0) != 0;
            }
        }
        
        /**
         * Sets the "destinatarios" element
         */
        public void setDestinatarios(org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios destinatarios)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
                if (target == null)
                {
                    target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().add_element_user(DESTINATARIOS$0);
                }
                target.set(destinatarios);
            }
        }
        
        /**
         * Appends and returns a new empty "destinatarios" element
         */
        public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios addNewDestinatarios()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().add_element_user(DESTINATARIOS$0);
                return target;
            }
        }
        
        /**
         * Nils the "destinatarios" element
         */
        public void setNilDestinatarios()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
                if (target == null)
                {
                    target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().add_element_user(DESTINATARIOS$0);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "destinatarios" element
         */
        public void unsetDestinatarios()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DESTINATARIOS$0, 0);
            }
        }
        
        /**
         * Gets the "assunto" element
         */
        public java.lang.String getAssunto()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSUNTO$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "assunto" element
         */
        public org.apache.xmlbeans.XmlString xgetAssunto()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASSUNTO$2, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "assunto" element
         */
        public boolean isNilAssunto()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASSUNTO$2, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "assunto" element
         */
        public boolean isSetAssunto()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ASSUNTO$2) != 0;
            }
        }
        
        /**
         * Sets the "assunto" element
         */
        public void setAssunto(java.lang.String assunto)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSUNTO$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSUNTO$2);
                }
                target.setStringValue(assunto);
            }
        }
        
        /**
         * Sets (as xml) the "assunto" element
         */
        public void xsetAssunto(org.apache.xmlbeans.XmlString assunto)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASSUNTO$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ASSUNTO$2);
                }
                target.set(assunto);
            }
        }
        
        /**
         * Nils the "assunto" element
         */
        public void setNilAssunto()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASSUNTO$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ASSUNTO$2);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "assunto" element
         */
        public void unsetAssunto()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ASSUNTO$2, 0);
            }
        }
        
        /**
         * Gets the "mensagem" element
         */
        public java.lang.String getMensagem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MENSAGEM$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "mensagem" element
         */
        public org.apache.xmlbeans.XmlString xgetMensagem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MENSAGEM$4, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "mensagem" element
         */
        public boolean isNilMensagem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MENSAGEM$4, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "mensagem" element
         */
        public boolean isSetMensagem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(MENSAGEM$4) != 0;
            }
        }
        
        /**
         * Sets the "mensagem" element
         */
        public void setMensagem(java.lang.String mensagem)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MENSAGEM$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MENSAGEM$4);
                }
                target.setStringValue(mensagem);
            }
        }
        
        /**
         * Sets (as xml) the "mensagem" element
         */
        public void xsetMensagem(org.apache.xmlbeans.XmlString mensagem)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MENSAGEM$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MENSAGEM$4);
                }
                target.set(mensagem);
            }
        }
        
        /**
         * Nils the "mensagem" element
         */
        public void setNilMensagem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MENSAGEM$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MENSAGEM$4);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "mensagem" element
         */
        public void unsetMensagem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(MENSAGEM$4, 0);
            }
        }
        
        /**
         * Gets the "anexos" element
         */
        public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos getAnexos()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ANEXOS$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Tests for nil "anexos" element
         */
        public boolean isNilAnexos()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ANEXOS$6, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "anexos" element
         */
        public boolean isSetAnexos()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ANEXOS$6) != 0;
            }
        }
        
        /**
         * Sets the "anexos" element
         */
        public void setAnexos(org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos anexos)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ANEXOS$6, 0);
                if (target == null)
                {
                    target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().add_element_user(ANEXOS$6);
                }
                target.set(anexos);
            }
        }
        
        /**
         * Appends and returns a new empty "anexos" element
         */
        public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos addNewAnexos()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().add_element_user(ANEXOS$6);
                return target;
            }
        }
        
        /**
         * Nils the "anexos" element
         */
        public void setNilAnexos()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ANEXOS$6, 0);
                if (target == null)
                {
                    target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().add_element_user(ANEXOS$6);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "anexos" element
         */
        public void unsetAnexos()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ANEXOS$6, 0);
            }
        }
    }
}
