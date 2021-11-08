package com.crescer.v1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.dtos.EmailDTO;
import com.crescer.v1.model.dtos.PedidoConclusaoDTO;
import com.crescer.v1.model.entities.Cliente;
import com.crescer.v1.model.entities.Pedido;
import com.crescer.v1.model.entities.Produto;
import com.crescer.v1.model.entities.Usuario;
import com.crescer.v1.model.enums.SituacaoProdutoEnum;
import com.crescer.v1.repository.PedidoRepository;

@Service
public class PedidoService extends AbstractService<Pedido> {
	private static String ASSUNTO_ATUALIZACAO_PEDIDOS = "Ajudando seu filho a crescer - Situação de Pedido";

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EmailService emailService;

	public List<Pedido> buscarTodos() {
		return super.buscarTodos();
	}

	public void atualizarSituacao(List<Pedido> pedidos) {
		try {
			for (Pedido pedido : pedidos) {
				if (!pedido.getSituacao().equals(SituacaoProdutoEnum.PENDENTE.getTipo())) {
					Usuario usuario = this.usuarioService.buscarPorId(pedido.getCliente());
					Cliente cliente = this.clienteService.buscarPorId(pedido.getCliente());
					Produto produto = this.produtoService.buscarPorId(pedido.getProduto());

					String pathHTML = "email/atualizaProdutos";
					Map<String, Object> variaveis = new HashMap<String, Object>();
					variaveis.put("pedido", pedido);
					variaveis.put("produto", produto);
					variaveis.put("cliente", cliente);
					EmailDTO email = new EmailDTO();
					email.setDestinatarios(usuario.getEmail());
					email.setAssunto(ASSUNTO_ATUALIZACAO_PEDIDOS);

					this.emailService.enviarHtmlEmail(email, pathHTML, variaveis);
				}
				this.atualizar(pedido);
			}
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

	public Pedido atualizar(Pedido pedido) {
		return super.atualizar(pedido);
	}

	public Pedido salvar(Pedido pedido) {
		return super.salvar(pedido);
	}

	public void excluir(Long id) {
		super.excluir(id);
	}

	public List<Pedido> recuperarPedidoPorCliente(Long cliente) {
		return this.repository.recuperarPedidoPorCliente(cliente);
	}

	public void excluirPedidoPorCliente(Long cliente) {
		this.repository.excluirPedidoPorCliente(cliente);
	}

	public List<Pedido> salvarPedidoEEnviarPorEmail(PedidoConclusaoDTO pedidoConclusao) {
		EmailDTO email = pedidoConclusao.getEmail();
		List<Pedido> pedidos = super.salvarTodos(pedidoConclusao.getPedidos());
		emailService.enviarHtmlEmail(email, email.getMensagem());

		return pedidos;
	}
}
