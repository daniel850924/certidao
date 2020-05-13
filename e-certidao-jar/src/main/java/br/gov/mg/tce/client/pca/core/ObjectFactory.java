
package br.gov.mg.tce.client.pca.core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.mg.tce.client.pca.core package. 
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

    private final static QName _BuscarPorMunicipio_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "buscarPorMunicipio");
    private final static QName _IndicesDentroLimite_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "indicesDentroLimite");
    private final static QName _RecuperaIndicePCAResponse_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "recuperaIndicePCAResponse");
    private final static QName _ValoresDevidos_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "valoresDevidos");
    private final static QName _BuscarPorMunicipioResponse_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "buscarPorMunicipioResponse");
    private final static QName _Exception_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "Exception");
    private final static QName _RecuperaIndicePCA_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "recuperaIndicePCA");
    private final static QName _IndicesDentroLimiteResponse_QNAME = new QName("http://integracaocore.ecertidao.tcemg/", "indicesDentroLimiteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.mg.tce.client.pca.core
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
     * Create an instance of {@link IndicesDentroLimiteResponse }
     * 
     */
    public IndicesDentroLimiteResponse createIndicesDentroLimiteResponse() {
        return new IndicesDentroLimiteResponse();
    }

    /**
     * Create an instance of {@link RecuperaIndicePCA }
     * 
     */
    public RecuperaIndicePCA createRecuperaIndicePCA() {
        return new RecuperaIndicePCA();
    }

    /**
     * Create an instance of {@link IndicesDentroLimite }
     * 
     */
    public IndicesDentroLimite createIndicesDentroLimite() {
        return new IndicesDentroLimite();
    }

    /**
     * Create an instance of {@link BuscarPorMunicipio }
     * 
     */
    public BuscarPorMunicipio createBuscarPorMunicipio() {
        return new BuscarPorMunicipio();
    }

    /**
     * Create an instance of {@link BuscarPorMunicipioResponse }
     * 
     */
    public BuscarPorMunicipioResponse createBuscarPorMunicipioResponse() {
        return new BuscarPorMunicipioResponse();
    }

    /**
     * Create an instance of {@link ValoresDevidos }
     * 
     */
    public ValoresDevidos createValoresDevidos() {
        return new ValoresDevidos();
    }

    /**
     * Create an instance of {@link RecuperaIndicePCAResponse }
     * 
     */
    public RecuperaIndicePCAResponse createRecuperaIndicePCAResponse() {
        return new RecuperaIndicePCAResponse();
    }

    /**
     * Create an instance of {@link IndicesDTO }
     * 
     */
    public IndicesDTO createIndicesDTO() {
        return new IndicesDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPorMunicipio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "buscarPorMunicipio")
    public JAXBElement<BuscarPorMunicipio> createBuscarPorMunicipio(BuscarPorMunicipio value) {
        return new JAXBElement<BuscarPorMunicipio>(_BuscarPorMunicipio_QNAME, BuscarPorMunicipio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndicesDentroLimite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "indicesDentroLimite")
    public JAXBElement<IndicesDentroLimite> createIndicesDentroLimite(IndicesDentroLimite value) {
        return new JAXBElement<IndicesDentroLimite>(_IndicesDentroLimite_QNAME, IndicesDentroLimite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperaIndicePCAResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "recuperaIndicePCAResponse")
    public JAXBElement<RecuperaIndicePCAResponse> createRecuperaIndicePCAResponse(RecuperaIndicePCAResponse value) {
        return new JAXBElement<RecuperaIndicePCAResponse>(_RecuperaIndicePCAResponse_QNAME, RecuperaIndicePCAResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValoresDevidos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "valoresDevidos")
    public JAXBElement<ValoresDevidos> createValoresDevidos(ValoresDevidos value) {
        return new JAXBElement<ValoresDevidos>(_ValoresDevidos_QNAME, ValoresDevidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPorMunicipioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "buscarPorMunicipioResponse")
    public JAXBElement<BuscarPorMunicipioResponse> createBuscarPorMunicipioResponse(BuscarPorMunicipioResponse value) {
        return new JAXBElement<BuscarPorMunicipioResponse>(_BuscarPorMunicipioResponse_QNAME, BuscarPorMunicipioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperaIndicePCA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "recuperaIndicePCA")
    public JAXBElement<RecuperaIndicePCA> createRecuperaIndicePCA(RecuperaIndicePCA value) {
        return new JAXBElement<RecuperaIndicePCA>(_RecuperaIndicePCA_QNAME, RecuperaIndicePCA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndicesDentroLimiteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integracaocore.ecertidao.tcemg/", name = "indicesDentroLimiteResponse")
    public JAXBElement<IndicesDentroLimiteResponse> createIndicesDentroLimiteResponse(IndicesDentroLimiteResponse value) {
        return new JAXBElement<IndicesDentroLimiteResponse>(_IndicesDentroLimiteResponse_QNAME, IndicesDentroLimiteResponse.class, null, value);
    }

}
