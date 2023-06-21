package com.uce.mercado.controller;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.ProductoProductor;
import com.uce.mercado.repository.model.Productor;
import com.uce.mercado.service.inter.IProductoProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/productoProductor")
public class ProductoProductorControllerRestFull {

    @Autowired
    IProductoProductorService productoProductorService;


    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductoProductor> ingresarProductoProductor(@RequestBody ProductoProductor productoProductor) {
        ProductoProductor savedProductoProductor = this.productoProductorService.create(productoProductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductoProductor);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<ProductoProductor>consultarId(@PathVariable Integer id){
        Optional<ProductoProductor> bookOptional = this.productoProductorService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProductoProductor productoProductor = (bookOptional.get());
        return ResponseEntity.ok(productoProductor);
    }

    @PutMapping(path = "/{id}")
    public void actualizarProductoProductor(@RequestBody ProductoProductor productoProductor, @PathVariable Integer id) {
        productoProductor.setId(id);
        this.productoProductorService.update(productoProductor);
    }

    @GetMapping(path="codigo/{codigo}")
    public ResponseEntity<List<ProductoProductor>>consultarCodgio(@PathVariable String codigo){
        Optional<List<ProductoProductor>> bookOptional = this.productoProductorService.readByCodigo(codigo);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ProductoProductor> productoProductor = (bookOptional.get());
        return ResponseEntity.ok(productoProductor);
    }
}
