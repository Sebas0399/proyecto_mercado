package com.uce.mercado.repository.inter;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Destinatario;
import com.uce.mercado.repository.model.Productor;

import java.util.List;
import java.util.Optional;

public interface IDestinatarioRepository {

    public Destinatario create(Destinatario destinatario);
    public Optional<Destinatario> read(Integer id);
    public void update(Destinatario destinatario);
    public void delete(Integer id);
    public Optional<List<Destinatario>> readByCedula(String cedula);

    public Optional<List<Destinatario>> getAll();
}
