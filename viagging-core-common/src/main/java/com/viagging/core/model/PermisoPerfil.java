package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_permisoperfil database table.
 * 
 */
@Entity
@Table(name="tr_permisoperfil")
@NamedQuery(name="PermisoPerfil.findAll", query="SELECT t FROM PermisoPerfil t")
public class PermisoPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="idperfil")
	private Perfil perfil;

	//bi-directional many-to-one association to Modulo
	@ManyToOne
	@JoinColumn(name="idmodulo")
	private Modulo modulo;

	public PermisoPerfil() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

}