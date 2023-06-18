package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.IGuiaRemisionRepository;
import com.uce.mercado.repository.model.GuiaRemision;
import com.uce.mercado.repository.model.ProductoGuia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class GuiaRemisionRepositoryImpl implements IGuiaRemisionRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public GuiaRemision create(GuiaRemision guiaRemision) {
        this.entityManager.persist(guiaRemision);
        return guiaRemision;
    }

    @Override
    public Optional<GuiaRemision> read(Integer id) {
        GuiaRemision guiaRemision=this.entityManager.find(GuiaRemision.class,id);
        return Optional.ofNullable(guiaRemision);
    }

    @Override
    public void update(GuiaRemision guiaRemision) {
        this.entityManager.merge(guiaRemision);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<GuiaRemision>> readByNumero(String numero) {
        TypedQuery myQuery=this.entityManager.createQuery("SELECT g FROM guiaRemision g WHERE g.numero=:numero", GuiaRemision.class);
        myQuery.setParameter("numero",numero);
        List<GuiaRemision>res=myQuery.getResultList();
        return Optional.ofNullable(res);
    }
}
