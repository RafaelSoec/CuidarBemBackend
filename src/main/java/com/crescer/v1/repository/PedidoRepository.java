package com.crescer.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crescer.v1.model.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Query("SELECT v FROM Pedido v WHERE v.cliente = ?1")
	List<Pedido> recuperarPedidoPorCliente(Long cliente);
	

	@Query("DELETE FROM Pedido v WHERE v.cliente = ?1")
	void excluirPedidoPorCliente(Long cliente);
}
