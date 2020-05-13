
package br.gov.mg.tce.client.pca.core;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IntegracaoCoreECertidaoWS", targetNamespace = "http://integracaocore.ecertidao.tcemg/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IntegracaoCoreECertidaoWS {


    /**
     * 
     * @param codIbge
     * @return
     *     returns br.gov.mg.tce.client.pca.core.ValoresDevidos
     */
    @WebMethod(action = "buscarPorMunicipio")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarPorMunicipio", targetNamespace = "http://integracaocore.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.core.BuscarPorMunicipio")
    @ResponseWrapper(localName = "buscarPorMunicipioResponse", targetNamespace = "http://integracaocore.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.core.BuscarPorMunicipioResponse")
    public ValoresDevidos buscarPorMunicipio(
        @WebParam(name = "codIbge", targetNamespace = "")
        Integer codIbge);

    /**
     * 
     * @param consolidado
     * @param codAnalise
     * @return
     *     returns java.lang.Boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "indicesDentroLimite", targetNamespace = "http://integracaocore.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.core.IndicesDentroLimite")
    @ResponseWrapper(localName = "indicesDentroLimiteResponse", targetNamespace = "http://integracaocore.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.core.IndicesDentroLimiteResponse")
    public Boolean indicesDentroLimite(
        @WebParam(name = "codAnalise", targetNamespace = "")
        Long codAnalise,
        @WebParam(name = "consolidado", targetNamespace = "")
        Boolean consolidado)
        throws Exception_Exception
    ;

    /**
     * 
     * @param consolidado
     * @param codAnalise
     * @return
     *     returns br.gov.mg.tce.client.pca.core.IndicesDTO
     * @throws Exception_Exception
     */
    @WebMethod(action = "recuperaIndicePCA")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "recuperaIndicePCA", targetNamespace = "http://integracaocore.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.core.RecuperaIndicePCA")
    @ResponseWrapper(localName = "recuperaIndicePCAResponse", targetNamespace = "http://integracaocore.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.core.RecuperaIndicePCAResponse")
    public IndicesDTO recuperaIndicePCA(
        @WebParam(name = "codAnalise", targetNamespace = "")
        Long codAnalise,
        @WebParam(name = "consolidado", targetNamespace = "")
        Boolean consolidado)
        throws Exception_Exception
    ;

}
