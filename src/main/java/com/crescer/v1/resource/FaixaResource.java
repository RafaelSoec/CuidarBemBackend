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

import com.crescer.v1.model.entities.FaixaEtaria;
import com.crescer.v1.service.FaixaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="faixa")
public class FaixaResource {
	
	@Autowired
	private FaixaService service;
	

	@GetMapping("/todos")
	public List<FaixaEtaria> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public FaixaEtaria buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping("/salvar")
	public FaixaEtaria salvar(@RequestBody FaixaEtaria faixa) {
		return this.service.salvar(faixa);
		
	}

	@PutMapping("/atualizar")
	public FaixaEtaria atualizar(@RequestBody FaixaEtaria faixa) {
		return this.service.atualizar(faixa);
		
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
