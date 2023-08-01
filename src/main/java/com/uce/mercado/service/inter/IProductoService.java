package com.uce.mercado.service.inter;

import com.uce.mercado.repository.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {


    public Producto create(Producto producto);
    public Optional<Producto> read(Integer id);
    public Boolean update(Producto producto);
    public Boolean delete(Integer id);
    public Optional<List<Producto>> readByCodigo(String codigo);

    public Optional<List<Producto>> readByNombre(String nombre);
    public Optional<List<Producto>> likeByLetter(String letter);
    public Optional<List<Producto>> getAll();

}
