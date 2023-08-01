package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.ITransortistaRepository;
import com.uce.mercado.repository.model.Canton;
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
public class TransportistaRepositoryImpl implements ITransortistaRepository {
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

    @Override
    public Optional<List<Transportista>> readAll() {
        TypedQuery<Transportista>myQuery=this.entityManager.createQuery("SELECT t FROM Transportista t",Transportista.class);
        List<Transportista>res=myQuery.getResultList();
        System.out.println(res);
        return Optional.ofNullable(res);
    }


}
