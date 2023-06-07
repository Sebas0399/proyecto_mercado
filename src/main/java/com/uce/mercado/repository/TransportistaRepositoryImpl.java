package com.uce.mercado.repository;

import com.uce.mercado.repository.model.Transportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TransportistaRepositoryImpl implements ITransportistaRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Transportista create(Transportista transportista) {
        this.entityManager.persist(transportista);
        return transportista;
    }

    @Override
    public Optional<Transportista> read(Integer id) {
        Transportista transportista=this.entityManager.find(Transportista.class,id);
        return Optional.ofNullable(transportista);
    }

    @Override
    public void update(Transportista transportista) {
        this.entityManager.merge(transportista);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<Transportista>> readByCodigo(String codigo) {
        return Optional.empty();
    }
}
