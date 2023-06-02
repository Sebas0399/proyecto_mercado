package com.uce.mercado.repository.model;

import jakarta.persistence.*;
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

//    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
//    @JoinColumn(name="productor_id")
//    private Productor productor;

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

//    public Productor getProductor() {
//        return productor;
//    }
//
//    public void setProductor(Productor productor) {
//        this.productor = productor;
//    }

}
