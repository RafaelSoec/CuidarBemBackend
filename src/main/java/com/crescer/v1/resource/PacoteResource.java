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

import com.crescer.v1.model.entities.Pacote;
import com.crescer.v1.service.PacoteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="pacote")
public class PacoteResource {
	
	@Autowired
	private PacoteService service;
	

	@GetMapping("/todos")
	public List<Pacote> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public Pacote buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping
	public Pacote salvar(@RequestBody Pacote pacote) {
		return this.service.salvar(pacote);
		
	}

	@PutMapping("/{id}")
	public Pacote atualizar(@PathVariable Long id, @RequestBody Pacote pacote) {
		return this.service.atualizar(id, pacote);
		
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
