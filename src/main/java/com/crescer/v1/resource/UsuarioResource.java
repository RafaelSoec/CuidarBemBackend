package com.crescer.v1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescer.v1.model.dtos.EmailDTO;
import com.crescer.v1.model.dtos.UsuarioTrocaSenhaDTO;
import com.crescer.v1.model.entities.Usuario;
import com.crescer.v1.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping("/todos")
	public List<Usuario> buscarTodos() {
		return this.service.buscarTodos();
	}

	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario usuario) {
		return this.service.login(usuario);
	}

	@GetMapping("/recuperarUsuarioPorEmail/{email}")
	public Usuario recuperarUsuarioPorEmail(@PathVariable String email) {
		return this.service.recuperarUsuarioPorEmail(email);
	}

	@PostMapping("/salvar")
	public Usuario salvar(@RequestBody Usuario usuario) {
		return this.service.salvar(usuario);

	}

	@PostMapping("/atualizarSenha")
	public Usuario atualizarSenha(@RequestBody UsuarioTrocaSenhaDTO usuario) {
		return this.service.atualizarSenha(usuario);
	}

	@PostMapping("/atualizar")
	public Usuario atualizar(@RequestBody Usuario usuario) {
		return this.service.atualizar(usuario);
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable Long id) {
		this.service.excluir(id);
	}

	@PostMapping("/recuperarSenhaEEnviarEmail")
	public void recuperarSenhaEEnviarEmail(@RequestBody EmailDTO email) {
		this.service.recuperarSenhaEEnviarEmail(email);
	}
}
