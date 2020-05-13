package org.tempuri;

public class IWsSgiConsultaPessoaProxy implements org.tempuri.IWsSgiConsultaPessoa {
  private String _endpoint = null;
  private org.tempuri.IWsSgiConsultaPessoa iWsSgiConsultaPessoa = null;
  
  public IWsSgiConsultaPessoaProxy() {
    _initIWsSgiConsultaPessoaProxy();
  }
  
  public IWsSgiConsultaPessoaProxy(String endpoint) {
    _endpoint = endpoint;
    _initIWsSgiConsultaPessoaProxy();
  }
  
  private void _initIWsSgiConsultaPessoaProxy() {
    try {
      iWsSgiConsultaPessoa = (new org.tempuri.WsSgiConsultaPessoaLocator()).getBasicHttpBinding_IWsSgiConsultaPessoa();
      if (iWsSgiConsultaPessoa != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iWsSgiConsultaPessoa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iWsSgiConsultaPessoa)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iWsSgiConsultaPessoa != null)
      ((javax.xml.rpc.Stub)iWsSgiConsultaPessoa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IWsSgiConsultaPessoa getIWsSgiConsultaPessoa() {
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa;
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao consultarUsuarioSistemaOrgao(java.lang.String siglaSistema, java.lang.Long codigoOrgaoEntidade, java.lang.String cpf, java.lang.Boolean somenteAtivo) throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.consultarUsuarioSistemaOrgao(siglaSistema, codigoOrgaoEntidade, cpf, somenteAtivo);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente consultarCpfReponsavelLegalVigente(java.lang.String siglaSistemaSolicitante, java.lang.String cpfResponsavelLegal, java.lang.String nomeCategoriaResponsavel) throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.consultarCpfReponsavelLegalVigente(siglaSistemaSolicitante, cpfResponsavelLegal, nomeCategoriaResponsavel);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal consultarResponsavel(java.lang.String siglaSistemaSolicitante, java.lang.String cpfResponsavelLegal, java.lang.String cnpjOrgao, java.lang.String tipoOrgao, java.lang.String codUnidadeOrcamentaria, java.lang.String tipoCategoriaResponsavel, java.lang.String dataInicio, java.lang.String dataFim) throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.consultarResponsavel(siglaSistemaSolicitante, cpfResponsavelLegal, cnpjOrgao, tipoOrgao, codUnidadeOrcamentaria, tipoCategoriaResponsavel, dataInicio, dataFim);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio consultaJurisdicionadoPorMunic(java.lang.Long codMunicipio) throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.consultaJurisdicionadoPorMunic(codMunicipio);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[] listarLocalidadesMG(java.lang.Boolean somenteMunicipios) throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.listarLocalidadesMG(somenteMunicipios);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus obterInformacoesPessoaFisica() throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.obterInformacoesPessoaFisica();
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus obterInformacoesPessoaJuridica() throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.obterInformacoesPessoaJuridica();
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao consultarResponsavelCodigoOrgao(java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.consultarResponsavelCodigoOrgao(codOrgaoEntidade);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao retornarUsuarioPerfilOrgao(java.lang.String siglaSistema, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException{
    if (iWsSgiConsultaPessoa == null)
      _initIWsSgiConsultaPessoaProxy();
    return iWsSgiConsultaPessoa.retornarUsuarioPerfilOrgao(siglaSistema, codOrgaoEntidade);
  }
  
  
}