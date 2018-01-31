package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tr_movimiento database table.
 * 
 */
@Entity
@Table(name="tr_movimiento")
@NamedQuery(name="Movimiento.findAll", query="SELECT t FROM Movimiento t")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String accion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to paquete
	@ManyToOne
	@JoinColumn(name="idpaquete")
	private Paquete paquete;

	//bi-directional many-to-one association to servicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	//bi-directional many-to-one association to usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Movimiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Paquete getpaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}