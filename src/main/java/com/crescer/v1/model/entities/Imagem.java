package com.crescer.v1.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagem")
public class Imagem extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3454734434633235618L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;


	@Column(name = "diretorio", nullable = false)
	private String diretorio;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDiretorio() {
		return diretorio;
	}


	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}
}