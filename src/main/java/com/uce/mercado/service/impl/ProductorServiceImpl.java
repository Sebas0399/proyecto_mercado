package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.IProductorRepository;
import com.uce.mercado.repository.model.Productor;
import com.uce.mercado.service.inter.IProductorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductorServiceImpl implements IProductorService {

    @Autowired
    IProductorRepository productorRepository;

    @Override
    public Productor crearProductor(Productor productor) {
        return this.productorRepository.create(productor);
    }

    @Override
    public Optional<Productor> read(Integer id) {
        return this.productorRepository.read(id);
    }

    @Override
    public void update(Productor productor) {
        this.productorRepository.update(productor);
    }

    @Override
    public void delete(Integer id) {
        this.productorRepository.delete(id);
    }
}
