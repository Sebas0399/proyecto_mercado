package com.uce.mercado.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productoGuia")
public class ProductoGuia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productoGuia_id")
    private Integer id;

    @Column(name = "productoGuia_cantidad")
    private Integer cantidad;
    @Column(name = "productoGuia_unidad")
    private String unidadMedida;

//    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
//    @JoinColumn(name="guiaRemision_id")
//    private GuiaRemision guiaRemision;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

//    public GuiaRemision getGuiaRemision() {
//        return guiaRemision;
//    }
//
//    public void setGuiaRemision(GuiaRemision guiaRemision) {
//        this.guiaRemision = guiaRemision;
//    }
}
