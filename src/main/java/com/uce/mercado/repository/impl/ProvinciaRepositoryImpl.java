package com.uce.mercado.repository.impl;

import java.util.Optional;

import com.uce.mercado.repository.inter.IProvinciaRepository;
import org.springframework.stereotype.Repository;

import com.uce.mercado.repository.model.Provincia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class ProvinciaRepositoryImpl implements IProvinciaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Provincia create(Provincia provinica) {
		// TODO Auto-generated method stub
		 this.entityManager.persist(provinica);
		 return provinica;
	}

	@Override
	public Optional<Provincia> read(Integer id) {
		// TODO Auto-generated method stub
		Provincia provincia = entityManager.find(Provincia.class, id);
        return Optional.ofNullable(provincia);
	}

	@Override
	public void update(Provincia provincia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(provincia);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

}
