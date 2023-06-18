package com.uce.mercado.controller;


import com.uce.mercado.repository.model.Producto;
import com.uce.mercado.repository.model.ProductoProductor;
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
public class ProductoControllerRestFull {
    @Autowired
    private IProductoService productoService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Producto> ingresarProducto(@RequestBody Producto producto) {

        Producto savedProducto = this.productoService.create(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Producto>consultarId(@PathVariable Integer id){
        Optional<Producto> bookOptional = this.productoService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Producto producto = (bookOptional.get());
        return ResponseEntity.ok(producto);
    }

    @PutMapping(path = "/{id}")
    public void actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        producto.setId(id);
        this.productoService.update(producto);
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


}
