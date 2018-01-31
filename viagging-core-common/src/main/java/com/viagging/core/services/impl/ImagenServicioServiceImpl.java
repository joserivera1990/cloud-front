package com.viagging.core.services.impl;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ImagenServicioDAO;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.model.ImagenServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.ImagenServicioService;

@Service
public class ImagenServicioServiceImpl implements ImagenServicioService{

	@Autowired
	private ImagenServicioDAO imagenServicioDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;

	@Override
	public ImagenServicio getImagenServicioById(Integer idImagenServicio) {
		return imagenServicioDAO.getImagenServicioById(idImagenServicio);
	}

	@Override
	public ImagenServicio createImagenServicio(ImagenServicio imagenServicio) {
		return imagenServicioDAO.createImagenServicio(imagenServicio);
	}

	
	@Override
	public ImagenServicio deleteImagenServicio(Integer idImagenServicio) {
		return imagenServicioDAO.deleteImagenServicio(idImagenServicio);

	}

	@Override
	public void createImagenServicio(byte[] imagenServicio, String idServicio) {
		byte[] byteArray = Base64.encodeBase64(imagenServicio);
		String encodedString = new String(byteArray);
		Servicio servicio = servicioDAO.getServicioById(Integer.parseInt(idServicio));
		if (servicio.getImagenprincipal() == null || servicio.getImagenprincipal().length == 0) {
			servicio.setImagenprincipal(encodedString.getBytes());
			servicioDAO.updateServicio(servicio);
		}
		ImagenServicio imagen = new ImagenServicio();
		imagen.setImagen(encodedString.getBytes());
		imagen.setServicio(servicio);
		createImagenServicio(imagen);
	}
	
}
