package com.uce.mercado.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transportista")
public class Transportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportista_id")
    private Integer id;

    @Column(name = "transportista_cedula")
    private String cedula;
    @Column(name = "transportista_nombre")
    private String nombre;


//    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
//    @JoinColumn(name="transporte_id")
//    private Transporte transporte;

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

//    public Transporte getTransporte() {
//        return transporte;
//    }
//
//    public void setTransporte(Transporte transporte) {
//        this.transporte = transporte;
//    }
}
