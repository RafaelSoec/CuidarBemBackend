package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Categoria;

@Service
public class CategoriaService extends AbstractService<Categoria>{

	public List<Categoria> buscarTodos() {
       return super.buscarTodos();
	}

	public Categoria atualizar(Categoria categoria){
		return super.atualizar(categoria);
	}

	public Categoria salvar(Categoria categoria){
		return super.salvar(categoria);
	}

	public void excluir(Long id){
		super.excluir(id);
	}
}


