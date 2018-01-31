package com.viagging.core.services;

import com.viagging.core.model.ImagenServicio;

public interface ImagenServicioService {

	ImagenServicio getImagenServicioById(Integer idImagenServicio);

	ImagenServicio createImagenServicio(ImagenServicio imagenServicio);
	
	ImagenServicio deleteImagenServicio(Integer idImagenServicio);
	
	void createImagenServicio(byte[] imageService, String idService);
}
