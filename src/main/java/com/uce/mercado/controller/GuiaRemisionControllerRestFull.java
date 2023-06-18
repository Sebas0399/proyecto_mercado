package com.uce.mercado.controller;


import com.uce.mercado.repository.model.GuiaRemision;

import com.uce.mercado.service.inter.IGuiaRemisionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping("/guiaRemision")
public class GuiaRemisionControllerRestFull {
    @Autowired
    private IGuiaRemisionService guiaRemisionService;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GuiaRemision> ingresarGuia(@RequestBody GuiaRemision guiaRemision) {

        GuiaRemision savedGuiaRemision = this.guiaRemisionService.create(guiaRemision);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuiaRemision);
    }


    @GetMapping(path="/{id}")
    public ResponseEntity<GuiaRemision>consultarId(@PathVariable Integer id){
        Optional<GuiaRemision> bookOptional = this.guiaRemisionService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        GuiaRemision guiaRemision = (bookOptional.get());
        return ResponseEntity.ok(guiaRemision);
    }

    @PutMapping(path = "/{id}")
    public void actualizarGuiaRemision(@RequestBody GuiaRemision guiaRemision, @PathVariable Integer id) {
        guiaRemision.setId(id);
        this.guiaRemisionService.update(guiaRemision);
    }
}
