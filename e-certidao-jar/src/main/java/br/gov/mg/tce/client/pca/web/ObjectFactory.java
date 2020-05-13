
package br.gov.mg.tce.client.pca.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.mg.tce.client.pca.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarAnaliseConsolidadaPorMunicipioExercicio_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarAnaliseConsolidadaPorMunicipioExercicio");
    private final static QName _BuscarMunicipioPorNomeMunicipioMG_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarMunicipioPorNomeMunicipioMG");
    private final static QName _BuscarAnaliseSemIndiceRelatorDelib_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarAnaliseSemIndiceRelatorDelib");
    private final static QName _IndiceInvPrePca_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "indiceInvPrePca");
    private final static QName _Municipio_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "municipio");
    private final static QName _BuscarAnaliseSemIndiceRelatorDelibResponse_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarAnaliseSemIndiceRelatorDelibResponse");
    private final static QName _BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio");
    private final static QName _IndiceParecerPrevio_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "indiceParecerPrevio");
    private final static QName _BuscarMunicipioPorCodMunicipioResponse_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarMunicipioPorCodMunicipioResponse");
    private final static QName _IndiceDelibInv_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "indiceDelibInv");
    private final static QName _BuscarMunicipioPorCodMunicipio_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarMunicipioPorCodMunicipio");
    private final static QName _BuscarMunicipioPorNomeMunicipioMGResponse_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarMunicipioPorNomeMunicipioMGResponse");
    private final static QName _IndiceObservacao_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "indiceObservacao");
    private final static QName _BuscarAnaliseConsolidadaPorMunicipioExercicioResponse_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarAnaliseConsolidadaPorMunicipioExercicioResponse");
    private final static QName _BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse");
    private final static QName _IndiceSubstituta_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "indiceSubstituta");
    private final static QName _Exception_QNAME = new QName("http://integracaoweb.ecertidao.tcemg/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.mg.tce.client.pca.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link IndiceSubstituta }
     * 
     */
    public IndiceSubstituta createIndiceSubstituta() {
        return new IndiceSubstituta();
    }

    /**
     * Create an instance of {@link BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse }
     * 
     */
    public BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse createBuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse() {
        return new BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse();
    }

    /**
     * Create an instance of {@link BuscarAnaliseConsolidadaPorMunicipioExercicioResponse }
     * 
     */
    public BuscarAnaliseConsolidadaPorMunicipioExercicioResponse createBuscarAnaliseConsolidadaPorMunicipioExercicioResponse() {
        return new BuscarAnaliseConsolidadaPorMunicipioExercicioResponse();
    }

    /**
     * Create an instance of {@link IndiceObservacao }
     * 
     */
    public IndiceObservacao createIndiceObservacao() {
        return new IndiceObservacao();
    }

    /**
     * Create an instance of {@link BuscarMunicipioPorNomeMunicipioMGResponse }
     * 
     */
    public BuscarMunicipioPorNomeMunicipioMGResponse createBuscarMunicipioPorNomeMunicipioMGResponse() {
        return new BuscarMunicipioPorNomeMunicipioMGResponse();
    }

    /**
     * Create an instance of {@link IndiceParecerPrevio }
     * 
     */
    public IndiceParecerPrevio createIndiceParecerPrevio() {
        return new IndiceParecerPrevio();
    }

    /**
     * Create an instance of {@link BuscarMunicipioPorCodMunicipioResponse }
     * 
     */
    public BuscarMunicipioPorCodMunicipioResponse createBuscarMunicipioPorCodMunicipioResponse() {
        return new BuscarMunicipioPorCodMunicipioResponse();
    }

    /**
     * Create an instance of {@link BuscarMunicipioPorCodMunicipio }
     * 
     */
    public BuscarMunicipioPorCodMunicipio createBuscarMunicipioPorCodMunicipio() {
        return new BuscarMunicipioPorCodMunicipio();
    }

    /**
     * Create an instance of {@link IndiceDelibInv }
     * 
     */
    public IndiceDelibInv createIndiceDelibInv() {
        return new IndiceDelibInv();
    }

    /**
     * Create an instance of {@link Municipio }
     * 
     */
    public Municipio createMunicipio() {
        return new Municipio();
    }

    /**
     * Create an instance of {@link BuscarAnaliseSemIndiceRelatorDelibResponse }
     * 
     */
    public BuscarAnaliseSemIndiceRelatorDelibResponse createBuscarAnaliseSemIndiceRelatorDelibResponse() {
        return new BuscarAnaliseSemIndiceRelatorDelibResponse();
    }

    /**
     * Create an instance of {@link IndiceInvPrePca }
     * 
     */
    public IndiceInvPrePca createIndiceInvPrePca() {
        return new IndiceInvPrePca();
    }

    /**
     * Create an instance of {@link BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio }
     * 
     */
    public BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio createBuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio() {
        return new BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio();
    }

    /**
     * Create an instance of {@link BuscarAnaliseSemIndiceRelatorDelib }
     * 
     */
    public BuscarAnaliseSemIndiceRelatorDelib createBuscarAnaliseSemIndiceRelatorDelib() {
        return new BuscarAnaliseSemIndiceRelatorDelib();
    }

    /**
     * Create an instance of {@link BuscarMunicipioPorNomeMunicipioMG }
     * 
     */
    public BuscarMunicipioPorNomeMunicipioMG createBuscarMunicipioPorNomeMunicipioMG() {
        return new BuscarMunicipioPorNomeMunicipioMG();
    }

    /**
     * Create an instance of {@link BuscarAnaliseConsolidadaPorMunicipioExercicio }
     * 
     */
    public BuscarAnaliseConsolidadaPorMunicipioExercicio createBuscarAnaliseConsolidadaPorMunicipioExercicio() {
        return new BuscarAnaliseConsolidadaPorMunicipioExercicio();
    }

    /**
     * Create an instance of {@link AnaliseDTO }
     * 
     */
    public AnaliseDTO createAnaliseDTO() {
        return new AnaliseDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarAnaliseConsolidadaPorMunicipioExercicio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarAnaliseConsolidadaPorMunicipioExercicio")
    public JAXBElement<BuscarAnaliseConsolidadaPorMunicipioExercicio> createBuscarAnaliseConsolidadaPorMunicipioExercicio(BuscarAnaliseConsolidadaPorMunicipioExercicio value) {
        return new JAXBElement<BuscarAnaliseConsolidadaPorMunicipioExercicio>(_BuscarAnaliseConsolidadaPorMunicipioExercicio_QNAME, BuscarAnaliseConsolidadaPorMunicipioExercicio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMunicipioPorNomeMunicipioMG }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarMunicipioPorNomeMunicipioMG")
    public JAXBElement<BuscarMunicipioPorNomeMunicipioMG> createBuscarMunicipioPorNomeMunicipioMG(BuscarMunicipioPorNomeMunicipioMG value) {
        return new JAXBElement<BuscarMunicipioPorNomeMunicipioMG>(_BuscarMunicipioPorNomeMunicipioMG_QNAME, BuscarMunicipioPorNomeMunicipioMG.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarAnaliseSemIndiceRelatorDelib }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarAnaliseSemIndiceRelatorDelib")
    public JAXBElement<BuscarAnaliseSemIndiceRelatorDelib> createBuscarAnaliseSemIndiceRelatorDelib(BuscarAnaliseSemIndiceRelatorDelib value) {
        return new JAXBElement<BuscarAnaliseSemIndiceRelatorDelib>(_BuscarAnaliseSemIndiceRelatorDelib_QNAME, BuscarAnaliseSemIndiceRelatorDelib.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndiceInvPrePca }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "indiceInvPrePca")
    public JAXBElement<IndiceInvPrePca> createIndiceInvPrePca(IndiceInvPrePca value) {
        return new JAXBElement<IndiceInvPrePca>(_IndiceInvPrePca_QNAME, IndiceInvPrePca.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Municipio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "municipio")
    public JAXBElement<Municipio> createMunicipio(Municipio value) {
        return new JAXBElement<Municipio>(_Municipio_QNAME, Municipio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarAnaliseSemIndiceRelatorDelibResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarAnaliseSemIndiceRelatorDelibResponse")
    public JAXBElement<BuscarAnaliseSemIndiceRelatorDelibResponse> createBuscarAnaliseSemIndiceRelatorDelibResponse(BuscarAnaliseSemIndiceRelatorDelibResponse value) {
        return new JAXBElement<BuscarAnaliseSemIndiceRelatorDelibResponse>(_BuscarAnaliseSemIndiceRelatorDelibResponse_QNAME, BuscarAnaliseSemIndiceRelatorDelibResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio")
    public JAXBElement<BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio> createBuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio(BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio value) {
        return new JAXBElement<BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio>(_BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio_QNAME, BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndiceParecerPrevio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "indiceParecerPrevio")
    public JAXBElement<IndiceParecerPrevio> createIndiceParecerPrevio(IndiceParecerPrevio value) {
        return new JAXBElement<IndiceParecerPrevio>(_IndiceParecerPrevio_QNAME, IndiceParecerPrevio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMunicipioPorCodMunicipioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarMunicipioPorCodMunicipioResponse")
    public JAXBElement<BuscarMunicipioPorCodMunicipioResponse> createBuscarMunicipioPorCodMunicipioResponse(BuscarMunicipioPorCodMunicipioResponse value) {
        return new JAXBElement<BuscarMunicipioPorCodMunicipioResponse>(_BuscarMunicipioPorCodMunicipioResponse_QNAME, BuscarMunicipioPorCodMunicipioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndiceDelibInv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "indiceDelibInv")
    public JAXBElement<IndiceDelibInv> createIndiceDelibInv(IndiceDelibInv value) {
        return new JAXBElement<IndiceDelibInv>(_IndiceDelibInv_QNAME, IndiceDelibInv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMunicipioPorCodMunicipio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarMunicipioPorCodMunicipio")
    public JAXBElement<BuscarMunicipioPorCodMunicipio> createBuscarMunicipioPorCodMunicipio(BuscarMunicipioPorCodMunicipio value) {
        return new JAXBElement<BuscarMunicipioPorCodMunicipio>(_BuscarMunicipioPorCodMunicipio_QNAME, BuscarMunicipioPorCodMunicipio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMunicipioPorNomeMunicipioMGResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarMunicipioPorNomeMunicipioMGResponse")
    public JAXBElement<BuscarMunicipioPorNomeMunicipioMGResponse> createBuscarMunicipioPorNomeMunicipioMGResponse(BuscarMunicipioPorNomeMunicipioMGResponse value) {
        return new JAXBElement<BuscarMunicipioPorNomeMunicipioMGResponse>(_BuscarMunicipioPorNomeMunicipioMGResponse_QNAME, BuscarMunicipioPorNomeMunicipioMGResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndiceObservacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "indiceObservacao")
    public JAXBElement<IndiceObservacao> createIndiceObservacao(IndiceObservacao value) {
        return new JAXBElement<IndiceObservacao>(_IndiceObservacao_QNAME, IndiceObservacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarAnaliseConsolidadaPorMunicipioExercicioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarAnaliseConsolidadaPorMunicipioExercicioResponse")
    public JAXBElement<BuscarAnaliseConsolidadaPorMunicipioExercicioResponse> createBuscarAnaliseConsolidadaPorMunicipioExercicioResponse(BuscarAnaliseConsolidadaPorMunicipioExercicioResponse value) {
        return new JAXBElement<BuscarAnaliseConsolidadaPorMunicipioExercicioResponse>(_BuscarAnaliseConsolidadaPorMunicipioExercicioResponse_QNAME, BuscarAnaliseConsolidadaPorMunicipioExercicioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse")
    public JAXBElement<BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse> createBuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse(BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse value) {
        return new JAXBElement<BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse>(_BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse_QNAME, BuscarUltimaAnaliseDefesaValidadaPorMunicipioExercicioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndiceSubstituta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "indiceSubstituta")
    public JAXBElement<IndiceSubstituta> createIndiceSubstituta(IndiceSubstituta value) {
        return new JAXBElement<IndiceSubstituta>(_IndiceSubstituta_QNAME, IndiceSubstituta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaoweb.ecertidao.tcemg/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
