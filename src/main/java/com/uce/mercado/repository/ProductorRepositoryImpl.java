package com.uce.mercado.repository;

import com.uce.mercado.repository.model.Productor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
}
