package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Produto;

@Service
public class ProdutoService extends AbstractService<Produto>{

	public List<Produto> buscarTodos() {
       return this.buscarTodos();
	}

	public Produto atualizar(Long id, Produto Produto){
		return super.atualizar(id, Produto);
	}

	public Produto salvar(Produto Produto){
		return super.salvar(Produto);
	}

	public void excluir(Long id){
		 this.excluir(id);
	}
}


