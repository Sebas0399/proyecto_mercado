package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "guia_remision")
public class GuiaRemision extends RepresentationModel<GuiaRemision> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guia_remision_id")
    private Integer id;
    @Column(name = "guia_remision_fecha")
    private String guiaFecha;
    @Column(name = "guia_remision_numero")
    private String numero;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="destinatario_id")
    private Destinatario destinatario;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="transporte_id")
    private Transporte transporte;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="productorTO_id")
    private ProductorTO productorTO;


    @OneToMany(mappedBy = "guiaRemision" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JsonBackReference
    private List<ProductoGuia> productosGuias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuiaFecha() {
        return guiaFecha;
    }

    public void setGuiaFecha(String guiaFecha) {
        this.guiaFecha = guiaFecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public ProductorTO getProductorTO() {
        return productorTO;
    }

    public void setProductorTO(ProductorTO productorTO) {
        this.productorTO = productorTO;
    }

    public List<ProductoGuia> getProductosGuias() {
        return productosGuias;
    }

    public void setProductosGuias(List<ProductoGuia> productosGuias) {
        this.productosGuias = productosGuias;
    }
}
