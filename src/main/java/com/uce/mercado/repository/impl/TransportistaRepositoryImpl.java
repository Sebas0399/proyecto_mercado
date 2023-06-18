package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.ITransportistaRepository;
import com.uce.mercado.repository.model.Transportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public class TransportistaRepositoryImpl implements ITransportistaRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Transportista create(Transportista transportista) {
        this.entityManager.persist(transportista);
        return transportista;
    }

    @Override
    public Optional<Transportista> read(Integer id) {
        Transportista transportista=this.entityManager.find(Transportista.class,id);
        return Optional.ofNullable(transportista);
    }

    @Override
    public void update(Transportista transportista) {
        this.entityManager.merge(transportista);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<Transportista>> readByCedula(String cedula) {
        TypedQuery<Transportista>myQuery=this.entityManager.createQuery("SELECT t FROM Transportista t WHERE t.cedula=:cedula",Transportista.class);
        myQuery.setParameter("cedula", cedula);
        List<Transportista>res=myQuery.getResultList();
        return Optional.ofNullable(res);
    }


}
