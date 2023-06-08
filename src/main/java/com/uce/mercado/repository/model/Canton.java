package com.uce.mercado.repository.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="canton")

public class Canton extends RepresentationModel<Canton>implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "canton_id")
	private Integer id;
	

	@Column(name = "canton_codigo")
	private String codigo;
	@Column(name = "canton_nombre")
	private String nombre;
	@ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL )
	@JoinColumn(name="provincia_id")
	
	private Provincia provincia;
	@OneToMany(mappedBy = "canton" ,fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Parroquia> parroquias;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Parroquia> getParroquias() {
		return parroquias;
	}

	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}
}
