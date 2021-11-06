package com.crescer.v1.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.entities.Usuario;
import com.crescer.v1.repository.UsuarioRepository;

@Service
public class UsuarioService extends AbstractService<Usuario> {
	@Value("${app.secretKey}")
	private String secretKey;

	@Autowired
	private BCryptPasswordEncoder crypt;

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> buscarTodos() {
		return this.buscarTodos();
	}

	public Usuario atualizar(Long id, Usuario Usuario) {
		return super.atualizar(id, Usuario);
	}

	public Usuario salvar(Usuario Usuario) {
		return super.salvar(Usuario);
	}

	public void excluir(Long id) {
		this.excluir(id);
	}

	public Usuario atualizarSenha(Usuario usuario, String novaSenha) {
		try {
			Usuario usuarioRecuperado = this.login(usuario);
			usuarioRecuperado.setSenha(novaSenha);
			return this.atualizar(usuario.getId(), usuarioRecuperado);
		} catch (Exception e) {
			throw new ResponseException(e);
		}
	}

	public Usuario login(Usuario usuario) {
		Usuario usuarioRecuperado = this.recuperarUsuarioPorEmail(usuario.getEmail());
		if (usuarioRecuperado != null && usuarioRecuperado.getId() != null) {
			String senhaCriptografada = crypt.encode(usuario.getSenha());

			if (!usuarioRecuperado.getSenha().equals(senhaCriptografada)) {
				throw new ResponseException("Usuário ou senha inválido.");
			}
			return usuarioRecuperado;
		} else {
			throw new ResponseException("Usuário não cadastrado.");
		}
	}

	public Usuario recuperarUsuarioPorEmail(String email) {
		if (email == null) {
			throw new ResponseException("Email inválido.");
		}

		Usuario usuario = this.repository.recuperarUsuarioPorEmail(email);
		if (usuario == null || usuario.getId() == null) {
			throw new ResponseException("Usuário não encontrado.");
		}

		return usuario;
	}

}