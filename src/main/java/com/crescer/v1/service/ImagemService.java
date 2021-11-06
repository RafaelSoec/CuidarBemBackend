package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Imagem;

@Service
public class ImagemService extends AbstractService<Imagem>{

	public List<Imagem> buscarTodos() {
       return this.buscarTodos();
	}

	public Imagem atualizar(Long id, Imagem Imagem){
		return super.atualizar(id, Imagem);
	}

	public Imagem salvar(Imagem Imagem){
		return super.salvar(Imagem);
	}

	public void excluir(Long id){
		 this.excluir(id);
	}
}


