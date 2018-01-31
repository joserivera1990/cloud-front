package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tp_usuario database table.
 * 
 */
@Entity
@Table(name="tp_usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT t FROM Usuario t"),
	@NamedQuery(name="Usuario.findByPasswordAndLogin", 
		query="SELECT t FROM Usuario t WHERE t.login = :login AND t.password = :password"),
    @NamedQuery(name="Usuario.findLogin", 
		query="SELECT t FROM Usuario t WHERE t.login = :login"),
	@NamedQuery(name="Usuario.findByEmailOrSocialNetwork",
		query="SELECT t FROM Usuario t WHERE t.correo = :email OR t.facebookId = :facebookId OR t.twitterId = :twitterId"),
    @NamedQuery(name="Usuario.findNumberDocument", 
			query="SELECT t FROM Usuario t WHERE t.numeroDocumento = :numeroDocumento")
})

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String login;

	private String password;
	
	private String correo;

	private String numeroCelular;

	private String numeroDocumento;

	private String primerApellido;

	private String primerNombre;

	private String segundoApellido;

	private String segundoNombre;

	private String tipoDocumento;
	
	private String direccion1;
	
	private String direccion2;
	
	private String ciudad;
	
	private String pais;
	
	private String estado;
	
	private String zipcode;
	
	private String facebookId;
	
	private String twitterId;

	//bi-directional many-to-one association to Conversacion
	@OneToMany(mappedBy="usuario1")
	private List<Conversacion> conversacion1;

	//bi-directional many-to-one association to Conversacion
	@OneToMany(mappedBy="usuario2")
	private List<Conversacion> conversacion2;

	//bi-directional many-to-one association to Paquete
	@OneToMany(mappedBy="usuario")
	private List<Paquete> paquetes;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="usuario")
	private List<Servicio> servicios;

	//bi-directional many-to-one association to ComentarioCalificacion
	@OneToMany(mappedBy="usuario")
	private List<ComentarioCalificacion> comentarioCalificacion;

	//bi-directional many-to-one association to CuentaAcceso
	@OneToMany(mappedBy="usuario")
	private List<CuentaAcceso> cuentaAcceso;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="usuario")
	private List<Movimiento> movimientos;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="usuario")
	private List<Pregunta> preguntas;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Conversacion> getConversacion1() {
		return this.conversacion1;
	}

	public void setConversacion1(List<Conversacion> conversacion1) {
		this.conversacion1 = conversacion1;
	}

	public Conversacion addConversacion1(Conversacion conversacion1) {
		getConversacion1().add(conversacion1);
		conversacion1.setUsuario1(this);

		return conversacion1;
	}

	public Conversacion removeConversacion1(Conversacion conversacion1) {
		getConversacion1().remove(conversacion1);
		conversacion1.setUsuario1(null);

		return conversacion1;
	}

	public List<Conversacion> getConversacion2() {
		return this.conversacion2;
	}

	public void setConversacion2(List<Conversacion> conversacion2) {
		this.conversacion2 = conversacion2;
	}

	public Conversacion addConversacion2(Conversacion conversacion2) {
		getConversacion2().add(conversacion2);
		conversacion2.setUsuario2(this);

		return conversacion2;
	}

	public Conversacion removeConversacion2(Conversacion conversacion2) {
		getConversacion2().remove(conversacion2);
		conversacion2.setUsuario2(null);

		return conversacion2;
	}

	public List<Paquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Paquete addPaquete(Paquete paquete) {
		getPaquetes().add(paquete);
		paquete.setUsuario(this);

		return paquete;
	}

	public Paquete removePaquete(Paquete paquete) {
		getPaquetes().remove(paquete);
		paquete.setUsuario(null);

		return paquete;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setUsuario(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setUsuario(null);

		return servicio;
	}

	public List<ComentarioCalificacion> getComentarioCalificacion() {
		return this.comentarioCalificacion;
	}

	public void setComentarioCalificacion(List<ComentarioCalificacion> comentarioCalificacion) {
		this.comentarioCalificacion = comentarioCalificacion;
	}

	public ComentarioCalificacion addComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().add(comentarioCalificacion);
		comentarioCalificacion.setUsuario(this);

		return comentarioCalificacion;
	}

	public ComentarioCalificacion removeComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().remove(comentarioCalificacion);
		comentarioCalificacion.setUsuario(null);

		return comentarioCalificacion;
	}

	public List<CuentaAcceso> getCuentaAcceso() {
		return this.cuentaAcceso;
	}

	public void setCuentaAcceso(List<CuentaAcceso> cuentaAcceso) {
		this.cuentaAcceso = cuentaAcceso;
	}

	public CuentaAcceso addCuentaAcceso(CuentaAcceso cuentaAcceso) {
		getCuentaAcceso().add(cuentaAcceso);
		cuentaAcceso.setUsuario(this);

		return cuentaAcceso;
	}

	public CuentaAcceso removeCuentaAcceso(CuentaAcceso cuentaAcceso) {
		getCuentaAcceso().remove(cuentaAcceso);
		cuentaAcceso.setUsuario(null);

		return cuentaAcceso;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setUsuario(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setUsuario(null);

		return movimiento;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setUsuario(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setUsuario(null);

		return pregunta;
	}

	@Column(name="facebook_id", length=50, nullable=true)
	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	@Column(name="twitter_id", length=50, nullable=true)
	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	
}