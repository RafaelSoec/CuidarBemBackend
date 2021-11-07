package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.FaixaEtaria;

@Service
public class FaixaService extends AbstractService<FaixaEtaria>{

	public List<FaixaEtaria> buscarTodos() {
       return super.buscarTodos();
	}

	public FaixaEtaria atualizar( FaixaEtaria faixaEtaria){
		return super.atualizar(faixaEtaria);
	}

	public FaixaEtaria salvar(FaixaEtaria faixaEtaria){
		return super.salvar(faixaEtaria);
	}

	public void excluir(Long id){
		super.excluir(id);
	}
}


