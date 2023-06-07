package com.uce.mercado.repository;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoRepository {


    public Producto create(Producto producto);
    public Optional<Producto> read(Integer id);
    public void update(Producto producto);
    public void delete(Integer id);
    public Optional<List<Producto>> readByCodigo(String codigo);

}
