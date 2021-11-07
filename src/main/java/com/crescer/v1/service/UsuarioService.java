package com.crescer.v1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.dtos.EmailDTO;
import com.crescer.v1.model.dtos.UsuarioTrocaSenhaDTO;
import com.crescer.v1.model.entities.Cliente;
import com.crescer.v1.model.entities.Usuario;
import com.crescer.v1.repository.UsuarioRepository;

@Service
public class UsuarioService extends AbstractService<Usuario> {
	private static String ASSUNTO_EMAIL_TROCA_SENHA = "Ajudando seu filho a crescer - Troca de senha";

	@Value("${app.secretKey}")
	private String secretKey;

	@Autowired
	private BCryptPasswordEncoder crypt;

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EmailService emailService;

	public List<Usuario> buscarTodos() {
		return super.buscarTodos();
	}

	public Usuario atualizar(Usuario usuario) {
		return super.atualizar(usuario);
	}

	public Usuario salvar(Usuario usuario) {
		String senhaCriptografada = crypt.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		usuario = super.salvar(usuario);

		Cliente cliente = new Cliente();
		cliente.setId(usuario.getId());
		this.clienteService.salvar(cliente);
		return usuario;
	}

	public void excluir(Long id) {
		this.clienteService.excluir(id);
		super.excluir(id);
	}

	public Usuario atualizarSenha(UsuarioTrocaSenhaDTO usuario) {
		Usuario usuarioRecuperado = this.recuperarUsuarioPorEmail(usuario.getEmail());
		return this.atualizarSenha(usuarioRecuperado, usuario.getSenhaNova());
	}
	
	public Usuario atualizarSenha(Usuario usuario, String novaSenha) {
		try {
			Usuario usuarioRecuperado = this.login(usuario);
			String senhaCriptografada = crypt.encode(novaSenha);
			usuarioRecuperado.setSenha(senhaCriptografada);
			return this.atualizar(usuarioRecuperado);
		} catch (Exception e) {
			throw new ResponseException(e);
		}
	}

	public Usuario login(Usuario usuario) {
		Usuario usuarioRecuperado = this.recuperarUsuarioPorEmail(usuario.getEmail());
		if (usuarioRecuperado != null && usuarioRecuperado.getId() != null) {
			if (!usuario.getSenha().equals(usuarioRecuperado.getSenha()) && !crypt.matches(usuario.getSenha(), usuarioRecuperado.getSenha()) ) {
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

	public void recuperarSenhaEEnviarEmail(EmailDTO email) {
		try {
			String pathHTML = "email/trocaSenha";
			String destinatario = email.getDestinatarios();
			String novaSenha = RandomStringUtils.randomAlphanumeric(8);
			Usuario usuarioRecuperado = this.recuperarUsuarioPorEmail(destinatario);
			this.atualizarSenha(usuarioRecuperado, novaSenha);

			Map<String, Object> variaveis = new HashMap<String, Object>();
			variaveis.put("novaSenha", novaSenha);
			email.setAssunto(ASSUNTO_EMAIL_TROCA_SENHA);

			this.emailService.enviarHtmlEmail(email, pathHTML, variaveis);
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

}