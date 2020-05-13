/*
 * XML Type:  ArrayOfAnexos
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice.impl;
/**
 * An XML ArrayOfAnexos(@http://schemas.datacontract.org/2004/07/SendMailService).
 *
 * This is a complex type.
 */
public class ArrayOfAnexosImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.sendmailservice.ArrayOfAnexos
{
    
    public ArrayOfAnexosImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANEXOS$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "Anexos");
    
    
    /**
     * Gets array of all "Anexos" elements
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Anexos[] getAnexosArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANEXOS$0, targetList);
            org.datacontract.schemas._2004._07.sendmailservice.Anexos[] result = new org.datacontract.schemas._2004._07.sendmailservice.Anexos[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Anexos" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Anexos getAnexosArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "Anexos" element
     */
    public boolean isNilAnexosArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "Anexos" element
     */
    public int sizeOfAnexosArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANEXOS$0);
        }
    }
    
    /**
     * Sets array of all "Anexos" element
     */
    public void setAnexosArray(org.datacontract.schemas._2004._07.sendmailservice.Anexos[] anexosArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(anexosArray, ANEXOS$0);
        }
    }
    
    /**
     * Sets ith "Anexos" element
     */
    public void setAnexosArray(int i, org.datacontract.schemas._2004._07.sendmailservice.Anexos anexos)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(anexos);
        }
    }
    
    /**
     * Nils the ith "Anexos" element
     */
    public void setNilAnexosArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().find_element_user(ANEXOS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Anexos" element
     */
    public org.datacontract.schemas._2004._07.sendmailservice.Anexos insertNewAnexos(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.datacontract.schemas._2004._07.sendmailservice.Anexos target = null;
            target = (org.datacontract.schemas._2004._07.sendmailservice.Anexos)get_store().insert_element_user(ANEXOS$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Anexos" element
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
     * Removes the ith "Anexos" element
     */
    public void removeAnexos(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANEXOS$0, i);
        }
    }
}
