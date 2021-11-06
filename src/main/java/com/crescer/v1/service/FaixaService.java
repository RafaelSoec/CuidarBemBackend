package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.FaixaEtaria;

@Service
public class FaixaService extends AbstractService<FaixaEtaria>{

	public List<FaixaEtaria> buscarTodos() {
       return super.buscarTodos();
	}

	public FaixaEtaria atualizar(Long id, FaixaEtaria FaixaEtaria){
		return super.atualizar(id, FaixaEtaria);
	}

	public FaixaEtaria salvar(FaixaEtaria FaixaEtaria){
		return super.salvar(FaixaEtaria);
	}

	public void excluir(Long id){
		super.excluir(id);
	}
}


