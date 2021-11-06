package com.crescer.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescer.v1.model.entities.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
