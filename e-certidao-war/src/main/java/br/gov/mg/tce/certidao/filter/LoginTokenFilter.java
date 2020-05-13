package br.gov.mg.tce.certidao.filter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoEntidade;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.OrgaoResponsaveLegal;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.PessoaFisica;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultaUsuarioSistemaOrgao;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseConsultarOrgaoCnpj;
import org.datacontract.schemas._2004._07.SGI_WebService_DataContracts.ResponseRespLegalVigente;
import org.tempuri.IWsSgiAutenticacaoProxy;
import org.tempuri.IWsSgiConsultaPessoaProxy;

import br.gov.mg.tce.certidao.model.Usuario;
import br.gov.mg.tce.certidao.util.CertificadoUtil;
import br.gov.mg.tce.certidao.util.DateUtil;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;

public class LoginTokenFilter implements Filter {
	
	public void init(FilterConfig filterConfig) {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain) {
		String ambiente = PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.AMBIENTE);
		if("producao".equalsIgnoreCase(ambiente)){
			doFilterProducao(servletRequest, servletResponse, filterChain);
		}else{
			doFilterHomologacao(servletRequest, servletResponse, filterChain);
		}
	}
	
	//PRODUÇÃO
	public void doFilterProducao(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain) {

		HttpServletRequest request = ((HttpServletRequest)servletRequest);
		HttpServletResponse response = ((HttpServletResponse)servletResponse);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
        boolean redirecionou = false;
        
        if(request.getSession().getAttribute("redirecionou") != null){
        	redirecionou = (Boolean) request.getSession().getAttribute("redirecionou");
        }
		
		try{
			
			if(((HttpServletRequest)servletRequest).getLocalPort() == 8440){
				
				final String CLIENT_CERT = "javax.servlet.request.X509Certificate";
				
				java.security.cert.X509Certificate certChain[] = (java.security.cert.X509Certificate[]) request.getAttribute(CLIENT_CERT);
				if (!resourceRequest){
					if (certChain != null) {
						
						Usuario usuario = CertificadoUtil.getInfo(certChain[0]);
	
						if(request.getSession().getAttribute(Constantes.USUARIO_LOGADO) == null){
							
							//Conforme conversa no dia 27-06-2016 com Flavia Martins e Lucas Machado o parametro PREFEITO MUNICIPAL deve ser passado para o serico para efetuar login no sistema.
							ResponseRespLegalVigente responseRespLegalVigente = getServicoLoginSGI().consultarCpfReponsavelLegalVigente(Constantes.NOME_SISTEMA, usuario.getCpf(), Constantes.PARAMETRO_PREFEITO_WSDL_LOGIN_SGI);
							
							Boolean responsavelValido = responsavelValido(responseRespLegalVigente, request);
							
							if(responsavelValido){
	
								request.getSession().setAttribute(Constantes.USUARIO_LOGADO, responseRespLegalVigente);
								
								servletRequest.setCharacterEncoding("UTF-8");
								servletResponse.setContentType("text/html;charset=UTF-8");
								
								verificaOrgaoSGI(responseRespLegalVigente, request);
								
	//							request.getRequestDispatcher("index.xhtml").forward(servletRequest, servletResponse);
								response.sendRedirect("index.xhtml");
									
							} else {
								
								if (request.getSession().getAttribute(Constantes.USUARIO_INTERNO_TCE_LOGADO) == null) {
									ResponseConsultarOrgaoCnpj orgao = getServicoConsultarOrgaoSGI().consultarOrgaoCNPJ(Constantes.NOME_SISTEMA, Constantes.NUM_CNPJ_TCE, null);
									OrgaoEntidade orgaoEntidade = orgao.getOrgaoEntidade()[0];
									ResponseConsultaUsuarioSistemaOrgao responseUsuarioSgi = getServicoLoginSGI().consultarUsuarioSistemaOrgao(
											Constantes.NOME_SISTEMA, orgaoEntidade.getCodigoOrgaoEntidade(), usuario.getCpf(), true);
									
									if (ArrayUtils.isNotEmpty(responseUsuarioSgi.getPessoaFisica()) && 
											responseUsuarioSgi.getPessoaFisica()[0] != null) {
									
										request.getSession().setAttribute(Constantes.USUARIO_INTERNO_TCE_LOGADO, responseUsuarioSgi.getPessoaFisica()[0]);
										request.getSession().setAttribute(Constantes.USUARIO_INTERNO_TCE, Boolean.TRUE);
										request.getSession().setAttribute(Constantes.INSTITUICAO_SGI_SELECIONADA, orgaoEntidade);
										
										servletRequest.setCharacterEncoding("UTF-8");
										servletResponse.setContentType("text/html;charset=UTF-8");
										
										response.sendRedirect("index.xhtml");
										
									} else {	
										
										destroy();
//										request.getRequestDispatcher("/view/xhtml/validarCertidaoRespInvalido.xhtml").forward(servletRequest, servletResponse);	
											
										if(!redirecionou){
											response.sendRedirect("view/xhtml/validarCertidaoRespInvalido.xhtml");
											request.getSession().setAttribute("redirecionou", true);
										}
										
									}	
								} else {
									PessoaFisica pessoaFisicaUsuario = (PessoaFisica) request.getSession().getAttribute(Constantes.USUARIO_INTERNO_TCE_LOGADO);
									
									if( ! usuario.getCpf().equals(pessoaFisicaUsuario.getCpf())){
										
										destroy();
//										request.getRequestDispatcher("/view/xhtml/validarCertidaoRespInvalido.xhtml").forward(servletRequest, servletResponse);
										
										if(!redirecionou){
											response.sendRedirect("view/xhtml/validarCertidaoRespInvalido.xhtml");
											request.getSession().setAttribute("redirecionou", true);
										}
										
									}
								}
								
							}
							
						}else{
							ResponseRespLegalVigente responseRespLegalVigente = (ResponseRespLegalVigente) request.getSession().getAttribute(Constantes.USUARIO_LOGADO);
							
							if( ! usuario.getCpf().equals(responseRespLegalVigente.getCpf())){
								
								destroy();
//								request.getRequestDispatcher("/view/xhtml/validarCertidao.xhtml").forward(servletRequest, servletResponse);
								
								if(!redirecionou){
									response.sendRedirect("view/xhtml/validarCertidao.xhtml");
									request.getSession().setAttribute("redirecionou", true);
								}
								
							}
						}
							
					}else{
						
						destroy();
//						request.getRequestDispatcher("/view/xhtml/validarCertidao.xhtml").forward(servletRequest, servletResponse);
						
						if(!redirecionou){
							response.sendRedirect("view/xhtml/validarCertidao.xhtml");
							request.getSession().setAttribute("redirecionou", true);
						}
						
					}
				}
			}else{
				
				destroy();
//				request.getRequestDispatcher("/view/xhtml/validarCertidao.xhtml").forward(servletRequest, servletResponse);
//				request.getRequestDispatcher("erroConectarPorta.xhtml").forward(servletRequest, servletResponse);
				
				if(!redirecionou){
					response.sendRedirect("view/xhtml/validarCertidao.xhtml");
					request.getSession().setAttribute("redirecionou", true);
				}
					
			}			
			
		}catch(Exception e){
			
			try {
				destroy();
//			request.getRequestDispatcher("acessoNegado.xhtml").forward(servletRequest, servletResponse);
				
				if(!redirecionou){
					response.sendRedirect("acessoNegado.xhtml");
					request.getSession().setAttribute("redirecionou", true);
				}
			} catch (IOException e1) {
			}
			
		}
		
		try {
			filterChain.doFilter(request, servletResponse);
		} catch (Exception e) {
		} 
	}
	
	// ===============================================================================================================================================================================
	
	//LOCAL
	public void doFilterHomologacao(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain){
		
		try {
			HttpServletRequest request = ((HttpServletRequest)servletRequest);
			HttpServletResponse response = ((HttpServletResponse)servletResponse);
			
				if(request.getSession().getAttribute(Constantes.USUARIO_LOGADO)==null){
					
					String cpfTeste = "interno";
//					String cpfTeste = "29853109620";
//					String cpfTeste = "45639809604";
//					String cpfTeste = "05087616623";
					
					ResponseRespLegalVigente responseRespLegalVigente = getServicoLoginSGI().consultarCpfReponsavelLegalVigente(Constantes.NOME_SISTEMA,
							cpfTeste, Constantes.PARAMETRO_PREFEITO_WSDL_LOGIN_SGI);
					
					Boolean responsavelValido = responsavelValido(responseRespLegalVigente, request);
					
//				ResponseRespLegalVigente responseRespLegalVigente = null;
//				Boolean responsavelValido = false;
					
					if( !  responsavelValido){
						
						/*
						 *  Quando usuario interno do TCE, visualiza somente a consulta e validacao de certidoes.
						 *  Previsto ter apenas uma entidade, direcionando direto para a tela de consulta de certidoes.
						 * 
						 *  ALTERAR O IF ABAIXO PARA TESTAR ACESSO DE USUARIO INTERNO TCE
						 *  
						 *  @Since 21/06/17 
						 */
						
						boolean isAcessoInterno = true;
						
						if (isAcessoInterno) {
							
							ResponseConsultarOrgaoCnpj orgao = getServicoConsultarOrgaoSGI().consultarOrgaoCNPJ(Constantes.NOME_SISTEMA, "11111111111111", null);
							OrgaoEntidade orgaoEntidade = orgao.getOrgaoEntidade()[0];
							ResponseConsultaUsuarioSistemaOrgao responseUsuarioSgi = getServicoLoginSGI().consultarUsuarioSistemaOrgao(
									Constantes.NOME_SISTEMA, orgaoEntidade.getCodigoOrgaoEntidade(), cpfTeste, true);
							
							if (ArrayUtils.isNotEmpty(responseUsuarioSgi.getPessoaFisica())) {
								request.getSession().setAttribute(Constantes.USUARIO_INTERNO_TCE_LOGADO, responseUsuarioSgi.getPessoaFisica()[0]);
							}

							request.getSession().setAttribute(Constantes.USUARIO_INTERNO_TCE, Boolean.TRUE);
							request.getSession().setAttribute(Constantes.INSTITUICAO_SGI_SELECIONADA, orgaoEntidade);
							
						} else {
							
							responseRespLegalVigente = new ResponseRespLegalVigente();
							
							responseRespLegalVigente.setNomeResponsavelLegal("USUÁRIO TESTE");
							responseRespLegalVigente.setEmail("teste@tce.mg.gov.br");
							responseRespLegalVigente.setMunicipio("TCE-MG");
							responseRespLegalVigente.setCpf("05087616623");

							responseRespLegalVigente.setOrgaosResponsavelLegal(new OrgaoResponsaveLegal[1]);
							OrgaoResponsaveLegal orgaoResponsaveLegal = new OrgaoResponsaveLegal();
							orgaoResponsaveLegal.setCnpjOrgaoEntidade("05461142000170");
							orgaoResponsaveLegal.setNomeMunicipio("TCE-MG");
							orgaoResponsaveLegal.setTipoEntidade("ENTIDADE ESTADUAL");
							orgaoResponsaveLegal.setDenominacaoOrgao("TRIBUNAL DE CONTAS DO ESTADO DE MINAS GERAIS");
							orgaoResponsaveLegal.setDataInicioVigencia(Calendar.getInstance());
							
							OrgaoResponsaveLegal orgaoResponsaveLegal2 = new OrgaoResponsaveLegal();
							orgaoResponsaveLegal2.setCnpjOrgaoEntidade("22222222222222");
							orgaoResponsaveLegal2.setNomeMunicipio("TCE-MG");
							orgaoResponsaveLegal2.setTipoEntidade("ENTIDADE MUNICIPAL");
							orgaoResponsaveLegal2.setDenominacaoOrgao("PREFEITURA BELO HORIZONTE");
							orgaoResponsaveLegal2.setDataInicioVigencia(Calendar.getInstance());
							
							responseRespLegalVigente.setOrgaosResponsavelLegal(new OrgaoResponsaveLegal[]{orgaoResponsaveLegal, orgaoResponsaveLegal2});
							
							request.getSession().setAttribute(Constantes.INSTITUICAO_SELECIONADA, responseRespLegalVigente.getOrgaosResponsavelLegal()[0]);
						}
						
					}
					
					request.getSession().setAttribute(Constantes.USUARIO_LOGADO, responseRespLegalVigente);
					verificaOrgaoSGI(responseRespLegalVigente, request);

					//request.getRequestDispatcher("index.xhtml").forward(servletRequest, servletResponse);
					
					response.sendRedirect("index.xhtml");
					
					//request.getRequestDispatcher("/view/xhtml/selecionarEntidade.xhtml").forward(servletRequest, servletResponse);

				}
				
			filterChain.doFilter(request, servletResponse);
		} catch (Exception e) {
		}
	}
	
	public IWsSgiConsultaPessoaProxy getServicoLoginSGI() throws Exception{
		
		return new IWsSgiConsultaPessoaProxy(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.WSDL_LOGIN_SGI)); 
				
	}
	
	public IWsSgiAutenticacaoProxy getServicoConsultarOrgaoSGI() throws Exception{
		
		return new IWsSgiAutenticacaoProxy(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.WSDL_BUSCAR_ORGAO_SGI));
		
	}	
	
	public Boolean responsavelValido(ResponseRespLegalVigente responseRespLegalVigente, HttpServletRequest request){
		
		Boolean responsavelValido = false;
		
		if(responseRespLegalVigente != null && responseRespLegalVigente.getHasError() == false){
			
			for (int i = 0; i < responseRespLegalVigente.getOrgaosResponsavelLegal().length; i++) {
				
				Boolean orgaoVigente = orgaoVigente(responseRespLegalVigente.getOrgaosResponsavelLegal()[i]);
				
				if(orgaoVigente){
					
					responsavelValido = true;
					request.getSession().setAttribute(Constantes.INSTITUICAO_SELECIONADA, responseRespLegalVigente.getOrgaosResponsavelLegal()[i]);
					break;
					
				}
				
			}
			
		}
		
		return responsavelValido;
	}
	
	public Boolean orgaoVigente(OrgaoResponsaveLegal orgaoResponsaveLegal){
		
		Boolean orgaoVigente = false;
		
		Date dataHoje = new Date();
		Date dataInicioVigencia = orgaoResponsaveLegal.getDataInicioVigencia() != null ? orgaoResponsaveLegal.getDataInicioVigencia().getTime() : null;
		Date dataFimVigencia = orgaoResponsaveLegal.getDataFimVigencia() != null ? orgaoResponsaveLegal.getDataFimVigencia().getTime() : null;
		
		orgaoVigente = DateUtil.estaNoIntervalo(dataHoje, dataInicioVigencia, dataFimVigencia, true);
		
		return orgaoVigente;
	}
	
	public void verificaOrgaoSGI(ResponseRespLegalVigente responseRespLegalVigente, HttpServletRequest request) throws Exception{
		
		OrgaoResponsaveLegal orgaoResponsaveLegal = (OrgaoResponsaveLegal) request.getSession().getAttribute(Constantes.INSTITUICAO_SELECIONADA);
		
		if (orgaoResponsaveLegal != null) {
			ResponseConsultarOrgaoCnpj responseConsultarOrgaoCnpj = getServicoConsultarOrgaoSGI().consultarOrgaoCNPJ(Constantes.NOME_SISTEMA, orgaoResponsaveLegal.getCnpjOrgaoEntidade(), null);
			
			if(responseConsultarOrgaoCnpj.getOrgaoEntidade().length == 1){
				request.getSession().setAttribute(Constantes.INSTITUICAO_SGI_SELECIONADA, responseConsultarOrgaoCnpj.getOrgaoEntidade()[0]);
			}
		}
	}
	
	public void destroy() {
		try {
			super.finalize();
		} catch (Throwable e) {
//			e.printStackTrace();
		}
	}
}
