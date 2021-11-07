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

import com.crescer.v1.model.dtos.PedidoConclusaoDTO;
import com.crescer.v1.model.entities.Pedido;
import com.crescer.v1.model.enums.SituacaoProdutoEnum;
import com.crescer.v1.service.PedidoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	

	@GetMapping("/todos")
	public List<Pedido> buscarTodos() {
		return this.service.buscarTodos();
	}


	@GetMapping("/{id}")
	public Pedido buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@GetMapping("recuperarPedidoPorCliente/{cliente}")
	public List<Pedido> recuperarPedidoPorCliente(@PathVariable Long cliente){
		return this.service.recuperarPedidoPorCliente(cliente);
	}

	@GetMapping("excluirPedidoPorCliente/{cliente}")
	public void excluirPedidoPorCliente(@PathVariable Long cliente){
		this.service.excluirPedidoPorCliente(cliente);
	}

	@PostMapping("/salvar")
	public Pedido salvar(@RequestBody Pedido pedido) {
		return this.service.salvar(pedido);
		
	}

	@PostMapping("/salvarPedidoEEnviarPorEmail")
	public  List<Pedido> salvarPedidoEEnviarPorEmail(@RequestBody PedidoConclusaoDTO pedidoConclusao) {
		return this.service.salvarPedidoEEnviarPorEmail(pedidoConclusao);
		
	}
	
	@PutMapping("/atualizar")
	public Pedido atualizar( @RequestBody Pedido pedido) {
		return this.service.atualizar(pedido);
		
	}
	
	@PutMapping("/atualizarSituacao/{id}")
	public Pedido atualizarSituacao(@PathVariable Long id, @RequestBody SituacaoProdutoEnum situacao) {
		return this.service.atualizarSituacao(id, situacao);
		
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
	
}
