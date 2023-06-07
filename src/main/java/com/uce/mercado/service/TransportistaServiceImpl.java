package com.uce.mercado.service;

import com.uce.mercado.repository.ITransporteRepository;
import com.uce.mercado.repository.ITransportistaRepository;
import com.uce.mercado.repository.model.Transportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportistaServiceImpl implements ITransportistaRepository {

    @Autowired
    ITransportistaRepository transportistaRepository;
    @Override
    public Transportista create(Transportista transportista) {
        return this.transportistaRepository.create(transportista);
    }

    @Override
    public Optional<Transportista> read(Integer id) {
        return this.transportistaRepository.read(id);
    }

    @Override
    public void update(Transportista transportista) {
        this.transportistaRepository.update(transportista);
    }

    @Override
    public void delete(Integer id) {
        this.transportistaRepository.delete(id);
    }

    @Override
    public Optional<List<Transportista>> readByCodigo(String codigo) {
        return this.transportistaRepository.readByCodigo(codigo);
    }
}
