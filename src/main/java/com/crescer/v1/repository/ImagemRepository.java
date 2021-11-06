package com.crescer.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crescer.v1.model.entities.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

	@Query("SELECT v FROM Imagem v WHERE v.diretorio LIKE %?1%")
	public List<Imagem> getImagensPorDiretorio(String diretorio);
}
