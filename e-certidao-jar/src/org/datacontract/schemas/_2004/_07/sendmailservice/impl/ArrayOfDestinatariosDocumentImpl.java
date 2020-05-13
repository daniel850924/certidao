/*
 * An XML document type.
 * Localname: ArrayOfDestinatarios
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatariosDocument
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice.impl;
/**
 * A document containing one ArrayOfDestinatarios(@http://schemas.datacontract.org/2004/07/SendMailService) element.
 *
 * This is a complex type.
 */
public class ArrayOfDestinatariosDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatariosDocument
{
    
    public ArrayOfDestinatariosDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARRAYOFDESTINATARIOS$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "ArrayOfDestinatarios");
    
    
    /**
     * Gets the "ArrayOfDestinatarios" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios getArrayOfDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(ARRAYOFDESTINATARIOS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "ArrayOfDestinatarios" element
     */
    public boolean isNilArrayOfDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(ARRAYOFDESTINATARIOS$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "ArrayOfDestinatarios" element
     */
    public void setArrayOfDestinatarios(org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios arrayOfDestinatarios)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(ARRAYOFDESTINATARIOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().add_element_user(ARRAYOFDESTINATARIOS$0);
            }
            target.set(arrayOfDestinatarios);
        }
    }
    
    /**
     * Appends and returns a new empty "ArrayOfDestinatarios" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios addNewArrayOfDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().add_element_user(ARRAYOFDESTINATARIOS$0);
            return target;
        }
    }
    
    /**
     * Nils the "ArrayOfDestinatarios" element
     */
    public void setNilArrayOfDestinatarios()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().find_element_user(ARRAYOFDESTINATARIOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios)get_store().add_element_user(ARRAYOFDESTINATARIOS$0);
            }
            target.setNil();
        }
    }
}
