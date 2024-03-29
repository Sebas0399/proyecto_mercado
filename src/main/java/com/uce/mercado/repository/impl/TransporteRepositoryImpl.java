package com.uce.mercado.repository.impl;

import com.uce.mercado.repository.inter.ITransporteRepository;
import com.uce.mercado.repository.model.Producto;
import com.uce.mercado.repository.model.Transporte;
import com.uce.mercado.repository.model.Transportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public class TransporteRepositoryImpl implements ITransporteRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Transporte create(Transporte transporte) {
        this.entityManager.persist(transporte);
        return transporte;
    }

    @Override
    public Optional<Transporte> read(Integer id) {
        Transporte transporte=this.entityManager.find(Transporte.class,id);
        return Optional.ofNullable(transporte);
    }

    @Override
    public void update(Transporte transporte) {
        this.entityManager.merge(transporte);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public Optional<List<Transporte>> readByPlaca(String placa) {
        TypedQuery myQuery=this.entityManager.createQuery("SELECT t FROM Transporte t WHERE t.placa=:placa",Transporte.class);
        myQuery.setParameter("placa",placa);
        List<Transporte>res=myQuery.getResultList();
        return Optional.ofNullable(res);

    }

    @Override
    public Optional<Transporte> readByCedula(String cedula) {

        TypedQuery<Transporte> myQuery=this.entityManager.createQuery("SELECT t FROM Transporte t WHERE t.transportista.cedula=:cedula",Transporte.class);
        myQuery.setParameter("cedula",cedula);
        Transporte res=myQuery.getSingleResult();
        return Optional.ofNullable(res);
    }

    @Override
    public Optional<List<Transporte>> readAll() {
        TypedQuery<Transporte> myQuery = this.entityManager.createQuery("SELECT t FROM Transporte t", Transporte.class);

        List<Transporte> res = myQuery.getResultList();

        return Optional.ofNullable(res);
    }
}
