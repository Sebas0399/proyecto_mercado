package com.uce.mercado.repository.inter;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.ProductoProductor;

import java.util.List;
import java.util.Optional;

public interface IProductoProductorRepository {
    public ProductoProductor create(ProductoProductor productoProductor);
    public Optional<ProductoProductor> read(Integer id);
    public void update(ProductoProductor productoProductor);
    public void delete(Integer id);
    public Optional<List<ProductoProductor>> readByCodigo(String codigo);
}
