package com.viagging.rest.dto.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ProductoDTO;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.util.ProductType;

@Component
public class ProductoDTOMapper {
	
	/**
	 * Builds the producto from paquete.
	 *
	 * @param paquete the paquete
	 * @return the producto
	 */
	public ProductoDTO buildProductoFromPaquete(PaqueteDTO paquete){
		if(paquete.getServicios() == null){
			return null;
		}
		ProductoDTO producto = new ProductoDTO();
		producto.setId(ProductType.PAQUETE.getPrefix() + paquete.getId());
		producto.setNombre(paquete.getNombre());
		producto.setDescripcion(paquete.getDescripcion());
		producto.setTipoProducto(ProductType.PAQUETE);
		producto.setServicios(paquete.getServicios());
		producto.setPrecio(new BigDecimal(paquete.getPrecio()));
		producto.setCapacidad(Integer.parseInt(paquete.getCapacidad()));
		producto.setNumeroAdquiridos(paquete.getNumeroAdquiridos());
		producto.setActivo(paquete.getActivo());
		producto.setProveedor(paquete.getUsuario());
		producto.setImagenes(new ArrayList<String>());
		//Imagenes
		for(ServicioDTO servicio : paquete.getServicios()){
			if(StringUtils.isEmpty(producto.getImagenPrincipal())){
				producto.setImagenPrincipal(servicio.getImagenPrincipal());
			} else {
				producto.getImagenes().add(servicio.getImagenPrincipal());
			}
			if(servicio.getImagenes() != null){
				for(String imagen : servicio.getImagenes()){
					producto.getImagenes().add(imagen);
				}
			}
			servicio.setImagenes(null);
			servicio.setImagenPrincipal(null);
		}
		
		return producto;
	}
	
	/**
	 * Builds the producto from servicio.
	 *
	 * @param servicio the servicio
	 * @return the producto
	 */
	public ProductoDTO buildProductoFromServicio(ServicioDTO servicio){
		ProductoDTO producto = new ProductoDTO();
		producto.setId(ProductType.SERVICIO.getPrefix() + servicio.getId());
		producto.setNombre(servicio.getNombre());
		producto.setDescripcion(servicio.getDescripcionCorta());
		producto.setTipoProducto(ProductType.SERVICIO);
		producto.setPrecio(new BigDecimal(servicio.getPrecio()));
		producto.setCapacidad(Integer.parseInt(servicio.getCapacidad()));
		producto.setNumeroAdquiridos(servicio.getNumeroAdquiridos());
		producto.setActivo(servicio.getActivo());
		producto.setImagenPrincipal(servicio.getImagenPrincipal());
		producto.setProveedor(servicio.getUsuario());
		producto.setImagenes(servicio.getImagenes());
		List<ServicioDTO> servicios = new ArrayList<>();
		servicios.add(servicio);
		producto.setServicios(servicios);
		servicio.setImagenes(null);
		servicio.setImagenPrincipal(null);
		return producto;
	}
}
