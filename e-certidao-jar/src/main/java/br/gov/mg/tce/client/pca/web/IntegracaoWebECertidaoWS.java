
package br.gov.mg.tce.client.pca.web;

import java.util.List;
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
@WebService(name = "IntegracaoWebECertidaoWS", targetNamespace = "http://integracaoweb.ecertidao.tcemg/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IntegracaoWebECertidaoWS {


    /**
     * 
     * @param anoExercicio
     * @param codMunicipio
     * @return
     *     returns br.gov.mg.tce.client.pca.web.AnaliseDTO
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio")
    @ResponseWrapper(localName = "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse")
    public AnaliseDTO buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio(
        @WebParam(name = "codMunicipio", targetNamespace = "")
        Long codMunicipio,
        @WebParam(name = "anoExercicio", targetNamespace = "")
        Long anoExercicio);

    /**
     * 
     * @param codMunicipio
     * @return
     *     returns br.gov.mg.tce.client.pca.web.Municipio
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarMunicipioPorCodMunicipio", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarMunicipioPorCodMunicipio")
    @ResponseWrapper(localName = "buscarMunicipioPorCodMunicipioResponse", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarMunicipioPorCodMunicipioResponse")
    public Municipio buscarMunicipioPorCodMunicipio(
        @WebParam(name = "codMunicipio", targetNamespace = "")
        Integer codMunicipio);

    /**
     * 
     * @return
     *     returns java.util.List<br.gov.mg.tce.client.pca.web.AnaliseDTO>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarAnaliseSemIndiceRelatorDelib", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarAnaliseSemIndiceRelatorDelib")
    @ResponseWrapper(localName = "buscarAnaliseSemIndiceRelatorDelibResponse", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarAnaliseSemIndiceRelatorDelibResponse")
    public List<AnaliseDTO> buscarAnaliseSemIndiceRelatorDelib();

    /**
     * 
     * @param nomeMunicipio
     * @return
     *     returns br.gov.mg.tce.client.pca.web.Municipio
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarMunicipioPorNomeMunicipioMG", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarMunicipioPorNomeMunicipioMG")
    @ResponseWrapper(localName = "buscarMunicipioPorNomeMunicipioMGResponse", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarMunicipioPorNomeMunicipioMGResponse")
    public Municipio buscarMunicipioPorNomeMunicipioMG(
        @WebParam(name = "nomeMunicipio", targetNamespace = "")
        String nomeMunicipio);

    /**
     * 
     * @param anoExercicio
     * @param codMunicipio
     * @return
     *     returns br.gov.mg.tce.client.pca.web.AnaliseDTO
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarAnaliseConsolidadaPorMunicipioExercicio", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarAnaliseConsolidadaPorMunicipioExercicio")
    @ResponseWrapper(localName = "buscarAnaliseConsolidadaPorMunicipioExercicioResponse", targetNamespace = "http://integracaoweb.ecertidao.tcemg/", className = "br.gov.mg.tce.client.pca.web.BuscarAnaliseConsolidadaPorMunicipioExercicioResponse")
    public AnaliseDTO buscarAnaliseConsolidadaPorMunicipioExercicio(
        @WebParam(name = "codMunicipio", targetNamespace = "")
        Long codMunicipio,
        @WebParam(name = "anoExercicio", targetNamespace = "")
        Long anoExercicio)
        throws Exception_Exception
    ;

}