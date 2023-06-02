package com.uce.mercado.service;

import java.util.List;
import java.util.Optional;

import com.uce.mercado.repository.model.Canton;

public interface ICantonService {
	public Canton create(Canton canton);
	public Optional<Canton> read(Integer id);
	public void update(Canton canton);
	public void delete(Integer id);
	public Optional<List<Canton>> readByCodigo(String codigo);
}
