package com.uce.mercado.service;

import com.uce.mercado.repository.IProductorRepository;
import com.uce.mercado.repository.model.Productor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductorServiceImpl implements IProductorRepository {

    @Autowired
    IProductorRepository productorRepository;

    @Override
    public Productor create(Productor productor) {
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
