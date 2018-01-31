package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.PriceRange;
import com.viagging.core.services.VariabilidadService;
import com.viagging.rest.dto.NombreValorDTO;
import com.viagging.rest.model.MarketPlaceConfig;
import com.viagging.util.CategoryEnum;

@RequestMapping("/marketplace")
@RestController
public class MarketPlaceController {

	@Autowired
	private VariabilidadService variabilidadService; 
	
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public MarketPlaceConfig getMarketPlaceConfig(){
		return initMarketPlaceConfig();
	}

	private MarketPlaceConfig initMarketPlaceConfig(){
		MarketPlaceConfig marketPlaceConfig = new MarketPlaceConfig();
		marketPlaceConfig.setCategories(buildCategories());
		marketPlaceConfig.setPrices(PriceRange.getKeyValues());
		marketPlaceConfig.setVariabilidad(variabilidadService.getVariabilidad());
		return marketPlaceConfig;
	}

	private List<NombreValorDTO> buildCategories(){
		List<NombreValorDTO> nombreValorDTO = new ArrayList<>();
		for (CategoryEnum category : CategoryEnum.values()) {
			NombreValorDTO nombre = new NombreValorDTO();
			nombre.setKey(category.name());
			nombre.setValue(category.getName());
			nombreValorDTO.add(nombre);
		}
		return nombreValorDTO;
	}

}
