package com.crescer.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.entities.Cliente;
import com.crescer.v1.repository.ClienteRepository;

@Service
public class ClienteService extends AbstractService<Cliente>{
	
	private ClienteRepository repository;


	//Por padrão a busca por clientes realiza uma paginação de 10 elementos por vez
	public List<Cliente> buscarTodos() {
       return super.buscarTodos();
	}
	
	public Cliente atualizar(Long id, Cliente cliente){
		this.validarDadosCliente(cliente);
		return super.atualizar(id, cliente);
	}

	public Cliente salvar(Cliente cliente){
		this.validarDadosCliente(cliente);
		boolean cpfExiste = this.validarCpfDuplicado(cliente.getCpf());
		if(cpfExiste) {
			throw new ResponseException("CPF já cadastrado.");
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
	
	public void validarDadosCliente(Cliente cliente) {
		if(cliente == null) {
			throw new ResponseException("Cliente não informado.");
		}
		if(cliente.getNome() == null) {
			throw new ResponseException("Nome não informado.");
		}
		
		if(cliente.getCpf() == null) {
			throw new ResponseException("CPF não informado.");
		}
	}

	public Cliente recuperarClientePorCpf(String cpf) {
		return this.repository.recuperarClientePorCpf(cpf);
	}

	public List<Cliente> recuperarClientePorNome(String nome) {
		return this.repository.recuperarClientePorNome(nome);
	}
	

	public void excluir(Long id){
		 super.excluir(id);
	}
}


