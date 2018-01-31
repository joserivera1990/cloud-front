package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tr_caracteristica_servicio database table.
 * 
 */
@Entity
@Table(name="tr_caracteristica_servicio")
@NamedQuery(name="CaracteristicaServicio.findAll", query="SELECT t FROM CaracteristicaServicio t")
public class CaracteristicaServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
   
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name="idcaracteristica")
	private Caracteristica caracteristica;
	
	public CaracteristicaServicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}
	
}