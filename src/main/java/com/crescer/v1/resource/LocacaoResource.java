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

import com.crescer.v1.model.entities.Locacao;
import com.crescer.v1.service.LocacaoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="locacao")
public class LocacaoResource {
	
	@Autowired
	private LocacaoService service;
	

	@GetMapping("/todos")
	public List<Locacao> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public Locacao buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping
	public Locacao salvar(@RequestBody Locacao locacao) {
		return this.service.salvar(locacao);
		
	}

	@PutMapping("/{id}")
	public Locacao atualizar(@PathVariable Long id, @RequestBody Locacao locacao) {
		return this.service.atualizar(id, locacao);
		
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
