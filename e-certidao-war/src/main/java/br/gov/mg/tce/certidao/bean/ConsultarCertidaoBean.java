package br.gov.mg.tce.certidao.bean;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.text.MaskFormatter;

import org.apache.commons.lang.StringUtils;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.gov.mg.tce.certidao.base.BaseBean;
import br.gov.mg.tce.certidao.datamodel.ConsultarSolicitacaoDTO;
import br.gov.mg.tce.certidao.datamodel.ConsultarSolicitacaoDataModel;
import br.gov.mg.tce.enumerator.EnumFormaEmissao;
import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.enumerator.EnumTipoSituacaoComumPeticaoCertidaoVwSgap;
import br.gov.mg.tce.enumerator.IndFinalidadeCertidaoEnum;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.enumerator.IndTipoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoBOLocal;
import br.gov.mg.tce.facade.CertidaoPCABOLocal;
import br.gov.mg.tce.facade.ControleVisualizaCertidaoBOLocal;
import br.gov.mg.tce.facade.IndicadorImplLocal;
import br.gov.mg.tce.facade.MunicipioImplLocal;
import br.gov.mg.tce.facade.PeticaoArquivoImplLocal;
import br.gov.mg.tce.facade.PeticaoImplLocal;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tce.model.Municipio;
import br.gov.mg.tce.model.TipoDocumentoPeticao;
import br.gov.mg.tce.model.TipoFinalidadePeticao;
import br.gov.mg.tce.model.VwArquivosPeticaoEletronica;
import br.gov.mg.tce.model.VwPeticaoEletronica;

@SessionScoped
@ManagedBean(name = "consultarCertidaoBean")
public class ConsultarCertidaoBean extends BaseBean {

	private static final long serialVersionUID = -2675830344126776195L;

	StreamedContent relatorio = null;
	
	private ArrayList<SelectItem> tipoCertidoes;
	private ArrayList<SelectItem> tipoInstituicoes;
	private ArrayList<SelectItem> orgaosEntidades;
	private String anoExercicio;
	private String tipoCertidaoSelecionado;
	private String tipoInstituicaoSelecionado;
	private String orgaoEntidadeSelecionado;
	
	private EnumTipoSituacaoComumPeticaoCertidaoVwSgap situacaoSelecionada;
	private EnumFormaEmissao formaSelecionada;
	
	private EnumTipoAnalise tipoAnaliseSelecionada;
	private Boolean habilitaBotaoVisualizarJustificativa;
	private Boolean habilitaBotaoVisualizarArquivo;
	
	private InputText inputAnoExercicio = new InputText();
	private InputText inputProtocolo = new InputText();
	private InputText inputNomePessoa = new InputText();
	private InputText inputNumCpf = new InputText();
	private IndTipoCertidaoEnum certidaoSelecionadaPesquisa;
	private IndFinalidadeCertidaoEnum finalidadeSelecionadaPesquisa;
		
	private ConsultarSolicitacaoDataModel listagem;
	private ConsultarSolicitacaoDTO certidaoSelecionada;
	private String msg; 
	
	private StreamedContent file;

	private List<SelectItem> listaCertidao = new ArrayList<SelectItem>();
	private List<SelectItem> listaFinalidade = new ArrayList<SelectItem>();
	private List<SelectItem> listaSituacao = new ArrayList<SelectItem>();
	private List<SelectItem> listaForma = new ArrayList<SelectItem>();
	private List<SelectItem> listaTipoAnalise = new ArrayList<SelectItem>();
	private List<TipoFinalidadePeticao> tipoFinalidade;
	private List<TipoDocumentoPeticao> indicadores;
	
	private Date dataIncioEmissao;
	private Date dataFimEmissao;
	
	
	private Map<String, Municipio> mapMunicipios;
	
	@EJB
	private PeticaoImplLocal peticaoService;
	@EJB
	private PeticaoArquivoImplLocal peticaoArquivoService;
	@EJB
	private IndicadorImplLocal indicadorImpl;
	@EJB
	private CertidaoBOLocal peticaoCertidaoBO;
	@EJB
	private CertidaoPCABOLocal certidaoPCABO;	
	@EJB
	private MunicipioImplLocal municipioImpl;
	@EJB
	private ControleVisualizaCertidaoBOLocal controleVisualizaCertidaoBO;
	@EJB
	private IndicadorImplLocal indicadorImplLocal;
	
	@PostConstruct
	private void init() {
		
		indicadores = indicadorImplLocal.buscarTipoCertidao();
		tipoFinalidade = indicadorImplLocal.buscarTipoFinalidadeCertidao();
		
		tipoCertidoes = new ArrayList<SelectItem>();
		tipoInstituicoes = new ArrayList<SelectItem>();
		orgaosEntidades = new ArrayList<SelectItem>();
		
		tipoInstituicaoSelecionado = "";
		tipoCertidaoSelecionado = "";
		orgaoEntidadeSelecionado = "";
		municipioSelecionado = null;
		situacaoSelecionada = null;
		tipoAnaliseSelecionada = null;
		
		listagem = new ConsultarSolicitacaoDataModel(new ArrayList<ConsultarSolicitacaoDTO>());
		certidaoSelecionada = null;
		
		habilitaBotaoVisualizarArquivo = false;
		habilitaBotaoVisualizarJustificativa = false;
		
		habilitaBotoes();
		
		listaCertidao.clear();
		listaCertidao.add(new SelectItem(null,"Selecione..."));
		 for (IndTipoCertidaoEnum indicador : IndTipoCertidaoEnum.values()) {
			listaCertidao.add(new SelectItem(indicador, indicador.getLabel()));
		}
		
		listaFinalidade.clear();
		listaFinalidade.add(new SelectItem(null,"Selecione..."));
		 for (IndFinalidadeCertidaoEnum finalidade : IndFinalidadeCertidaoEnum.values()) {
			listaFinalidade.add(new SelectItem(finalidade, finalidade.getLabel()));
		}
		
		listaSituacao.clear();
		listaSituacao.add(new SelectItem(StringUtils.EMPTY, "Selecione..."));
		for (EnumTipoSituacaoComumPeticaoCertidaoVwSgap situacao : EnumTipoSituacaoComumPeticaoCertidaoVwSgap.values()) {
			listaSituacao.add(new SelectItem(situacao, situacao.getDescricao()));
		}
		
		listaForma.clear();
		listaForma.add(new SelectItem(StringUtils.EMPTY, "Selecione..."));
		for (EnumFormaEmissao forma : EnumFormaEmissao.values()) {
			listaForma.add(new SelectItem(forma, forma.getDescricao()));
		}
		
		listaTipoAnalise.clear();
		listaTipoAnalise.add(new SelectItem(StringUtils.EMPTY, "Selecione..."));
		for (EnumTipoAnalise tipoAnalise : EnumTipoAnalise.values()) {
			listaTipoAnalise.add(new SelectItem(tipoAnalise, tipoAnalise.getDescricaoFiltro()));
		}
		
		listaMunicipio = municipioImpl.buscarMunicipios();
		preencherMapMunicipios(listaMunicipio);
		
	}
	
	private void preencherMapMunicipios(final List<Municipio> listaMunicipio) {
		mapMunicipios = new HashMap<String, Municipio>();
		
		for (Municipio municipio : listaMunicipio) {
			if (! mapMunicipios.containsKey(municipio.getCodMunicipioIBGE())) {
				mapMunicipios.put(municipio.getCodMunicipioIBGE(), municipio);
			}
		}
	}

	public String habilitaBotaoVisualizar(){
		return "";
	}
	
	public String carregarCertidao() {
		
		init();
		
		if (isSeUsuarioInternoTce()) {
			listagem = new ConsultarSolicitacaoDataModel(new ArrayList<ConsultarSolicitacaoDTO>());
			return "consultarCertidao";
			
		} else {
			ResponseRespLegalVigente usuarioLogado = getUsuarioLogado();
			VwPeticaoEletronica filtroVW = new VwPeticaoEletronica();
			Certidao peticaoFiltro = new Certidao();
			
			filtroVW.setNumCpfCnpf(Long.valueOf(usuarioLogado.getCpf()));
			peticaoFiltro.setNumCpfCnpf(Long.valueOf(usuarioLogado.getCpf()));
			peticaoFiltro.setNomeMunicipio(getOrgaoUsuarioLogadoSelecionado().getNomeMunicipio());
			return carregarListagemCompleta(filtroVW, peticaoFiltro);
		}
	}

	/**
	 * O IF contido neste metodo trata o preenchimento do filtro de TIPO DE ANALISE,
	 * pois, na VW_PETICAO_ELETRONICA nao possui esta informacao e apenas na 
	 * tabela PETICAO_CERTIDAO. 
	 * 
	 * @param filtroVW
	 * @param peticaoFiltro
	 * @return
	 */
	private String carregarListagemCompleta(final VwPeticaoEletronica filtroVW, final Certidao peticaoFiltro) {
		
		ArrayList<ConsultarSolicitacaoDTO> listaConsultaSolicitacao = new ArrayList<>();
		
		if (peticaoFiltro.getTipoAnalise() == null && (formaSelecionada == null || formaSelecionada.equals(EnumFormaEmissao.MANUAL))) {
			listaConsultaSolicitacao = obterRegistrosVw(filtroVW);
		}
		
		return carregarListagemCertidao(peticaoFiltro, listaConsultaSolicitacao);
	}

	private ArrayList<ConsultarSolicitacaoDTO> obterRegistrosVw(final VwPeticaoEletronica filtroVW) {
		
		List<VwPeticaoEletronica> buscarTodasPeticoes = peticaoService.buscarPeticaoPorFiltro(filtroVW);
		
		ArrayList<ConsultarSolicitacaoDTO> listaConsultaSolicitacao = new ArrayList<ConsultarSolicitacaoDTO>();
		
		for (VwPeticaoEletronica vw : buscarTodasPeticoes){
			
			if(vw.getDscSituacao().equals("DEFERIDO")){
				
				VwArquivosPeticaoEletronica arquivo = peticaoArquivoService.buscarUltimoArquivoPeticao(vw.getCodPeticao());

				if(arquivo != null && arquivo.getSglSituacaoAssinatura()!= null && arquivo.getSglSituacaoAssinatura().equals("D")){
					vw.setDscSituacao("DEFERIDO AGURADANDO ASSINATURA(S)");
				}
			}
			
			ConsultarSolicitacaoDTO consultarSolicitacaoDTO = new ConsultarSolicitacaoDTO(vw);
			
			preencherDescricaoMunicipio(vw.getCodMunicipioIbge(), consultarSolicitacaoDTO);
			
			listaConsultaSolicitacao.add(consultarSolicitacaoDTO);
		}
		return listaConsultaSolicitacao;
	}

	public String carregarListagemCertidao(final Certidao peticaoFiltro, final List<ConsultarSolicitacaoDTO> listaConsultaSolicitacao) {
		
		try {
			
			List<Certidao> result = null;
			if(formaSelecionada == null || formaSelecionada.equals(EnumFormaEmissao.ELETRONICA)){
				
				if(peticaoFiltro.getTipoAnalise() == null){
					result = peticaoCertidaoBO.consultarPeticoesPorFiltrosDTO(peticaoFiltro);
				}else{
					result = certidaoPCABO.consultarCertidaoPCAPorFiltros(peticaoFiltro);
				}
			}
			
			if(result != null){
				for (Certidao peticaoCertidao : result) {
					ConsultarSolicitacaoDTO consultarSolicitacaoDTO = new ConsultarSolicitacaoDTO(peticaoCertidao);
					preencherDescricaoMunicipio(String.valueOf(peticaoCertidao.getCodMunicipio()), consultarSolicitacaoDTO);
					
					listaConsultaSolicitacao.add(consultarSolicitacaoDTO);
				}
				preencherTipoAnalise(listaConsultaSolicitacao);
			}
			
			ordernarListagemPorDataSolicitacao(listaConsultaSolicitacao);
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Falha ao consultar no serviço.", null));
			listagem = new ConsultarSolicitacaoDataModel(listaConsultaSolicitacao);
			return "consultarCertidao";
		}
		
		for (ConsultarSolicitacaoDTO consultarSolicitacaoDTO : listaConsultaSolicitacao) {
			preencherDataVisualizacaoCertidao(consultarSolicitacaoDTO);
		}
		
		listagem = new ConsultarSolicitacaoDataModel(listaConsultaSolicitacao);
		return "consultarCertidao";

	}

	private void preencherTipoAnalise(List<ConsultarSolicitacaoDTO> listaConsultaSolicitacao) {
		
		for (ConsultarSolicitacaoDTO consultarSolicitacaoDTO : listaConsultaSolicitacao) {
			
			Certidao peticaoCertidao = consultarSolicitacaoDTO.getPeticaoCertidao();
			if(peticaoCertidao != null && !peticaoCertidao.getIndSituacao().equals(IndSituacaoCertidaoEnum.INDEFERIDA) 
					&& (IndTipoCertidaoEnum.FUNDEB.equals(peticaoCertidao.getIndTipoCertidao())
					|| IndTipoCertidaoEnum.GASTO_ENSINO.equals(peticaoCertidao.getIndTipoCertidao())
					|| IndTipoCertidaoEnum.GASTO_PESSOAL.equals(peticaoCertidao.getIndTipoCertidao())
					|| IndTipoCertidaoEnum.GASTO_SAUDE.equals(peticaoCertidao.getIndTipoCertidao())
					|| IndTipoCertidaoEnum.GERAL.equals(peticaoCertidao.getIndTipoCertidao()))){
				
				EnumTipoAnalise tipoAnalise = EnumTipoAnalise.getEnumBySigla(certidaoPCABO.obter(peticaoCertidao.getCodCertidao()).getSglTipoAnalise());
				consultarSolicitacaoDTO.setDscTipoAnalise(tipoAnalise.getDescricao());
			}
		}
		
	}

	private void ordernarListagemPorDataSolicitacao(final List<ConsultarSolicitacaoDTO> listaConsultaSolicitacao) {
		Collections.sort(listaConsultaSolicitacao, new Comparator<ConsultarSolicitacaoDTO>() {
			@Override
			public int compare(ConsultarSolicitacaoDTO o1, ConsultarSolicitacaoDTO o2) {
				return o2.getDatSolicitacao().compareTo(o1.getDatSolicitacao());
			}
		});
	}
	
	private void preencherDataVisualizacaoCertidao(ConsultarSolicitacaoDTO consultarSolicitacaoDTO) {
		Date dataVisualizacao = controleVisualizaCertidaoBO.obterDataVisualizacaoPorProtocolo(consultarSolicitacaoDTO.getProtocoloEditado());
		consultarSolicitacaoDTO.setDatVisualizacaoCertidao(dataVisualizacao);
	}

	private void preencherDescricaoMunicipio(String codMunicipioIbge, ConsultarSolicitacaoDTO consultarSolicitacaoDTO) {
		if (isSeUsuarioInternoTce()) {
			Municipio municipio = mapMunicipios.get(codMunicipioIbge);
			consultarSolicitacaoDTO.setDscMunicipio((municipio != null) ? municipio.getDescMunicipio() : null);
		} else {
			consultarSolicitacaoDTO.setDscMunicipio(getOrgaoUsuarioLogadoSelecionado().getNomeMunicipio());
		}
	}

	public String limparCampos() {
		
		inputAnoExercicio.setValue(""); 
		inputProtocolo.setValue("");
		inputNomePessoa.setValue("");
		inputNumCpf.setValue("");
		certidaoSelecionadaPesquisa = null;
		finalidadeSelecionadaPesquisa = null;
		municipioSelecionado = null;
		situacaoSelecionada  = null;
		tipoAnaliseSelecionada = null;
		
		return "consultarCertidao";
	}
	
	public String pesquisarCertidao() {
		
		VwPeticaoEletronica filtroVW = new VwPeticaoEletronica();
		Certidao peticaoFiltro = new Certidao();
		
		preencherFiltroPesquisa(filtroVW, peticaoFiltro);
		
		return carregarListagemCompleta(filtroVW, peticaoFiltro);
		
	}

	private void preencherFiltroPesquisa(final VwPeticaoEletronica vw, final Certidao peticaoFiltro) {
		
		peticaoFiltro.setDataIncioEmissao(dataIncioEmissao);
		peticaoFiltro.setDataFimEmissao(dataFimEmissao);
		vw.setDataIncioEmissao(dataIncioEmissao);
		vw.setDataFimEmissao(dataFimEmissao);
		
		
		String protocolo = (String) inputProtocolo.getValue(); 
		String ano = (String) inputAnoExercicio.getValue(); 
		//String nomePessoa = (String) inputNomePessoa.getValue(); 
		
		ResponseRespLegalVigente usuarioLogado = getUsuarioLogado();
		String numCpf = (isSeUsuarioInternoTce()) ? StringUtils.EMPTY : (String) usuarioLogado.getCpf();
		
		if(protocolo!= null && !"".equals(protocolo)){
			vw.setProtocoloEditado(protocolo);
			peticaoFiltro.setNumProtocolo(Long.valueOf(protocolo.replace(".", "")));
		}
		if(ano!= null && !"".equals(ano)){
			vw.setNumAnoRef(Integer.parseInt(ano));
			peticaoFiltro.setNumAnoRef(Integer.parseInt(ano));
		}
		if(numCpf!= null && !"".equals(numCpf)){
			vw.setNumCpfCnpf(Long.parseLong(numCpf));
			peticaoFiltro.setNumCpfCnpf(Long.parseLong(numCpf));
		}
		
		if(certidaoSelecionadaPesquisa != null){
			for (TipoDocumentoPeticao documentoPeticao : indicadores) {
				if(documentoPeticao.getSglIndicador().equalsIgnoreCase(certidaoSelecionadaPesquisa.getId())){
					vw.setCodTipoDocPeticao(documentoPeticao.getId());
					peticaoFiltro.setIndTipoCertidao(certidaoSelecionadaPesquisa);
					break;
				}
			}
		}
		
		if(finalidadeSelecionadaPesquisa != null){
			
			for (TipoFinalidadePeticao finalidade : tipoFinalidade) {
				if(finalidade.getSglIndicador().equalsIgnoreCase(finalidadeSelecionadaPesquisa.getId())){
					vw.setCodFinalidade(finalidade.getId());
					peticaoFiltro.setIndFinalidade(finalidadeSelecionadaPesquisa);
					break;
				}
			}
		}
		
		if (municipioSelecionado != null) {
			vw.setCodMunicipioIbge(municipioSelecionado.getCodMunicipioIBGE());
			peticaoFiltro.setCodMunicipio(Long.valueOf(municipioSelecionado.getCodMunicipioIBGE()));
		}
		
		if (situacaoSelecionada != null) {
			vw.setSglSituacao(situacaoSelecionada.getSiglaSituacaoVwSgap());
			peticaoFiltro.setIndSituacao(IndSituacaoCertidaoEnum.getPorId(situacaoSelecionada.getSiglaSituacaoPeticao()));
		}
		
		/* ESTE FILTRO E REALIZADO APENAS NA TABELA CERTIDAO_PCA. A VW NAO POSSUI ESTE FILTRO*/
		if (tipoAnaliseSelecionada != null) {
			peticaoFiltro.setTipoAnalise(tipoAnaliseSelecionada);
		}
	}
		
	public StreamedContent recuperaRelatorio()  throws Exception {
		if(certidaoSelecionada!=null) {
		
			return relatorio;
		}
		
		return null;
	}
	
	public void visualizarJustificativa(){
		if (certidaoSelecionada.getViewPeticaoEletronica() != null){
			this.msg = certidaoSelecionada.getViewPeticaoEletronica().getDscMotivo();
			RequestContext.getCurrentInstance().execute("popupConsultarJustificativa.show();");
		}
		if (certidaoSelecionada.getPeticaoCertidao() != null){
			this.msg = certidaoSelecionada.getPeticaoCertidao().getDscIndeferidoJustificativa();
			RequestContext.getCurrentInstance().execute("popupConsultarJustificativa.show();");
		}
		
	}
	
	public void habilitaBotoes() {
		habilitaBotaoVisualizarArquivo = true;
		habilitaBotaoVisualizarJustificativa = true;
		if(certidaoSelecionada != null && certidaoSelecionada.getViewPeticaoEletronica() != null){
			if(certidaoSelecionada.getViewPeticaoEletronica().getDscMotivo() !="" && certidaoSelecionada.getViewPeticaoEletronica().getDscMotivo() != null) {
			
				habilitaBotaoVisualizarJustificativa = false;
				
			}
			
			if(certidaoSelecionada.getViewPeticaoEletronica().getCodPeticao() !=null ){
			
				boolean verificaExisteArquivo = peticaoArquivoService.verificaExisteArquivo(certidaoSelecionada.getViewPeticaoEletronica().getCodPeticao());
				
				if( verificaExisteArquivo ){
					
					habilitaBotaoVisualizarArquivo =false;
				}
			}
		}else{
			if (certidaoSelecionada != null && certidaoSelecionada.getPeticaoCertidao() != null){
					habilitaBotaoVisualizarArquivo = certidaoSelecionada.getPeticaoCertidao().getArqCertidaoPdf() == null;
					if (certidaoSelecionada.getPeticaoCertidao().getDscIndeferidoJustificativa() != null && !certidaoSelecionada.getPeticaoCertidao().getDscIndeferidoJustificativa().isEmpty()){
						habilitaBotaoVisualizarJustificativa = false;
					}
			}
		}
	}
	
	public void obterArquivo(){
		if (certidaoSelecionada != null ){
			if (certidaoSelecionada.getViewPeticaoEletronica() != null){
				ArrayList<VwArquivosPeticaoEletronica> listaPeticoes = peticaoArquivoService.buscarArquivosPeticoes(certidaoSelecionada.getViewPeticaoEletronica().getCodPeticao());
				setFile(new DefaultStreamedContent(new ByteArrayInputStream(((VwArquivosPeticaoEletronica)listaPeticoes.get(0)).getArqProcessoPdf()), "application/pdf", "Documento.pdf"));
				
				gravarVisualizacaoCertidaoJurisdicionado(certidaoSelecionada.getViewPeticaoEletronica().getProtocolo());
				
			}else if (certidaoSelecionada.getPeticaoCertidao() != null){
				try {

					byte[] arquivoCertidao = null;
					
					arquivoCertidao = peticaoCertidaoBO.recuperaArquivoCertidaoPorId(certidaoSelecionada.getPeticaoCertidao().getCodCertidao());
					setFile(new DefaultStreamedContent(new ByteArrayInputStream(arquivoCertidao), "application/pdf", "Documento.pdf"));
					
					gravarVisualizacaoCertidaoJurisdicionado(certidaoSelecionada.getPeticaoCertidao().getNumProtocolo().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	/**
	 * Metodo Responsavel por gravar a visualizacao da certidao pelo
	 * jusrisdicionado apenas. Para usuario interno do TCE nao e gravado.
	 * 
	 * @param numProtocolo
	 */
	private void gravarVisualizacaoCertidaoJurisdicionado(String numProtocolo) {
		if (!isSeUsuarioInternoTce()) {
			controleVisualizaCertidaoBO.gravarVisualizacaoCertidaoJurisdicionado(getUsuarioLogado().getCpf(), numProtocolo);
		}
	}

	public String getRecuperaCpfLogado() {
		String retorno = "";
		ResponseRespLegalVigente usuarioLogado = getUsuarioLogado();
		if(usuarioLogado != null && usuarioLogado.getCpf() != null) {
			retorno = format("###.###.###-##", usuarioLogado.getCpf());
		}
		return retorno;
	}
	
	private static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
	
	// AUTOCOMPLETE FILTROS
	
	// GETTERs AND SETTERs

	public String voltarPaginaInicial() {
		return "/login.jsf";
	}
	
	public ArrayList<SelectItem> getTipoCertidoes() {
		return tipoCertidoes;
	}

	public void setTipoCertidoes(ArrayList<SelectItem> tipoCertidoes) {
		this.tipoCertidoes = tipoCertidoes;
	}

	public ArrayList<SelectItem> getTipoInstituicoes() {
		return tipoInstituicoes;
	}

	public void setTipoInstituicoes(ArrayList<SelectItem> tipoInstituicoes) {
		this.tipoInstituicoes = tipoInstituicoes;
	}

	public ArrayList<SelectItem> getOrgaosEntidades() {
		return orgaosEntidades;
	}

	public void setOrgaosEntidades(ArrayList<SelectItem> orgaosEntidades) {
		this.orgaosEntidades = orgaosEntidades;
	}

	public String getAnoExercicio() {
		return anoExercicio;
	}

	public void setAnoExercicio(String anoExercicio) {
		this.anoExercicio = anoExercicio;
	}

	public String getTipoCertidaoSelecionado() {
		return tipoCertidaoSelecionado;
	}

	public void setTipoCertidaoSelecionado(String tipoCertidaoSelecionado) {
		this.tipoCertidaoSelecionado = tipoCertidaoSelecionado;
	}

	public String getTipoInstituicaoSelecionado() {
		return tipoInstituicaoSelecionado;
	}

	public void setTipoInstituicaoSelecionado(String tipoInstituicaoSelecionado) {
		this.tipoInstituicaoSelecionado = tipoInstituicaoSelecionado;
	}

	public String getOrgaoEntidadeSelecionado() {
		return orgaoEntidadeSelecionado;
	}

	public void setOrgaoEntidadeSelecionado(String orgaoEntidadeSelecionado) {
		this.orgaoEntidadeSelecionado = orgaoEntidadeSelecionado;
	}

	public ConsultarSolicitacaoDataModel getListagem() {
		return listagem;
	}

	public void setListagem(ConsultarSolicitacaoDataModel listagem) {
		this.listagem = listagem;
	}


	public ConsultarSolicitacaoDTO getCertidaoSelecionada() {
		return certidaoSelecionada;
	}

	public void setCertidaoSelecionada(ConsultarSolicitacaoDTO certidaoSelecionada) {
		this.certidaoSelecionada = certidaoSelecionada;
	}

	public StreamedContent getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(StreamedContent relatorio) {
		this.relatorio = relatorio;
	}

	public InputText getInputAnoExercicio() {
		return inputAnoExercicio;
	}

	public void setInputAnoExercicio(InputText inputAnoExercicio) {
		this.inputAnoExercicio = inputAnoExercicio;
	}

	public InputText getInputProtocolo() {
		return inputProtocolo;
	}

	public void setInputProtocolo(InputText inputProtocolo) {
		this.inputProtocolo = inputProtocolo;
	}

	public InputText getInputNomePessoa() {
		return inputNomePessoa;
	}

	public void setInputNomePessoa(InputText inputNomePessoa) {
		this.inputNomePessoa = inputNomePessoa;
	}

	public InputText getInputNumCpf() {
		return inputNumCpf;
	}

	public void setInputNumCpf(InputText inputNumCpf) {
		this.inputNumCpf = inputNumCpf;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getHabilitaBotaoVisualizarJustificativa() {
		return habilitaBotaoVisualizarJustificativa;
	}

	public void setHabilitaBotaoVisualizarJustificativa(
			Boolean habilitaBotaoVisualizarJustificativa) {
		this.habilitaBotaoVisualizarJustificativa = habilitaBotaoVisualizarJustificativa;
	}

	public Boolean getHabilitaBotaoVisualizarArquivo() {
		return habilitaBotaoVisualizarArquivo;
	}

	public void setHabilitaBotaoVisualizarArquivo(
			Boolean habilitaBotaoVisualizarArquivo) {
		this.habilitaBotaoVisualizarArquivo = habilitaBotaoVisualizarArquivo;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public List<SelectItem> getListaCertidao() {
		return listaCertidao;
	}

	public void setListaCertidao(List<SelectItem> listaCertidao) {
		this.listaCertidao = listaCertidao;
	}

	public List<SelectItem> getListaFinalidade() {
		return listaFinalidade;
	}

	public void setListaFinalidade(ArrayList<SelectItem> listaFinalidade) {
		this.listaFinalidade = listaFinalidade;
	}

	public IndTipoCertidaoEnum getCertidaoSelecionadaPesquisa() {
		return certidaoSelecionadaPesquisa;
	}

	public void setCertidaoSelecionadaPesquisa(IndTipoCertidaoEnum certidaoSelecionadaPesquisa) {
		this.certidaoSelecionadaPesquisa = certidaoSelecionadaPesquisa;
	}

	public IndFinalidadeCertidaoEnum getFinalidadeSelecionadaPesquisa() {
		return finalidadeSelecionadaPesquisa;
	}

	public void setFinalidadeSelecionadaPesquisa(
			IndFinalidadeCertidaoEnum finalidadeSelecionadaPesquisa) {
		this.finalidadeSelecionadaPesquisa = finalidadeSelecionadaPesquisa;
	}

	public EnumTipoSituacaoComumPeticaoCertidaoVwSgap getSituacaoSelecionada() {
		return situacaoSelecionada;
	}

	public void setSituacaoSelecionada(EnumTipoSituacaoComumPeticaoCertidaoVwSgap situacaoSelecionada) {
		this.situacaoSelecionada = situacaoSelecionada;
	}

	public List<SelectItem> getListaSituacao() {
		return listaSituacao;
	}

	public void setListaSituacao(List<SelectItem> listaSituacao) {
		this.listaSituacao = listaSituacao;
	}

	public List<SelectItem> getListaTipoAnalise() {
		return listaTipoAnalise;
	}

	public void setListaTipoAnalise(ArrayList<SelectItem> listaTipoAnalise) {
		this.listaTipoAnalise = listaTipoAnalise;
	}

	public EnumTipoAnalise getTipoAnaliseSelecionada() {
		return tipoAnaliseSelecionada;
	}

	public void setTipoAnaliseSelecionada(EnumTipoAnalise tipoAnaliseSelecionada) {
		this.tipoAnaliseSelecionada = tipoAnaliseSelecionada;
	}

	public Date getDataIncioEmissao() {
		return dataIncioEmissao;
	}

	public void setDataIncioEmissao(Date dataIncioEmissao) {
		this.dataIncioEmissao = dataIncioEmissao;
	}

	public Date getDataFimEmissao() {
		return dataFimEmissao;
	}

	public void setDataFimEmissao(Date dataFimEmissao) {
		this.dataFimEmissao = dataFimEmissao;
	}

	public List<SelectItem> getListaForma() {
		return listaForma;
	}

	public void setListaForma(List<SelectItem> listaForma) {
		this.listaForma = listaForma;
	}

	public EnumFormaEmissao getFormaSelecionada() {
		return formaSelecionada;
	}

	public void setFormaSelecionada(EnumFormaEmissao formaSelecionada) {
		this.formaSelecionada = formaSelecionada;
	}
	
}
