package com.viagging.api.model;

import com.viagging.rest.dto.ProductoDTO;

public class Deseo {
	
	private Integer id;
	
	private ProductoDTO producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
}
