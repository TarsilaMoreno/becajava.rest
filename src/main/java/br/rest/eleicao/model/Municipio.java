package br.rest.eleicao.model;

public class Municipio {

	
		private Long ID;
		private String Nome;
		private String Populacao;

		public String getPopulacao() {
			return Populacao;
		}

		public void setPopulacao(String populacao) {
			Populacao = populacao;
		}

		public Long getID() {
			return ID;
		}

		public void setID(Long iD) {
			ID = iD;
		}

		public String getNome() {
			return Nome;
		}

		public void setNome(String nome) {
			Nome = nome;
		}

	}


