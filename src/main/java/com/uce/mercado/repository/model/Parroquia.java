package com.uce.mercado.repository.model;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Entity
@Table(name="parroquia")
public class Parroquia extends RepresentationModel<Parroquia> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parroquia_id")
    private Integer id;


    @Column(name = "parroquia_codigo")
    private String codigo;
    @Column(name = "parroquia_nombre")
    private String nombre;

    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name="canton_id")
    private Canton canton;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }
}
