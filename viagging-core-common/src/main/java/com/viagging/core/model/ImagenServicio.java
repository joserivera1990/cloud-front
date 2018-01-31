package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tp_imagen_servicio database table.
 * 
 */
@Entity
@Table(name="tp_imagen_servicio")
@NamedQuery(name="ImagenServicio.findAll", query="SELECT t FROM ImagenServicio t")
public class ImagenServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private byte[] imagen;

	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	public ImagenServicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}