package com.uce.mercado.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.service.ICantonService;
import com.uce.mercado.service.IProvinciaService;
@RestController
@CrossOrigin
@RequestMapping("/canton")
public class CantonControllerRestFul {
	@Autowired
	ICantonService cantonService;
	@Autowired
	IProvinciaService provinciaService;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Canton> ingresarCanton(@RequestBody Canton canton) {
    	Link myLink=linkTo(methodOn(CantonControllerRestFul.class).consultaCodgio(canton.getCodigo())).withSelfRel();
    	//Link myLink=Link.of("/canton/{id}").withRel(LinkRelation.of("canton")).expand(canton.getId());
		//Link myLink=linkTo(methodOn(CantonControllerRestFul.class).consultaId(canton.getId())).withSelfRel();
		canton.add(myLink);
		canton.setProvincia(this.provinciaService.read(canton.getProvincia().getId()).get());
		 this.cantonService.create(canton);
	        return ResponseEntity.status(HttpStatus.OK).body(canton);
	    }
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Canton>consultaId(@PathVariable Integer id){
		Optional<Canton> bookOptional = this.cantonService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Canton canton = (bookOptional.get());
        return ResponseEntity.ok(canton);
	}
	@GetMapping(path="codigo/{codigo}")
	public ResponseEntity<List<Canton>>consultaCodgio(@PathVariable String codigo){
		Optional<List<Canton>> bookOptional = this.cantonService.readByCodigo(codigo);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Canton> canton = (bookOptional.get());
        return ResponseEntity.ok(canton);
	}
	@PutMapping(path ="/{id}")
	public void actualizarCanton(@RequestBody Canton canton,@PathVariable Integer  id) {
		canton.setId(id);
		this.cantonService.update(canton);
	}
	
}
