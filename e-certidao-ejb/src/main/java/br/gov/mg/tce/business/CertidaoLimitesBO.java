/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.mg.tce.business;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import br.gov.mg.tce.dao.CertidaoLimitesDAO;
import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoLimitesBOLocal;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.facade.SiaceBOLocal;
import br.gov.mg.tce.facade.sicom.SicomLimitesBOLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.CertidaoLimites;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.util.DateUtil;
import br.gov.mg.tcemg.util.Paginacao;

/**
 *
 * @author daniel.paula
 */
@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "CertidaoLimitesBO", mappedName = "CertidaoLimitesBO")
public class CertidaoLimitesBO extends TCEMGBusinessDomain<CertidaoLimites> implements CertidaoLimitesBOLocal{

    @InjectDAO
    private CertidaoLimitesDAO certidaoLimitesLrfDAO;
    
    @EJB
    private EMailBOLocal eMailBO;
    @EJB
	private SiaceBOLocal siaceBO;
    @EJB
	private SicomLimitesBOLocal sicomLimitesBO;
    
    @Override
    protected TCEMGDao<CertidaoLimites> getDao() {
        return certidaoLimitesLrfDAO;
    }

    private List<CertidaoLimites> pesquisarSolicitacoesEmAnalise(Integer qtde) {
    	return super.consultarPorNamedQuery(CertidaoLimites.PESQUISAR_EM_ANALISE, null, new Paginacao(0,qtde));
    }
    
    public void gerarCertidao(Integer qtde) {

//        	CertidaoLimites limite = super.obter(70229L);
//        	List<CertidaoLimites> certidoes = new ArrayList<>();
//        	certidoes.add(limite);
        List<CertidaoLimites> certidoes = this.pesquisarSolicitacoesEmAnalise(qtde);
        
        for (CertidaoLimites certidao : certidoes) {
            try {

				if(certidao.getNumAnoRef() <= 2017){
					siaceBO.setDadosCertidaoLimites(certidao);
				}else{
					sicomLimitesBO.consultarDadosCertidaoLimites(certidao);
				}
				
				if(IndSituacaoCertidaoEnum.CONCLUIDA.equals(certidao.getIndSituacao())){
					certidao.setArqCertidaoPdf(gerarArquivoCertidao(certidao));
				}
            } catch (Exception ex) {
            	certidao.setIndSituacao(IndSituacaoCertidaoEnum.ERRO);
            	eMailBO.enviarEmailErro(new Email(certidao, "Limites", ex));
            }finally{
            	certidaoLimitesLrfDAO.alterar(certidao);
            }
        }

        
    }

    public byte[] gerarArquivoCertidao(CertidaoLimites certidao) throws Exception {

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        String protocolo = String.valueOf(certidao.getNumProtocolo());
        String protocoloFormatado = protocolo.substring(0, 10);
        protocoloFormatado = protocoloFormatado + "/" + protocolo.substring(10);
        parameters.put("P_NUM_PROTOCOLO", protocoloFormatado);
        parameters.put("P_ANO_REFERENCIA", String.valueOf(certidao.getNumAnoRef()));
        parameters.put("P_DATA_VENCIMENTO", String.valueOf(DateUtil.adicionaDias(certidao.getDataSolicitacao(), 90)));
        parameters.put("P_IMG_TCE_LOGO", CertidaoLimites.class.getResourceAsStream("/relatorios" + "/tceLogo.png"));
        parameters.put("P_NUM_PORTARIA", "54/PRES./2018");
        parameters.put("P_LINK_ECERTIDAO", "http://www.tce.mg.gov.br/ecertidao/");
        parameters.put("P_NOME_MUNICIPIO", "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">" + certidao.getNomeMunicipio() + "</style>");
        
        //Opção de semestralidade
        final String dscOpcaoSemestralidade = certidao.getDscOpcaoSemestralidade();
        String semestre = null;
        if(dscOpcaoSemestralidade.equalsIgnoreCase("OPTANTE")){
            semestre = "segundo semestre";
        }else{
            //("Não Optante") 
            //("Perdeu o Direito a Opção")
            semestre = "terceiro quadrimestre";
        }
        parameters.put("P_OPCAO_SEMESTRALIDADE", semestre);
        
        //Item 1
        BigDecimal pctDespesaExecutivo = certidao.getPctDespesaExecutivo();
        BigDecimal pctDespesaLegislativo = certidao.getPctDespesaLegislativo();
        BigDecimal pctDespesaTotal = certidao.getPctDespesaTotal();
        String param1 = null;
        if(pctDespesaExecutivo.doubleValue() <= 54D && pctDespesaLegislativo.doubleValue() <= 6D && pctDespesaTotal.doubleValue() <= 60L){
            param1 = "O Município encontra-se dentro do limite da despesa total com pessoal previsto no art. 19, III, da Lei Complementar n.º 101/2000";
        }else if(pctDespesaTotal.doubleValue() > 60D){
            param1 = "O Município encontra-se acima do limite da despesa total com pessoal previsto no art. 19, III, da Lei Complementar n.º 101/2000";
        }else if(pctDespesaExecutivo.doubleValue() > 54D && pctDespesaLegislativo.doubleValue() <= 6D && pctDespesaTotal.doubleValue() <= 60D){
            param1 = "O Município encontra-se dentro do limite da despesa total com pessoal previsto no art. 19, III, da Lei Complementar n.º 101/2000, tendo, no entanto, o Poder Executivo ultrapassado seu limite percentual setorial estabelecido no art. 20, III, b, da mesma Lei";
        }else if(pctDespesaExecutivo.doubleValue() <= 54D && pctDespesaLegislativo.doubleValue() > 6D && pctDespesaTotal.doubleValue() <= 60D){
            param1 = "O Município encontra-se dentro do limite de despesa total com pessoal previsto no art. 19, III, da Lei Complementar n.º 101/2000, tendo, no entanto, o Poder Legislativo ultrapassado seu limite percentual setorial estabelecido no art. 20, III, a, da mesma Lei";
        }
        parameters.put("P_PARAM1", param1);
        
        //Item 2
        if(certidao.getNumAnoRef() <= 2017){
        	Date datPublicacaoExecutivo = certidao.getDatPublicacaoExecutivo();
        	Integer anoPosteriorCertidao = certidao.getNumAnoRef().intValue() + 1;
        	Date dataReferencia = DateUtil.newDate(31, 1, anoPosteriorCertidao);
        	String param2;
        	if(DateUtil.comparaDataDescartandoHoras(datPublicacaoExecutivo, dataReferencia) <= 0 ){
        		param2 = "O Poder Executivo publicou os Relatórios tempestivamente, conforme previsto nos arts. 52 e 55, § 2º, da LRF";
        	}else{
        		param2 = "O Poder Executivo publicou os Relatórios intempestivamente, contrariando o previsto nos arts. 52 e 55, § 2º, da LRF";
        	}
        	parameters.put("P_PARAM2", param2);
        }else{
        	
        	StringBuilder param2 = new StringBuilder();
        	if("Tempestivo".equalsIgnoreCase(certidao.getSitPubRgf())){
        		param2.append("O Poder Executivo publicou o Relatório de Gestão Fiscal tempestivamente, conforme previsto no art. 55, § 2º, da LRF, ");
        	}else if ("Intempestivo".equalsIgnoreCase(certidao.getSitPubRgf())){
        		param2.append("O Poder Executivo publicou o Relatório de Gestão Fiscal intempestivamente, contrariando o previsto no art. 55, § 2º, da LRF, ");
        	}else{
        		param2.append("Poder Executivo não informou a data de publicação do Relatório de Gestão Fiscal, contrariando o previsto no art. 55, § 2º, da LRF, ");
        	}
        	
        	if("Tempestivo".equalsIgnoreCase(certidao.getSitPubRreo())){
        		param2.append("O Poder Executivo publicou o Relatório Resumido da Execução Orçamentária tempestivamente, conforme previsto no art. 52, da LRF");
        	}else if ("Intempestivo".equalsIgnoreCase(certidao.getSitPubRreo())){
        		param2.append("O Poder Executivo publicou o Relatório Resumido da Execução Orçamentária intempestivamente, contrariando o previsto no art. 52, da LRF");
        	}else{
        		param2.append("O Poder Executivo não informou a data de publicação do Relatório Resumido da Execução Orçamentária, contrariando o previsto no art. 52, da LRF");
        	}
        	
        	parameters.put("P_PARAM2", param2.toString());
        }
        
        //Item 3
        BigDecimal pctDividaConsExecutivo = certidao.getPctDividaConsExecutivo().doubleValue() < 0D ? new BigDecimal("0") : certidao.getPctDividaConsExecutivo();
        BigDecimal vlrDividaConsLrf = certidao.getVlrDividaConsLrf();
        String param3 = null;
        if((pctDividaConsExecutivo.doubleValue() > 0D && pctDividaConsExecutivo.doubleValue() <= 120D)
                || (pctDividaConsExecutivo.doubleValue() == 0D && vlrDividaConsLrf.doubleValue() > 0D)){
            param3 = "O montante da Dívida Consolidada Líquida do Município encontra-se dentro do limite previsto na Resolução n.º 40/2001 do Senado Federal";
        }else if(pctDividaConsExecutivo.doubleValue() == 0D && vlrDividaConsLrf.doubleValue() == 0D){
            param3 = "Não consta saldo relativo à Dívida Consolidada do Município em 31/12/" + certidao.getNumAnoRef();
        }else if(pctDividaConsExecutivo.doubleValue() > 120D){
            param3 = "O montante da Dívida Consolidada Líquida do Município ultrapassou o limite previsto na Resolução n.º 40/2001 do Senado Federal";
        }
        parameters.put("P_PARAM3", param3);
        
        //Item 4
        BigDecimal pctConcGarantExecutivo = certidao.getPctConcGarantExecutivo();
        String param4 = null;
        if(pctConcGarantExecutivo.doubleValue() == 0D){
            param4 = "Não houve Concessão de Garantias";
        }else if(pctConcGarantExecutivo.doubleValue() > 0D && pctConcGarantExecutivo.doubleValue() <= 22D){
            param4 = "A Concessão de Garantias do Município se encontra dentro do limite previsto na Resolução n.º 43/2001 do Senado Federal";
        }else if(pctConcGarantExecutivo.doubleValue() > 22D){
            param4 = "A Concessão de Garantias do Município ultrapassou o limite previsto na Resolução n.º 43/2001 do Senado Federal";
        }
        parameters.put("P_PARAM4", param4);
        
        //Item 5 E/OU?
        String param5 = null;
        BigDecimal pctOperCredExecutivo = certidao.getPctOperCredExecutivo();
        BigDecimal pctOperCredRealExec = certidao.getPctOperCredRealExec();
        if(pctOperCredExecutivo.doubleValue() == 0D && pctOperCredRealExec.doubleValue() == 0D){
            param5 = "O Município não realizou Receitas de Operações de Crédito no exercício de " + certidao.getNumAnoRef();
        }else if((pctOperCredExecutivo.doubleValue() > 0D && pctOperCredExecutivo.doubleValue() <= 16D)
                || (pctOperCredRealExec.doubleValue() > 0D && pctOperCredRealExec.doubleValue() <= 16D)){
             param5 = "O montante global das Receitas de Operações de Crédito encontra-se dentro do limite estabelecido na Resolução nº 43/2001 do Senado Federal";
        }else if(pctOperCredExecutivo.doubleValue() > 16D && pctOperCredRealExec.doubleValue() > 16D){
            param5 = "O montante global das Receitas de Operações de Crédito ultrapassou o limite estabelecido na Resolução nº 43/2001 do Senado Federal”";
        }
        parameters.put("P_PARAM5", param5);
        
        //Item 6
        String param6 = null;
        BigDecimal pctAroExecutivo = certidao.getPctAroExecutivo();
        if(pctAroExecutivo.doubleValue() == 0D){
            param6 = "Não consta saldo em 31/12/" + certidao.getNumAnoRef() + " relativo à Operação de Crédito por Antecipação da Receita Orçamentária – ARO";
        }else if(pctAroExecutivo.doubleValue() > 0D && pctAroExecutivo.doubleValue() <= 7D){
            param6 = "O montante global da Operação de Crédito por Antecipação da Receita Orçamentária – ARO se encontra dentro do limite estabelecido na Resolução nº 43/2001 do Senado Federal";
        }else if(pctAroExecutivo.doubleValue() > 7D){
            param6 = "O montante global da Operação de Crédito por Antecipação da Receita Orçamentária – ARO ultrapassou o limite estabelecido na Resolução nº 43/2001 do Senado Federal";
        }
        parameters.put("P_PARAM6", param6);
        
        
        //<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\"> </style>
        //Item 7 
//        String param7 = null;
//        String dscResultadoRpps = certidao.getDscResultadoRpps();
        String ok = "OK";
//		if(ok.equalsIgnoreCase(dscResultadoRpps)){
//            param7 = "Não constam inscrições na conta Restos a Pagar em 31/12/" + certidao.getNumAnoRef();
//        }else if("Não Ultrapassou".equalsIgnoreCase(dscResultadoRpps)){
//            param7 = "O montante das inscrições em Restos a Pagar não ultrapassou as disponibilidades financeiras em 31/12/" + certidao.getNumAnoRef();
//        }else if("Ultrapassou".equalsIgnoreCase(dscResultadoRpps)){
//            param7 = "O montante das inscrições em Restos a Pagar ultrapassou as disponibilidades financeiras em 31/12/" + certidao.getNumAnoRef();
//        }
//        parameters.put("P_PARAM7", param7);
        
        //Item 8 
        String param8 = null;
        String dscImpCompNaoArrecadados = certidao.getDscImpCompNaoArrecadados();
        String dscImpCompNaoPrevisto = certidao.getDscImpCompNaoPrevisto();
        if(ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
        	param8 = "O Município fez a previsão e arrecadou todos os tributos de sua competência, conforme estabelecido no artigo 11 da Lei Complementar nº 101/2000";
        } else {
			if(ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && !ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
				param8 = "O Município não fez a previsão do "+ dscImpCompNaoPrevisto + ", contudo, arrecadou todos os tributos de sua competência, conforme estabelecido no artigo 11 da Lei Complementar nº 101/2000";
			}else if(!ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
				param8 = "O Município fez a previsão de todos os tributos de sua competência, contudo, não arrecadou o " + dscImpCompNaoArrecadados + ", conforme estabelecido no artigo 11 da Lei Complementar nº 101/2000";
			}else if(!ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && !ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
				param8 = "O Município não fez a previsão do " + dscImpCompNaoPrevisto + " e não arrecadou o " + dscImpCompNaoArrecadados + ", contrariando o estabelecido no artigo 11 da Lei Complementar nº 101/2000";
			}
		}
        parameters.put("P_PARAM8", param8);
        
        StringBuilder nota = new StringBuilder();

        /*Em razão da Ordem de Serviço Conjunta nº 01/2019, para fins de cálculo com a despesa com pessoal  
		 * (Certidão de gasto com pessoal, limites e certidão para fins de operações de crédito) para o exercício de 2018, deverá ser considerado os valores devidos 
		 * pelo Estado aos municípios relativos ao Fundeb e ICMS do exercício de 2018, os quais deverão ser somados ao total da receita corrente líquida.*/
        //solicitado a remessa da nota pela HELIANE DA COSTA no dia 21//11/2019  
//		if(certidao.getNumAnoRef() == 2018){
//			nota.append("<br /><style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Nota explicativa:</style> Conforme disposto nos §§ 5° e 6° do art. 1° da Ordem de Serviço Conjunta n° 01, de 29 de maio de 2019")
//			.append(", acrescentou-se ao total da Receita Corrente Líquida os valores devidos pelo Estado aos Municípios relativos ao Fundeb e ICMS do exercício de 2018. ");
//		}
        
        nota.append("<br /> Os dados informados nesta certidão, baseados nos Relatórios de Gestão Fiscal e Resumido da Execução Orçamentária enviados a este Tribunal, poderão sujeitar-se à retificação em decorrência de inspeção ordinária, extraordinária ou especial e tomada de contas que venham a ser realizadas no Município ou de qualquer outro processo que venha a ser apreciado por este Tribunal.");
        
        
        parameters.put("P_NOTA", nota.toString());
        
        InputStream inputStream = CertidaoLimites.class.getResourceAsStream("/relatorios/" + "Mod_cert_Limites.jasper");
        JasperPrint jpPrint = JasperFillManager.fillReport(inputStream, parameters, new JREmptyDataSource());
		return JasperExportManager.exportReportToPdf(jpPrint);
    }
}
