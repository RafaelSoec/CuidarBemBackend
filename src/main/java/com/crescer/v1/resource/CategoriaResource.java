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

import com.crescer.v1.model.entities.Categoria;
import com.crescer.v1.service.CategoriaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	

	@GetMapping("/todos")
	public List<Categoria> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public Categoria buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping
	public Categoria salvar(@RequestBody Categoria categoria) {
		return this.service.salvar(categoria);
		
	}

	@PutMapping("/atualizar")
	public Categoria atualizar( @RequestBody Categoria categoria) {
		return this.service.atualizar(categoria);
		
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
