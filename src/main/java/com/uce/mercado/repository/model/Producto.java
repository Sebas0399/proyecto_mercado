package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer id;

    @Column(name = "producto_codigo")
    private String codigo;
    @Column(name = "producto_nombre")
    private String nombre;

    @OneToMany(mappedBy = "producto" ,fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ProductoProductor> productosProductor;
    @OneToMany(mappedBy = "producto" ,fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ProductoGuia> productoGuias;
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
}
