package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "destinatario")
public class Destinatario extends RepresentationModel<Destinatario> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destinatario_id")
    private Integer id;
    @Column(name = "destinatario_cedula")
    private String cedula;
    @Column(name = "destinatario_nombre")
    private String nombre;
    @Column(name = "destinatario_telefono")
    private String telefono;
    @OneToMany(mappedBy = "destinatario" ,fetch = FetchType.LAZY)
    @JsonBackReference
    private List<GuiaRemision> guiasRemision;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<GuiaRemision> getGuiasRemision() {
        return guiasRemision;
    }

    public void setGuiasRemision(List<GuiaRemision> guiasRemision) {
        this.guiasRemision = guiasRemision;
    }
}
