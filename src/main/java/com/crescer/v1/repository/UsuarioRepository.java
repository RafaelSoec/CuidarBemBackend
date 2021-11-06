package com.crescer.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crescer.v1.model.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT v FROM Usuario v WHERE v.email = ?1")
	Usuario recuperarUsuarioPorEmail(String email);
}
