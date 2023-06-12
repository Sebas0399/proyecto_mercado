package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "transportista")
public class Transportista extends RepresentationModel<Transportista> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportista_id")
    private Integer id;

    @Column(name = "transportista_cedula")
    private String cedula;
    @Column(name = "transportista_nombre")
    private String nombre;


    @OneToMany(mappedBy = "transportista" ,fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Transporte> transportes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }
}
