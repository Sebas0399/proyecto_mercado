package com.uce.mercado.service;

import com.uce.mercado.repository.ITransporteRepository;
import com.uce.mercado.repository.model.Transporte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransporteServiceImpl implements ITransporteRepository {
    @Autowired
    ITransporteRepository transporteRepository;

    @Override
    public Transporte create(Transporte transporte) {
        return this.transporteRepository.create(transporte);
    }

    @Override
    public Optional<Transporte> read(Integer id) {
        return this.transporteRepository.read(id);
    }

    @Override
    public void update(Transporte transporte) {
        this.transporteRepository.update(transporte);
    }

    @Override
    public void delete(Integer id) {
        this.transporteRepository.delete(id);
    }

    @Override
    public Optional<List<Transporte>> readByCodigo(String placa) {
        return this.transporteRepository.readByCodigo(placa);
    }
}
