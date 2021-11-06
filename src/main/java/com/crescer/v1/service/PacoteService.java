package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Pacote;

@Service
public class PacoteService extends AbstractService<Pacote>{

	public List<Pacote> buscarTodos() {
       return this.buscarTodos();
	}

	public Pacote atualizar(Long id, Pacote Pacote){
		return super.atualizar(id, Pacote);
	}

	public Pacote salvar(Pacote Pacote){
		return super.salvar(Pacote);
	}

	public void excluir(Long id){
		 this.excluir(id);
	}
}


