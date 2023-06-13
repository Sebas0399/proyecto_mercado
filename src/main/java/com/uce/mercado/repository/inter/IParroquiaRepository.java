package com.uce.mercado.repository.inter;

import com.uce.mercado.repository.model.Parroquia;
import com.uce.mercado.repository.model.ProductoProductor;

import java.util.List;
import java.util.Optional;

public interface IParroquiaRepository {
    public Parroquia create(Parroquia parroquia);
    public Optional<Parroquia> read(Integer id);
    public void update(Parroquia parroquia);
    public void delete(Integer id);
    public Optional<List<Parroquia>> readByCodigo(String codigo);
}
