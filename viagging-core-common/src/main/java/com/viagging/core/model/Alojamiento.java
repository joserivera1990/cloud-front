package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_alojamiento database table.
 * 
 */
@Entity
@Table(name="tr_alojamiento")
@NamedQuery(name="Alojamiento.findAll", query="SELECT t FROM Alojamiento t")
public class Alojamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String ciudad;

	private Integer valorpornoche;
	
	private String tipo;
	
	private Integer numeroPersonas;

	public Alojamiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getValorpornoche() {
		return valorpornoche;
	}

	public void setValorpornoche(Integer valorpornoche) {
		this.valorpornoche = valorpornoche;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	
}