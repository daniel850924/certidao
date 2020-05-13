/*
 * XML Type:  Anexos
 * Namespace: http://schemas.datacontract.org/2004/07/SendMailService
 * Java type: org.datacontract.schemas._2004._07.sendmailservice.Anexos
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.sendmailservice.impl;
/**
 * An XML Anexos(@http://schemas.datacontract.org/2004/07/SendMailService).
 *
 * This is a complex type.
 */
public class AnexosImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.sendmailservice.Anexos
{
    
    public AnexosImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARQUIVO$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "arquivo");
    private static final javax.xml.namespace.QName NOMEARQUIVO$2 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SendMailService", "nomeArquivo");
    
    
    /**
     * Gets the "arquivo" element
     */
    public byte[] getArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARQUIVO$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getByteArrayValue();
        }
    }
    
    /**
     * Gets (as xml) the "arquivo" element
     */
    public org.apache.xmlbeans.XmlBase64Binary xgetArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_element_user(ARQUIVO$0, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "arquivo" element
     */
    public boolean isNilArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_element_user(ARQUIVO$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "arquivo" element
     */
    public boolean isSetArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARQUIVO$0) != 0;
        }
    }
    
    /**
     * Sets the "arquivo" element
     */
    public void setArquivo(byte[] arquivo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARQUIVO$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARQUIVO$0);
            }
            target.setByteArrayValue(arquivo);
        }
    }
    
    /**
     * Sets (as xml) the "arquivo" element
     */
    public void xsetArquivo(org.apache.xmlbeans.XmlBase64Binary arquivo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_element_user(ARQUIVO$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBase64Binary)get_store().add_element_user(ARQUIVO$0);
            }
            target.set(arquivo);
        }
    }
    
    /**
     * Nils the "arquivo" element
     */
    public void setNilArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_element_user(ARQUIVO$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBase64Binary)get_store().add_element_user(ARQUIVO$0);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "arquivo" element
     */
    public void unsetArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARQUIVO$0, 0);
        }
    }
    
    /**
     * Gets the "nomeArquivo" element
     */
    public java.lang.String getNomeArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMEARQUIVO$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nomeArquivo" element
     */
    public org.apache.xmlbeans.XmlString xgetNomeArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMEARQUIVO$2, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "nomeArquivo" element
     */
    public boolean isNilNomeArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMEARQUIVO$2, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "nomeArquivo" element
     */
    public boolean isSetNomeArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NOMEARQUIVO$2) != 0;
        }
    }
    
    /**
     * Sets the "nomeArquivo" element
     */
    public void setNomeArquivo(java.lang.String nomeArquivo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMEARQUIVO$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NOMEARQUIVO$2);
            }
            target.setStringValue(nomeArquivo);
        }
    }
    
    /**
     * Sets (as xml) the "nomeArquivo" element
     */
    public void xsetNomeArquivo(org.apache.xmlbeans.XmlString nomeArquivo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMEARQUIVO$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NOMEARQUIVO$2);
            }
            target.set(nomeArquivo);
        }
    }
    
    /**
     * Nils the "nomeArquivo" element
     */
    public void setNilNomeArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMEARQUIVO$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NOMEARQUIVO$2);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "nomeArquivo" element
     */
    public void unsetNomeArquivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NOMEARQUIVO$2, 0);
        }
    }
}
