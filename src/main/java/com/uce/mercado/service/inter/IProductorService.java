package com.uce.mercado.service.inter;

import com.uce.mercado.repository.model.Productor;

import java.util.List;
import java.util.Optional;

public interface IProductorService {
    public Productor create(Productor productor);
    public Optional<Productor> read(Integer id);
    public void update(Productor productor);
    public void delete(Integer id);
    public Optional<List<Productor>> likeByCedula(String cedula);
    public Optional<List<Productor>> getAll();
}
