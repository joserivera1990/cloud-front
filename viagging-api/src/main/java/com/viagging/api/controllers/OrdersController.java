package com.viagging.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.model.Orden;
import com.viagging.core.services.OrdenService;
import com.viagging.rest.dto.OrdenDTO;
import com.viagging.rest.dto.mapper.OrdenDTOMapper;

@RequestMapping("/user")
@RestController
public class OrdersController {
	
	@Autowired
	private OrdenService ordenService;
	
	@Autowired
	private OrdenDTOMapper ordenDTOMapper;

	@RequestMapping(value = "/{usuarioId}/orders/{ordenId}", method = RequestMethod.GET)
	public ResponseEntity<OrdenDTO> getOrdenById(@PathVariable("usuarioId") String usuarioId,
			@PathVariable("ordenId") Integer ordenId){
		Orden orden = ordenService.getOrdenById(ordenId);
		if(orden == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		OrdenDTO ordenDTO = ordenDTOMapper.mapObject(orden);
		return new ResponseEntity<>(ordenDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{usuarioId}/orders", method = RequestMethod.GET)
	public ResponseEntity<List<OrdenDTO>> getOrdenById(@PathVariable("usuarioId") Integer usuarioId){
		List<Orden> ordenes = ordenService.getOrdenesByUsuario(usuarioId);
		if(ordenes == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<OrdenDTO> ordenesDTO = ordenDTOMapper.mapObjectList(ordenes);
		return new ResponseEntity<>(ordenesDTO, HttpStatus.OK);
	}
	
}
