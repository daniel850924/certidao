/**
 * IWsSgiConsultaPessoa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IWsSgiConsultaPessoa extends java.rmi.Remote {
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao consultarUsuarioSistemaOrgao(java.lang.String siglaSistema, java.lang.Long codigoOrgaoEntidade, java.lang.String cpf, java.lang.Boolean somenteAtivo) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente consultarCpfReponsavelLegalVigente(java.lang.String siglaSistemaSolicitante, java.lang.String cpfResponsavelLegal, java.lang.String nomeCategoriaResponsavel) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal consultarResponsavel(java.lang.String siglaSistemaSolicitante, java.lang.String cpfResponsavelLegal, java.lang.String cnpjOrgao, java.lang.String tipoOrgao, java.lang.String codUnidadeOrcamentaria, java.lang.String tipoCategoriaResponsavel, java.lang.String dataInicio, java.lang.String dataFim) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio consultaJurisdicionadoPorMunic(java.lang.Long codMunicipio) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[] listarLocalidadesMG(java.lang.Boolean somenteMunicipios) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus obterInformacoesPessoaFisica() throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus obterInformacoesPessoaJuridica() throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao consultarResponsavelCodigoOrgao(java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao retornarUsuarioPerfilOrgao(java.lang.String siglaSistema, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException;
}
