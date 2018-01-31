package com.viagging.util;

import java.util.ArrayList;
import java.util.List;

import com.viagging.rest.dto.NombreValorDTO;

public enum CategoryEnum {

	TRANSPORTE("01", "Transporte"), 
	ALOJAMIENTO("02", "Alojamiento"), 
	PASEO_ECOLOGICO("03", "Paseo Ecológico"), 
	ALIMENTACION("04", "Alimentación");

	private String id;
	
	private String name;

	private CategoryEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public String getName(){
		return name;
	}

	public static List<NombreValorDTO> getKeyValues() {
		List<NombreValorDTO> nombreValorDTO = new ArrayList<>();
		for (CategoryEnum topicEnum : CategoryEnum.values()) {
			NombreValorDTO nombre = new NombreValorDTO();
			nombre.setKey(topicEnum.getId());
			nombre.setValue(topicEnum.getName());
			nombreValorDTO.add(nombre);
		}
		return nombreValorDTO;
	}

}
