package com.uce.mercado.controller;

import com.uce.mercado.repository.model.*;
import com.uce.mercado.service.inter.IParroquiaService;
import com.uce.mercado.service.inter.IProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/productor")
public class ProductorControllerRestFull {

    @Autowired
    IProductorService productorService;
    @Autowired
    IParroquiaService parroquiaService;
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Productor> ingresarProductor(@RequestBody Productor productor) {
        productor.setParroquia(this.parroquiaService.readByLetter(productor.getParroquia().getNombre()).get().get(0));
        this.productorService.create(productor);
        return ResponseEntity.status(HttpStatus.CREATED).body(productor);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Productor>consultarId(@PathVariable Integer id){
        Optional<Productor> bookOptional = this.productorService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Productor productor = (bookOptional.get());
        return ResponseEntity.ok(productor);
    }

    @PutMapping(path = "/{id}")
    public void actualizarProductor(@RequestBody Productor productor, @PathVariable Integer id) {
        productor.setId(id);
        this.productorService.update(productor);
    }
    @GetMapping(path="letra/{letra}")
    public ResponseEntity<List<Productor>> consultaCedula(@PathVariable String letra){
        Optional<List<Productor>> bookOptional = this.productorService.likeByCedula(letra);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Productor> productors = (bookOptional.get());
        return ResponseEntity.ok(productors);
    }
    @GetMapping
    public ResponseEntity<List<Productor>> obtenerTodos(){
        Optional<List<Productor>> bookOptional = this.productorService.getAll();
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Productor> productors = (bookOptional.get());
        return ResponseEntity.ok(productors);
    }



}