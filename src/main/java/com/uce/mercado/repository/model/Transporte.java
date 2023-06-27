package com.uce.mercado.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "transporte")
public class Transporte extends RepresentationModel<Transporte> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transporte_id")
    private Integer id;

    @Column(name = "transporte_placa")
    private String placa;
    @Column(name = "transporte_detalle")
    private String detalle;

    @Column(name = "productor_cedula")
    private String cedula;

    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name="transportista_id")
    private Transportista transportista;

    @OneToMany(mappedBy = "transporte" ,fetch = FetchType.LAZY)
    @JsonBackReference(value = "transporte-guia")
    private List<GuiaRemision> guiasRemision;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public List<GuiaRemision> getGuiasRemision() {
        return guiasRemision;
    }

    public void setGuiasRemision(List<GuiaRemision> guiasRemision) {
        this.guiasRemision = guiasRemision;
    }
}
