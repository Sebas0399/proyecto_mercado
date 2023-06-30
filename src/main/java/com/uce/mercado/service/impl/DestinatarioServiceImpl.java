package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.IDestinatarioRepository;
import com.uce.mercado.repository.model.Destinatario;
import com.uce.mercado.service.inter.IDestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinatarioServiceImpl implements IDestinatarioService {

    @Autowired
    private IDestinatarioRepository destinatarioRepository;

    @Override
    public Destinatario create(Destinatario destinatario) {
        return this.destinatarioRepository.create(destinatario);
    }

    @Override
    public Optional<Destinatario> read(Integer id) {
        return this.destinatarioRepository.read(id);
    }

    @Override
    public void update(Destinatario destinatario) {
        this.destinatarioRepository.update(destinatario);
    }

    @Override
    public void delete(Integer id) {
        this.destinatarioRepository.delete(id);
    }

    @Override
    public Optional<List<Destinatario>> readByCedula(String cedula) {
        return this.destinatarioRepository.readByCedula(cedula);
    }

    @Override
    public Optional<List<Destinatario>> getAll() {
        return this.destinatarioRepository.getAll();
    }
}
