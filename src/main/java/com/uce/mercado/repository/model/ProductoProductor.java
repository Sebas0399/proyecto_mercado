package com.uce.mercado.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productoProductor")
public class ProductoProductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productoProductor_id")
    private Integer id;

//    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
//    @JoinColumn(name="producto_id")
//    private Producto producto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Producto getProducto() {
//        return producto;
//    }
//
//    public void setProducto(Producto producto) {
//        this.producto = producto;
//    }
}
