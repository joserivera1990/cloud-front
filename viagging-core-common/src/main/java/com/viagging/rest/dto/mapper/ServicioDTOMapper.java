package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.ImagenServicio;
import com.viagging.core.model.PaqueteServicio;
import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.util.CategoryEnum;

@Component
public class ServicioDTOMapper {

	@Autowired
	private AlojamientoDTOMapper alojamientoDTOMapper;
	
	@Autowired
	private AlimentacionDTOMapper alimentacionDTOMapper;
	
	@Autowired
	private TransporteDTOMapper transporteDTOMapper;
	
	@Autowired
	private PaseoEcologicoDTOMapper paseoEcologicoDTOMapper;
	
	@Autowired
	private CaracteristicaDTOMapper caracteristicaDTOMapper;
	
	@Autowired
	private UsuarioDTOMapper usuarioDTOMapper;
	
	public ServicioDTO mapObject(Servicio servicio) {
		ServicioDTO servicioDTO = new ServicioDTO();
		servicioDTO.setId(servicio.getId());
		servicioDTO.setActivo(servicio.getActivo());
		servicioDTO.setNombre(servicio.getNombre());
		servicioDTO.setDescripcionCorta(servicio.getDescripcion());
		servicioDTO.setCaracteristicas(caracteristicaDTOMapper.mapObjectListFromCaracteristicaServicio(servicio.getCaracteristicas()));
		servicioDTO.setPrecio(String.valueOf(servicio.getPrecio()));
		servicioDTO.setCapacidad(servicio.getCapacidad().toString());
		servicioDTO.setNumeroAdquiridos(servicio.getNumeroAdquiridos());
		servicioDTO.setRestricciones(servicio.getRestricciones());
		servicioDTO.setUsuario(usuarioDTOMapper.mapObject(servicio.getUsuario()));
		if(servicio.getImagenprincipal() != null){
			servicioDTO.setImagenPrincipal(new String(servicio.getImagenprincipal()));
		}
		if(servicio.getImagenes() != null && !servicio.getImagenes().isEmpty()){
			List<String> imagenes = new ArrayList<>();
			for(ImagenServicio imagenServicio : servicio.getImagenes()){
				if(imagenServicio.getImagen() != null){
					imagenes.add(new String(imagenServicio.getImagen()));
				}
			}
			servicioDTO.setImagenes(imagenes);
		}
		CategoryEnum categoria = getCategoriaFromServicio(servicio);
		servicioDTO.setCategoria(categoria);
		servicioDTO.setCiudad(getCiudadFromCategoria(servicio, categoria));
		mapCategoria(servicioDTO, servicio);
		return servicioDTO;
	}
	
	private CategoryEnum getCategoriaFromServicio(Servicio servicio){
		if (servicio.getAlimentacion() != null) {
			return CategoryEnum.ALIMENTACION;
		} else if (servicio.getTransporte() != null) {
			return CategoryEnum.TRANSPORTE;
		} else if (servicio.getAlojamiento() != null) {
			return CategoryEnum.ALOJAMIENTO;
		} else if (servicio.getPaseoEcologico() != null) {
			return CategoryEnum.PASEO_ECOLOGICO;
		}
		return null;
	}
	
	private String getCiudadFromCategoria(Servicio servicio, CategoryEnum categoria) {
		switch(categoria){
			case ALIMENTACION:
				return servicio.getAlimentacion().getCiudad();
			case TRANSPORTE:
				return servicio.getTransporte().getLugardestino();
			case ALOJAMIENTO:
				return servicio.getAlojamiento().getCiudad();
			case PASEO_ECOLOGICO:
				return servicio.getPaseoEcologico().getCiudad();
		}
		return "";
	}
	
	public List<ServicioDTO> mapObjectList(List<Servicio> listServicio) {
		List<ServicioDTO> listServicioDTO = new ArrayList<>();
		for (Servicio servicio : listServicio) {
			listServicioDTO.add(mapObject(servicio));
		}
		return listServicioDTO;
	}
	
	private void mapCategoria(ServicioDTO servicioDTO, Servicio servicio){
		switch(servicioDTO.getCategoria()){
			case ALIMENTACION:
				servicioDTO.setAlimentacion(alimentacionDTOMapper.mapObject(servicio.getAlimentacion()));
				break;
			case TRANSPORTE:
				servicioDTO.setTransporte(transporteDTOMapper.mapObject(servicio.getTransporte()));
				break;
			case ALOJAMIENTO:
				servicioDTO.setAlojamiento(alojamientoDTOMapper.mapObject(servicio.getAlojamiento()));
				break;
			case PASEO_ECOLOGICO:
				servicioDTO.setPaseoEcologico(paseoEcologicoDTOMapper.mapObject(servicio.getPaseoEcologico()));
				break;
		}
	}
	
	public List<ServicioDTO> mapObjectListFromPaqueteServicio(List<PaqueteServicio> paquetesServicios) {
		List<ServicioDTO> serviciosDTO = new ArrayList<>();
		for (PaqueteServicio paqueteServicio : paquetesServicios) {
			serviciosDTO.add(mapObject(paqueteServicio.getServicio()));
		}
		return serviciosDTO;
	}
}