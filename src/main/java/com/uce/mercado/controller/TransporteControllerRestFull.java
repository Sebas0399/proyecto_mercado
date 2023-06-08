package com.uce.mercado.controller;

import com.uce.mercado.repository.model.Transporte;
import com.uce.mercado.repository.model.Transportista;
import com.uce.mercado.service.inter.ITransporteService;
import com.uce.mercado.service.inter.ITransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transporte")
public class TransporteControllerRestFull {
    @Autowired
    ITransporteService transporteService;
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Transporte> ingresarTransporte(@RequestBody Transporte transporte) {

        Transporte savedTransporte = this.transporteService.create(transporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransporte);
    }
}
