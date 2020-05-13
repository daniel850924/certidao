package org.tempuri;

public class IWsSgiAutenticacaoProxy implements org.tempuri.IWsSgiAutenticacao {
  private String _endpoint = null;
  private org.tempuri.IWsSgiAutenticacao iWsSgiAutenticacao = null;
  
  public IWsSgiAutenticacaoProxy() {
    _initIWsSgiAutenticacaoProxy();
  }
  
  public IWsSgiAutenticacaoProxy(String endpoint) {
    _endpoint = endpoint;
    _initIWsSgiAutenticacaoProxy();
  }
  
  private void _initIWsSgiAutenticacaoProxy() {
    try {
      iWsSgiAutenticacao = (new org.tempuri.WsSgiAutenticacaoLocator()).getBasicHttpBinding_IWsSgiAutenticacao();
      if (iWsSgiAutenticacao != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iWsSgiAutenticacao)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iWsSgiAutenticacao)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iWsSgiAutenticacao != null)
      ((javax.xml.rpc.Stub)iWsSgiAutenticacao)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IWsSgiAutenticacao getIWsSgiAutenticacao() {
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao;
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseAutenticar autenticar(java.lang.String siglaSistemaSolicitante, java.lang.String cpfUsuario, java.lang.String senhaMD5, java.lang.String senhaSHA1, java.lang.Long codigoOrgao) throws java.rmi.RemoteException{
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao.autenticar(siglaSistemaSolicitante, cpfUsuario, senhaMD5, senhaSHA1, codigoOrgao);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCnpj consultarOrgaoCNPJ(java.lang.String siglaSistemaSolicitante, java.lang.String cnpjOrgaoEntidade, java.lang.String denominacaoOrgao) throws java.rmi.RemoteException{
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao.consultarOrgaoCNPJ(siglaSistemaSolicitante, cnpjOrgaoEntidade, denominacaoOrgao);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCodigo consultarOrgaoCodigo(java.lang.String siglaSistemaSolcitante, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException{
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao.consultarOrgaoCodigo(siglaSistemaSolcitante, codOrgaoEntidade);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCadastroporCNPJ consultarOrgaoCadastroporCNPJ(java.lang.String siglaSistemaSolcitante, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException{
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao.consultarOrgaoCadastroporCNPJ(siglaSistemaSolcitante, codOrgaoEntidade);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrigemOrgaoEntidade consultarOrigemOrgaoEntidade(java.lang.String siglaSistemaSolicitante, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException{
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao.consultarOrigemOrgaoEntidade(siglaSistemaSolicitante, codOrgaoEntidade);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseAutenticarUsuario autenticarUsuarioCNPJ(java.lang.String siglaSistemaSolicitante, java.lang.String cpf, java.lang.String cnpj, java.lang.String senha) throws java.rmi.RemoteException{
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao.autenticarUsuarioCNPJ(siglaSistemaSolicitante, cpf, cnpj, senha);
  }
  
  public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRetornarUsuarioPerfilOrgao autenticarUsuarioOrgaos(java.lang.String siglaSistemaSolicitante, java.lang.String cpf, java.lang.String senhaMD5) throws java.rmi.RemoteException{
    if (iWsSgiAutenticacao == null)
      _initIWsSgiAutenticacaoProxy();
    return iWsSgiAutenticacao.autenticarUsuarioOrgaos(siglaSistemaSolicitante, cpf, senhaMD5);
  }
  
  
}