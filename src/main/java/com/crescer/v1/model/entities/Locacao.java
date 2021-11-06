package com.crescer.v1.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faixa")
public class Locacao extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3454734434633235618L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	

	@Column(name = "pct_desconto", unique = true, nullable = false)
	private Double pct_desconto;

	@Column(name = "qtd_dias", unique = true, nullable = false)
	private Integer qtd_dias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPct_desconto() {
		return pct_desconto;
	}

	public void setPct_desconto(Double pct_desconto) {
		this.pct_desconto = pct_desconto;
	}

	public Integer getQtd_dias() {
		return qtd_dias;
	}

	public void setQtd_dias(Integer qtd_dias) {
		this.qtd_dias = qtd_dias;
	}
}
