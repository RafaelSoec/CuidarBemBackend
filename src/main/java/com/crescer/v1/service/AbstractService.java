package com.crescer.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.entities.AbstractEntity;

public abstract class AbstractService<T extends AbstractEntity> {

	@Autowired
	private JpaRepository<T, Long> repository;

	public T buscarPorId(Long id) {
		if (id == null) {
			throw new ResponseException("Id não informado.");
		}

		Optional<T> entity = this.repository.findById(id);

		if (!entity.isPresent()) {
			return null;
		}

		return entity.get();
	}

	public List<T> buscarTodos() {
		return this.repository.findAll();
	}

	public T salvar(T entity) {
		if (entity == null) {
			throw new ResponseException("Objeto não informado.");
		}

		if (entity.getId() == null) {
			return this.repository.save(entity);
		} else {
			T entityRec = this.buscarPorId(entity.getId());
			if (entityRec != null) {
				throw new ResponseException("Id já cadastrado.");
			} else {
				return this.repository.save(entity);
			}
		}
	}

	public T atualizar(Long id, T entity) {
		T entityRec = this.buscarPorId(id);

		if (entityRec == null) {
			throw new ResponseException("Id não encontrado.");
		}

		entityRec = entity;
		entityRec.setId(id);
		return this.repository.save(entityRec);
	}

	public void excluir(Long id) {
		T entityRec = this.buscarPorId(id);
		this.repository.delete(entityRec);
	}
}
