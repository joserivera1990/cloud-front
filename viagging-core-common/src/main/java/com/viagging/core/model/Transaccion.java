package com.viagging.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.viagging.core.constant.EstadoTransaccion;

@Entity
@Table(name="tp_transaccion")
public class Transaccion implements Serializable{

	private static final long serialVersionUID = -7746200195336306483L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private EstadoTransaccion estado;
	
	private String medioPago;
	
	private BigDecimal valor;
	
	private String nombrePagador;
	
	private String numeroTarjeta;
	
	private String codigoSeguridad;
	
	private String mesVencimiento;
	
	private String annoVencimiento;
	
	private int cuotas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoTransaccion getEstado() {
		return estado;
	}

	public void setEstado(EstadoTransaccion estado) {
		this.estado = estado;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNombrePagador() {
		return nombrePagador;
	}

	public void setNombrePagador(String nombrePagador) {
		this.nombrePagador = nombrePagador;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getMesVencimiento() {
		return mesVencimiento;
	}

	public void setMesVencimiento(String mesVencimiento) {
		this.mesVencimiento = mesVencimiento;
	}

	public String getAnnoVencimiento() {
		return annoVencimiento;
	}

	public void setAnnoVencimiento(String annoVencimiento) {
		this.annoVencimiento = annoVencimiento;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
}
