package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.ITransortistaRepository;
import com.uce.mercado.repository.model.Transportista;
import com.uce.mercado.service.inter.ITransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TransportistaServiceImpl implements ITransportistaService {
    @Autowired
    private ITransortistaRepository transortistaRepository;
    @Override
    public Transportista create(Transportista transportista) {
        return this.transortistaRepository.create(transportista);
    }

    @Override
    public Optional<Transportista> read(Integer id) {
        return this.transortistaRepository.read(id);
    }

    @Override
    public void update(Transportista transportista) {
this.transortistaRepository.update(transportista);
    }

    @Override
    public void delete(Integer id) {
this.transortistaRepository.delete(id);
    }

    @Override
    public Optional<List<Transportista>> readByCedula(String cedula) {
        return this.transortistaRepository.readByCedula(cedula);
    }
}
