package com.uce.mercado.controller;

import com.uce.mercado.repository.model.ProductoGuia;
import com.uce.mercado.service.inter.IProductoGuiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/productosGuia")
public class ProductoGuiaControllerRestFull {

    @Autowired
    IProductoGuiaService productoGuiaService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductoGuia> ingresarProductoGuia(@RequestBody ProductoGuia productoGuia) {

        ProductoGuia savedProductoGuia = this.productoGuiaService.create(productoGuia);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductoGuia);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<ProductoGuia>consultarId(@PathVariable Integer id){
        Optional<ProductoGuia> bookOptional = this.productoGuiaService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProductoGuia productoGuia = (bookOptional.get());
        return ResponseEntity.ok(productoGuia);
    }

    @PutMapping(path = "/{id}")
    public void actualizarProductoGuia(@RequestBody ProductoGuia productoGuia, @PathVariable Integer id) {
        productoGuia.setId(id);
        this.productoGuiaService.update(productoGuia);
    }

    @GetMapping(path="codigo/{codigo}")
    public ResponseEntity<List<ProductoGuia>> consultarCodigo(@PathVariable String codigo){
        Optional<List<ProductoGuia>> bookOptional = this.productoGuiaService.readByCodigo(codigo);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ProductoGuia> productosGuia = (bookOptional.get());
        return ResponseEntity.ok(productosGuia);
    }
}
