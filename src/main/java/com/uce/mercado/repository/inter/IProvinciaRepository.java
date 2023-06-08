package com.uce.mercado.repository.inter;

import java.util.Optional;

import com.uce.mercado.repository.model.Provincia;

public interface IProvinciaRepository {
	public Provincia create(Provincia provincia);
	public Optional<Provincia> read(Integer id);
	public void update(Provincia provincia);
	public void delete(Integer id);
}
