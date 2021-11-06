package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Pedido;

@Service
public class PedidoService extends AbstractService<Pedido>{

	public List<Pedido> buscarTodos() {
       return this.buscarTodos();
	}

	public Pedido atualizar(Long id, Pedido Pedido){
		return super.atualizar(id, Pedido);
	}

	public Pedido salvar(Pedido Pedido){
		return super.salvar(Pedido);
	}

	public void excluir(Long id){
		 this.excluir(id);
	}
}


