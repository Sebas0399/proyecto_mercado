package com.uce.mercado.service;

import com.uce.mercado.repository.IProductoRepository;
import com.uce.mercado.repository.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoRepository {

    @Autowired
    IProductoRepository productoRepository;
    @Override
    public Producto create(Producto producto) {
        return this.productoRepository.create(producto);
    }

    @Override
    public Optional<Producto> read(Integer id) {
        return this.productoRepository.read(id);
    }

    @Override
    public void update(Producto producto) {
        this.productoRepository.update(producto);
    }

    @Override
    public void delete(Integer id) {
        this.productoRepository.delete(id);
    }

    @Override
    public Optional<List<Producto>> readByCodigo(String codigo) {
        return this.productoRepository.readByCodigo(codigo);
    }
}
