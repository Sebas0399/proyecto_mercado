package com.uce.mercado.repository.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "provincia")
public class Provincia extends RepresentationModel<Provincia>implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prov_id")
	private Integer id;
	@Column(name = "prov_nombre")
	private String nombre;
	@OneToMany(mappedBy = "provincia" ,fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Canton> cantones;
	//constructor
	public Provincia() {
		super();
	}
	public Provincia (Integer id) {
		
		this.id=id;
	}
	//get y set
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
	public List<Canton> getCantones() {
		return cantones;
	}
	public void setCantones(List<Canton> cantones) {
		this.cantones = cantones;
	}
	
}
