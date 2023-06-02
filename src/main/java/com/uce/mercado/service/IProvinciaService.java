package com.uce.mercado.service;

import java.util.Optional;

import com.uce.mercado.repository.model.Provincia;

public interface IProvinciaService {
	public Provincia create(Provincia provinica);
	public Optional<Provincia> read(Integer id);
	public void update(Provincia provincia);
	public void delete(Integer id);
}
