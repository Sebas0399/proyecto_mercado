package com.uce.mercado.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Provincia;
import com.uce.mercado.service.ICantonService;
import com.uce.mercado.service.IProvinciaService;

@RestController
@RequestMapping("/provincia")
public class ProvinciaControllerRestFul {
	@Autowired
	private IProvinciaService provinciaService;
	@Autowired
	private ICantonService cantonService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Provincia> ingresarCanton(@RequestBody Provincia provincia) {

		Provincia savedProvincia = this.provinciaService.create(provincia);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProvincia);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Provincia> consultaCodigo(@PathVariable Integer id) {
		Optional<Provincia> provinciaOptional = this.provinciaService.read(id);
		if (provinciaOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Provincia provincia = provinciaOptional.get();
		return ResponseEntity.ok(provincia);
	}

	@PutMapping(path = "/{id}")
	public void actualizarProvincia(@RequestBody Provincia provincia, @PathVariable Integer id) {
		provincia.setId(id);
		this.provinciaService.update(provincia);
	}
}
