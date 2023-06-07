package com.uce.mercado.repository;

import com.uce.mercado.repository.model.Productor;

import java.util.List;
import java.util.Optional;

public interface IProductorRepository {
    public Productor create(Productor productor);
    public Optional<Productor> read(Integer id);
    public void update(Productor productor);
    public void delete(Integer id);
}
