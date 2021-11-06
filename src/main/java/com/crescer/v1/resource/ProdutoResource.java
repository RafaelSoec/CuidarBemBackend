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

import com.crescer.v1.model.entities.Produto;
import com.crescer.v1.service.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	

	@GetMapping
	public List<Produto> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return this.service.salvar(produto);
		
	}

	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return this.service.atualizar(id, produto);
		
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
