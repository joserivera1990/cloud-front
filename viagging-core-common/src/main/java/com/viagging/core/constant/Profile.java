package com.viagging.core.constant;

import java.util.ArrayList;
import java.util.List;
import com.viagging.rest.dto.NombreValorDTO;

public enum Profile {

	USUARIO("1", "Usuario"), 
	PROVEEDOR("2", "Proveedor"), 
	ADMINISTRADOR("3", "Administrador");

	private String id;
	
	private String name;

	private Profile(String id, String name) {
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
		for (Profile profile : Profile.values()) {
			if(profile.getName().equalsIgnoreCase(name)){
				value = profile.getId();				
			    break;
			}
		}
		return value;
	}
	
	public static List<NombreValorDTO> getKeyValuesWithoutUser() {
		List<NombreValorDTO> nombreValorDTO = new ArrayList<>();
		for (Profile profile : Profile.values()) {
			if(!profile.getId().equals(Profile.USUARIO.getId())){
				NombreValorDTO perfil = new NombreValorDTO();
				perfil.setKey(profile.getId());
				perfil.setValue(profile.getName());
				nombreValorDTO.add(perfil);
			}
		}
		return nombreValorDTO;
	}
}
