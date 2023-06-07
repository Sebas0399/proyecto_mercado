package com.uce.mercado.repository;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Transporte;

import java.util.List;
import java.util.Optional;

public interface ITransporteRepository {
    public Transporte create(Transporte transporte);
    public Optional<Transporte> read(Integer id);
    public void update(Transporte transporte);
    public void delete(Integer id);
    public Optional<List<Transporte>> readByCodigo(String placa);
}
