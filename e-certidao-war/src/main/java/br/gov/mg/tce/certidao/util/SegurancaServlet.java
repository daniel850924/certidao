package br.gov.mg.tce.certidao.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SegurancaServlet
 */
public class SegurancaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SegurancaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*request.getSession().invalidate();
		
		RequestDispatcher view = request.getRequestDispatcher("http://www.tce.mg.gov.br/");  
		view.forward(request,response);*/
		
		
		
		request.getSession().invalidate();
		
		Cookie[] c = request.getCookies();
		
		if (c != null)
	        for (int i = 0; i < c.length; i++) {
	            c[i].setValue("");
	            c[i].setPath("/");
	            c[i].setMaxAge(0);
	            response.addCookie(c[i]);
	        }
		
		response.setContentType("text/html;charset=ISO-8859-1");
		response.sendRedirect("obrigado.xhtml");

	}

}
