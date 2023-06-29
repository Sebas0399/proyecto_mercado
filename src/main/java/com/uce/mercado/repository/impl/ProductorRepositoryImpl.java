package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.IProductorRepository;
import com.uce.mercado.repository.model.Producto;
import com.uce.mercado.repository.model.Productor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductorRepositoryImpl implements IProductorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Productor create(Productor productor) {
        this.entityManager.persist(productor);
        return productor;
    }

    @Override
    public Optional<Productor> read(Integer id) {
        Productor productor= this.entityManager.find(Productor.class,id);
        return Optional.ofNullable(productor);
    }

    @Override
    public void update(Productor productor) {
        this.entityManager.merge(productor);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<Productor>> likeByCedula(String cedula) {
        TypedQuery<Productor> myQuery=this.entityManager.createQuery("SELECT p FROM Productor p WHERE p.cedula LIKE:cedula",Productor.class);
        myQuery.setParameter("cedula", "%" + cedula + "%");
        myQuery.setMaxResults(10);
        List<Productor>res=myQuery.getResultList();

        return Optional.ofNullable(res);
    }

    @Override
    public Optional<List<Productor>> getAll() {
        TypedQuery<Productor> myQuery=this.entityManager.createQuery("SELECT p FROM Productor p",Productor.class);
        myQuery.setMaxResults(10);
        List<Productor>res=myQuery.getResultList();

        return Optional.ofNullable(res);
    }

}
