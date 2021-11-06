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

import com.crescer.v1.model.entities.Usuario;
import com.crescer.v1.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	

	@GetMapping
	public List<Usuario> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@GetMapping("/recuperarUsuarioPorEmail/{email}")
	public Usuario recuperarUsuarioPorEmail(@PathVariable String email) {
		return this.service.recuperarUsuarioPorEmail(email);
	}

	@PostMapping
	public Usuario salvar(@RequestBody Usuario usuario) {
		return this.service.salvar(usuario);
		
	}

	@PutMapping("/{id}")
	public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		return this.service.atualizar(id, usuario);
		
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
