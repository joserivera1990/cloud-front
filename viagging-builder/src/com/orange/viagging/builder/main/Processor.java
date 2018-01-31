package com.orange.viagging.builder.main;

import java.util.List;

/**
 * Procesador de caracteristicas
 * @author karenvega
 *
 */
public class Processor {
	
	private List<String> features;
	
	/**
	 * Constructor
	 * @param features Lista de caracteristicas seleccionadas
	 */
	public Processor(List<String> features) {
		this.features = features;
	}
	
	/**
	 * Se valida si una caracteristica esta presente
	 * @param featureName nombre de la caracteristica
	 * @return true si la caracteristica se encuentra seleccionada, false en caso contrario
	 */
	public boolean isFeature(String featureName) {
		if (features.contains(featureName)) 
			return true;
		return false;
	}

}
