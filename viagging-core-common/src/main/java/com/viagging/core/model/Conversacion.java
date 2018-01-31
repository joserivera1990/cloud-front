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
 * The persistent class for the tp_conversacion database table.
 * 
 */
@Entity
@Table(name="tp_conversacion")
@NamedQueries({
	@NamedQuery(name="Conversacion.findAll", query="SELECT t FROM Conversacion t"),
	@NamedQuery(name="Conversacion.findByIdUsuario", query="SELECT t FROM Conversacion t WHERE t.usuario1.id = :idusuario OR t.usuario2.id = :idusuario"),
	@NamedQuery(name="Conversacion.findByUsuarios", query="SELECT t FROM Conversacion t"
		+ " WHERE (t.usuario1.id = :idusuario1 AND t.usuario2.id = :idusuario2) OR (t.usuario1.id = :idusuario2 AND t.usuario2.id = :idusuario1)"),
	@NamedQuery(name="Conversacion.findByIdConversacion", query="SELECT t FROM Conversacion t WHERE t.id = :idconversacion")
})

public class Conversacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fechaUltimoMensaje;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariouno")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariodos")
	private Usuario usuario2;

	
	//bi-directional many-to-one association to Mensaje
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="conversacion")
	private List<Mensaje> mensajes;
	
	public Conversacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaUltimoMensaje() {
		return this.fechaUltimoMensaje;
	}

	public void setFechaUltimoMensaje(Date fechaUltimoMensaje) {
		this.fechaUltimoMensaje = fechaUltimoMensaje;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

}