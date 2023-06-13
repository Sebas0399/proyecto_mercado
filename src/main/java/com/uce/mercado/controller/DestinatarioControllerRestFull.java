package com.uce.mercado.controller;

import com.uce.mercado.repository.model.Destinatario;
import com.uce.mercado.repository.model.Parroquia;
import com.uce.mercado.repository.model.Provincia;
import com.uce.mercado.service.inter.IDestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinatario")
public class DestinatarioControllerRestFull {

    @Autowired
    private IDestinatarioService destinatarioService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Destinatario> ingresarDestinatario(@RequestBody Destinatario destinatario) {

        Destinatario savedDestinatario = this.destinatarioService.create(destinatario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDestinatario);
    }


    @GetMapping(path="cedula/{cedula}")
    public ResponseEntity<List<Destinatario>> consultaCedula(@PathVariable String cedula){
        Optional<List<Destinatario>> bookOptional = this.destinatarioService.readByCedula(cedula);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Destinatario> destinatarios = (bookOptional.get());
        return ResponseEntity.ok(destinatarios);
    }



}
