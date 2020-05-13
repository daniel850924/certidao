//package br.gov.mg.tcemg.ws;
//
//import java.util.List;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import javax.ejb.EJB;
//import javax.ejb.Schedule;
//import javax.ejb.Stateless;
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebService;
//import javax.jws.soap.SOAPBinding;
//
//import br.gov.mg.tce.dto.Email;
//import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
//import br.gov.mg.tce.facade.CertidaoBOLocal;
//import br.gov.mg.tce.facade.CertidaoCompetenciaTributariaBOLocal;
//import br.gov.mg.tce.facade.CertidaoLimitesBOLocal;
//import br.gov.mg.tce.facade.CertidaoOperacaoCreditoBOLocal;
//import br.gov.mg.tce.facade.CertidaoPCAConsolidaBOLocal;
//import br.gov.mg.tce.facade.CertidaoPCADefesaValidadaBOLocal;
//import br.gov.mg.tce.facade.CertidaoPrePCABOLocal;
//import br.gov.mg.tce.facade.CertidaoSGAPBOLocal;
//import br.gov.mg.tce.facade.EMailBOLocal;
//import br.gov.mg.tce.model.Certidao;
//
//@Stateless
//@WebService(name = "JobCertidao", targetNamespace = "http://ecertidaoService.tcemg/" )
//@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.DOCUMENT)
//public class JobCertidao {
//
//	private static AtomicBoolean isJobGerarCertidaoCompetenciaTributariaOn = new AtomicBoolean(false);
//	private static AtomicBoolean bloquearJobGerarCertidaoCompetenciaTributaria = new AtomicBoolean(false);
//
//	private static AtomicBoolean isJobGerarCertidaoOperacaoCreditoOn = new AtomicBoolean(false);
//	private static AtomicBoolean bloquearJobGerarCertidaoOperacaoCredito = new AtomicBoolean(false);
//
//	private static AtomicBoolean isJobGerarCertidaoOnLimitesOn = new AtomicBoolean(false);
//	private static AtomicBoolean bloquearJobGerarCertidaoLimites = new AtomicBoolean(false);
//
//	private static AtomicBoolean isJobGerarCertidaoOn = new AtomicBoolean(false);
//	private static AtomicBoolean bloquearJobGerarCertidaoConsolidada = new AtomicBoolean(false);
//
//	private static AtomicBoolean isJobGerarCertidaoPrePcaOn = new AtomicBoolean(false);
//	private static AtomicBoolean bloquearJobGerarCertidaoPrePca = new AtomicBoolean(false);
//
//	private static AtomicBoolean isJobAnaliseComProcessoTransjulgadoOn = new AtomicBoolean(false);
//	private static AtomicBoolean bloquearJobAnaliseComProcessoTransjulgado = new AtomicBoolean(false);
//
//	private static AtomicBoolean isJobAnaliseDefesaValidada = new AtomicBoolean(false);
//	private static AtomicBoolean bloquearJobAnaliseDefesaValidada = new AtomicBoolean(false);
//
//	private static AtomicInteger qtdeCertidoes = new AtomicInteger(1);
//
//	@EJB
//	private EMailBOLocal eMailBO;
//	@EJB
//	private CertidaoBOLocal certidaoBO;
//	@EJB
//	private CertidaoCompetenciaTributariaBOLocal certidaoCompetenciaTributariaBO;
//	@EJB
//	private CertidaoOperacaoCreditoBOLocal certidaoOperacaoCreditoBO;
//	@EJB
//	private CertidaoLimitesBOLocal certidaoLimitesBO;
//	@EJB
//	private CertidaoPrePCABOLocal certidaoPrePCABO;
//	@EJB
//	private CertidaoPCAConsolidaBOLocal certidaoPCAConsolidaBO;
//	@EJB
//	private CertidaoPCADefesaValidadaBOLocal certidaoPCADefesaValidadaBO;
//	@EJB
//	private CertidaoSGAPBOLocal certidaoSGAPBO;
//
//	@WebMethod
//	@Schedule(hour = "*/1", minute = "0", second = "0", persistent = false)
//	public void jobAnaliseComErro() throws Exception {
//		
//		try {
//			Certidao peticaoCertidaoFiltro = new Certidao();
//			peticaoCertidaoFiltro.setIndSituacao(IndSituacaoCertidaoEnum.ERRO);
//			List<Certidao> consultarPeticoesPorFiltros = certidaoBO.consultarPeticoesPorFiltros(peticaoCertidaoFiltro);
//			for (Certidao certidao : consultarPeticoesPorFiltros) {
//				certidao.setIndSituacao(IndSituacaoCertidaoEnum.EM_ANALISE);
//				certidaoBO.alterar(certidao);
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobAnaliseComErro", e));
//		}
//	}
//
//	@WebMethod
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	public void jobCertidaoCompetenciaTributaria() throws Exception {
//
//		try {
//			if (!bloquearJobGerarCertidaoCompetenciaTributaria.get() && !isJobGerarCertidaoCompetenciaTributariaOn.getAndSet(true)) {
//				certidaoCompetenciaTributariaBO.gerarCertidao(qtdeCertidoes.get());
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobCertidaoCompetenciaTributaria", e));
//		}finally{
//			isJobGerarCertidaoCompetenciaTributariaOn.set(false);
//		}
//	}
//
//	@WebMethod
//	@Schedule(hour = "*", minute = "*/2", persistent = false)
//	public void jobCertidaoOperacaoCredito() throws Exception {
//
//		try {
//			if (!bloquearJobGerarCertidaoOperacaoCredito.get() && !isJobGerarCertidaoOperacaoCreditoOn.getAndSet(true)) {
//				certidaoOperacaoCreditoBO.gerarCertidao(qtdeCertidoes.get());
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobCertidaoOperacaoCredito", e));
//		}finally{
//			isJobGerarCertidaoOperacaoCreditoOn.set(false);
//		}
//	}
//
//	@WebMethod
//	@Schedule(hour = "*", minute = "*/2", persistent = false)
//	public void jobGerarCertidaoLimites() throws Exception {
//
//		try {
//			if (!bloquearJobGerarCertidaoLimites.get() && !isJobGerarCertidaoOnLimitesOn.getAndSet(true)) {
//				certidaoLimitesBO.gerarCertidao(qtdeCertidoes.get());
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobGerarCertidaoLimites", e));
//		}finally{
//			isJobGerarCertidaoOnLimitesOn.set(false);
//		}
//	}
//
//	@WebMethod
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	public void jobGerarCertidaoPrePCA() throws Exception {
//		try {
//			if (!bloquearJobGerarCertidaoPrePca.get() && !isJobGerarCertidaoPrePcaOn.getAndSet(true)) {
//				certidaoPrePCABO.gerarCertidao(qtdeCertidoes.get());
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobGerarCertidaoPrePCA", e));
//		}finally{
//			isJobGerarCertidaoPrePcaOn.set(false);
//		}
//	}
//
//	@WebMethod
//	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
//	public void jobGerarCertidaoConsolidada() throws Exception {
//
//		try {
//			if (!bloquearJobGerarCertidaoConsolidada.get() && !isJobGerarCertidaoOn.getAndSet(true)) {
//				certidaoPCAConsolidaBO.gerarCertidao(qtdeCertidoes.get());
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobGerarCertidaoConsolidada", e));
//		}finally{
//			isJobGerarCertidaoOn.set(false);
//		}
//	}
//
//	@WebMethod
//	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
//	public void jobAnaliseDefesaValidada() {
//
//		try {
//			if (!bloquearJobAnaliseDefesaValidada.get() && !isJobAnaliseDefesaValidada.getAndSet(true)) {
//				certidaoPCADefesaValidadaBO.gerarCertidao(qtdeCertidoes.get());
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobAnaliseDefesaValidada", e));
//		}finally{
//			isJobAnaliseDefesaValidada.set(false);
//		}
//	}
//
//	@WebMethod
//	@Schedule(hour = "*", minute = "*/1", persistent = false)
//	public void jobAnaliseComProcessoTransjulgado() throws Exception {
//
//		try {
//			if (!bloquearJobAnaliseComProcessoTransjulgado.get() && !isJobAnaliseComProcessoTransjulgadoOn.getAndSet(true)) {
//				certidaoSGAPBO.gerarCertidao();
//			}
//		} catch (Exception e) {
//			eMailBO.enviarEmailErro(new Email(null, "jobAnaliseComProcessoTransjulgado", e));
//		}finally{
//			isJobAnaliseComProcessoTransjulgadoOn.set(false);
//		}
//	}
//
//	@WebMethod
//	public void setBloquearJobCertidaoLimites(@WebParam(name = "bloquearJobCertidaoLimites") Boolean bloquearJobGerarCertidao) {
//		JobCertidao.bloquearJobGerarCertidaoLimites.set(bloquearJobGerarCertidao);
//	}
//
//	@WebMethod
//	public void setBloquearJobCertidaoOperacaoCredito(@WebParam(name = "bloquearJobCertidaoOperacaoCredito") Boolean bloquearJobGerarCertidao) {
//		JobCertidao.bloquearJobGerarCertidaoOperacaoCredito.set(bloquearJobGerarCertidao);
//	}
//
//	@WebMethod
//	public void setBloquearJobCertidaoCompetenciaTributaria(@WebParam(name = "bloquearJobCertidaoCompetenciaTributaria") Boolean bloquearJobGerarCertidao) {
//		JobCertidao.bloquearJobGerarCertidaoCompetenciaTributaria.set(bloquearJobGerarCertidao);
//	}
//
//	@WebMethod
//	public void setBloquearJobGerarCertidaoConsolidada(@WebParam(name = "bloquearJobGerarCertidaoConsolidada") Boolean bloquearJobGerarCertidaoConsolidada) {
//		JobCertidao.bloquearJobGerarCertidaoConsolidada.set(bloquearJobGerarCertidaoConsolidada);
//	}
//
//	@WebMethod
//	public void setBloquearJobGerarCertidaoPrePca(@WebParam(name = "bloquearJobGerarCertidaoPrePca") Boolean bloquearJobGerarCertidaoPrePca) {
//		JobCertidao.bloquearJobGerarCertidaoPrePca.set(bloquearJobGerarCertidaoPrePca);
//	}
//
//	@WebMethod
//	public void setBloquearJobAnaliseDefesaValidada(@WebParam(name = "bloquearJobAnaliseDefesaValidada") Boolean bloquearJobAnaliseDefesaValidada) {
//		JobCertidao.bloquearJobAnaliseDefesaValidada.set(bloquearJobAnaliseDefesaValidada);
//	}
//
//	@WebMethod
//	public void setBloquearJobAnaliseComProcessoTransjulgado(
//			@WebParam(name = "bloquearJobAnaliseComProcessoTransjulgado") Boolean bloquearJobAnaliseComProcessoTransjulgado) {
//		JobCertidao.bloquearJobAnaliseComProcessoTransjulgado.set(bloquearJobAnaliseComProcessoTransjulgado);
//	}
//
//	@WebMethod
//	public Integer getQtdeCertidoes() {
//		return JobCertidao.qtdeCertidoes.intValue();
//	}
//
//	@WebMethod
//	public void setQtdeCertidoes(Integer qtdeCertidoes) {
//		JobCertidao.qtdeCertidoes.set(qtdeCertidoes);
//	}
//}
