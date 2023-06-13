package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.IParroquiaRepository;
import com.uce.mercado.repository.model.Parroquia;
import com.uce.mercado.service.inter.IParroquiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParroquiaServiceImpl implements IParroquiaService {
    @Autowired
    private IParroquiaRepository parroquiaRepository;
    @Override
    public Parroquia create(Parroquia parroquia) {
        return this.parroquiaRepository.create(parroquia);
    }

    @Override
    public Optional<Parroquia> read(Integer id) {
        return this.parroquiaRepository.read(id);
    }

    @Override
    public void update(Parroquia parroquia) {
        this.parroquiaRepository.update(parroquia);
    }

    @Override
    public void delete(Integer id) {
        this.parroquiaRepository.delete(id);
    }

    @Override
    public Optional<List<Parroquia>> readByCodigo(String codigo) {
        return this.parroquiaRepository.readByCodigo(codigo);
    }
}
