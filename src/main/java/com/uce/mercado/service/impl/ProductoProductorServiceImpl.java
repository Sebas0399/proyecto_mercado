package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.IProductoProductorRepository;
import com.uce.mercado.repository.inter.IProductorRepository;
import com.uce.mercado.repository.model.ProductoProductor;
import com.uce.mercado.service.inter.IProductoProductorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoProductorServiceImpl implements IProductoProductorService {

    @Autowired
    IProductoProductorRepository productoProductorRepository;
    @Override
    public ProductoProductor create(ProductoProductor productoProductor) {
        return this.productoProductorRepository.create(productoProductor);
    }

    @Override
    public Optional<ProductoProductor> read(Integer id) {
        return this.productoProductorRepository.read(id);
    }

    @Override
    public void update(ProductoProductor productoProductor) {
        this.productoProductorRepository.update(productoProductor);
    }

    @Override
    public void delete(Integer id) {
        this.productoProductorRepository.delete(id);
    }

    @Override
    public Optional<List<ProductoProductor>> readByCodigo(String codigo) {
        return this.productoProductorRepository.readByCodigo(codigo);
    }
}
