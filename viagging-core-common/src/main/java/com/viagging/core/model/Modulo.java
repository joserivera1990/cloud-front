package com.viagging.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tp_modulo")

@NamedQueries( { @NamedQuery(name="Modulo.findAll", query="SELECT t FROM Modulo t"),
		         @NamedQuery(name="Modulo.findById", query="SELECT t FROM Modulo t where t.id = :id")})
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to PermisoPerfil
	@OneToMany(mappedBy="modulo")
	private List<PermisoPerfil> PermisoPerfil;

	public Modulo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PermisoPerfil> getPermisoPerfil() {
		return this.PermisoPerfil;
	}

	public void setPermisoPerfil(List<PermisoPerfil> PermisoPerfil) {
		this.PermisoPerfil = PermisoPerfil;
	}

	public PermisoPerfil addPermisoPerfil(PermisoPerfil permisoPerfil) {
		getPermisoPerfil().add(permisoPerfil);
		permisoPerfil.setModulo(this);

		return permisoPerfil;
	}

	public PermisoPerfil removePermisoPerfil(PermisoPerfil permisoPerfil) {
		getPermisoPerfil().remove(permisoPerfil);
		permisoPerfil.setModulo(null);

		return permisoPerfil;
	}

}