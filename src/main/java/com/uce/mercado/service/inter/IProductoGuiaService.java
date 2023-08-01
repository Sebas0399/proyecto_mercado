package com.uce.mercado.service.inter;

import com.uce.mercado.repository.model.ProductoGuia;

import java.util.List;
import java.util.Optional;

public interface IProductoGuiaService {
    public ProductoGuia create(ProductoGuia productoGuia);
    public Optional<ProductoGuia> read(Integer id);
    public void update(ProductoGuia productoGuia);
    public void delete(Integer id);
    public Optional<List<ProductoGuia>> readByCodigo(String codigo);
    public Optional<List<ProductoGuia>> readByNumeroGuia(String numero);
}
