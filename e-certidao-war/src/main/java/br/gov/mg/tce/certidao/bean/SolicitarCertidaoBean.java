package br.gov.mg.tce.certidao.bean;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.text.MaskFormatter;

import org.codehaus.plexus.util.ExceptionUtils;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCnpj;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente;
import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;

import br.gov.mg.tce.certidao.base.BaseBean;
import br.gov.mg.tce.certidao.util.MascaraUtil;
import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.enumerator.IndFinalidadeCertidaoEnum;
import br.gov.mg.tce.enumerator.IndSimNaoEnum;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.enumerator.IndTipoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoBOLocal;
import br.gov.mg.tce.facade.CertidaoLimitesBOLocal;
import br.gov.mg.tce.facade.CertidaoPCABOLocal;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.facade.IndicadorImplLocal;
import br.gov.mg.tce.facade.MunicipioImplLocal;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tce.model.CertidaoCompetenciaTributaria;
import br.gov.mg.tce.model.CertidaoLimites;
import br.gov.mg.tce.model.CertidaoOperacaoCredito;
import br.gov.mg.tce.model.Municipio;
import br.gov.mg.tce.model.TipoDocumentoPeticao;
import br.gov.mg.tce.model.TipoFinalidadePeticao;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tcemg.util.DateUtil;

@SessionScoped
@ManagedBean(name = "solicitarCertidaoBean")
public class SolicitarCertidaoBean extends BaseBean {

	private static final String BRAZOPOLIS = "BRAZ\u00D3POLIS";

	private static final String BRASOPOLIS = "BRAS\u00D3POLIS";
	
    private static final long serialVersionUID = 6286548953458239116L;

    @EJB
    private CertidaoBOLocal certidaoBO;
    @EJB
    private CertidaoLimitesBOLocal certidaoLimitesLrfBO;
    @EJB
    private CertidaoPCABOLocal certidaoPCABO;
    @EJB
    private MunicipioImplLocal municipioImpl;
    @EJB
    private IndicadorImplLocal indicadorImpl;
    @EJB
    private EMailBOLocal eMailBO;

    private InputText inputEmail = new InputText();
    private InputText inputTipoInstituicao = new InputText();
    private InputText inputMunicipio = new InputText();
    private InputText inputNome = new InputText();
    private String nomeOrgao;
    private String nomeEntidade;
    private InputMask inputCPF = new InputMask();
    private String cpf;
    private String cnpj;
    private InputMask inputOrgaoEntidade = new InputMask();
    
    private IndTipoCertidaoEnum tipoCertidao;
    private IndSimNaoEnum indContratacaoOP2014;
    private IndSimNaoEnum indRealizacaoOP2014;
    private IndSimNaoEnum indContratacaoOP2015;
    private IndSimNaoEnum indRealizacaoOP2015;
    private IndFinalidadeCertidaoEnum finalidade;
    private Integer anoExercicio;
    private String msg;
    private boolean exibeCampoOP = false;

    private List<SelectItem> listaCertidao = new ArrayList<SelectItem>();
    private List<SelectItem> listaSimNao = new ArrayList<SelectItem>();
    private List<SelectItem> listaFinalidade = new ArrayList<SelectItem>();
    private List<SelectItem> exercicios = new ArrayList<SelectItem>();

    public String getRecuperaCpfLogado() {
        String retorno = "";
        FacesContext context = FacesContext.getCurrentInstance();
        ResponseRespLegalVigente usuarioLogado = getUsuarioLogado();
        if (usuarioLogado != null && usuarioLogado.getCpf() != null) {
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

    public String carregarDadosUsuario() {

    	tipoCertidao = null;
	    indContratacaoOP2014 = null;
	    indRealizacaoOP2014 = null;
	    indContratacaoOP2015 = null;
	    indRealizacaoOP2015 = null;
	    finalidade = null;
	    anoExercicio = null;
	    exibeCampoOP = false;
    	
        ResponseRespLegalVigente usuarioLogado = getUsuarioLogado();
        OrgaoResponsaveLegal orgaoUsuarioLogado = getOrgaoUsuarioLogadoSelecionado();
        OrgaoEntidade orgaoEntidade = getOrgaoSGISelecionado();

        if (orgaoEntidade == null) {
            ResponseConsultarOrgaoCnpj responseConsultarOrgaoCnpj = pesquisarOrgaosSGI();
            enviarSessao(Arrays.asList(responseConsultarOrgaoCnpj.getOrgaoEntidade()), Constantes.LISTA_INSTITUICOES_SGI);
            if (responseConsultarOrgaoCnpj.getOrgaoEntidade().length == 1) {
                OrgaoEntidade entidade = responseConsultarOrgaoCnpj.getOrgaoEntidade()[0];
                enviarSessao(entidade, Constantes.INSTITUICAO_SGI_SELECIONADA);
                orgaoEntidade = entidade;
            } else {
                return "selecionarEntidade";
            }
        }

        nomeOrgao = orgaoUsuarioLogado.getDenominacaoOrgao();
        nomeEntidade = orgaoEntidade.getDenominacaoOrgao();
        inputNome.setValue(usuarioLogado.getNomeResponsavelLegal());
        inputNome.setReadonly(true);
        inputCPF.setValue(usuarioLogado.getCpf());
        inputCPF.setReadonly(true);

        inputEmail.setValue(usuarioLogado.getEmail());
        inputEmail.setReadonly(true);
        inputTipoInstituicao.setValue(orgaoUsuarioLogado.getTipoEntidade());
        inputTipoInstituicao.setReadonly(true);
        inputMunicipio.setValue(orgaoUsuarioLogado.getNomeMunicipio());
        inputMunicipio.setReadonly(true);
        inputOrgaoEntidade.setValue(orgaoUsuarioLogado.getCnpjOrgaoEntidade());
        inputOrgaoEntidade.setReadonly(true);
        
        cpf = MascaraUtil.formatar(usuarioLogado.getCpf(), "###.###.###-##");
        cnpj = MascaraUtil.formatar(orgaoUsuarioLogado.getCnpjOrgaoEntidade(), "##.###.###/####-##");
        inputOrgaoEntidade.setMask("99.999.999/9999-99");
        inputCPF.setMask("999.999.999-99");

        listaCertidao.clear();
        listaCertidao.add(new SelectItem(null, "Selecione..."));
        for (IndTipoCertidaoEnum indicador : IndTipoCertidaoEnum.values()) {
            listaCertidao.add(new SelectItem(indicador, indicador.getLabel()));
        }
        
        listaSimNao.clear();
        listaSimNao.add(new SelectItem(null, "Selecione..."));
        for (IndSimNaoEnum indicador : IndSimNaoEnum.values()) {
        	listaSimNao.add(new SelectItem(indicador, indicador.getLabel()));
        }


        listaFinalidade.clear();
        listaFinalidade.add(new SelectItem(null, "Selecione..."));
        for (IndFinalidadeCertidaoEnum finalidade : IndFinalidadeCertidaoEnum.values()) {
            listaFinalidade.add(new SelectItem(finalidade, finalidade.getLabel()));
        }
        
        anoExercicio = DateUtil.getAnoData();
        exercicios.clear();
        exercicios.add(new SelectItem(null, "Selecione..."));
        for (Integer i = 2013; i <= anoExercicio; i++) {
        	exercicios.add(new SelectItem(i, i.toString()));
		}
        
        return "solicitarCertidao";
    }

    public void validaTipoCertidao(){
    	
    	if(tipoCertidao != null && tipoCertidao.equals(IndTipoCertidaoEnum.OPERACAO_CREDITO)){
    		exibeCampoOP = true;
    	}else{
    		exibeCampoOP = false;
    	}
    }
    
    public void solicitarCertidao() {

		String camposObrigatorios = "";
		Certidao certidao = null;
		
		try {
			
			ResponseRespLegalVigente usuarioLogado = getUsuarioLogado();
			
			if (tipoCertidao == null || "".equals(tipoCertidao)) {
				camposObrigatorios += "Tipo Certidão";
			}
			if (finalidade == null || "".equals(finalidade)) {
				if (!camposObrigatorios.equals("")) {
					camposObrigatorios += ", ";
				}
				camposObrigatorios += "Finalidade da Certidão";
			}
			if ((tipoCertidao != null && !tipoCertidao.equals(IndTipoCertidaoEnum.OPERACAO_CREDITO)) 
					&& (anoExercicio == null)) {
				if (!camposObrigatorios.equals("")) {
					camposObrigatorios += ", ";
				}
				camposObrigatorios += "Ano Exercício da Certidão";
			}
			
			if (camposObrigatorios.equals("")) {
				
				switch (tipoCertidao) {
				case OPERACAO_CREDITO:
					certidao = new CertidaoOperacaoCredito(indContratacaoOP2014, indRealizacaoOP2014, indContratacaoOP2015, indRealizacaoOP2015);
					break;
				case COMPETENCIA_TRIBUTARIA:
					certidao = new CertidaoCompetenciaTributaria();
					break;
				case LIMITES:
					certidao = new CertidaoLimites();
					break;
				case FUNDEB:
					certidao = certidaoPCABO.criarCertidaoPCA(anoExercicio, getOrgaoUsuarioLogadoSelecionado().getCodigoIBGE());
					break;
				case GASTO_ENSINO:
					certidao = certidaoPCABO.criarCertidaoPCA(anoExercicio, getOrgaoUsuarioLogadoSelecionado().getCodigoIBGE());
					break;
				case GASTO_PESSOAL:
					certidao = certidaoPCABO.criarCertidaoPCA(anoExercicio, getOrgaoUsuarioLogadoSelecionado().getCodigoIBGE());
					break;
				case GASTO_SAUDE:
					certidao = certidaoPCABO.criarCertidaoPCA(anoExercicio, getOrgaoUsuarioLogadoSelecionado().getCodigoIBGE());
					break;
				case GERAL:
					certidao = certidaoPCABO.criarCertidaoPCA(anoExercicio, getOrgaoUsuarioLogadoSelecionado().getCodigoIBGE());
					break;
				}
				
				if(certidao != null){
					
					preencherDadosSolicitacaoCertidao(certidao, usuarioLogado, anoExercicio, tipoCertidao, finalidade);
					certidaoBO.solicitarCertidao(certidao);
					Long numProtocolo = certidao.getNumProtocolo();
					this.msg = "Protocolo da Solicitação: " + formataProtocolo(numProtocolo.toString())
							+ ".\n A certidão será gerada automaticamente pelo sistema.\n Acompanhe o andamento pelo menu \"Consultar Certidão\"";
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, this.msg, null));
				}else{
					solicitarCertidaoSGAP(usuarioLogado, anoExercicio.toString(), ".pdf");
//					eMailBO.enviarEmailErroECertidao(tipoCertidao + " " + anoExercicio, "ERRO SOLICITACAO CERTIDAO " + getUsuarioLogado().getMunicipio() + " " + getUsuarioLogado().getCpf());
				}
				
			} else {
				camposObrigatorios = replaceLast(camposObrigatorios, ",", " e");
				this.msg = camposObrigatorios + " são obrigatórios.";
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, this.msg, null));
			}
			
		} catch (Exception e) {
			
			eMailBO.enviarEmailErro(new Email(certidao, "Competencia Triburaria", e));
			this.msg = "Ocorreu um erro ao criar a solicitação de certidão, favor contate o administrador do sistema.";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, this.msg, null));
			e.printStackTrace();
		}
    }

	private void preencherDadosSolicitacaoCertidao(Certidao certidao, ResponseRespLegalVigente usuarioLogado, Integer anoExercicio, 
			IndTipoCertidaoEnum tipoCertidao, IndFinalidadeCertidaoEnum finalidade) {
		
		certidao.setNumCpfCnpf(Long.valueOf(MascaraUtil.retiraMascaraCpfCnpj(usuarioLogado.getCpf())));
		certidao.setCodMunicipio(Long.valueOf(getOrgaoUsuarioLogadoSelecionado().getCodigoIBGE()));
		
		certidao.setNomeMunicipio(getOrgaoUsuarioLogadoSelecionado().getNomeMunicipio());
		certidao.setIndFinalidade(finalidade);
		certidao.setIndTipoCertidao(tipoCertidao);
		if(certidao.getIndSituacao() == null){
			certidao.setIndSituacao(IndSituacaoCertidaoEnum.EM_ANALISE);
		}
		certidao.setDataSolicitacao(new Date());
		certidao.setNumAnoRef(anoExercicio);
	}

	private void solicitarCertidaoSGAP(ResponseRespLegalVigente usuarioLogado, String anoExercicio,	String extensaoArquvo) throws Exception {
		
		OrgaoEntidade orgaoEntidade = getOrgaoSGISelecionado();
		String nomeMunicipio = getOrgaoUsuarioLogadoSelecionado().getNomeMunicipio();

        TipoDocumentoPeticao indicadorTipoCert = indicadorImpl.buscarIndicadorTipoCertidao(tipoCertidao.getId());  
        TipoFinalidadePeticao indicadorFinalidade = indicadorImpl.buscarIndicadorTipoFinalidadePeticao(finalidade.getId());
		String retorno = certidaoBO.solicitacaoCertidao(MascaraUtil.retiraMascaraCpfCnpj(usuarioLogado.getCpf()),
		        usuarioLogado.getNomeResponsavelLegal(),
		        usuarioLogado.getEmail(),
		        nomeMunicipio,
		        "MG",
		        MascaraUtil.retiraMascaraCpfCnpj(getOrgaoUsuarioLogadoSelecionado().getCnpjOrgaoEntidade()),
		        getOrgaoUsuarioLogadoSelecionado().getDenominacaoOrgao(),
		        "CERTIDAO",
		        indicadorTipoCert.getCodIndicador(),
		        Integer.parseInt(anoExercicio),
		        indicadorFinalidade.getCodIndicador(),
		        null,
		        null,
		        orgaoEntidade.getCodigoOrgaoEntidade());

		if (retorno != null) {
		    this.msg = retorno;

		} else {
		    this.msg = "Ocorreu um erro ao criar a solicitação de certidão, favor contate o administrador do sistema.";
		}
	}

    public static String replaceLast(String texto, String substituir, String substituto) {
        int pos = texto.lastIndexOf(substituir);
        if (pos > -1) {
            return texto.substring(0, pos) + substituto + texto.substring(pos + substituir.length(), texto.length());
        } else {
            return texto;
        }
    }

    public Boolean getExibeTrocaEntidade() {

        List<OrgaoEntidade> listaEntidade = getListaOrgaosSGI();

        if (listaEntidade != null && listaEntidade.size() > 1) {
            return true;
        }

        return false;
    }

    private ResponseConsultarOrgaoCnpj pesquisarOrgaosSGI() {

        try {
            OrgaoResponsaveLegal orgaoUsuarioLogadoSelecionado = getOrgaoUsuarioLogadoSelecionado();
            ResponseConsultarOrgaoCnpj responseConsultarOrgaoCnpj = getServicoConsultarOrgaoSGI().consultarOrgaoCNPJ(Constantes.NOME_SISTEMA, orgaoUsuarioLogadoSelecionado.getCnpjOrgaoEntidade(), null);
            return responseConsultarOrgaoCnpj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String formataProtocolo(String numProtocolo) {
        StringBuilder builder = new StringBuilder();
        builder.append(numProtocolo.substring(0, 2));
        builder.append(".");
        builder.append(numProtocolo.substring(2, 6));
        builder.append(".");
        builder.append(numProtocolo.substring(6, 10));
        builder.append(".");
        builder.append(numProtocolo.substring(10));
        return builder.toString();
    }

    public List<String> autoCompleteMunicipio(String query) {
        List<String> resultado = new ArrayList<String>();
        try {
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
        for (Municipio mun : listaMunicipio) {
            String descMunicipio = mun.getDescMunicipio();
            descMunicipio = Normalizer.normalize(descMunicipio, Normalizer.Form.NFD);
            descMunicipio = descMunicipio.replaceAll("[^\\p{ASCII}]", "");
            if (descMunicipio.toUpperCase().startsWith(query.toUpperCase())) {
                resultado.add(mun.getDescMunicipio().toUpperCase());
            }
        }
        return resultado;
    }
    
    public String carregarPaginaPrincipal() {

        return "principal";
    }

    public InputText getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(InputText inputEmail) {
        this.inputEmail = inputEmail;
    }

    public InputText getInputTipoInstituicao() {
        return inputTipoInstituicao;
    }

    public void setInputTipoInstituicao(InputText inputTipoInstituicao) {
        this.inputTipoInstituicao = inputTipoInstituicao;
    }

    public InputText getInputMunicipio() {
        return inputMunicipio;
    }

    public void setInputMunicipio(InputText inputMunicipio) {
        this.inputMunicipio = inputMunicipio;
    }

    public InputMask getInputOrgaoEntidade() {
        return inputOrgaoEntidade;
    }

    public void setInputOrgaoEntidade(InputMask inputOrgaoEntidade) {
        this.inputOrgaoEntidade = inputOrgaoEntidade;
    }

    public List<SelectItem> getListaCertidao() {
        return listaCertidao;
    }

    public void setListaCertidao(ArrayList<SelectItem> listaCertidao) {
        this.listaCertidao = listaCertidao;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SelectItem> getListaFinalidade() {
        return listaFinalidade;
    }

    public void setListaFinalidade(ArrayList<SelectItem> listaFinalidade) {
        this.listaFinalidade = listaFinalidade;
    }

    public InputText getInputNome() {
        return inputNome;
    }

    public void setInputNome(InputText inputNome) {
        this.inputNome = inputNome;
    }

    public InputMask getInputCPF() {
        return inputCPF;
    }

    public void setInputCPF(InputMask inputCPF) {
        this.inputCPF = inputCPF;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeOrgao() {
        return nomeOrgao;
    }

    public void setNomeOrgao(String nomeOrgao) {
        this.nomeOrgao = nomeOrgao;
    }

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public List<Municipio> getListaMunicipio() {
        return listaMunicipio;
    }

    public void setListaMunicipio(List<Municipio> listaMunicipio) {
        this.listaMunicipio = listaMunicipio;
    }

	public IndTipoCertidaoEnum getTipoCertidao() {
		return tipoCertidao;
	}

	public void setTipoCertidao(IndTipoCertidaoEnum tipoCertidao) {
		this.tipoCertidao = tipoCertidao;
	}

	public IndFinalidadeCertidaoEnum getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(IndFinalidadeCertidaoEnum finalidade) {
		this.finalidade = finalidade;
	}

	public List<SelectItem> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<SelectItem> exercicios) {
		this.exercicios = exercicios;
	}

	public Integer getAnoExercicio() {
		return anoExercicio;
	}

	public void setAnoExercicio(Integer anoExercicio) {
		this.anoExercicio = anoExercicio;
	}

	public boolean isExibeCampoOP() {
		return exibeCampoOP;
	}

	public void setExibeCampoOP(boolean exibeCampoOP) {
		this.exibeCampoOP = exibeCampoOP;
	}

	public IndSimNaoEnum getIndRealizacaoOP2014() {
		return indRealizacaoOP2014;
	}

	public void setIndRealizacaoOP2014(IndSimNaoEnum indRealizacaoOP2014) {
		this.indRealizacaoOP2014 = indRealizacaoOP2014;
	}

	public IndSimNaoEnum getIndRealizacaoOP2015() {
		return indRealizacaoOP2015;
	}

	public void setIndRealizacaoOP2015(IndSimNaoEnum indRealizacaoOP2015) {
		this.indRealizacaoOP2015 = indRealizacaoOP2015;
	}

	public IndSimNaoEnum getIndContratacaoOP2014() {
		return indContratacaoOP2014;
	}

	public void setIndContratacaoOP2014(IndSimNaoEnum indContratacaoOP2014) {
		this.indContratacaoOP2014 = indContratacaoOP2014;
	}

	public IndSimNaoEnum getIndContratacaoOP2015() {
		return indContratacaoOP2015;
	}

	public void setIndContratacaoOP2015(IndSimNaoEnum indContratacaoOP2015) {
		this.indContratacaoOP2015 = indContratacaoOP2015;
	}

	public List<SelectItem> getListaSimNao() {
		return listaSimNao;
	}

	public void setListaSimNao(List<SelectItem> listaSimNao) {
		this.listaSimNao = listaSimNao;
	}

}
