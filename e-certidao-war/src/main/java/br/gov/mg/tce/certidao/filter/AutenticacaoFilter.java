package br.gov.mg.tce.certidao.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.mg.tce.util.Constantes;

public class AutenticacaoFilter implements Filter {
	
	public void init(FilterConfig filterConfig) {
		
	}
	

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

		try {
			HttpServletRequest request = ((HttpServletRequest)servletRequest);
			HttpServletResponse response = ((HttpServletResponse)servletResponse);
			
			try{
				
				if(request.getSession().getAttribute(Constantes.USUARIO_LOGADO) != null && 
						request.getSession().getAttribute(Constantes.INSTITUICAO_SGI_SELECIONADA) == null && 
							!request.getRequestURI().equalsIgnoreCase("/E-Certidao/view/xhtml/selecionarEntidade.xhtml") &&
							(request.getRequestURI().contains("E-Certidao/view/xhtml/") ||
									request.getRequestURI().contains("E-Certidao/principal"))){
					
					//request.getRequestDispatcher("/view/xhtml/selecionarEntidade.xhtml").forward(servletRequest, servletResponse);
					
					response.sendRedirect("/E-Certidao/view/xhtml/selecionarEntidade.xhtml");
				}
				
			}catch(Exception e){
				destroy();
			}
			
			filterChain.doFilter(request, servletResponse);
		} catch (Exception e) {
		}
	}
	
	public void destroy() {
		try {
			super.finalize();
		} catch (Throwable e) {
		}
	}
	
}
