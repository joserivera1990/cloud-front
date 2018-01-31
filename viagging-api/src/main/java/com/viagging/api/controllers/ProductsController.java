package com.viagging.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.Busqueda;
import com.viagging.api.services.ProductsService;
import com.viagging.api.util.ProductsUtil;
import com.viagging.core.model.Pregunta;
import com.viagging.core.model.mapper.PreguntaMapper;
import com.viagging.core.services.PreguntaService;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.PreguntaDTO;
import com.viagging.rest.dto.ProductoDTO;
import com.viagging.rest.dto.ServicioDTO;

/**
 * The Class ProductsController.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

	/** The product service. */
	@Autowired
	private ProductsService productsService;

	@Autowired
	private ProductsUtil productsUtil;

	@Autowired
	private PreguntaService preguntaService;

	@Autowired
	private PreguntaMapper preguntaMapper;

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductoDTO>> getAllProducts(){
		List<ProductoDTO> productos = productsService.getAllProducts();
		if(productos != null){
			return new ResponseEntity<>(productos, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductoDTO> getProductByIdAndType(@PathVariable String id,
			@RequestHeader(value = "token", required = false) String token){
		ProductoDTO producto = productsService.getProductById(id);
		if(producto != null){
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}/question", method = RequestMethod.POST)
	public void addQuestion(@RequestBody PreguntaDTO preguntaDTO, @PathVariable String id){
		Integer productId = productsUtil.getProductId(id);
		if(productsUtil.isPaqueteProducto(id)){
			PaqueteDTO paquete = new PaqueteDTO();
			paquete.setId(productId);
			preguntaDTO.setPaquete(paquete);
		} else if(productsUtil.isServicioProducto(id)){
			ServicioDTO servicio = new ServicioDTO();
			servicio.setId(productId);
			preguntaDTO.setServicio(servicio);
		}

		Pregunta pregunta = preguntaMapper.mapObject(preguntaDTO);
		preguntaService.createPregunta(pregunta);
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public ResponseEntity<List<ProductoDTO>> findProducts(@RequestBody Busqueda busqueda,
			@RequestHeader(value = "token", required = false) String token){
		List<ProductoDTO> productos = productsService.findProducts(busqueda);
		if(productos != null){
			return new ResponseEntity<>(productos, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}