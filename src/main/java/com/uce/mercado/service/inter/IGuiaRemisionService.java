package com.uce.mercado.service.inter;

import com.uce.mercado.repository.model.GuiaRemision;
import com.uce.mercado.repository.model.ProductoGuia;

import java.util.List;
import java.util.Optional;

public interface IGuiaRemisionService {
    public GuiaRemision create(GuiaRemision guiaRemision);
    public Optional<GuiaRemision> read(Integer id);
    public void update(GuiaRemision guiaRemision);
    public boolean delete(Integer id);
    public Optional<List<GuiaRemision>> readByNumero(String numero);
    public Optional<List<GuiaRemision>> getAll();


}
