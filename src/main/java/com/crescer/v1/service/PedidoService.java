package com.crescer.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Pedido;
import com.crescer.v1.model.enums.SituacaoProdutoEnum;
import com.crescer.v1.repository.PedidoRepository;

@Service
public class PedidoService extends AbstractService<Pedido>{

	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> buscarTodos() {
       return super.buscarTodos();
	}

	public Pedido atualizarSituacao(Long id, SituacaoProdutoEnum situacao){
		Pedido pedido = this.buscarPorId(id);
		pedido.setSituacao(situacao.getTipo());
		
		return this.atualizar(id, pedido);
	}
	
	public Pedido atualizar(Long id, Pedido pedido){
		return super.atualizar(id, pedido);
	}

	public Pedido salvar(Pedido pedido){
		return super.salvar(pedido);
	}

	public void excluir(Long id){
		super.excluir(id);
	}
	

	public List<Pedido> recuperarPedidoPorCliente(Long cliente){
		return this.repository.recuperarPedidoPorCliente(cliente);
	}
	
	public void excluirPedidoPorCliente(Long cliente){
		this.repository.excluirPedidoPorCliente(cliente);
	}
}


