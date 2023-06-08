package com.uce.mercado.service.impl;

import java.util.Optional;

import com.uce.mercado.service.inter.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.mercado.repository.inter.IProvinciaRepository;
import com.uce.mercado.repository.model.Provincia;
@Service
public class ProvinciaServiceImpl implements IProvinciaService {
	@Autowired
	private IProvinciaRepository provinciaRepo;
	@Override
	public Provincia create(Provincia provincia) {
		return this.provinciaRepo.create(provincia);
	}

	@Override
	public Optional<Provincia> read(Integer id) {
		// TODO Auto-generated method stub
		
		return this.provinciaRepo.read(id);
	}

	@Override
	public void update(Provincia provincia) {
		// TODO Auto-generated method stub
		this.provinciaRepo.update(provincia);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.provinciaRepo.delete(id);
	}

}
