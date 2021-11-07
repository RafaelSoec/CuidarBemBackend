package com.crescer.v1.model.dtos;

import java.util.ArrayList;
import java.util.List;

import com.crescer.v1.model.entities.Pedido;

public class PedidoConclusaoDTO {
	private EmailDTO email;
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public EmailDTO getEmail() {
		return email;
	}

	public void setEmail(EmailDTO email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
