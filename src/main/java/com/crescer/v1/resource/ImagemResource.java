package com.crescer.v1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescer.v1.model.entities.Imagem;
import com.crescer.v1.service.ImagemService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="imagem")
public class ImagemResource {
	
	@Autowired
	private ImagemService service;
	

	@GetMapping
	public List<Imagem> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public Imagem buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping
	public Imagem salvar(@RequestBody Imagem imagem) {
		return this.service.salvar(imagem);
		
	}

	@PutMapping("/{id}")
	public Imagem atualizar(@PathVariable Long id, @RequestBody Imagem imagem) {
		return this.service.atualizar(id, imagem);
		
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
