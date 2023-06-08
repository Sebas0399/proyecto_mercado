package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.ITransporteRepository;
import com.uce.mercado.repository.model.Transporte;
import com.uce.mercado.service.inter.ITransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TransporteServiceImpl implements ITransporteService {
    @Autowired
    private ITransporteRepository transporteRepository;
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
    public Optional<List<Transporte>> readByPlaca(String placa) {

        return this.transporteRepository.readByPlaca(placa);
    }
}
