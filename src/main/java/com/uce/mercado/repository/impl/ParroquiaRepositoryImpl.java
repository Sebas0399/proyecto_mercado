package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.IParroquiaRepository;
import com.uce.mercado.repository.model.Parroquia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public class ParroquiaRepositoryImpl implements IParroquiaRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Parroquia create(Parroquia parroquia) {
        this.entityManager.persist(parroquia);
        return parroquia;
    }

    @Override
    public Optional<Parroquia> read(Integer id) {
        Parroquia parroquia=this.entityManager.find(Parroquia.class,id);
        return Optional.of(parroquia);
    }

    @Override
    public void update(Parroquia parroquia) {
        this.entityManager.merge(parroquia);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<Parroquia>> readByCodigo(String codigo) {
        TypedQuery<Parroquia> myQuery=this.entityManager.createQuery("SELECT p FROM Parroquia p WHERE p.codigo=:codigo",Parroquia.class);
        myQuery.setParameter("codigo", codigo);
        List<Parroquia>res=myQuery.getResultList();
        return Optional.ofNullable(res);
    }
}
