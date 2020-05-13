/*
 * XML Type:  ArrayOfDestinatarios
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice.impl;
/**
 * An XML ArrayOfDestinatarios(@http://schemas.datacontract.org/2004/07/SendMailService).
 *
 * This is a complex type.
 */
public class ArrayOfDestinatariosImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.sendmailservice.ArrayOfDestinatarios
{
    
    public ArrayOfDestinatariosImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DESTINATARIOS$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "Destinatarios");
    
    
    /**
     * Gets array of all "Destinatarios" elements
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Destinatarios[] getDestinatariosArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DESTINATARIOS$0, targetList);
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios[] result = new org.datacontract.schemas._2004._07.sendmailservice.Destinatarios[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Destinatarios" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Destinatarios getDestinatariosArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "Destinatarios" element
     */
    public boolean isNilDestinatariosArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "Destinatarios" element
     */
    public int sizeOfDestinatariosArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DESTINATARIOS$0);
        }
    }
    
    /**
     * Sets array of all "Destinatarios" element
     */
    public void setDestinatariosArray(org.datacontract.schemas._2004._07.sendmailservice.Destinatarios[] destinatariosArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(destinatariosArray, DESTINATARIOS$0);
        }
    }
    
    /**
     * Sets ith "Destinatarios" element
     */
    public void setDestinatariosArray(int i, org.datacontract.schemas._2004._07.sendmailservice.Destinatarios destinatarios)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(destinatarios);
        }
    }
    
    /**
     * Nils the ith "Destinatarios" element
     */
    public void setNilDestinatariosArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().find_element_user(DESTINATARIOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Destinatarios" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Destinatarios insertNewDestinatarios(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Destinatarios target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Destinatarios)get_store().insert_element_user(DESTINATARIOS$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Destinatarios" element
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
     * Removes the ith "Destinatarios" element
     */
    public void removeDestinatarios(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DESTINATARIOS$0, i);
        }
    }
}
