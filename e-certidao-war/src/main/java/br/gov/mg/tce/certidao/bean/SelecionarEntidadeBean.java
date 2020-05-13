package br.gov.mg.tce.certidao.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCnpj;

import br.gov.mg.tce.certidao.base.BaseBean;
import br.gov.mg.tce.util.Constantes;

@SessionScoped
@ManagedBean(name = "selecionarEntidadeBean")
public class SelecionarEntidadeBean extends BaseBean {

	private static final long serialVersionUID = -1976770490571908815L;

	private ArrayList<OrgaoEntidade> listaEntidade = new ArrayList<OrgaoEntidade>();
	private OrgaoEntidade entidadeSelecionada;
	
	
	@PostConstruct
	private void init() {
		
		carregarComboEntidade();
		
	}
	
	public ArrayList<OrgaoEntidade> getListaEntidade() {
		return listaEntidade;
	}

	public void setListaEntidade(ArrayList<OrgaoEntidade> listaEntidade) {
		this.listaEntidade = listaEntidade;
	}

	private void carregarComboEntidade(){
		
		ResponseConsultarOrgaoCnpj responseConsultarOrgaoCnpj = pesquisarOrgaosSGI();
		
		if( (responseConsultarOrgaoCnpj != null &&  ! responseConsultarOrgaoCnpj.getHasError()) && 
				(responseConsultarOrgaoCnpj.getOrgaoEntidade() != null && responseConsultarOrgaoCnpj.getOrgaoEntidade().length > 0)){
			
			for (int i = 0; i < responseConsultarOrgaoCnpj.getOrgaoEntidade().length; i++) {
				
				OrgaoEntidade orgaoEntidade = responseConsultarOrgaoCnpj.getOrgaoEntidade()[i];
				
				listaEntidade.add(orgaoEntidade);
				//listaEntidade.add(new SelectItem(orgaoEntidade.getCodigoOrgaoEntidade(), orgaoEntidade.getDenominacaoOrgao()));
				
			}
			
		}
		
	}
	
	private ResponseConsultarOrgaoCnpj pesquisarOrgaosSGI(){
		
		try {
			
			OrgaoResponsaveLegal orgaoUsuarioLogadoSelecionado = getOrgaoUsuarioLogadoSelecionado();
			
			ResponseConsultarOrgaoCnpj responseConsultarOrgaoCnpj = getServicoConsultarOrgaoSGI().consultarOrgaoCNPJ(Constantes.NOME_SISTEMA, orgaoUsuarioLogadoSelecionado.getCnpjOrgaoEntidade(), null);
			
			return responseConsultarOrgaoCnpj;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void validaEntidade() throws Exception{
		
		if(entidadeSelecionada == null || "".equals(entidadeSelecionada)){
			String msg = "Favor selecionar uma entidade!";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null));
			throw new Exception("Favor selecionar uma entidade!");
			
		}
		
	}
	
	public String avancar(){
		
		enviarSessao(entidadeSelecionada, Constantes.INSTITUICAO_SGI_SELECIONADA);
		enviarSessao(listaEntidade, Constantes.LISTA_INSTITUICOES_SGI);
		
		return "principal";
	}
	
	public String habilitaBotaoVisualizar(){
		return "";
	}
	
	public OrgaoEntidade getEntidadeSelecionada() {
		return entidadeSelecionada;
	}

	public void setEntidadeSelecionada(OrgaoEntidade entidadeSelecionada) {
		this.entidadeSelecionada = entidadeSelecionada;
	}
	
}
