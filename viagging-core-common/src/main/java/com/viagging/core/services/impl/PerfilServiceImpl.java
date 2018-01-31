package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.PerfilDAO;
import com.viagging.core.model.Perfil;
import com.viagging.core.services.PerfilService;

/**
 * The Class UsuarioServiceImpl.
 */
@Service
public class PerfilServiceImpl implements  PerfilService  {

	@Autowired
	private PerfilDAO perfilDAO;


	@Override
	public Perfil getPerfilById(Integer idPerfil) {
		return perfilDAO.getPerfilById(idPerfil);
	}


	
}