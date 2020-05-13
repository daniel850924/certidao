package br.gov.mg.tcemg.ws;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.namespace.QName;

import br.gov.mg.tce.client.pca.web.AnaliseDTO;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWS;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWSService;
import br.gov.mg.tce.client.sgap.ListarProcessosTransJulgadosDTO;
import br.gov.mg.tce.client.sgap.ProcessoTransJulgadoWS;
import br.gov.mg.tce.client.sgap.ProcessosTransJulgadoWSService;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.facade.ProcessoJulgadoAnaliseBOLocal;
import br.gov.mg.tce.model.ProcessoJulgadoAnalise;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.util.ListUtil;

@Stateless
@WebService(name = "JobProcessoAnaliseBO", targetNamespace = "http://jobprocessoanalise.ecertidao.tcemg/")
@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.DOCUMENT)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class JobProcessoAnaliseBO {

//    @EJB
//    private ProcessoJulgadoAnaliseBOLocal processoJulgadoAnaliseBO;
//    @EJB
//    private EMailBOLocal eMailBO;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @WebMethod
//    @Schedule(hour = "*/12", minute = "0", second = "0", persistent = false)
    public void jobProcessoAnaliseBO() throws Exception {

//        IntegracaoWebECertidaoWS integracaoWebECertidaoWS = new IntegracaoWebECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_WEB_CERTIDAO)),
//                new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSService")).getIntegracaoWebECertidaoWSPort();
//        List<AnaliseDTO> listAnalises = integracaoWebECertidaoWS.buscarAnaliseSemIndiceRelatorDelib();
//
//        Map<Long, AnaliseDTO> mapAnalises = new HashMap<Long, AnaliseDTO>();
//        List<Long> listProcessos = new ArrayList<Long>();
//        for (AnaliseDTO analiseDTO : listAnalises) {
//            mapAnalises.put(analiseDTO.getNumProcesso(), analiseDTO);
//            listProcessos.add(analiseDTO.getNumProcesso());
//        }
//
//        List<ListarProcessosTransJulgadosDTO> listaProcessosTransJulgados = new ArrayList<ListarProcessosTransJulgadosDTO>();
//        List<List> listProcessosParticionado = ListUtil.particionarLista(listProcessos, 500);
//        ProcessoTransJulgadoWS processoTransJulgadoWS = new ProcessosTransJulgadoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_WEBSERVICE_PROCESSO_JULGADO)), new QName("http://processoTransJulgado.sgap.tcemg/",
//        		"ProcessosTransJulgadoWSService")).getProcessoTransJulgadoWSPort();
//        for (List list : listProcessosParticionado) {
//            listaProcessosTransJulgados.addAll(processoTransJulgadoWS.listarProcessosTransJulgadosPorListaProcessos(list));
//        }
//
//        List<AnaliseDTO> listaAnalisesTJ = new ArrayList<AnaliseDTO>();
//        List<AnaliseDTO> listaAnalisesATJ = new ArrayList<AnaliseDTO>();
//
//        ProcessoJulgadoAnalise processoJulgadoAnalise = null;
//        if (listaProcessosTransJulgados != null) {
//            for (ListarProcessosTransJulgadosDTO processosTransJulgadosDTO : listaProcessosTransJulgados) {
//                processoJulgadoAnalise = processoJulgadoAnaliseBO.findByNumeroProcesso(processosTransJulgadosDTO.getNumeroProcesso());
//
//                if (processoJulgadoAnalise == null) {
//                    processoJulgadoAnalise = new ProcessoJulgadoAnalise();
//                }
//
//                AnaliseDTO analise = mapAnalises.get(processosTransJulgadosDTO.getNumeroProcesso());
//                processoJulgadoAnalise.setCodProcesso(processosTransJulgadosDTO.getNumeroProcesso());
//                processoJulgadoAnalise.setSglSituacaoProcesso(processosTransJulgadosDTO.getSglSituacao());
//                processoJulgadoAnalise.setCodAnalise(analise.getCodAnalise());
//                processoJulgadoAnalise.setCodDecisao(processosTransJulgadosDTO.getCodDecisao().longValue());
//                processoJulgadoAnalise.setDscDecisao(processosTransJulgadosDTO.getDscDecisao());
//                processoJulgadoAnaliseBO.salvarProcessoJulgadoAnalise(processoJulgadoAnalise);
//
//                if ("TJ".equals(processosTransJulgadosDTO.getSglSituacao())) {
//                    listaAnalisesTJ.add(analise);
//                } else if ("ATJ".equals(processosTransJulgadosDTO.getSglSituacao())) {
//                    listaAnalisesATJ.add(analise);
//                }
//            }
//        }
//        eviarEmailTJ(listaAnalisesTJ);
//        enviarEmailATJ(listaAnalisesATJ);
        
    }

//    private void enviarEmailATJ(List<AnaliseDTO> listaAnalisesATJ) {
//        if (!listaAnalisesATJ.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (AnaliseDTO analise : listaAnalisesATJ) {
//                if (analise.getIndiceParecerPrevio() == null) {
//                    sb.append("Número do Processo: ");
//                    sb.append(analise.getNumProcesso());
//                    if (analise.getNomMunicipio() != null) {
//                        sb.append(" Município: ");
//                        sb.append(analise.getNomMunicipio());
//                    }
//                    if (analise.getNumAnoExercicio() != null) {
//                        sb.append(" Ano Exercício: ");
//                        sb.append(analise.getNumAnoExercicio());
//                    }
//                    sb.append("<br/>");
//                }
//            }
//
//            if(sb.length() > 0){
//            	eMailBO.enviarEmailECertidao("Preencher as seguintes Análises: Aba Relator. <br/>" + sb.toString(), "E-Certidao processo aguardando transito julgado");
//            }
//        }
//    }
//
//    private void eviarEmailTJ(List<AnaliseDTO> listaAnalisesTJ) {
//        if (!listaAnalisesTJ.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (AnaliseDTO analise : listaAnalisesTJ) {
//                if (analise.getIndiceDelibInv() == null) {
//                    sb.append("Número do Processo: ");
//                    sb.append(analise.getNumProcesso());
//                    if (analise.getNomMunicipio() != null) {
//                        sb.append(" Município: ");
//                        sb.append(analise.getNomMunicipio());
//                    }
//                    if (analise.getNumAnoExercicio() != null) {
//                        sb.append(" Ano Exercício: ");
//                        sb.append(analise.getNumAnoExercicio());
//                    }
//                    sb.append("<br/>");
//                }
//            }
//
//            if(sb.length() > 0){
//            	eMailBO.enviarEmailECertidao("Preencher as seguintes Análises: Deliberado . <br/>" + sb.toString(), "E-Certidao processo transito julgado");
//            }
//        }
//
//    }

}
