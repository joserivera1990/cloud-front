package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tr_paqueteservicio database table.
 * 
 */
@Entity
@Table(name="tr_paqueteservicio")
@NamedQueries({
	 @NamedQuery(name="PaqueteServicio.findAll", query="SELECT t FROM PaqueteServicio t"),
	 @NamedQuery (name="PaqueteServicio.findByIdPaquete", query="SELECT t FROM PaqueteServicio t where t.paquete.id = :idPaquete")
})
public class PaqueteServicio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="idpaquete")
	private Paquete paquete;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	public PaqueteServicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}