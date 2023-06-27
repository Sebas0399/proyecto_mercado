package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productorTO")
public class ProductorTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productorTO_id")
    private Integer id;
    @Column(name = "prodcutorTO_cedula")
    private String cedula;
    @Column(name = "prodcutorTO_telefono")
    private String telefono;
    @Column(name = "prodcutorTO_paroquia_codigo")
    private String parroquiaCodigo;
    @Column(name = "prodcutorTO_productorTO_col")
    private String productorTOcol;
    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name="productor_cedula")
    private Productor productor;
    @OneToMany(mappedBy = "productorTO" ,fetch = FetchType.LAZY)
    @JsonBackReference(value = "productorTO-productoProductor")
    private List<ProductoProductor> productosProductor;

    @OneToMany(mappedBy = "productorTO" ,fetch = FetchType.LAZY)
    @JsonBackReference(value = "productorTO-guiaRemision")
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getParroquiaCodigo() {
        return parroquiaCodigo;
    }

    public void setParroquiaCodigo(String parroquiaCodigo) {
        this.parroquiaCodigo = parroquiaCodigo;
    }

    public String getProductorTOcol() {
        return productorTOcol;
    }

    public void setProductorTOcol(String productorTOcol) {
        this.productorTOcol = productorTOcol;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }
}
