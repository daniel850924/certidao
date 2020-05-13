/*
 * An XML document type.
 * Localname: Anexos
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.AnexosDocument
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice.impl;
/**
 * A document containing one Anexos(@http://schemas.datacontract.org/2004/07/SendMailService) element.
 *
 * This is a complex type.
 */
public class AnexosDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.sendmailservice.AnexosDocument
{
    
    public AnexosDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANEXOS$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "Anexos");
    
    
    /**
     * Gets the "Anexos" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Anexos getAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "Anexos" element
     */
    public boolean isNilAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "Anexos" element
     */
    public void setAnexos(org.datacontract.schemas._2004._07.sendmailservice.Anexos anexos)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().add_element_user(ANEXOS$0);
            }
            target.set(anexos);
        }
    }
    
    /**
     * Appends and returns a new empty "Anexos" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Anexos addNewAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().add_element_user(ANEXOS$0);
            return target;
        }
    }
    
    /**
     * Nils the "Anexos" element
     */
    public void setNilAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().add_element_user(ANEXOS$0);
            }
            target.setNil();
        }
    }
}
