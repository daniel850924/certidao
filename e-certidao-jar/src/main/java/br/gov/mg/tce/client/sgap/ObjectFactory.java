
package br.gov.mg.tce.client.sgap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.mg.tce.client.sgap package. 
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

    private final static QName _ListarProcessosTransJulgadosResponse_QNAME = new QName("http://processoTransJulgado.sgap.tcemg/", "listarProcessosTransJulgadosResponse");
    private final static QName _ListarProcessosTransJulgadosPorListaProcessosResponse_QNAME = new QName("http://processoTransJulgado.sgap.tcemg/", "listarProcessosTransJulgadosPorListaProcessosResponse");
    private final static QName _ListarProcessosTransJulgadosDTO_QNAME = new QName("http://processoTransJulgado.sgap.tcemg/", "listarProcessosTransJulgadosDTO");
    private final static QName _ListarProcessosTransJulgadosPorNumeroProcessoResponse_QNAME = new QName("http://processoTransJulgado.sgap.tcemg/", "listarProcessosTransJulgadosPorNumeroProcessoResponse");
    private final static QName _ListarProcessosTransJulgados_QNAME = new QName("http://processoTransJulgado.sgap.tcemg/", "listarProcessosTransJulgados");
    private final static QName _ListarProcessosTransJulgadosPorListaProcessos_QNAME = new QName("http://processoTransJulgado.sgap.tcemg/", "listarProcessosTransJulgadosPorListaProcessos");
    private final static QName _ListarProcessosTransJulgadosPorNumeroProcesso_QNAME = new QName("http://processoTransJulgado.sgap.tcemg/", "listarProcessosTransJulgadosPorNumeroProcesso");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.mg.tce.client.sgap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarProcessosTransJulgadosDTO }
     * 
     */
    public ListarProcessosTransJulgadosDTO createListarProcessosTransJulgadosDTO() {
        return new ListarProcessosTransJulgadosDTO();
    }

    /**
     * Create an instance of {@link ListarProcessosTransJulgadosPorListaProcessosResponse }
     * 
     */
    public ListarProcessosTransJulgadosPorListaProcessosResponse createListarProcessosTransJulgadosPorListaProcessosResponse() {
        return new ListarProcessosTransJulgadosPorListaProcessosResponse();
    }

    /**
     * Create an instance of {@link ListarProcessosTransJulgadosResponse }
     * 
     */
    public ListarProcessosTransJulgadosResponse createListarProcessosTransJulgadosResponse() {
        return new ListarProcessosTransJulgadosResponse();
    }

    /**
     * Create an instance of {@link ListarProcessosTransJulgados }
     * 
     */
    public ListarProcessosTransJulgados createListarProcessosTransJulgados() {
        return new ListarProcessosTransJulgados();
    }

    /**
     * Create an instance of {@link ListarProcessosTransJulgadosPorNumeroProcessoResponse }
     * 
     */
    public ListarProcessosTransJulgadosPorNumeroProcessoResponse createListarProcessosTransJulgadosPorNumeroProcessoResponse() {
        return new ListarProcessosTransJulgadosPorNumeroProcessoResponse();
    }

    /**
     * Create an instance of {@link ListarProcessosTransJulgadosPorListaProcessos }
     * 
     */
    public ListarProcessosTransJulgadosPorListaProcessos createListarProcessosTransJulgadosPorListaProcessos() {
        return new ListarProcessosTransJulgadosPorListaProcessos();
    }

    /**
     * Create an instance of {@link ListarProcessosTransJulgadosPorNumeroProcesso }
     * 
     */
    public ListarProcessosTransJulgadosPorNumeroProcesso createListarProcessosTransJulgadosPorNumeroProcesso() {
        return new ListarProcessosTransJulgadosPorNumeroProcesso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProcessosTransJulgadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://processoTransJulgado.sgap.tcemg/", name = "listarProcessosTransJulgadosResponse")
    public JAXBElement<ListarProcessosTransJulgadosResponse> createListarProcessosTransJulgadosResponse(ListarProcessosTransJulgadosResponse value) {
        return new JAXBElement<ListarProcessosTransJulgadosResponse>(_ListarProcessosTransJulgadosResponse_QNAME, ListarProcessosTransJulgadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProcessosTransJulgadosPorListaProcessosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://processoTransJulgado.sgap.tcemg/", name = "listarProcessosTransJulgadosPorListaProcessosResponse")
    public JAXBElement<ListarProcessosTransJulgadosPorListaProcessosResponse> createListarProcessosTransJulgadosPorListaProcessosResponse(ListarProcessosTransJulgadosPorListaProcessosResponse value) {
        return new JAXBElement<ListarProcessosTransJulgadosPorListaProcessosResponse>(_ListarProcessosTransJulgadosPorListaProcessosResponse_QNAME, ListarProcessosTransJulgadosPorListaProcessosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProcessosTransJulgadosDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://processoTransJulgado.sgap.tcemg/", name = "listarProcessosTransJulgadosDTO")
    public JAXBElement<ListarProcessosTransJulgadosDTO> createListarProcessosTransJulgadosDTO(ListarProcessosTransJulgadosDTO value) {
        return new JAXBElement<ListarProcessosTransJulgadosDTO>(_ListarProcessosTransJulgadosDTO_QNAME, ListarProcessosTransJulgadosDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProcessosTransJulgadosPorNumeroProcessoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://processoTransJulgado.sgap.tcemg/", name = "listarProcessosTransJulgadosPorNumeroProcessoResponse")
    public JAXBElement<ListarProcessosTransJulgadosPorNumeroProcessoResponse> createListarProcessosTransJulgadosPorNumeroProcessoResponse(ListarProcessosTransJulgadosPorNumeroProcessoResponse value) {
        return new JAXBElement<ListarProcessosTransJulgadosPorNumeroProcessoResponse>(_ListarProcessosTransJulgadosPorNumeroProcessoResponse_QNAME, ListarProcessosTransJulgadosPorNumeroProcessoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProcessosTransJulgados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://processoTransJulgado.sgap.tcemg/", name = "listarProcessosTransJulgados")
    public JAXBElement<ListarProcessosTransJulgados> createListarProcessosTransJulgados(ListarProcessosTransJulgados value) {
        return new JAXBElement<ListarProcessosTransJulgados>(_ListarProcessosTransJulgados_QNAME, ListarProcessosTransJulgados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProcessosTransJulgadosPorListaProcessos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://processoTransJulgado.sgap.tcemg/", name = "listarProcessosTransJulgadosPorListaProcessos")
    public JAXBElement<ListarProcessosTransJulgadosPorListaProcessos> createListarProcessosTransJulgadosPorListaProcessos(ListarProcessosTransJulgadosPorListaProcessos value) {
        return new JAXBElement<ListarProcessosTransJulgadosPorListaProcessos>(_ListarProcessosTransJulgadosPorListaProcessos_QNAME, ListarProcessosTransJulgadosPorListaProcessos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProcessosTransJulgadosPorNumeroProcesso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://processoTransJulgado.sgap.tcemg/", name = "listarProcessosTransJulgadosPorNumeroProcesso")
    public JAXBElement<ListarProcessosTransJulgadosPorNumeroProcesso> createListarProcessosTransJulgadosPorNumeroProcesso(ListarProcessosTransJulgadosPorNumeroProcesso value) {
        return new JAXBElement<ListarProcessosTransJulgadosPorNumeroProcesso>(_ListarProcessosTransJulgadosPorNumeroProcesso_QNAME, ListarProcessosTransJulgadosPorNumeroProcesso.class, null, value);
    }

}
