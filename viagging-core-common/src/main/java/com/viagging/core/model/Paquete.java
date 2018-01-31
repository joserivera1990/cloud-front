package com.viagging.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the tp_paquete database table.
 * 
 */
@Entity
@Table(name="tp_paquete")
@NamedQueries({
	@NamedQuery(name = "Paquete.findAll", query = "SELECT t FROM Paquete t"),
	@NamedQuery(name = "Paquete.findAllByCriteria", query = "SELECT t FROM Paquete t WHERE t.nombrePaquete LIKE :nombre OR t.descripcion LIKE :descripcion")
})

public class Paquete implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean activo;

	private String nombrePaquete;
	
	private String descripcion;
	
	private String estado;
	
	private Integer precio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
    
	@Temporal(TemporalType.DATE)
	private Date fechaVigencia;
	
	private Integer capacidad;
	
	private Integer numeroAdquiridos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to ComentarioCalificacion
	@OneToMany(mappedBy="paquete")
	private List<ComentarioCalificacion> comentarioCalificacion;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="paquete")
	private List<Compra> compras;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="paquete")
	private List<Movimiento> movimientos;

	//bi-directional many-to-one association to PaqueteServicio
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="paquete")
	private List<PaqueteServicio> paqueteServicios;

	//bi-directional many-to-one association to Pregunta
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="paquete")
	private List<Pregunta> preguntas;

	public Paquete() {
	}
	
	public Paquete( int id,  String nombrePaquete, Integer precio, String descripcion, Date fechaInicio, Date fechaVigencia, Integer capacidad) {
		super();
		this.nombrePaquete = nombrePaquete;
		this.precio = precio;
		this.descripcion = descripcion;
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaVigencia = fechaVigencia;
		this.capacidad = capacidad;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombrePaquete() {
		return this.nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ComentarioCalificacion> getComentarioCalificacion() {
		return this.comentarioCalificacion;
	}

	public void setComentarioCalificacion(List<ComentarioCalificacion> comentarioCalificacion) {
		this.comentarioCalificacion = comentarioCalificacion;
	}

	public ComentarioCalificacion addComentarioCalificacion(ComentarioCalificacion trComentarioCalificacion) {
		getComentarioCalificacion().add(trComentarioCalificacion);
		trComentarioCalificacion.setPaquete(this);

		return trComentarioCalificacion;
	}

	public ComentarioCalificacion removeComentarioCalificacion(ComentarioCalificacion trComentarioCalificacion) {
		getComentarioCalificacion().remove(trComentarioCalificacion);
		trComentarioCalificacion.setPaquete(null);

		return trComentarioCalificacion;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setPaquete(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setPaquete(null);

		return compra;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setPaquete(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setPaquete(null);
		return movimiento;
	}

	public List<PaqueteServicio> getPaqueteServicios() {
		return this.paqueteServicios;
	}

	public void setPaqueteServicios(List<PaqueteServicio> paqueteServicios) {
		this.paqueteServicios = paqueteServicios;
	}

	public PaqueteServicio addPaqueteServicio(PaqueteServicio paqueteServicio) {
		getPaqueteServicios().add(paqueteServicio);
		paqueteServicio.setPaquete(this);

		return paqueteServicio;
	}

	public PaqueteServicio removePaqueteServicio(PaqueteServicio paqueteServicio) {
		getPaqueteServicios().remove(paqueteServicio);
		paqueteServicio.setPaquete(null);
		return paqueteServicio;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setPaquete(this);
		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setPaquete(null);
		return pregunta;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getNumeroAdquiridos() {
		return numeroAdquiridos;
	}

	public void setNumeroAdquiridos(Integer numeroAdquiridos) {
		this.numeroAdquiridos = numeroAdquiridos;
	}


}