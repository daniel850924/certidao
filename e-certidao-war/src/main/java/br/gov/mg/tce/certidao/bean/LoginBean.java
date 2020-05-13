package br.gov.mg.tce.certidao.bean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal;

import br.gov.mg.tce.certidao.base.BaseBean;
import br.gov.mg.tce.certidao.security.CaptchaSecurity;
import br.gov.mg.tce.certidao.util.MascaraUtil;
import br.gov.mg.tce.util.Constantes;

@SessionScoped
@ManagedBean(name = "loginBean")
public class LoginBean extends BaseBean {

	private static final long serialVersionUID = -7850854601267038206L;
	
	private String cpf;
	private String valorImagem;
	private String captcha;
	private ArrayList<OrgaoResponsaveLegal> listaInstituicoes;
	String instituicaoUsuarioSelecionada;
	
	public String solicitarCertidao() {
		if(validaCampos()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().getSessionMap().put("cpfLogado", cpf);
			facesContext.getExternalContext().getSessionMap().put("captchaDigitado", captcha);
			return "/view/xhtml/solicitarCertidao.jsf";
		}
		return null;
	}
	
	public String consultarCertidao() {
		if(validaCampos()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().getSessionMap().put("cpfLogado", cpf);
			facesContext.getExternalContext().getSessionMap().put("captchaDigitado", captcha);
			return "/view/xhtml/consultarCertidao.jsf";
		}
		return null;
	}
	
	public boolean validaCampos() {
		boolean valido = true;
		
		if(cpf==null || cpf.equals("")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"O campo 'CPF' é obrigatório", ""));
			valido = false;
		} else if (!MascaraUtil.cpfValido(cpf)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"O CPF digitado não é válido", ""));
			valido = false;
		}
		
		if(valorImagem==null || valorImagem.equals("")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"O campo 'Valor da Imagem' é obrigatório", ""));
			valido = false;
		} else if (!captchaValido(valorImagem)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"O Valor da Imagem não condiz com os caracteres gerados na Imagem", ""));
			valido = false;
		}
		
		return valido;
	}
	
	public boolean captchaValido(String captchaDigitado) {
		boolean retorno = true;
		
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        javax.servlet.http.HttpSession session = request.getSession();
        
        String c = (String) session.getAttribute(CaptchaSecurity.CAPTCHA_KEY);
        if (!valorImagem.equals(c)) {
        	retorno = false;
        }
		return retorno;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getValorImagem() {
		return valorImagem;
	}
	public void setValorImagem(String valorImagem) {
		this.valorImagem = valorImagem;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public ArrayList<OrgaoResponsaveLegal> getListaInstituicoes() {
		
		if(listaInstituicoes == null){
			
			if (isSeUsuarioInternoTce()) {
				listaInstituicoes = new ArrayList<OrgaoResponsaveLegal>();
			} else {
			
				if(getUsuarioLogado().getOrgaosResponsavelLegal() != null){
					
					listaInstituicoes = new ArrayList<OrgaoResponsaveLegal>();
					
					for (int i = 0; i < getUsuarioLogado().getOrgaosResponsavelLegal().length; i++) {
						
						Boolean orgaoVigente = orgaoVigente(getUsuarioLogado().getOrgaosResponsavelLegal()[i]);
						
						if(orgaoVigente){
							
							listaInstituicoes.add(getUsuarioLogado().getOrgaosResponsavelLegal()[i]);
							
						}
						
					}
					
				}
			}
			
		}
		
		return listaInstituicoes;
	}
	
	public ArrayList<SelectItem> getListaInstituicoesUsuario(){
		
		ArrayList<SelectItem> listaInstiuicoesUsuario = new ArrayList<SelectItem>();
		
		if(getListaInstituicoes() != null && getListaInstituicoes().size() > 0){
			
			listaInstiuicoesUsuario.add(new SelectItem("", "Selecione"));
			
			for(OrgaoResponsaveLegal orgaoResponsaveLegal : getListaInstituicoes()){
				
				listaInstiuicoesUsuario.add(new SelectItem(orgaoResponsaveLegal.getCnpjOrgaoEntidade(), orgaoResponsaveLegal.getDenominacaoOrgao()));
				
			}
			
		}
		
		return listaInstiuicoesUsuario;
	}
	
	public void trocarInstituicao(){
		
		if(StringUtils.isNotBlank(instituicaoUsuarioSelecionada)){
			
			for(OrgaoResponsaveLegal orgaoResponsaveLegal : getListaInstituicoes()){
			
				if(orgaoResponsaveLegal.getCnpjOrgaoEntidade().equals(instituicaoUsuarioSelecionada)){
					getRequest().getSession().setAttribute(Constantes.INSTITUICAO_SELECIONADA, orgaoResponsaveLegal);
					removerSessao(Constantes.INSTITUICAO_SGI_SELECIONADA);
				}
				
			}
			
		}
	}
	
	public Boolean getExibeTrocaInstituicao(){
		
		if(getListaInstituicoes() != null && getListaInstituicoes().size() > 1){
			return true;
		}
		
		return false;
	}

	public void setListaInstituicoes(
			ArrayList<OrgaoResponsaveLegal> listaInstituicoes) {
		this.listaInstituicoes = listaInstituicoes;
	}

	public String getInstituicaoUsuarioSelecionada() {
		return instituicaoUsuarioSelecionada;
	}

	public void setInstituicaoUsuarioSelecionada(
			String instituicaoUsuarioSelecionada) {
		this.instituicaoUsuarioSelecionada = instituicaoUsuarioSelecionada;
	}

}
