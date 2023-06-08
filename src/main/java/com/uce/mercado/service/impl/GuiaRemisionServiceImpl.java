package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.IGuiaRemisionRepository;
import com.uce.mercado.repository.model.GuiaRemision;
import com.uce.mercado.service.inter.IGuiaRemisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GuiaRemisionServiceImpl implements IGuiaRemisionService {
    @Autowired
    private IGuiaRemisionRepository guiaRemisionRepository;
    @Override
    public GuiaRemision create(GuiaRemision guiaRemision) {
        return this.guiaRemisionRepository.create(guiaRemision);
    }

    @Override
    public Optional<GuiaRemision> read(Integer id) {
        return this.guiaRemisionRepository.read(id);
    }

    @Override
    public void update(GuiaRemision guiaRemision) {
        this.guiaRemisionRepository.update(guiaRemision);
    }

    @Override
    public void delete(Integer id) {
        this.guiaRemisionRepository.delete(id);
    }
}
