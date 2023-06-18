package com.uce.mercado.controller;

import com.uce.mercado.repository.model.ProductoProductor;
import com.uce.mercado.repository.model.Transporte;
import com.uce.mercado.repository.model.Transportista;
import com.uce.mercado.service.inter.ITransporteService;
import com.uce.mercado.service.inter.ITransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path="/{id}")
    public ResponseEntity<Transporte>consultarId(@PathVariable Integer id){
        Optional<Transporte> bookOptional = this.transporteService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Transporte transporte = (bookOptional.get());
        return ResponseEntity.ok(transporte);
    }

    @PutMapping(path = "/{id}")
    public void actualizarTransporte(@RequestBody Transporte transporte, @PathVariable Integer id) {
        transporte.setId(id);
        this.transporteService.update(transporte);
    }


    @GetMapping(path="placa/{placa}")
    public ResponseEntity<List<Transporte>>consultarPlaca(@PathVariable String placa){
        Optional<List<Transporte>> bookOptional = this.transporteService.readByPlaca(placa);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Transporte> transportes = (bookOptional.get());
        return ResponseEntity.ok(transportes);
    }
}
