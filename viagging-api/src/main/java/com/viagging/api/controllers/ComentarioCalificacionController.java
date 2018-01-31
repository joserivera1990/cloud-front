package com.viagging.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.util.ProductsUtil;
import com.viagging.core.model.ComentarioCalificacion;
import com.viagging.core.model.mapper.ComentarioCalificacionMapper;
import com.viagging.core.services.ComentarioCalificacionService;
import com.viagging.rest.dto.ComentarioCalificacionDTO;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

@RestController
@RequestMapping("/products")
public class ComentarioCalificacionController {

	@Autowired
	private ComentarioCalificacionService comentarioCalificacionService;

	@Autowired
	private ProductsUtil productsUtil;

	@Autowired
	private ComentarioCalificacionMapper comentarioCalificacionMapper;

	@RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
	public void addComment(@RequestBody ComentarioCalificacionDTO comentarioDTO, @PathVariable String id){
		Integer productId = productsUtil.getProductId(id);
		if(productsUtil.isPaqueteProducto(id)){
			PaqueteDTO paquete = new PaqueteDTO();
			paquete.setId(productId);
			comentarioDTO.setPaquete(paquete);
		} else if(productsUtil.isServicioProducto(id)){
			ServicioDTO servicio = new ServicioDTO();
			servicio.setId(productId);
			comentarioDTO.setServicio(servicio);
		}

		ComentarioCalificacion comentario = comentarioCalificacionMapper.mapObject(comentarioDTO);
		comentarioCalificacionService.createComentario(comentario);
	}

}
