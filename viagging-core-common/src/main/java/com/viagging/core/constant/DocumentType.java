package com.viagging.core.constant;

import java.util.ArrayList;
import java.util.List;
import com.viagging.rest.dto.NombreValorDTO;

public enum DocumentType {

	CEDULA("Cédula", "Cédula"), 
	CEDULA_EXTRANJERIA("Cédula extranjeria", "Cédula extranjeria"), 
	TARJETA_IDENTIDAD("Tarjeta de identidad", "Tarjeta de identidad");

	private String id;
	
	private String name;

	private DocumentType(String id, String name) {
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
		for (DocumentType profile : DocumentType.values()) {
			if(profile.getName().equalsIgnoreCase(name)){
				value = profile.getId();				
			    break;
			}
		}
		return value;
	}
	
	public static List<NombreValorDTO> getKeyValues() {
		List<NombreValorDTO> nombreValorDTO = new ArrayList<>();
		for (DocumentType profile : DocumentType.values()) {
				NombreValorDTO perfil = new NombreValorDTO();
				perfil.setKey(profile.getId());
				perfil.setValue(profile.getName());
				nombreValorDTO.add(perfil);
			}
		return nombreValorDTO;
	}
}
