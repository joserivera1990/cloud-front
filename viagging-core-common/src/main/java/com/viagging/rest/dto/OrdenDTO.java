package com.viagging.rest.dto;

import java.util.Date;
import java.util.List;

import com.viagging.core.constant.EstadoOrden;

public class OrdenDTO {

	private Integer id;
	
	private Date fechaCompra;
	
	private EstadoOrden estado;
	
	private TransaccionDTO transaccion;
	
	private List<CompraDTO> compras;

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

	public TransaccionDTO getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(TransaccionDTO transaccion) {
		this.transaccion = transaccion;
	}

	public List<CompraDTO> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraDTO> compras) {
		this.compras = compras;
	}
	
}
