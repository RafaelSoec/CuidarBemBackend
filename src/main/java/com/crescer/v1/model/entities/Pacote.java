package com.crescer.v1.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pacote")
public class Pacote extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3454734434633235618L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	

	@Column(name = "qtd_dias", nullable = false)
	private Integer qtd_dias;

	@Column(name = "pct_desconto", nullable = false)
	private Integer pct_desconto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtd_dias() {
		return qtd_dias;
	}

	public void setQtd_dias(Integer qtd_dias) {
		this.qtd_dias = qtd_dias;
	}

	public Integer getPct_desconto() {
		return pct_desconto;
	}

	public void setPct_desconto(Integer pct_desconto) {
		this.pct_desconto = pct_desconto;
	}
	
}
