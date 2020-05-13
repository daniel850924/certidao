package org.tempuri;

public class ISgapPcaAnaliseServiceProxy implements org.tempuri.ISgapPcaAnaliseService {
  private String _endpoint = null;
  private org.tempuri.ISgapPcaAnaliseService iSgapPcaAnaliseService = null;
  
  public ISgapPcaAnaliseServiceProxy() {
    _initISgapPcaAnaliseServiceProxy();
  }
  
  public ISgapPcaAnaliseServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initISgapPcaAnaliseServiceProxy();
  }
  
  private void _initISgapPcaAnaliseServiceProxy() {
    try {
      iSgapPcaAnaliseService = (new br.gov.mg.tce.sgap.pcaanaliseservice.SgapPcaAnaliseServiceLocator()).getBasicHttpBinding_ISgapPcaAnaliseService();
      if (iSgapPcaAnaliseService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iSgapPcaAnaliseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iSgapPcaAnaliseService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iSgapPcaAnaliseService != null)
      ((javax.xml.rpc.Stub)iSgapPcaAnaliseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ISgapPcaAnaliseService getISgapPcaAnaliseService() {
    if (iSgapPcaAnaliseService == null)
      _initISgapPcaAnaliseServiceProxy();
    return iSgapPcaAnaliseService;
  }
  
  public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.ValidarPCAResult validarPCA(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.ValidarPCAParameter parameter) throws java.rmi.RemoteException{
    if (iSgapPcaAnaliseService == null)
      _initISgapPcaAnaliseServiceProxy();
    return iSgapPcaAnaliseService.validarPCA(parameter);
  }
  
  public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaResult getDocumentosJuntadosProcessoExecutivoMunicipal(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaParameter documentoJuntadaParameter) throws java.rmi.RemoteException{
    if (iSgapPcaAnaliseService == null)
      _initISgapPcaAnaliseServiceProxy();
    return iSgapPcaAnaliseService.getDocumentosJuntadosProcessoExecutivoMunicipal(documentoJuntadaParameter);
  }
  
  public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.TramitaProcessoResult tramitarProcessoEntreUnidades(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Parameters.TramitaProcessoParameter parameter) throws java.rmi.RemoteException{
    if (iSgapPcaAnaliseService == null)
      _initISgapPcaAnaliseServiceProxy();
    return iSgapPcaAnaliseService.tramitarProcessoEntreUnidades(parameter);
  }
  
  public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioResult obterSituacaoPCAPorMunicipio(java.lang.Long codMunicipio) throws java.rmi.RemoteException{
    if (iSgapPcaAnaliseService == null)
      _initISgapPcaAnaliseServiceProxy();
    return iSgapPcaAnaliseService.obterSituacaoPCAPorMunicipio(codMunicipio);
  }
  
  
}