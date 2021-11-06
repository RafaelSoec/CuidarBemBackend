package com.crescer.v1.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3454734434633235618L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	

	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "sobrenome", nullable = false)
	private String sobrenome;

	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;

	@Column(name = "municipio", nullable = false, unique = true)
	private String municipio;

	@Column(name = "estado", nullable = false, unique = true)
	private String estado;

	@Column(name = "complemento", nullable = false, unique = true)
	private String complemento;

	@Column(name = "logradouro", nullable = false, unique = true)
	private String logradouro;

	@Column(name = "cep", nullable = false, unique = true)
	private String cep;

	@Column(name = "telefone", nullable = false, unique = true)
	private String telefone;

	@Column(name = "numero", nullable = false, unique = true)
	private Integer numero;

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
