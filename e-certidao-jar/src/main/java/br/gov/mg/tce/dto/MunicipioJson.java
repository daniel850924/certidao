package br.gov.mg.tce.dto;

public class MunicipioJson {

	private Long codIBGE;
	Integer exercicio;
	

	public Long getCodIBGE() {
		return codIBGE;
	}

	public void setCodIBGE(Long codIBGE) {
		this.codIBGE = codIBGE;
	}

	public MunicipioJson(Long codIBGE, Integer exercicio) {
		super();
		this.codIBGE = codIBGE;
		this.exercicio = exercicio;
	}

	public MunicipioJson() {
		super();
	}

	public Integer getExercicio() {
		return exercicio;
	}

	public void setExercicio(Integer exercicio) {
		this.exercicio = exercicio;
	}
	
}
