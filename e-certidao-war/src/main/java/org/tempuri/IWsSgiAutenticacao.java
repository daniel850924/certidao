/**
 * IWsSgiAutenticacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IWsSgiAutenticacao extends java.rmi.Remote {
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseAutenticar autenticar(java.lang.String siglaSistemaSolicitante, java.lang.String cpfUsuario, java.lang.String senhaMD5, java.lang.String senhaSHA1, java.lang.Long codigoOrgao) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCnpj consultarOrgaoCNPJ(java.lang.String siglaSistemaSolicitante, java.lang.String cnpjOrgaoEntidade, java.lang.String denominacaoOrgao) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCodigo consultarOrgaoCodigo(java.lang.String siglaSistemaSolcitante, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCadastroporCNPJ consultarOrgaoCadastroporCNPJ(java.lang.String siglaSistemaSolcitante, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrigemOrgaoEntidade consultarOrigemOrgaoEntidade(java.lang.String siglaSistemaSolicitante, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseAutenticarUsuario autenticarUsuarioCNPJ(java.lang.String siglaSistemaSolicitante, java.lang.String cpf, java.lang.String cnpj, java.lang.String senha) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRetornarUsuarioPerfilOrgao autenticarUsuarioOrgaos(java.lang.String siglaSistemaSolicitante, java.lang.String cpf, java.lang.String senhaMD5) throws java.rmi.RemoteException;
}
