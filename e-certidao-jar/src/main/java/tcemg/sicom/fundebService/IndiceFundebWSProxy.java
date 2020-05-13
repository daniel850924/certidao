package tcemg.sicom.fundebService;

public class IndiceFundebWSProxy implements tcemg.sicom.fundebService.IndiceFundebWS {
  private String _endpoint = null;
  private tcemg.sicom.fundebService.IndiceFundebWS indiceFundebWS = null;
  
  public IndiceFundebWSProxy() {
    _initIndiceFundebWSProxy();
  }
  
  public IndiceFundebWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initIndiceFundebWSProxy();
  }
  
  private void _initIndiceFundebWSProxy() {
    try {
      indiceFundebWS = (new tcemg.sicom.fundebService.IndiceFundebWSServiceLocator()).getIndiceFundebWSPort();
      if (indiceFundebWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)indiceFundebWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)indiceFundebWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (indiceFundebWS != null)
      ((javax.xml.rpc.Stub)indiceFundebWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tcemg.sicom.fundebService.IndiceFundebWS getIndiceFundebWS() {
    if (indiceFundebWS == null)
      _initIndiceFundebWSProxy();
    return indiceFundebWS;
  }
  
  public java.lang.String buscarIndiceFundeb(java.lang.String codMunicipio, java.lang.String anoExercicio, java.lang.Long codAnalise) throws java.rmi.RemoteException{
    if (indiceFundebWS == null)
      _initIndiceFundebWSProxy();
    return indiceFundebWS.buscarIndiceFundeb(codMunicipio, anoExercicio, codAnalise);
  }
  
  
}