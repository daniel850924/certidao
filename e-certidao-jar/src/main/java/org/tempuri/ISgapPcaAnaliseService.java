/**
 * ISgapPcaAnaliseService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface ISgapPcaAnaliseService extends java.rmi.Remote {
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.ValidarPCAResult validarPCA(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service.ValidarPCAParameter parameter) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaResult getDocumentosJuntadosProcessoExecutivoMunicipal(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA.DocumentoJuntadaParameter documentoJuntadaParameter) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.TramitaProcessoResult tramitarProcessoEntreUnidades(org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Parameters.TramitaProcessoParameter parameter) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioResult obterSituacaoPCAPorMunicipio(java.lang.Long codMunicipio) throws java.rmi.RemoteException;
}
