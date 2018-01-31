package com.viagging.rest.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viagging.core.constant.EstadoItem;
import com.viagging.core.model.PaqueteServicio;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicioDTO {

	private Integer id;

	private Boolean activo;

	private String nombre;

	private String descripcionCorta;

	private String precio;

	private String idCategoria;
	
	private CategoryEnum categoria;

	private String ciudad;

	private PaqueteDTO paquete;

	private String imagenPrincipal;

	private List<String> imagenes;

	private String restricciones;

	private List<CaracteristicasDTO> caracteristicas;
	
	private AlimentacionDTO alimentacion;
	
	private AlojamientoDTO alojamiento;
	
	private PaseoEcologicoDTO paseoEcologico;
	
	private TransporteDTO transporte;
	
	private UsuarioDTO usuario;
	
	private String fechaInicial;
	
	private String fechaFinal;
	
	private String capacidad;
	
	private Integer numeroAdquiridos;

	public ServicioDTO() {
	}

	public ServicioDTO(Integer id, Boolean activo, String nombre,
			String descripcionCorta, String precio, String restricciones, String fechaInicial, String fechaFinal, String capacidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.precio = precio;
		this.restricciones = restricciones;
		this.activo = activo;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public List<CaracteristicasDTO> getCaracteristicas() {
		return caracteristicas;
	}
	
	public void setCaracteristicas(List<CaracteristicasDTO> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


	public List<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}

	public String getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}

	public PaqueteDTO getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteDTO paquete) {
		this.paquete = paquete;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public CategoryEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoryEnum categoria) {
		this.categoria = categoria;
	}

	public AlimentacionDTO getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(AlimentacionDTO alimentacion) {
		this.alimentacion = alimentacion;
	}

	public AlojamientoDTO getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(AlojamientoDTO alojamiento) {
		this.alojamiento = alojamiento;
	}

	public PaseoEcologicoDTO getPaseoEcologico() {
		return paseoEcologico;
	}

	public void setPaseoEcologico(PaseoEcologicoDTO paseoEcologico) {
		this.paseoEcologico = paseoEcologico;
	}

	public TransporteDTO getTransporte() {
		return transporte;
	}

	public void setTransporte(TransporteDTO transporte) {
		this.transporte = transporte;
	}
	
	public Integer getNumeroAdquiridos() {
		return numeroAdquiridos;
	}

	public void setNumeroAdquiridos(Integer numeroAdquiridos) {
		this.numeroAdquiridos = numeroAdquiridos;
	}

	public static List<ServicioDTO> buildListObject(List<Servicio> listServicio) {
		List<ServicioDTO> listServicioDTO = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (Servicio servicio : listServicio) {
			ServicioDTO servicioDTO = new ServicioDTO(servicio.getId(), true,servicio.getNombre(), servicio.getDescripcion(), String.valueOf(servicio.getPrecio()), servicio.getRestricciones(),
					servicio.getFechaInicio() != null ? sdf.format(servicio.getFechaInicio()) : "", servicio.getFechaVigencia() != null ? sdf.format(servicio.getFechaVigencia()) : "", String.valueOf(servicio.getCapacidad()));
			servicioDTO =  ServicioDTO.setearDatosAdicionales(servicioDTO, servicio);
			if(servicio.getEstado() != null){
			      servicioDTO.setActivo(servicio.getEstado().equals(EstadoItem.ACTIVO.getId()) ? true : false );
			}
			listServicioDTO.add(servicioDTO);
		}
		return listServicioDTO;
	}
    
	private static ServicioDTO setearDatosAdicionales(ServicioDTO servicioDTO, Servicio servicio){
		String idCategoria = "";
		if (servicio.getAlimentacion() != null) {
			idCategoria = CategoryEnum.ALIMENTACION.getId();
			servicioDTO.setCategoria(CategoryEnum.ALIMENTACION);
		} else if (servicio.getTransporte() != null) {
			idCategoria = CategoryEnum.TRANSPORTE.getId();
			servicioDTO.setCategoria(CategoryEnum.TRANSPORTE);
		} else if (servicio.getAlojamiento() != null) {
			idCategoria = CategoryEnum.ALOJAMIENTO.getId();
			servicioDTO.setCategoria(CategoryEnum.ALOJAMIENTO);
		} else if (servicio.getPaseoEcologico() != null) {
			idCategoria = CategoryEnum.PASEO_ECOLOGICO.getId();
			servicioDTO.setCategoria(CategoryEnum.PASEO_ECOLOGICO);
		}
		servicioDTO.setIdCategoria(idCategoria);
		servicioDTO.setCiudadFromCategoria(servicio);
		if(servicio.getImagenprincipal() != null){
			servicioDTO.setImagenPrincipal(new String(servicio.getImagenprincipal()));
		}
		return servicioDTO;
		
	} 
	
	public static ServicioDTO buildObject(Servicio servicio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ServicioDTO servicioDTO = new ServicioDTO(servicio.getId(),servicio.getActivo(),  servicio.getNombre(), servicio.getDescripcion(), String.valueOf(servicio.getPrecio()), servicio.getRestricciones(),
				sdf.format(servicio.getFechaInicio()), sdf.format(servicio.getFechaVigencia()), String.valueOf(servicio.getCapacidad()));
		servicioDTO.setCiudadFromCategoria(servicio);
		servicioDTO.setActivo(servicio.getEstado().equals(EstadoItem.ACTIVO.getId()) ? true : false );
		if(servicio.getImagenprincipal() != null){
			servicioDTO.setImagenPrincipal(new String(servicio.getImagenprincipal()));
		}
		return servicioDTO;
	}

	private void setCiudadFromCategoria(Servicio servicio) {
		String ciudad = "";
		if (servicio.getAlimentacion() != null) {
			ciudad = servicio.getAlimentacion().getCiudad();
		} else if (servicio.getTransporte() != null) {
			ciudad = servicio.getTransporte().getLugardestino();
		} else if (servicio.getAlojamiento() != null) {
			ciudad = servicio.getAlojamiento().getCiudad();
		} else if (servicio.getPaseoEcologico() != null) {
			ciudad = servicio.getPaseoEcologico().getCiudad();
		}
		this.ciudad = ciudad;
	}

	public static List<ServicioDTO> buildListServicioDTO(List<PaqueteServicio> listaPaqueteServicio) {
		List<ServicioDTO> listaServicioDTO = new ArrayList<>();
		for (PaqueteServicio paqueteServicio : listaPaqueteServicio) {
			ServicioDTO servicioDTO = ServicioDTO.buildObject(paqueteServicio.getServicio());
			servicioDTO.setPaquete(servicioDTO.buildPaquete(paqueteServicio.getServicio()));
			listaServicioDTO.add(servicioDTO);
		}
		return listaServicioDTO;
	}
    
	private PaqueteDTO buildPaquete(Servicio servicio) {
		PaqueteDTO paquete = new PaqueteDTO();
		String idCategoria = "";
		if (servicio.getAlimentacion() != null) {
			idCategoria = CategoryEnum.ALIMENTACION.getId();
			paquete.setNombre(CategoryEnum.ALIMENTACION.name());
		} else if (servicio.getTransporte() != null) {
			idCategoria = CategoryEnum.TRANSPORTE.getId();
			paquete.setNombre(CategoryEnum.TRANSPORTE.name());
		} else if (servicio.getAlojamiento() != null) {
			idCategoria = CategoryEnum.ALOJAMIENTO.getId();
			paquete.setNombre(CategoryEnum.ALOJAMIENTO.name());
		} else if (servicio.getPaseoEcologico() != null) {
			idCategoria = CategoryEnum.PASEO_ECOLOGICO.getId();
			paquete.setNombre(CategoryEnum.PASEO_ECOLOGICO.name());
		}
		this.idCategoria = idCategoria;
		return paquete;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}