
package br.gov.mg.tce.client.pca.web;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "IntegracaoWebECertidaoWSService", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", wsdlLocation = "http://panama.tce.mg.gov.br:8080/pca-analise/IntegracaoWebECertidaoWS?wsdl")
public class IntegracaoWebECertidaoWSService
    extends Service
{

    private final static URL INTEGRACAOWEBECERTIDAOWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException INTEGRACAOWEBECERTIDAOWSSERVICE_EXCEPTION;
    private final static QName INTEGRACAOWEBECERTIDAOWSSERVICE_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://panama.tce.mg.gov.br:8080/pca-analise/IntegracaoWebECertidaoWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INTEGRACAOWEBECERTIDAOWSSERVICE_WSDL_LOCATION = url;
        INTEGRACAOWEBECERTIDAOWSSERVICE_EXCEPTION = e;
    }

    public IntegracaoWebECertidaoWSService() {
        super(__getWsdlLocation(), INTEGRACAOWEBECERTIDAOWSSERVICE_QNAME);
    }

    public IntegracaoWebECertidaoWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), INTEGRACAOWEBECERTIDAOWSSERVICE_QNAME, features);
    }

    public IntegracaoWebECertidaoWSService(URL wsdlLocation) {
        super(wsdlLocation, INTEGRACAOWEBECERTIDAOWSSERVICE_QNAME);
    }

    public IntegracaoWebECertidaoWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INTEGRACAOWEBECERTIDAOWSSERVICE_QNAME, features);
    }

    public IntegracaoWebECertidaoWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IntegracaoWebECertidaoWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IntegracaoWebECertidaoWS
     */
    @WebEndpoint(name = "IntegracaoWebECertidaoWSPort")
    public IntegracaoWebECertidaoWS getIntegracaoWebECertidaoWSPort() {
        return super.getPort(new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSPort"), IntegracaoWebECertidaoWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IntegracaoWebECertidaoWS
     */
    @WebEndpoint(name = "IntegracaoWebECertidaoWSPort")
    public IntegracaoWebECertidaoWS getIntegracaoWebECertidaoWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSPort"), IntegracaoWebECertidaoWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INTEGRACAOWEBECERTIDAOWSSERVICE_EXCEPTION!= null) {
            throw INTEGRACAOWEBECERTIDAOWSSERVICE_EXCEPTION;
        }
        return INTEGRACAOWEBECERTIDAOWSSERVICE_WSDL_LOCATION;
    }

}
