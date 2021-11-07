package com.crescer.v1.model.dtos;

public class PixDTO {
	private String nome;
	private String chave;
	
	public PixDTO(String nome, String chave) {
		this.nome = nome;
		this.chave = chave;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	
}
