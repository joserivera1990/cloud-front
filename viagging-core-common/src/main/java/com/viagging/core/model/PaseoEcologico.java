package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the tr_paseosecologicos database table.
 * 
 */
@Entity
@Table(name="tr_paseoecologico")
@NamedQuery(name="PaseoEcologico.findAll", query="SELECT t FROM PaseoEcologico t")
public class PaseoEcologico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String ciudad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String horario;

	private String tiempoderecorrido;
    
	private String horarioInicio;
	
	private String horarioFin;
	
	public PaseoEcologico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTiempoderecorrido() {
		return tiempoderecorrido;
	}

	public void setTiempoderecorrido(String tiempoderecorrido) {
		this.tiempoderecorrido = tiempoderecorrido;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}
}