package com.uce.mercado.service.inter;

import com.uce.mercado.repository.model.GuiaRemision;

import java.util.Optional;

public interface IGuiaRemisionService {
    public GuiaRemision create(GuiaRemision guiaRemision);
    public Optional<GuiaRemision> read(Integer id);
    public void update(GuiaRemision guiaRemision);
    public void delete(Integer id);
}
