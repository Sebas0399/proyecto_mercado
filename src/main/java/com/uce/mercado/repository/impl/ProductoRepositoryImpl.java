package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.IProductoRepository;
import com.uce.mercado.repository.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Producto create(Producto producto) {
        this.entityManager.persist(producto);
        return producto;
    }

    @Override
    public Optional<Producto> read(Integer id) {
        Producto producto= this.entityManager.find(Producto.class,id);
        return Optional.ofNullable(producto);
    }

    @Override
    public void update(Producto producto) {
        this.entityManager.merge(producto);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<Producto>> readByCodigo(String codigo) {
        TypedQuery<Producto> myQuery=this.entityManager.createQuery("SELECT p FROM Producto o WHERE p.codigo=:codigo",Producto.class);
        myQuery.setParameter("codigo", codigo);
        List<Producto>res=myQuery.getResultList();
        return Optional.ofNullable(res);
    }
}
