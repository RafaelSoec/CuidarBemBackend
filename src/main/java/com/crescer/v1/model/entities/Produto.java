package com.crescer.v1.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3454734434633235618L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "avaliacao", nullable = false)
	private Integer avaliacao = 5;

	@Column(name = "estoque", nullable = false)
	private Integer estoque;

	@Column(name = "pacote", nullable = false)
	private Long pacote;

	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "situacao", nullable = false)
	private Integer situacao;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "faixa_etaria", nullable = false)
	private Integer faixa_etaria;

	@Column(name = "categoria", nullable = false)
	private Integer categoria;

	@Column(name = "imagem", nullable = false)
	private String imagem;

	@Column(name = "diretorio_imagem", nullable = false)
	private String diretorioImagens;

	public String getDiretorioImagens() {
		return diretorioImagens;
	}

	public void setDiretorioImagens(String diretorioImagens) {
		this.diretorioImagens = diretorioImagens;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
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

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Long getPacote() {
		return pacote;
	}

	public void setPacote(Long pacote) {
		this.pacote = pacote;
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

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getFaixa_etaria() {
		return faixa_etaria;
	}

	public void setFaixa_etaria(Integer faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
}
