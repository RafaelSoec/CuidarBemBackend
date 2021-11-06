package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Categoria;

@Service
public class CategoriaService extends AbstractService<Categoria>{

	public List<Categoria> buscarTodos() {
       return super.buscarTodos();
	}

	public Categoria atualizar(Long id, Categoria Categoria){
		return super.atualizar(id, Categoria);
	}

	public Categoria salvar(Categoria Categoria){
		return super.salvar(Categoria);
	}

	public void excluir(Long id){
		super.excluir(id);
	}
}


