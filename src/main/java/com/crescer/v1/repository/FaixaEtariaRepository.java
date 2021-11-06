package com.crescer.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescer.v1.model.entities.FaixaEtaria;

@Repository
public interface FaixaEtariaRepository extends JpaRepository<FaixaEtaria, Long> {
}
