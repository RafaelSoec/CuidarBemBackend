package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Locacao;

@Service
public class LocacaoService extends AbstractService<Locacao>{

	public List<Locacao> buscarTodos() {
       return super.buscarTodos();
	}

	public Locacao atualizar(Long id, Locacao Locacao){
		return super.atualizar(id, Locacao);
	}

	public Locacao salvar(Locacao Locacao){
		return super.salvar(Locacao);
	}

	public void excluir(Long id){
		super.excluir(id);
	}
}


