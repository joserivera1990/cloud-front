package com.viagging.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * The persistent class for the tp_servicio database table.
 * 
 */
@Entity
@Table(name="tp_servicio")
@NamedQueries({ 
	@NamedQuery(name = "Servicio.findAllTransporte", query = "SELECT t FROM Servicio t where t.transporte != null"),
	@NamedQuery(name = "Servicio.findAllAlojamiento", query = "SELECT t FROM Servicio t where t.alojamiento != null"),
	@NamedQuery(name = "Servicio.findAllAlimentacion", query = "SELECT t FROM Servicio t where t.alimentacion != null"),
	@NamedQuery(name = "Servicio.findAllPaseoEcologico", query = "SELECT t FROM Servicio t where t.paseoEcologico != null"),
	@NamedQuery(name = "Servicio.findAll", query = "SELECT t FROM Servicio t"),
	@NamedQuery(name = "Servicio.findAllByCriteria", query = "SELECT t FROM Servicio t WHERE t.nombre LIKE :nombre OR t.descripcion LIKE :descripcion"),
	@NamedQuery(name = "Servicio.findAllTransporteByProveedor", query = "SELECT t FROM Servicio t where t.transporte != null and t.estado != :estado and t.usuario.id = :idUsuario"),
	@NamedQuery(name = "Servicio.findAllAlojamientoByProveedor", query = "SELECT t FROM Servicio t where t.alojamiento != null and t.estado != :estado and t.usuario.id = :idUsuario"),
	@NamedQuery(name = "Servicio.findAllAlimentacionByProveedor", query = "SELECT t FROM Servicio t where t.alimentacion != null and t.estado != :estado and t.usuario.id = :idUsuario"),
	@NamedQuery(name = "Servicio.findAllPaseoEcologicoByProveedor", query = "SELECT t FROM Servicio t where t.paseoEcologico != null and t.estado != :estado and t.usuario.id = :idUsuario"),
	@NamedQuery(name = "Servicio.findAllByProveedor", query = "SELECT t FROM Servicio t where t.estado != :estado and t.usuario.id = :idUsuario")
})
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean activo;

	private String nombre;
	
	private String descripcion;

	private Integer precio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
    
	@Temporal(TemporalType.DATE)
	private Date fechaVigencia;
	
	private Integer capacidad;
	
	private Integer numeroAdquiridos;
    
	private byte[] imagenprincipal;
	
	private String restricciones;
	
	private String estado;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Alimentacion
	@ManyToOne
	@JoinColumn(name="idalimentacion")
	private Alimentacion alimentacion;

	//bi-directional many-to-one association to Alojamiento
	@ManyToOne
	@JoinColumn(name="idalojamiento")
	private Alojamiento alojamiento;

	//bi-directional many-to-one association to PaseoEcologico
	@ManyToOne
	@JoinColumn(name="idpaseosecologicos")
	private PaseoEcologico paseoEcologico;

	//bi-directional many-to-one association to Transporte
	@ManyToOne
	@JoinColumn(name="idtransporte")
	private Transporte transporte;

	//bi-directional many-to-one association to ComentarioCalificacion
	@OneToMany(mappedBy="servicio")
	private List<ComentarioCalificacion> comentarioCalificacion;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="servicio")
	private List<Compra> compras;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="servicio")
	private List<Movimiento> movimientos;

	//bi-directional many-to-one association to PaqueteServicio
	@OneToMany(mappedBy="servicio")
	private List<PaqueteServicio> paqueteServicios;

	//bi-directional many-to-one association to Pregunta
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy="servicio")
	private List<Pregunta> preguntas;
	
//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="servicio", fetch=FetchType.EAGER)
	private List<CaracteristicaServicio> caracteristicas;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="servicio")
	private List<ImagenServicio> imagenes;
	
	public Servicio() {
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Alimentacion getAlimentacion() {
		return this.alimentacion;
	}
	
	public byte[] getImagenprincipal() {
		return imagenprincipal;
	}

	public void setImagenprincipal(byte[] imagenprincipal) {
		this.imagenprincipal = imagenprincipal;
	}

	public void setAlimentacion(Alimentacion alimentacion) {
		this.alimentacion = alimentacion;
	}

	public Alojamiento getAlojamiento() {
		return this.alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public PaseoEcologico getPaseoEcologico() {
		return this.paseoEcologico;
	}

	public void setPaseoEcologico(PaseoEcologico paseoEcologico) {
		this.paseoEcologico = paseoEcologico;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public List<ComentarioCalificacion> getComentarioCalificacion() {
		return this.comentarioCalificacion;
	}

	public void setComentarioCalificacion(List<ComentarioCalificacion> comentarioCalificacion) {
		this.comentarioCalificacion = comentarioCalificacion;
	}

	public ComentarioCalificacion addComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().add(comentarioCalificacion);
		comentarioCalificacion.setServicio(this);

		return comentarioCalificacion;
	}

	public ComentarioCalificacion removeComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().remove(comentarioCalificacion);
		comentarioCalificacion.setServicio(null);

		return comentarioCalificacion;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setServicio(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setServicio(null);

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
		movimiento.setServicio(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setServicio(null);

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
		paqueteServicio.setServicio(this);

		return paqueteServicio;
	}

	public PaqueteServicio removePaqueteServicio(PaqueteServicio paqueteServicio) {
		getPaqueteServicios().remove(paqueteServicio);
		paqueteServicio.setServicio(null);

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
		pregunta.setServicio(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setServicio(null);

		return pregunta;
	}

	public List<CaracteristicaServicio> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaServicio> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<ImagenServicio> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenServicio> imagenes) {
		this.imagenes = imagenes;
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