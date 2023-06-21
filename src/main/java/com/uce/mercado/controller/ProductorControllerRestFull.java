package com.uce.mercado.controller;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Productor;
import com.uce.mercado.repository.model.Provincia;
import com.uce.mercado.service.inter.IProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/productor")
public class ProductorControllerRestFull {

    @Autowired
    IProductorService productorService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Productor> ingresarCanton(@RequestBody Productor productor) {
        Productor savedProductor = this.productorService.create(productor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductor);
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




}