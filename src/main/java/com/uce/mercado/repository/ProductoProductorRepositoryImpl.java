package com.uce.mercado.repository;

import com.uce.mercado.repository.model.ProductoProductor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductoProductorRepositoryImpl implements IProductoProductorRepository{

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
        return Optional.empty();
    }
}
