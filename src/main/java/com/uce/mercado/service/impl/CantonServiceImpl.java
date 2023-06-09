package com.uce.mercado.service.impl;

import java.util.List;
import java.util.Optional;

import com.uce.mercado.service.inter.ICantonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.mercado.repository.inter.ICantonRepository;
import com.uce.mercado.repository.model.Canton;

@Service
public class CantonServiceImpl implements ICantonService {
	@Autowired
	private ICantonRepository cantonRepo;
	@Override
	public Canton create(Canton canton) {
		// TODO Auto-generated method stub
		return this.cantonRepo.create(canton);
	}

	@Override
	public Optional<Canton> read(Integer id) {
		// TODO Auto-generated method stub
		return this.cantonRepo.read(id);
	}

	@Override
	public void update(Canton canton) {
		// TODO Auto-generated method stub
		this.cantonRepo.update(canton);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.cantonRepo.delete(id);
	}

	@Override
	public Optional<List<Canton>> readByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.cantonRepo.readByCodigo(codigo);
	}

}
