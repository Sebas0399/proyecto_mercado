package com.uce.mercado.service.impl;

import com.uce.mercado.repository.model.Transportista;
import com.uce.mercado.service.inter.ITransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TransportistaServiceImpl implements ITransportistaService {
    @Autowired
    private ITransportistaService transportistaService;
    @Override
    public Transportista create(Transportista transportista) {
        return this.transportistaService.create(transportista);
    }

    @Override
    public Optional<Transportista> read(Integer id) {
        return this.transportistaService.read(id);
    }

    @Override
    public void update(Transportista transportista) {
this.transportistaService.update(transportista);
    }

    @Override
    public void delete(Integer id) {
this.transportistaService.delete(id);
    }

    @Override
    public Optional<List<Transportista>> readByCedula(String cedula) {
        return this.transportistaService.readByCedula(cedula);
    }
}
