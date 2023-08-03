package com.uce.mercado.service.inter;

import com.uce.mercado.repository.model.Transporte;

import java.util.List;
import java.util.Optional;

public interface ITransporteService {
    public Transporte create(Transporte transporte);
    public Optional<Transporte> read(Integer id);
    public void update(Transporte transporte);
    public void delete(Integer id);
    public Optional<List<Transporte>> readByPlaca(String placa);
    public Optional<List<Transporte>> readAll();

}
