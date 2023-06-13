package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.IDestinatarioRepository;
import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Destinatario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class DestinatarioRepositoryImpl implements IDestinatarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Destinatario create(Destinatario destinatario) {
        this.entityManager.persist(destinatario);
        return destinatario;
    }

    @Override
    public Optional<Destinatario> read(Integer id) {
        Destinatario destinatario=this.entityManager.find(Destinatario.class,id);
        return Optional.ofNullable(destinatario);
    }

    @Override
    public void update(Destinatario destinatario) {
        this.entityManager.merge(destinatario);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<Destinatario>> readByCedula(String cedula) {
        TypedQuery<Destinatario> myQuery=this.entityManager.createQuery("SELECT d FROM Destinatario d WHERE d.cedula=:cedula",Destinatario.class);
        myQuery.setParameter("cedula", cedula);
        List<Destinatario>res=myQuery.getResultList();
        return Optional.ofNullable(res);
    }
}
