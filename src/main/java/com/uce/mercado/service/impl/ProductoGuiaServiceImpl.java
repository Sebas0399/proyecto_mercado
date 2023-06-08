package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.IProductoGuiaRepository;
import com.uce.mercado.repository.model.ProductoGuia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoGuiaServiceImpl implements IProductoGuiaRepository {

    @Autowired
    IProductoGuiaRepository productoGuiaRepository;

    @Override
    public ProductoGuia create(ProductoGuia productoGuia) {
        return this.productoGuiaRepository.create(productoGuia);
    }

    @Override
    public Optional<ProductoGuia> read(Integer id) {
        return this.productoGuiaRepository.read(id);
    }

    @Override
    public void update(ProductoGuia productoGuia) {
        this.productoGuiaRepository.update(productoGuia);
    }

    @Override
    public void delete(Integer id) {
        this.productoGuiaRepository.delete(id);
    }

    @Override
    public Optional<List<ProductoGuia>> readByCodigo(String codigo) {
        return this.productoGuiaRepository.readByCodigo(codigo);
    }
}
