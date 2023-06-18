package com.uce.mercado.repository.inter;

import com.uce.mercado.repository.model.GuiaRemision;
import com.uce.mercado.repository.model.ProductoGuia;

import java.util.List;
import java.util.Optional;

public interface IGuiaRemisionRepository {
    public GuiaRemision create(GuiaRemision guiaRemision);
    public Optional<GuiaRemision> read(Integer id);
    public void update(GuiaRemision guiaRemision);
    public void delete(Integer id);
    public Optional<List<GuiaRemision>> readByNumero(String numero);
}
