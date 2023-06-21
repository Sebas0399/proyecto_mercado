package com.uce.mercado.repository.inter;

import com.uce.mercado.repository.model.ProductoGuia;

import java.util.List;
import java.util.Optional;

public interface IProductoGuiaRepository {
    public ProductoGuia create(ProductoGuia productoGuia);
    public Optional<ProductoGuia> read(Integer id);
    public void update(ProductoGuia productoGuia);
    public void delete(Integer id);
    public Optional<List<ProductoGuia>> readByCodigo(String codigo);

}
