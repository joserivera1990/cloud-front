package com.viagging.api.model;

import java.util.List;

public class Payment {

	private Integer idUsuario;
	
	private List<PaymentProduct> productos;
	
	private String medioPago;
	
	private String nombrePagador;
	
	private String numeroTarjeta;
	
	private String codigoSeguridad;
	
	private String mesVencimiento;
	
	private String annoVencimiento;
	
	private String valorTotal;
	
	private int cuotas;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<PaymentProduct> getProductos() {
		return productos;
	}

	public void setProductos(List<PaymentProduct> productos) {
		this.productos = productos;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
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

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
}
