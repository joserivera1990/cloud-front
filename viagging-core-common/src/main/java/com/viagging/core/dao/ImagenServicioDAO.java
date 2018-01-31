package com.viagging.core.dao;

import com.viagging.core.model.ImagenServicio;

public interface ImagenServicioDAO {
  
	ImagenServicio getImagenServicioById(Integer idImagenServicio);

	ImagenServicio createImagenServicio( ImagenServicio  imagenServicio);

	ImagenServicio deleteImagenServicio(Integer idImagenServicio);
}
