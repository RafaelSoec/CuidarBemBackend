package com.crescer.v1.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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


	@Column(name = "descricao", nullable = false, length = 2000)
	private String descricao;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "situacao", nullable = false)
	private Integer situacao;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "faixa_etaria", nullable = false)
	private Long faixa_etaria;

	@Column(name = "categoria", nullable = false)
	private Long categoria;
	
	@Column(name = "pacote", nullable = false)
	private Long pacote;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto", referencedColumnName = "id")
    private List<Imagem> imagens = new ArrayList<Imagem>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto", referencedColumnName = "id")
    private List<Pacote> pacotes = new ArrayList<Pacote>();
	
	public Long getPacote() {
		return pacote;
	}

	public void setPacote(Long pacote) {
		this.pacote = pacote;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
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

	public Long getFaixa_etaria() {
		return faixa_etaria;
	}

	public void setFaixa_etaria(Long faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
}
