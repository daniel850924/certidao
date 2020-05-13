package br.gov.mg.tce.certidao.util;

public class MensagemUtil {

	private String titulo;
	private String msg;
	private String tipo;
	
	public MensagemUtil(String titulo,String msg,String tipo){
		this.tipo = tipo;
		this.titulo = titulo;
		this.msg = msg;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
