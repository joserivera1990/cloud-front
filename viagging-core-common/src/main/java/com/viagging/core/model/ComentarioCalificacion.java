package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the tr_comentario_calificacion database table.
 * 
 */
@Entity
@Table(name="tr_comentario_calificacion")
@NamedQueries({
	@NamedQuery(name="ComentarioCalificacion.findAll", query="SELECT t FROM ComentarioCalificacion t"),
	@NamedQuery(name="ComentarioCalificacion.findByIdServicio", query="SELECT t FROM ComentarioCalificacion t WHERE t.servicio != null AND t.servicio.id = :idservicio"),
	@NamedQuery(name="ComentarioCalificacion.findByIdPaquete", query="SELECT t FROM ComentarioCalificacion t WHERE t.paquete != null AND t.paquete.id = :idpaquete")
})
public class ComentarioCalificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private double calificacion;

	private String comentario;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="idpaquete")
	private Paquete paquete;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="idcompra")
	private Compra compra;

	public ComentarioCalificacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Paquete getPaquete() {
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

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}