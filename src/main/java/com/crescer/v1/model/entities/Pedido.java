package com.crescer.v1.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3454734434633235618L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	

	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "produto", nullable = false)
	private Long produto;

	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "situacao", nullable = false)
	private String situacao;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "cliente", nullable = false)
	private Long cliente;

	@Column(name = "data", nullable = false)
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getProduto() {
		return produto;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
