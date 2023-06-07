package com.uce.mercado.repository;

import com.uce.mercado.repository.model.ProductoGuia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductoGuiaRepositoryImpl implements IProductoGuiaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductoGuia create(ProductoGuia productoGuia) {
        this.entityManager.persist(productoGuia);
        return productoGuia;
    }

    @Override
    public Optional<ProductoGuia> read(Integer id) {
        ProductoGuia productoGuia=this.entityManager.find(ProductoGuia.class, id);
        return Optional.ofNullable(productoGuia);
    }

    @Override
    public void update(ProductoGuia productoGuia) {
        this.entityManager.merge(productoGuia);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<ProductoGuia>> readByCodigo(String codigo) {
        return Optional.empty();
    }
}
