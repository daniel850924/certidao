/*
 * An XML document type.
 * Localname: ArrayOfAnexos
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexosDocument
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice.impl;
/**
 * A document containing one ArrayOfAnexos(@http://schemas.datacontract.org/2004/07/SendMailService) element.
 *
 * This is a complex type.
 */
public class ArrayOfAnexosDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexosDocument
{
    
    public ArrayOfAnexosDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARRAYOFANEXOS$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "ArrayOfAnexos");
    
    
    /**
     * Gets the "ArrayOfAnexos" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos getArrayOfAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ARRAYOFANEXOS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "ArrayOfAnexos" element
     */
    public boolean isNilArrayOfAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ARRAYOFANEXOS$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "ArrayOfAnexos" element
     */
    public void setArrayOfAnexos(org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos arrayOfAnexos)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ARRAYOFANEXOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().add_element_user(ARRAYOFANEXOS$0);
            }
            target.set(arrayOfAnexos);
        }
    }
    
    /**
     * Appends and returns a new empty "ArrayOfAnexos" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos addNewArrayOfAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().add_element_user(ARRAYOFANEXOS$0);
            return target;
        }
    }
    
    /**
     * Nils the "ArrayOfAnexos" element
     */
    public void setNilArrayOfAnexos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().find_element_user(ARRAYOFANEXOS$0, 0);
            if (target == null)
            {
                target = (org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos)get_store().add_element_user(ARRAYOFANEXOS$0);
            }
            target.setNil();
        }
    }
}
