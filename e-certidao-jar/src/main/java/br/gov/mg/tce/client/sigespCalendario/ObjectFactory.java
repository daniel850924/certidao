
package br.gov.mg.tce.client.sigespCalendario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.mg.tce.client.sigespCalendario package. 
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

    private final static QName _AdicionaDiasUteis_QNAME = new QName("http://calendariows.sigesp.tcemg/", "adicionaDiasUteis");
    private final static QName _AdicionaDiasUteisResponse_QNAME = new QName("http://calendariows.sigesp.tcemg/", "adicionaDiasUteisResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.mg.tce.client.sigespCalendario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AdicionaDiasUteis }
     * 
     */
    public AdicionaDiasUteis createAdicionaDiasUteis() {
        return new AdicionaDiasUteis();
    }

    /**
     * Create an instance of {@link AdicionaDiasUteisResponse }
     * 
     */
    public AdicionaDiasUteisResponse createAdicionaDiasUteisResponse() {
        return new AdicionaDiasUteisResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdicionaDiasUteis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calendariows.sigesp.tcemg/", name = "adicionaDiasUteis")
    public JAXBElement<AdicionaDiasUteis> createAdicionaDiasUteis(AdicionaDiasUteis value) {
        return new JAXBElement<AdicionaDiasUteis>(_AdicionaDiasUteis_QNAME, AdicionaDiasUteis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdicionaDiasUteisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calendariows.sigesp.tcemg/", name = "adicionaDiasUteisResponse")
    public JAXBElement<AdicionaDiasUteisResponse> createAdicionaDiasUteisResponse(AdicionaDiasUteisResponse value) {
        return new JAXBElement<AdicionaDiasUteisResponse>(_AdicionaDiasUteisResponse_QNAME, AdicionaDiasUteisResponse.class, null, value);
    }

}
