package com.uce.mercado.repository.model;

import jakarta.persistence.*;
@Entity
@Table(name = "producto")
public class Producto {


   @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer id;
//
//    @Column(name = "producto_id")
//    private Integer id;
//    @Column(name = "producto_id")
//    private Integer id;

}
