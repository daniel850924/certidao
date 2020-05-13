/**
 * BasicHttpBinding_IWsSgiConsultaPessoaStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class BasicHttpBinding_IWsSgiConsultaPessoaStub extends org.apache.axis.client.Stub implements org.tempuri.IWsSgiConsultaPessoa {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarUsuarioSistemaOrgao");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "siglaSistema"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "codigoOrgaoEntidade"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cpf"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "somenteAtivo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseConsultaUsuarioSistemaOrgao"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarUsuarioSistemaOrgaoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarCpfReponsavelLegalVigente");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "siglaSistemaSolicitante"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cpfResponsavelLegal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nomeCategoriaResponsavel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseRespLegalVigente"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarCpfReponsavelLegalVigenteResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarResponsavel");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "siglaSistemaSolicitante"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cpfResponsavelLegal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cnpjOrgao"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "tipoOrgao"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "codUnidadeOrcamentaria"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "tipoCategoriaResponsavel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "dataInicio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "dataFim"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosResponsavelLegal"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarResponsavelResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaJurisdicionadoPorMunic");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "codMunicipio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaosPorMunicipio"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultaJurisdicionadoPorMunicResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListarLocalidadesMG");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "somenteMunicipios"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ArrayOfDadosListaCidade"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListarLocalidadesMGResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosListaCidade"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObterInformacoesPessoaFisica");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisicaFocus"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "PessoaFisica"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObterInformacoesPessoaJuridica");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaJuridicaFocus"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "PessoaJuridica"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultarResponsavelCodigoOrgao");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "codOrgaoEntidade"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponsavelLegalOrgao"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarResponsavelCodigoOrgaoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RetornarUsuarioPerfilOrgao");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "siglaSistema"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "codOrgaoEntidade"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseConsultaUsuarioSistemaOrgao"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "RetornarUsuarioPerfilOrgaoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

    }

    public BasicHttpBinding_IWsSgiConsultaPessoaStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_IWsSgiConsultaPessoaStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_IWsSgiConsultaPessoaStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "ArrayOfContatoServiceDto");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_DAL_DTO.ContatoServiceDto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "ContatoServiceDto");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "ContatoServiceDto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "ArrayOfOrgaoEntidadeServiceDto");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_DAL_DTO.OrgaoEntidadeServiceDto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "OrgaoEntidadeServiceDto");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "OrgaoEntidadeServiceDto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "ContatoServiceDto");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_DAL_DTO.ContatoServiceDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.DAL.DTO", "OrgaoEntidadeServiceDto");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_DAL_DTO.OrgaoEntidadeServiceDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ArrayOfContato");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ArrayOfDadosListaCidade");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosListaCidade");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosListaCidade");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ArrayOfInterface");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts._interface[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Interface");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Interface");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ArrayOfOrgaoResponsaveLegal");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoResponsaveLegal");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoResponsaveLegal");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ArrayOfPessoaFisica");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisica");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisica");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ArrayOfUsuarioPerfil");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Contato");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Contato.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosListaCidade");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "DadosResponsavelLegal");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Endereco");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.Endereco.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "Interface");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts._interface.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaoResponsaveLegal");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "OrgaosPorMunicipio");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisica");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaFisicaFocus");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "PessoaJuridicaFocus");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponsavelLegalOrgao");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseConsultaUsuarioSistemaOrgao");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "ResponseRespLegalVigente");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/SGI.WebService.DataContracts", "UsuarioPerfil");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.UsuarioPerfil.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao consultarUsuarioSistemaOrgao(java.lang.String siglaSistema, java.lang.Long codigoOrgaoEntidade, java.lang.String cpf, java.lang.Boolean somenteAtivo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ConsultarUsuarioSistemaOrgao");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarUsuarioSistemaOrgao"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {siglaSistema, codigoOrgaoEntidade, cpf, somenteAtivo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente consultarCpfReponsavelLegalVigente(java.lang.String siglaSistemaSolicitante, java.lang.String cpfResponsavelLegal, java.lang.String nomeCategoriaResponsavel) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ConsultarCpfReponsavelLegalVigente");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarCpfReponsavelLegalVigente"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {siglaSistemaSolicitante, cpfResponsavelLegal, nomeCategoriaResponsavel});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal consultarResponsavel(java.lang.String siglaSistemaSolicitante, java.lang.String cpfResponsavelLegal, java.lang.String cnpjOrgao, java.lang.String tipoOrgao, java.lang.String codUnidadeOrcamentaria, java.lang.String tipoCategoriaResponsavel, java.lang.String dataInicio, java.lang.String dataFim) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ConsultarResponsavel");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarResponsavel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {siglaSistemaSolicitante, cpfResponsavelLegal, cnpjOrgao, tipoOrgao, codUnidadeOrcamentaria, tipoCategoriaResponsavel, dataInicio, dataFim});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosResponsavelLegal.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio consultaJurisdicionadoPorMunic(java.lang.Long codMunicipio) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ConsultaJurisdicionadoPorMunic");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultaJurisdicionadoPorMunic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codMunicipio});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaosPorMunicipio.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[] listarLocalidadesMG(java.lang.Boolean somenteMunicipios) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ListarLocalidadesMG");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListarLocalidadesMG"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {somenteMunicipios});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[]) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.DadosListaCidade[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus obterInformacoesPessoaFisica() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ObterInformacoesPessoaFisica");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "RequestObterInformacoesPessoaFisica"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisicaFocus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus obterInformacoesPessoaJuridica() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ObterInformacoesPessoaJuridica");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "RequestObterInformacoesPessoaJuridica"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaJuridicaFocus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao consultarResponsavelCodigoOrgao(java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/ConsultarResponsavelCodigoOrgao");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultarResponsavelCodigoOrgao"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codOrgaoEntidade});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponsavelLegalOrgao.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao retornarUsuarioPerfilOrgao(java.lang.String siglaSistema, java.lang.Long codOrgaoEntidade) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IWsSgiConsultaPessoa/RetornarUsuarioPerfilOrgao");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "RetornarUsuarioPerfilOrgao"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {siglaSistema, codOrgaoEntidade});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
