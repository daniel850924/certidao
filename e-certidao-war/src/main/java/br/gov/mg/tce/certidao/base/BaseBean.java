package br.gov.mg.tce.certidao.base;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente;
import org.tempuri.IWsSgiAutenticacaoProxy;

import br.gov.mg.tce.certidao.util.DateUtil;
import br.gov.mg.tce.certidao.util.MensagemUtil;
import br.gov.mg.tce.facade.MunicipioImplLocal;
import br.gov.mg.tce.model.Municipio;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.util.StringUtil;

public class BaseBean implements Serializable {

	private static final long serialVersionUID = -6329759962195098991L;
	protected MensagemUtil mensagem;
	protected boolean exibeMsgErro;
	protected boolean exibeMsgAlerta;
	protected boolean exibeMsgInfo;
	
	private boolean seUsuarioInternoTce;
	
	protected List<Municipio> listaMunicipio;
	protected Municipio municipioSelecionado;
	
	@EJB
	private MunicipioImplLocal municipioImpl;
	
	@PostConstruct
	public void initBase(){
        listaMunicipio = municipioImpl.buscarMunicipios();
	}
	
	public List<Municipio> completarObjetoMunicipio(String query) {
		List<Municipio> listaRetorno = new ArrayList<Municipio>();
		
		for (Municipio municipio : listaMunicipio) {
			String queryNormalizada = Normalizer.normalize(query.toLowerCase().trim(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			String dscMunicipioNormalizado = Normalizer.normalize(municipio.getDescMunicipio().toLowerCase().trim(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			if (StringUtil.verificaExisteTexto(queryNormalizada, dscMunicipioNormalizado)) {
				listaRetorno.add(municipio);
				
				if (listaRetorno.size() > Constantes.TAMANHO_MAX_ITEM_COMBO) {
					return listaRetorno;
				}
			}
		}
		return listaRetorno;
	}
	
	public String obterTextoExibicaoMunicipio(Municipio municipio) {
		if (municipio != null) {
			return listaMunicipio.get(listaMunicipio.indexOf(municipio)).getDescMunicipio();
		}
		return null;
	}
	
	public Municipio getMunicipioSelecionado() {
		return municipioSelecionado;
	}

	public void setMunicipioSelecionado(Municipio municipioSelecionado) {
		this.municipioSelecionado = municipioSelecionado;
	}
	
//	@SuppressWarnings("rawtypes")
//	public StreamedContent gerarRelatorio(HashMap<String, Object> parametros, String nomeRelatorio) throws JRException, CertidaoException{
//		
//		StreamedContent relatorio;
//		
//		byte[] byteArrayRelatorio = relatorioService.gerarByteArrayRelatorio(parametros, nomeRelatorio);
//		
//		try{
//			
//			String tituloCertidao = "";
//			String tituloRelatorio = "";
//			
//			Iterator it = parametros.entrySet().iterator();
//		    while (it.hasNext()) {
//		        Map.Entry pairs = (Map.Entry)it.next();
//		        if(pairs.getKey().equals(Constantes.REL_P_TITULO_CERTIDAO)) {
//		        	tituloCertidao = (String) pairs.getValue();
//		        }
//		        if(pairs.getKey().equals(Constantes.REL_P_TITULO_RELATORIO)) {
//		        	tituloRelatorio = (String) pairs.getValue();
//		        }
//		    }
//			
//		    String nomeRelatorioImpresso = tituloCertidao + "-" + tituloRelatorio;
//			if(byteArrayRelatorio != null){
//				relatorio = new DefaultStreamedContent(new ByteArrayInputStream(byteArrayRelatorio), "application/pdf", retiraEspacosParaRelatorio(nomeRelatorioImpresso) + ".pdf");
//			}else{
//				relatorio = null;
//			}
//			
//		}catch (Exception e) {
//			relatorio = null;
//			e.printStackTrace();
//		}
//		
//		return relatorio;
//	}
	
	
	public String retiraEspacosParaRelatorio(String nomeRelatorio) {
		nomeRelatorio = Normalizer.normalize(nomeRelatorio, Normalizer.Form.NFD);
		nomeRelatorio = nomeRelatorio.replaceAll("[^\\p{ASCII}]", "");
		return nomeRelatorio.replace(" ", "_");
	}
	
	public void enviarSessao(Object valor, String label){
		getAtributte().put(label, valor);
	}
	
	public void removerSessao(String label){
		getAtributte().remove(label);
	}
	
	public Object obterSessao(String label){
		return getAtributte().get(label);
	}
	
	public void setarMensagem(String titulo,String msg,String tipo){
		getAtributte().put(Constantes.MSG_SESSAO, new MensagemUtil(titulo, msg, tipo));
	}
	
	public MensagemUtil obterMensagem() {
		return (MensagemUtil) getAtributte().get(Constantes.MSG_SESSAO);
	}
	
	public void limparMensagem(){
		getAtributte().remove(Constantes.MSG_SESSAO);
	}
	
	public String getRecuperaNomeUsuario() {
		
		try{
			if (isSeUsuarioInternoTce()) {
				return getUsuarioInternoTceLogado().getNome();
			} else {
				return getUsuarioLogado().getNomeResponsavelLegal();
			}
			
		}catch (Exception e) {
		}
		
		return "Usuário";
	}
	
	public ResponseRespLegalVigente getUsuarioLogado(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		ResponseRespLegalVigente usuarioLogado = (ResponseRespLegalVigente) context.getExternalContext().getSessionMap().get(Constantes.USUARIO_LOGADO);
		
		return usuarioLogado;
	}
	
	public PessoaFisica getUsuarioInternoTceLogado(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		PessoaFisica usuarioLogado = (PessoaFisica) context.getExternalContext().getSessionMap().get(Constantes.USUARIO_INTERNO_TCE_LOGADO);
		
		return usuarioLogado;
	}
	
	public OrgaoResponsaveLegal getOrgaoUsuarioLogadoSelecionado(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		return (OrgaoResponsaveLegal) context.getExternalContext().getSessionMap().get(Constantes.INSTITUICAO_SELECIONADA);
	}
	
	public OrgaoEntidade getOrgaoSGISelecionado(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		return (OrgaoEntidade) context.getExternalContext().getSessionMap().get(Constantes.INSTITUICAO_SGI_SELECIONADA);
	}
	
	public List<OrgaoEntidade> getListaOrgaosSGI(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		return (List<OrgaoEntidade>) context.getExternalContext().getSessionMap().get(Constantes.LISTA_INSTITUICOES_SGI);
	}
	
	public IWsSgiAutenticacaoProxy getServicoConsultarOrgaoSGI() throws Exception{
		
		IWsSgiAutenticacaoProxy proxy = new IWsSgiAutenticacaoProxy(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.WSDL_BUSCAR_ORGAO_SGI));
		
//		IWsSgiAutenticacao iWsSgiAutenticacaoProxy = new WsSgiAutenticacaoLocator(
//				PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.WSDL_BUSCAR_ORGAO_SGI), new javax.xml.namespace.QName("http://tempuri.org/", "WsSgiAutenticacao")).getBasicHttpBinding_IWsSgiAutenticacao();
		
		return proxy;
	}	
	
	public Boolean orgaoVigente(OrgaoResponsaveLegal orgaoResponsaveLegal){
		
		Boolean orgaoVigente = false;
		
		Date dataHoje = new Date();
		Date dataInicioVigencia = orgaoResponsaveLegal.getDataInicioVigencia() != null ? orgaoResponsaveLegal.getDataInicioVigencia().getTime() : null;
		Date dataFimVigencia = orgaoResponsaveLegal.getDataFimVigencia() != null ? orgaoResponsaveLegal.getDataFimVigencia().getTime() : null;
		
		orgaoVigente = DateUtil.estaNoIntervalo(dataHoje, dataInicioVigencia, dataFimVigencia, true);
		
		return orgaoVigente;
	}
	
	public boolean isExibeMsgErro() {
		exibeMsgErro = false;
		MensagemUtil mensagemUtil = obterMensagem();
		if(mensagemUtil != null){
			if(mensagemUtil.getTipo().equalsIgnoreCase(Constantes.TIPO_MSG_ERRO)){
				exibeMsgErro = true;
				mensagem = mensagemUtil;
				limparMensagem();
			}
		}
		return exibeMsgErro;
	}

	public void setExibeMsgErro(boolean exibeMsgErro) {
		this.exibeMsgErro = exibeMsgErro;
	}

	public boolean isExibeMsgAlerta() {
		exibeMsgAlerta = false;
		MensagemUtil mensagemUtil = obterMensagem();
		if(mensagemUtil != null){
			if(mensagemUtil.getTipo().equalsIgnoreCase(Constantes.TIPO_MSG_ALERTA)){
				exibeMsgAlerta = true;
				mensagem = mensagemUtil;
				limparMensagem();
			}
		}
		return exibeMsgAlerta;
	}

	public void setExibeMsgAlerta(boolean exibeMsgAlerta) {
		this.exibeMsgAlerta = exibeMsgAlerta;
	}

	public boolean isExibeMsgInfo() {
		exibeMsgInfo = false;
		MensagemUtil mensagemUtil = obterMensagem();
		if(mensagemUtil != null){
			if(mensagemUtil.getTipo().equalsIgnoreCase(Constantes.TIPO_MSG_INFO)){
				exibeMsgInfo = true;
				mensagem = mensagemUtil;
				limparMensagem();
			}
		}
		return exibeMsgInfo;
	}

	public void setExibeMsgInfo(boolean exibeMsgInfo) {
		this.exibeMsgInfo = exibeMsgInfo;
	}
	
	/* ========================== */
	
	//ENVIA USUARIO SESSAO
	/*public void enviarUsuarioLogadoSessao(ActionEvent event){
		try{
			Object authentication = SecurityContextHolder.getContext().getAuthentication();
			LoginDAO loginDAO = new LoginDAO();
			String nomeUsuario = "";
			if(authentication instanceof Authentication)   
            {   
				nomeUsuario = ((User)((Authentication) authentication).getPrincipal()).getUsername();   
            }
			Usuario usuarioLogado = loginDAO.procurarUsuario(nomeUsuario);
			getAtributte().put("UsuarioLogado", usuarioLogado);
		}catch (Exception e) {
			getAtributte().remove("UsuarioLogado");
		}
		
	}
	
	public Usuario getUsuarioLogado(){
		Usuario usuRetorno = null;
		try{
			usuRetorno = (Usuario) getAtributte().get("UsuarioLogado");
			
			if(usuRetorno == null){

				Object authentication = SecurityContextHolder.getContext().getAuthentication();
				LoginDAO loginDAO = new LoginDAO();
				String nomeUsuario = "";
				if(authentication instanceof Authentication)   
		        {   
					nomeUsuario = ((User)((Authentication) authentication).getPrincipal()).getUsername();   
		        }
				usuRetorno = loginDAO.procurarUsuario(nomeUsuario);
				getAtributte().put("UsuarioLogado", usuRetorno);

			}
			
		}catch (Exception e) {
			usuRetorno = null;
			getAtributte().remove("UsuarioLogado");
		}
		
		return usuRetorno;
	}*/

	public Map<String, Object> getAtributte() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
	}
	
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	
	public void sair(){
		try{
			
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
			response.sendRedirect("http://www.tce.mg.gov.br/");  
	        FacesContext.getCurrentInstance().responseComplete(); 
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        
		}catch (Exception e) {
		}

	}

	public String redirecionarPaginaAcordao(){
		return "principal";
	}
	
	public String redirecionarPaginaRelatorio(){
		return "relatorio";
	}
	
	public String redirecionarPaginaInicial(){
		return "paginaInicial";
	}
	
	public String redirecionarPaginaDespacho(){
		return "despacho";
	}

	public MensagemUtil getMensagem() {
		return mensagem;
	}

	public void setMensagem(MensagemUtil mensagem) {
		this.mensagem = mensagem;
	}

	public boolean obterSeLoginUsuarioInternoTce() {
		Boolean isUsuarioInternoTce = (Boolean) obterSessao(Constantes.USUARIO_INTERNO_TCE);
		return (isUsuarioInternoTce == null) ? Boolean.FALSE : isUsuarioInternoTce;
	}
	
	public boolean isSeUsuarioInternoTce() {
		seUsuarioInternoTce = obterSeLoginUsuarioInternoTce();
		return seUsuarioInternoTce;
	}

	public void setSeUsuarioInternoTce(boolean seUsuarioInternoTce) {
		this.seUsuarioInternoTce = seUsuarioInternoTce;
	}

	public List<Municipio> getListaMunicipio() {
		return listaMunicipio;
	}

	public void setListaMunicipio(List<Municipio> listaMunicipio) {
		this.listaMunicipio = listaMunicipio;
	}

}
