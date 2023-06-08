package com.uce.mercado.repository.inter;

import com.uce.mercado.repository.model.Transporte;
import com.uce.mercado.repository.model.Transportista;

import java.util.List;
import java.util.Optional;

public interface ITransporteRepository {
    public Transporte create(Transporte transporte);
    public Optional<Transporte> read(Integer id);
    public void update(Transporte transporte);
    public void delete(Integer id);
    public Optional<List<Transporte>> readByPlaca(String placa);
}
