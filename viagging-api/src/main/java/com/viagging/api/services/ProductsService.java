/*
 *
 */
package com.viagging.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.api.model.Busqueda;
import com.viagging.api.util.ProductsUtil;
import com.viagging.core.model.ComentarioCalificacion;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Pregunta;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.ComentarioCalificacionService;
import com.viagging.core.services.PaqueteService;
import com.viagging.core.services.PreguntaService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.ComentarioCalificacionDTO;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ProductoDTO;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.mapper.ComentarioCalificacionDTOMapper;
import com.viagging.rest.dto.mapper.PaqueteDTOMapper;
import com.viagging.rest.dto.mapper.PreguntaDTOMapper;
import com.viagging.rest.dto.mapper.ProductoDTOMapper;
import com.viagging.rest.dto.mapper.ServicioDTOMapper;

/**
 * The Class ProductoServiceImpl.
 */
@Service
public class ProductsService {

	/** The servicio service. */
	@Autowired
	private ServicioService servicioService;

	/** The paquete service. */
	@Autowired
	private PaqueteService paqueteService;

	@Autowired
	private PreguntaService preguntaService;

	@Autowired
	private PaqueteDTOMapper paqueteDTOMapper;

	@Autowired
	private ServicioDTOMapper servicioDTOMapper;

	@Autowired
	private ProductoDTOMapper productoMapper;

	@Autowired
	private PreguntaDTOMapper preguntaDTOMapper;

	@Autowired
	private ComentarioCalificacionDTOMapper comentarioDTOMapper;

	@Autowired
	private ComentarioCalificacionService comentarioService;

	@Autowired
	private ProductsUtil productsUtil;
    	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	public List<ProductoDTO> getAllProducts(){
		List<PaqueteDTO> paquetes = paqueteDTOMapper.mapObjectList(paqueteService.getAllPaquete());
		List<ServicioDTO> servicios = servicioDTOMapper.mapObjectList(servicioService.getAllServicio());
		return buildProductosFromPaquetesAndServicios(paquetes, servicios);
	}

	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 */
	public ProductoDTO getProductById(String productId){
		Integer id = productsUtil.getProductId(productId);
		ProductoDTO producto = new ProductoDTO();
		if(productsUtil.isPaqueteProducto(productId)){
			PaqueteDTO paquete = paqueteDTOMapper.mapObject(paqueteService.getPaqueteById(id));
			producto = buildProductoFromPaquete(paquete);

		} else if(productsUtil.isServicioProducto(productId)){
			ServicioDTO servicio = servicioDTOMapper.mapObject(servicioService.getServicioById(id));
			producto = buildProductoFromServicio(servicio);
		}

		Double calificacion = new Double(0);
		if(producto.getComentarios() != null && !producto.getComentarios().isEmpty()){
			Double calificaciones = new Double(0);
			for(ComentarioCalificacionDTO comentario : producto.getComentarios()){
				calificaciones += comentario.getCalificacion();
			}
			calificacion = calificaciones / producto.getComentarios().size();
		}
		producto.setCalificacion(calificacion);
		return producto;
	}



	/**
	 * Builds the producto from paquete.
	 *
	 * @param paquete the paquete
	 * @return the producto
	 */
	private ProductoDTO buildProductoFromPaquete(PaqueteDTO paquete) {
		ProductoDTO producto = productoMapper.buildProductoFromPaquete(paquete);

		List<Pregunta> preguntas = preguntaService.findPreguntasByPaquete(paquete.getId());
		if(preguntas != null){
			producto.setPreguntas(preguntaDTOMapper.mapObjectList(preguntas));
		}

		List<ComentarioCalificacion> comentarios = comentarioService.findComentariosByPaquete(paquete.getId());
		if(comentarios != null){
			producto.setComentarios(comentarioDTOMapper.mapObjectList(comentarios));
		}
		return producto;
	}

	/**
	 * Builds the producto from servicio.
	 *
	 * @param servicio the servicio
	 * @return the producto
	 */
	private ProductoDTO buildProductoFromServicio(ServicioDTO servicio) {
		ProductoDTO producto = productoMapper.buildProductoFromServicio(servicio);

		List<Pregunta> preguntas = preguntaService.findPreguntasByServicio(servicio.getId());
		if(preguntas != null){
			producto.setPreguntas(preguntaDTOMapper.mapObjectList(preguntas));
		}

		List<ComentarioCalificacion> comentarios = comentarioService.findComentariosByServicio(servicio.getId());
		if(comentarios != null){
			producto.setComentarios(comentarioDTOMapper.mapObjectList(comentarios));
		}
		return producto;
	}

	/**
	 * Builds the productos from paquetes and servicios.
	 *
	 * @param paquetes the paquetes
	 * @param servicios the servicios
	 * @return the list
	 */
	private List<ProductoDTO> buildProductosFromPaquetesAndServicios(List<PaqueteDTO> paquetes, List<ServicioDTO> servicios){
		List<ProductoDTO> productos = new ArrayList<>();
		for(PaqueteDTO paquete : paquetes){
			ProductoDTO productoPaquete = productoMapper.buildProductoFromPaquete(paquete);
			if(productoPaquete != null && productoPaquete.getActivo()){
				productos.add(productoPaquete);
			}
		}
		for(ServicioDTO servicio : servicios){
			ProductoDTO productoServicio = productoMapper.buildProductoFromServicio(servicio);
			if(productoServicio != null && productoServicio.getActivo()){
				productos.add(productoServicio);
			}
		}
		return productos;
	}

	public List<ProductoDTO> findProducts(Busqueda busqueda){
		//Find servicios
		Servicio servicio = new Servicio();
		servicio.setNombre(busqueda.getTexto());
		servicio.setDescripcion(busqueda.getTexto());

		List<Servicio> servicios = servicioService.findAllByCriteria(servicio);

		List<ServicioDTO> serviciosDTO = servicioDTOMapper.mapObjectList(servicios);

		//Find paquetes
		Paquete paquete = new Paquete();
		paquete.setNombrePaquete(busqueda.getTexto());
		paquete.setDescripcion(busqueda.getTexto());

		List<Paquete> paquetes = paqueteService.findAllByCriteria(paquete);
		List<PaqueteDTO> paquetesDTO = paqueteDTOMapper.mapObjectList(paquetes);

		List<ProductoDTO> productos = buildProductosFromPaquetesAndServicios(paquetesDTO, serviciosDTO);

		return productos;
	}
	


}
