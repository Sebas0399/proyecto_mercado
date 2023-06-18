package com.uce.mercado.controller;

import com.uce.mercado.repository.model.*;
import com.uce.mercado.service.inter.IGuiaRemisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/guiaRemision")
public class GuiaRemisionControllerRestFull {
    @Autowired
    private IGuiaRemisionService guiaRemisionService;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GuiaRemision> ingresarGuia(@RequestBody GuiaRemision guiaRemision) {

        GuiaRemision savedGuiaRemision = this.guiaRemisionService.create(guiaRemision);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuiaRemision);
    }

    @GetMapping(path = "/numero/{numero}")

    public ResponseEntity<List<GuiaRemision>> consultaCodigo(@PathVariable String numero) {
        Optional<List<GuiaRemision>> bookOptional = this.guiaRemisionService.readByNumero(numero);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<GuiaRemision> guiaRemisions = (bookOptional.get());
        return ResponseEntity.ok(guiaRemisions);
    }

    @PutMapping(path = "/{id}")
    public void actualizarGuia(@RequestBody GuiaRemision guiaRemision, @PathVariable Integer id) {
        guiaRemision.setId(id);
        this.guiaRemisionService.update(guiaRemision);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<GuiaRemision>borrarGuia(@PathVariable Integer id){
       boolean ok= this.guiaRemisionService.delete(id);
        if (ok){
            return new ResponseEntity<GuiaRemision>(HttpStatus.NO_CONTENT);
        }
        else {
            return  new ResponseEntity<GuiaRemision>(HttpStatus.OK);
        }
    }
}
