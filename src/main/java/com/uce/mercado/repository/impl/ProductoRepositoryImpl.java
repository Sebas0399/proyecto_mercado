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
        Producto producto = this.entityManager.find(Producto.class, id);
        return Optional.ofNullable(producto);
    }

    @Override
    public Boolean update(Producto producto) {
        Producto productoAct = this.entityManager.merge(producto);
        if (productoAct != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean delete(Integer id) {

        if (this.read(id).isPresent()) {

            this.entityManager.remove(this.read(id).get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<List<Producto>> readByCodigo(String codigo) {
        TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigo=:codigo", Producto.class);
        myQuery.setParameter("codigo", codigo);
        List<Producto> res = myQuery.getResultList();
        return Optional.ofNullable(res);
    }

    @Override
    public Optional<List<Producto>> readByNombre(String nombre) {
        TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.nombre=:nombre", Producto.class);
        myQuery.setParameter("nombre", nombre);
        List<Producto> res = myQuery.getResultList();
        return Optional.ofNullable(res);
    }

    @Override
    public Optional<List<Producto>> likeByLetter(String letter) {
        TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE:letter", Producto.class);
        myQuery.setParameter("letter", "%" + letter + "%");
        List<Producto> res = myQuery.getResultList();

        return Optional.ofNullable(res);
    }

    @Override
    public Optional<List<Producto>> getAll() {
        TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);

        List<Producto> res = myQuery.getResultList();

        return Optional.ofNullable(res);
    }
}
