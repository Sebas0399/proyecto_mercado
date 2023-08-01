package com.uce.mercado.controller;


import com.uce.mercado.repository.model.Producto;
import com.uce.mercado.service.inter.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoControllerRestFull {
    @Autowired
    private IProductoService productoService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Producto> ingresarProducto(@RequestBody Producto producto) {

        Producto savedProducto = this.productoService.create(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }


    @GetMapping(path="codigo/{codigo}")
    public ResponseEntity<List<Producto>> consultaCodigo(@PathVariable String codigo){
        Optional<List<Producto>> bookOptional = this.productoService.readByCodigo(codigo);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Producto> productos = (bookOptional.get());
        return ResponseEntity.ok(productos);
    }

    @GetMapping(path="nombre/{nombre}")
    public ResponseEntity<List<Producto>> consultaNombre(@PathVariable String nombre){
        Optional<List<Producto>> bookOptional = this.productoService.readByNombre(nombre);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Producto> productos = (bookOptional.get());
        return ResponseEntity.ok(productos);
    }

    @GetMapping(path="letra/{letra}")
    public ResponseEntity<List<Producto>> consultaLetra(@PathVariable String letra){
        Optional<List<Producto>> bookOptional = this.productoService.likeByLetter(letra);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Producto> productos = (bookOptional.get());
        return ResponseEntity.ok(productos);
    }
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos(){
        Optional<List<Producto>> bookOptional = this.productoService.getAll();
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Producto> productos = (bookOptional.get());
        return ResponseEntity.ok(productos);
    }
    @PutMapping
    public ResponseEntity actualizar(@RequestBody Producto producto){
        if(this.productoService.update(producto)){
            return ResponseEntity.ok(producto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(path = "/{id}")
    public void eliminar(@PathVariable Integer id) {
        this.productoService.delete(id);
    }

}
