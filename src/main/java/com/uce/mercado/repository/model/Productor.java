package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productor")
public class Productor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productor_id")
    private Integer id;


    @Column(name = "productor_cedula")
    private String cedula;
    @Column(name = "productor_nombre")
    private String nombre;
    @Column(name = "productor_telefono")
    private String telefono;


   @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
   @JoinColumn(name="parroquia_id")
   private Parroquia parroquia;

    @OneToMany(mappedBy = "productor" ,fetch = FetchType.LAZY)
    @JsonBackReference
   private List<ProductorTO> productorsTO;

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

    public Parroquia getParroquia() {
        return parroquia;
    }

    public void setParroquia(Parroquia parroquia) {
        this.parroquia = parroquia;
    }


}
