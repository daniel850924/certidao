package br.gov.mg.tce.enumerator;

public enum MesEnum {

	JAN(1, "Janeiro"),
	FEV(2, "Fevereiro"),
	MAR(3, "Março"),
	ABR(4, "Abril"),
	MAI(5, "Maio"),
	JUN(6, "Junho"),
	JUL(7, "Julho"),
	AGO(8, "Agosto"),
	SET(9, "Setembro"), 
	OUT(10, "Outubro"),
	NOV(11, "Novembro"),
	DEZ(12, "Dezembro");
	
	private Integer numMes;
	private String descricaoMes;
	
	private MesEnum(Integer numMes, String descricaoMes) {
		this.numMes = numMes;
		this.descricaoMes = descricaoMes;
	}
	
	public static String getDescricaoPorMes(Integer numMes){

		String descricaoMes = null;
		switch (numMes) {
		case 1:
			descricaoMes = MesEnum.JAN.descricaoMes;
			break;
		case 2:
			descricaoMes = MesEnum.FEV.descricaoMes;
			break;
		case 3:
			descricaoMes = MesEnum.MAR.descricaoMes;
			break;
		case 4:
			descricaoMes = MesEnum.ABR.descricaoMes;
			break;
		case 5:
			descricaoMes = MesEnum.MAI.descricaoMes;
			break;
		case 6:
			descricaoMes = MesEnum.JUN.descricaoMes;
			break;
		case 7:
			descricaoMes = MesEnum.JUL.descricaoMes;
			break;
		case 8:
			descricaoMes = MesEnum.AGO.descricaoMes;
			break;
		case 9:
			descricaoMes = MesEnum.SET.descricaoMes;
			break;
		case 10:
			descricaoMes = MesEnum.OUT.descricaoMes;
			break;
		case 11:
			descricaoMes = MesEnum.NOV.descricaoMes;
			break;
		case 12:
			descricaoMes = MesEnum.DEZ.descricaoMes;
			break;
		}
		
		return descricaoMes;
	}

	public Integer getNumMes() {
		return numMes;
	}

	public void setNumMes(Integer numMes) {
		this.numMes = numMes;
	}

	public String getDescricaoMes() {
		return descricaoMes;
	}

	public void setDescricaoMes(String descricaoMes) {
		this.descricaoMes = descricaoMes;
	}
	
	
	
}
