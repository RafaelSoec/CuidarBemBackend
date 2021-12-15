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

import com.crescer.v1.model.entities.Cliente;
import com.crescer.v1.service.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	

	@GetMapping("/todos")
	public List<Cliente> buscarTodos() {
		return this.service.buscarTodos();
	}

	@GetMapping("/buscarNome/{nome}")
	public List<Cliente> buscarClientesPorNome(@PathVariable String nome) {
		return this.service.recuperarClientePorNome(nome);
	}

	@GetMapping("/buscarCpf/{cpf}")
	public Cliente buscarClientesPorCpf(@PathVariable String cpf) {
		return this.service.recuperarClientePorCpf(cpf);
	}
	
	@GetMapping("/buscarPorEmail/{email}")
	public Cliente buscarClientePorEmail(@PathVariable String email) {
		return this.service.buscarClientePorEmail(email);
	}

	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping("/salvar")
	public Cliente salvar(@RequestBody Cliente cliente) {
		return this.service.salvar(cliente);
		
	}

	@PutMapping("/atualizar")
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return this.service.atualizar(cliente);
		
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
