package br.rest.eleicao.model;

public class Voto {

	private Long Id;
	private String Candidato;
	private String ZonaEleitoral;
	private String eleitor;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCandidato() {
		return Candidato;
	}

	public void setCandidato(String candidato) {
		Candidato = candidato;
	}

	public String getZonaEleitoral() {
		return ZonaEleitoral;
	}

	public void setZonaEleitoral(String zonaEleitoral) {
		ZonaEleitoral = zonaEleitoral;
	}

	public String getEleitor() {
		return eleitor;
	}

	public void setEleitor(String eleitor) {
		this.eleitor = eleitor;
	}

}
