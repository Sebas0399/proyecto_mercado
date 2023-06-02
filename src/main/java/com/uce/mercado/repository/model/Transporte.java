package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "transporte")
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transporte_id")
    private Integer id;

    @Column(name = "transporte_placa")
    private String placa;
    @Column(name = "transporte_detalle")
    private String detalle;

    @Column(name = "productor_cedula")
    private String cedula;

//    @OneToMany(mappedBy = "transporte" ,fetch = FetchType.LAZY)
//    @JsonBackReference
//    private List<Transportista> transportistas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

//    public List<Transportista> getTransportistas() {
//        return transportistas;
//    }
//
//    public void setTransportistas(List<Transportista> transportistas) {
//        this.transportistas = transportistas;
//    }


}
