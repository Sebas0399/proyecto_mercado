package com.uce.mercado.controller;

import com.uce.mercado.repository.model.Canton;
import com.uce.mercado.repository.model.GuiaRemision;
import com.uce.mercado.repository.model.Transporte;
import com.uce.mercado.service.inter.IGuiaRemisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
