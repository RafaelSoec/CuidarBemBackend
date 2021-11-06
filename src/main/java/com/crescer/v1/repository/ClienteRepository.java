package com.crescer.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crescer.v1.model.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT v FROM Cliente v WHERE v.cpf = ?1")
	Cliente recuperarClientePorCpf(String cpf);

	@Query("SELECT v FROM Cliente v WHERE v.nome LIKE %?1%")
	List<Cliente> recuperarClientePorNome(String nome);

}
