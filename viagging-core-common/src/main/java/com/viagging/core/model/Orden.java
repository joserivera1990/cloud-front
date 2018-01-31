package com.viagging.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.viagging.core.constant.EstadoOrden;

@Entity
@Table(name="tp_orden")
@NamedQueries({
	@NamedQuery(name="Orden.findAll", query="SELECT t FROM Orden t"),
	@NamedQuery(name="Orden.findByUsuario", query="SELECT t FROM Orden t WHERE t.usuario.id = :idusuario")
})
public class Orden implements Serializable{

	private static final long serialVersionUID = -6447565646428403641L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCompra;
	
	private EstadoOrden estado;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idtransaccion")
	private Transaccion transaccion;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	@OneToMany(mappedBy="orden", cascade=CascadeType.ALL)
	private List<Compra> compras;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public EstadoOrden getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
}
