package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.IProductoProductorRepository;
import com.uce.mercado.repository.model.ProductoProductor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductoProductorRepositoryImpl implements IProductoProductorRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public ProductoProductor create(ProductoProductor productoProductor) {
        this.entityManager.persist(productoProductor);
        return productoProductor;
    }

    @Override
    public Optional<ProductoProductor> read(Integer id) {
        ProductoProductor productoProductor=this.entityManager.find(ProductoProductor.class,id);
        return Optional.ofNullable(productoProductor);
    }

    @Override
    public void update(ProductoProductor productoProductor) {
        this.entityManager.merge(productoProductor);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<ProductoProductor>> readByCodigo(String codigo) {
        TypedQuery myQuery=this.entityManager.createQuery("SELECT p FROM productoProductor p WHERE p.id=:id", ProductoProductor.class);
        myQuery.setParameter("id",codigo);
        List<ProductoProductor>res=myQuery.getResultList();

        return Optional.ofNullable(res);
    }
}
