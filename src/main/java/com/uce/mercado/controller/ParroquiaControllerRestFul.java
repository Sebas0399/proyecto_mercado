package com.uce.mercado.controller;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.Parroquia;
import com.uce.mercado.repository.model.Producto;
import com.uce.mercado.service.inter.IParroquiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/parroquia")
public class ParroquiaControllerRestFul {
    @Autowired
    private IParroquiaService parroquiaService;
    @GetMapping(path="codigo/{codigo}")
    public ResponseEntity<List<Parroquia>> consultaCodgio(@PathVariable String codigo){
        Optional<List<Parroquia>> bookOptional = this.parroquiaService.readByCodigo(codigo);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Parroquia> canton = (bookOptional.get());
        return ResponseEntity.ok(canton);
    }
    @GetMapping(path="letra/{letra}")
    public ResponseEntity<List<Parroquia>> letraParroquia(@PathVariable String letra){
        Optional<List<Parroquia>> bookOptional = this.parroquiaService.readByLetter(letra);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Parroquia> canton = (bookOptional.get());
        return ResponseEntity.ok(canton);
    }

    @GetMapping
    public ResponseEntity<List<Parroquia>> obtenerTodos(){
        Optional<List<Parroquia>> bookOptional = this.parroquiaService.getAll();
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Parroquia> parroquias = (bookOptional.get());
        return ResponseEntity.ok(parroquias);
    }
}
