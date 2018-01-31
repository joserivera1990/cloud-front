package com.viagging.util;

public enum ProductType {

	SERVICIO("S"),
	
	PAQUETE("P");
	
	private String prefix;
	
	public String getPrefix(){
		return this.prefix;
	}
	
	ProductType(String prefix){
		this.prefix = prefix;
	}
}
