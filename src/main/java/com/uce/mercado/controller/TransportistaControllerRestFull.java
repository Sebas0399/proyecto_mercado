package com.uce.mercado.controller;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.ProductoProductor;
import com.uce.mercado.repository.model.Provincia;
import com.uce.mercado.repository.model.Transportista;
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
@RequestMapping("/transportista")
public class TransportistaControllerRestFull {
    @Autowired
    ITransportistaService transportistaService;
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Transportista> ingresarTransportista(@RequestBody Transportista transportista) {

        Transportista savedTransportista = this.transportistaService.create(transportista);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransportista);
    }


    @GetMapping(path="/{id}")
    public ResponseEntity<Transportista>consultarId(@PathVariable Integer id){
        Optional<Transportista> bookOptional = this.transportistaService.read(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Transportista transportista = (bookOptional.get());
        return ResponseEntity.ok(transportista);
    }

    @PutMapping(path = "/{id}")
    public void actualizarTransportista(@RequestBody Transportista transportista, @PathVariable Integer id) {
        transportista.setId(id);
        this.transportistaService.update(transportista);
    }





    @GetMapping(path="cedula/{cedula}")
    public ResponseEntity<List<Transportista>>consultaCedula(@PathVariable String cedula){
        Optional<List<Transportista>> bookOptional = this.transportistaService.readByCedula(cedula);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Transportista> transportistas = (bookOptional.get());
        return ResponseEntity.ok(transportistas);
    }
}
