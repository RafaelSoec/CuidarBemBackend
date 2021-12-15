package com.crescer.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.entities.Cliente;
import com.crescer.v1.model.entities.Usuario;
import com.crescer.v1.repository.ClienteRepository;

@Service
public class ClienteService extends AbstractService<Cliente>{
	
	private ClienteRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;


	//Por padrão a busca por clientes realiza uma paginação de 10 elementos por vez
	public List<Cliente> buscarTodos() {
       return super.buscarTodos();
	}
	
	public Cliente atualizar(Cliente cliente){
		return super.atualizar(cliente);
	}

	public Cliente salvar(Cliente cliente){
		if(cliente.getCpf() != null) {
			boolean cpfExiste = this.validarCpfDuplicado(cliente.getCpf());
			if(cpfExiste) {
				throw new ResponseException("CPF já cadastrado.");
			}
		}
		
		return super.salvar(cliente);
	}
	
	//retorna true se o cpf do cliente for duplicado
	public boolean validarCpfDuplicado(String cpf) {
		Cliente cliente = this.repository.recuperarClientePorCpf(cpf);
		
		if(cliente != null) {
			return true;
		}
		
		return false;
	}

	public Cliente recuperarClientePorCpf(String cpf) {
		return this.repository.recuperarClientePorCpf(cpf);
	}

	public Cliente buscarClientePorEmail(String email) {
		Usuario usuario = this.usuarioService.recuperarUsuarioPorEmail(email);
		return this.buscarPorId(usuario.getId());
	}
	

	public List<Cliente> recuperarClientePorNome(String nome) {
		return this.repository.recuperarClientePorNome(nome);
	}
	

	public void excluir(Long id){
		 super.excluir(id);
	}
}


