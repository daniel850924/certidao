/**
 * ISendMailService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface ISendMailService extends java.rmi.Remote {
    public java.lang.Boolean enviarEmail(org.datacontract.schemas._2004._07.SendMailService.Destinatarios[] destinatarios, java.lang.String assunto, java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.Boolean enviarEmailComAnexo(org.datacontract.schemas._2004._07.SendMailService.Destinatarios[] destinatarios, java.lang.String assunto, java.lang.String mensagem, org.datacontract.schemas._2004._07.SendMailService.Anexos[] anexos) throws java.rmi.RemoteException;
}
