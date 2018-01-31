package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tb_perfil database table.
 * 
 */
@Entity
@Table(name="tb_perfil")
@NamedQuery(name="Perfil.findAll", query="SELECT t FROM Perfil t")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nombre;
    
	public Perfil() {
	}
	
	public Perfil(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	//bi-directional many-to-one association to CuentaAcceso
	@OneToMany(mappedBy="perfil")
	private List<CuentaAcceso> cuentaAcceso;

	//bi-directional many-to-one association to PermisoPerfil
	@OneToMany(mappedBy="perfil")
	private List<PermisoPerfil> permisoPerfil;

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

	public List<CuentaAcceso> getCuentaAcceso() {
		return this.cuentaAcceso;
	}

	public void setCuentaAcceso(List<CuentaAcceso> cuentaAcceso) {
		this.cuentaAcceso = cuentaAcceso;
	}

	public CuentaAcceso addCuentaAcceso(CuentaAcceso cuentaAcceso) {
		getCuentaAcceso().add(cuentaAcceso);
		cuentaAcceso.setPerfil(this);

		return cuentaAcceso;
	}

	public CuentaAcceso removeCuentaAcceso(CuentaAcceso cuentaAcceso) {
		getCuentaAcceso().remove(cuentaAcceso);
		cuentaAcceso.setPerfil(null);

		return cuentaAcceso;
	}

	public List<PermisoPerfil> getPermisoPerfil() {
		return this.permisoPerfil;
	}

	public void setPermisoPerfil(List<PermisoPerfil> permisoPerfil) {
		this.permisoPerfil = permisoPerfil;
	}

	public PermisoPerfil addPermisoPerfil(PermisoPerfil permisoPerfil) {
		getPermisoPerfil().add(permisoPerfil);
		permisoPerfil.setPerfil(this);

		return permisoPerfil;
	}

	public PermisoPerfil removePermisoPerfil(PermisoPerfil permisoPerfil) {
		getPermisoPerfil().remove(permisoPerfil);
		permisoPerfil.setPerfil(null);

		return permisoPerfil;
	}

}