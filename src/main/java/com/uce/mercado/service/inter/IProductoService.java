package com.uce.mercado.service.inter;

import com.uce.mercado.repository.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {


    public Producto create(Producto producto);
    public Optional<Producto> read(Integer id);
    public void update(Producto producto);
    public void delete(Integer id);
    public Optional<List<Producto>> readByCodigo(String codigo);

}
