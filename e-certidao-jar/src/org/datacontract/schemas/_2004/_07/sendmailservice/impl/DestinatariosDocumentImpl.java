/*
 * An XML document type.
 * Localname: Destinatarios
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.DestinatariosDocument
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice.impl;
/**
 * A document containing one Destinatarios(@http://schemas.datacontract.org/2004/07/SendMailService) element.
 *
 * This is a complex type.
 */
public class DestinatariosDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.sendmailservice.DestinatariosDocument
{
    
    public DestinatariosDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DESTINATARIOS$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "Destinatarios");
    
    
    /**
     * Gets the "Destinatarios" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Destinatarios getDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "Destinatarios" element
     */
    public boolean isNilDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "Destinatarios" element
     */
    public void setDestinatarios(org.datacontract.schemas._2004._07.sendmailservice.Destinatarios destinatarios)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().add_element_user(DESTINATARIOS$0);
            }
            target.set(destinatarios);
        }
    }
    
    /**
     * Appends and returns a new empty "Destinatarios" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Destinatarios addNewDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().add_element_user(DESTINATARIOS$0);
            return target;
        }
    }
    
    /**
     * Nils the "Destinatarios" element
     */
    public void setNilDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().add_element_user(DESTINATARIOS$0);
            }
            target.setNil();
        }
    }
}
