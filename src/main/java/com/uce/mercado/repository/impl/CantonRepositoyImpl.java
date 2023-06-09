package com.uce.mercado.repository.impl;

import java.util.List;
import java.util.Optional;

import com.uce.mercado.repository.inter.ICantonRepository;
import org.springframework.stereotype.Repository;

import com.uce.mercado.repository.model.Canton;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CantonRepositoyImpl implements ICantonRepository {
	@PersistenceContext 
	private EntityManager entityManager;
	@Override
	public Canton create(Canton canton) {
		// TODO Auto-generated method stub
		this.entityManager.persist(canton);
		return canton;
	}

	@Override
	public Optional<Canton> read(Integer id) {
		// TODO Auto-generated method stub
		Canton canton= this.entityManager.find(Canton.class,id);
		return Optional.ofNullable(canton);
	}

	@Override
	public void update(Canton canton) {
		// TODO Auto-generated method stub
		this.entityManager.merge(canton);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

	@Override
	public Optional<List<Canton>> readByCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Canton>myQuery=this.entityManager.createQuery("SELECT c FROM Canton c WHERE c.codigo=:codigo",Canton.class);
		myQuery.setParameter("codigo", codigo);
		List<Canton>res=myQuery.getResultList();
		return Optional.ofNullable(res);
	}

}
