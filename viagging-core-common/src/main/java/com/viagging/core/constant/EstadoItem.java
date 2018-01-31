package com.viagging.core.constant;

public enum EstadoItem {

	ACTIVO("ACT", "Activo"), 
	INACTIVO("INA", "Inactivo"), 
	ELIMINADO("ELI", "Eliminado");

	private String id;
	
	private String name;

	private EstadoItem(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public String getName(){
		return name;
	}
    
	public static String getValue(String name) {
		String value = "";
		for (EstadoItem estado : EstadoItem.values()) {
			if(estado.getName().equalsIgnoreCase(name)){
				value = estado.getId();				
			    break;
			}
		}
		return value;
	}

}
