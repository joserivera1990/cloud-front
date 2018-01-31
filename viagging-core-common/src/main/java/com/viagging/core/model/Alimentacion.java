package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_alimentacion database table.
 * 
 */
@Entity
@Table(name="tr_alimentacion")
@NamedQuery(name="Alimentacion.findAll", query="SELECT t FROM Alimentacion t")
public class Alimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String ciudad;

	private String horarioapertura;
	
	private String horariocierre;

	private Integer preciomayor;

	private Integer preciomenor;

	public Alimentacion() {
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

	public String getHorarioapertura() {
		return horarioapertura;
	}

	public void setHorarioapertura(String horarioapertura) {
		this.horarioapertura = horarioapertura;
	}
	
	public String getHorariocierre() {
		return horariocierre;
	}

	public void setHorariocierre(String horariocierre) {
		this.horariocierre = horariocierre;
	}

	public Integer getPreciomayor() {
		return preciomayor;
	}

	public void setPreciomayor(Integer preciomayor) {
		this.preciomayor = preciomayor;
	}

	public Integer getPreciomenor() {
		return preciomenor;
	}

	public void setPreciomenor(Integer preciomenor) {
		this.preciomenor = preciomenor;
	}

}