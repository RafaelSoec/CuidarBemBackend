package com.crescer.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescer.v1.model.entities.Imagem;
import com.crescer.v1.repository.ImagemRepository;

@Service
public class ImagemService extends AbstractService<Imagem>{

	@Autowired
	private ImagemRepository repository;
	
	public List<Imagem> buscarTodos() {
       return super.buscarTodos();
	}

	public List<Imagem> getImagensPorDiretorio(String diretorio) {
       return this.repository.getImagensPorDiretorio(diretorio);
	}
	

	public Imagem atualizar(Imagem Imagem){
		return super.atualizar(Imagem);
	}

	public Imagem salvar(Imagem Imagem){
		return super.salvar(Imagem);
	}

	public void excluir(Long id){
		super.excluir(id);
	}
}


