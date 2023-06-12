package com.uce.mercado.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productoProductor")
public class ProductoProductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_productor_id")
    private Integer id;

    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name="producto_codigo")
    private Producto producto;
    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name="productorTO_cedula")
    private ProductorTO productorTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
