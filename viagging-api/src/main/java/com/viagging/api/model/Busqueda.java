package com.viagging.api.model;

import com.viagging.util.CategoryEnum;

public class Busqueda {

	private String texto;
	
	private CategoryEnum categoria;
	
	private Integer valorMinimo;
	
	private Integer valorMaximo;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public CategoryEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoryEnum categoria) {
		this.categoria = categoria;
	}

	public Integer getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Integer valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Integer getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Integer valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	
}
