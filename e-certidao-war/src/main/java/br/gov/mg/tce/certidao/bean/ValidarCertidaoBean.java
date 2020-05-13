package br.gov.mg.tce.certidao.bean;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.gov.mg.tce.certidao.base.BaseBean;
import br.gov.mg.tce.dto.ValidarCertidaoResponse;
import br.gov.mg.tce.facade.CertidaoBOLocal;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;


/**
 * Controller responsavel por validar as informacoes de uma certidao
 */
@SessionScoped
@ManagedBean(name = "validarCertidaoBean")
public class ValidarCertidaoBean extends BaseBean {

	private static final long serialVersionUID = 1756232751373006961L;
	
	private String numProtocoloFormatado;
	private ValidarCertidaoResponse validarCertidaoResponse;
	private String msg;
	private String captchaDigitado;
	private StreamedContent file;
	
	@EJB
	private CertidaoBOLocal certidaoBO;
	
	/**
	 * Valida a certidao.
	 * Chama o WebService PeticaoCertidaoWS do SGAP para validar a certidao.
	 */
	public void validarCertidao(){
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext ext = context.getExternalContext();
			Map<String, Object> session = ext.getSessionMap();
			String captchaSessao = (String) session.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			
			if("producao".equals(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.AMBIENTE)) && (captchaDigitado == null || captchaSessao == null || !(captchaDigitado.equalsIgnoreCase(captchaSessao)))){
				this.msg = "Valor de captcha não confere.";
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,this.msg, null));
			}else{
				String numProtocolo = numProtocoloFormatado.replace(".","");
				numProtocolo = numProtocolo .replace("/","");
				
				
				validarCertidaoResponse = certidaoBO.validarCertidaoPorNumProtocolo(numProtocolo);
			}
		}catch (Exception e){
			msg = "Erro ao validar certidão. Serviço fora do ar.";
			validarCertidaoResponse = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,this.msg, null));
		}
		
	}
	
	public StreamedContent getFile() throws FileNotFoundException {

		if(validarCertidaoResponse.getCertidao() != null){
			InputStream stream = new ByteArrayInputStream(validarCertidaoResponse.getCertidao().getArqCertidaoPdf());
			file = new DefaultStreamedContent(stream, "application/pdf", "edital.pdf");  
		}

        return file;  
    } 

	public String getNumProtocoloFormatado() {
		return numProtocoloFormatado;
	}


	public void setNumProtocoloFormatado(String numProtocoloFormatado) {
		this.numProtocoloFormatado = numProtocoloFormatado;
	}

	public ValidarCertidaoResponse getValidarCertidaoResponse() {
		return validarCertidaoResponse;
	}

	public void setValidarCertidaoResponse(
			ValidarCertidaoResponse validarCertidaoResponse) {
		this.validarCertidaoResponse = validarCertidaoResponse;
	}

	public String getCaptchaDigitado() {
		return captchaDigitado;
	}

	public void setCaptchaDigitado(String captchaDigitado) {
		this.captchaDigitado = captchaDigitado;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}


}
