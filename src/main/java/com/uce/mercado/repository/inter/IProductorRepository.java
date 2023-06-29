package com.uce.mercado.repository.inter;

import com.uce.mercado.repository.model.Producto;
import com.uce.mercado.repository.model.Productor;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public interface IProductorRepository {
    public Productor create(Productor productor);
    public Optional<Productor> read(Integer id);
    public void update(Productor productor);
    public void delete(Integer id);

    public Optional<List<Productor>> likeByCedula(String cedula);

    public Optional<List<Productor>> getAll();
}
