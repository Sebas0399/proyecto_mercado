package com.uce.mercado.repository;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Transportista;

import java.util.List;
import java.util.Optional;

public interface ITransportistaRepository {
    public Transportista create(Transportista transportista);
    public Optional<Transportista> read(Integer id);
    public void update(Transportista transportista);
    public void delete(Integer id);
    public Optional<List<Transportista>> readByCodigo(String codigo);
}
