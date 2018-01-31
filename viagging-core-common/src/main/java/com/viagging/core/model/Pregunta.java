package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the tr_pregunta database table.
 * 
 */
@Entity
@Table(name="tr_pregunta")
@NamedQueries({
	@NamedQuery(name="Pregunta.findAll", query="SELECT t FROM Pregunta t"),
	@NamedQuery(name="Pregunta.findByIdServicio", query="SELECT t FROM Pregunta t WHERE t.servicio != null AND t.servicio.id = :idservicio"),
	@NamedQuery(name="Pregunta.findByIdPaquete", query="SELECT t FROM Pregunta t WHERE t.paquete != null AND t.paquete.id = :idpaquete")
})
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String pregunta;

	private String respuesta;

	//bi-directional many-to-one association to Paquete
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="idpaquete")
	private Paquete paquete;

	//bi-directional many-to-one association to Servicio
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Pregunta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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

}