package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ModuloDAO;
import com.viagging.core.model.Modulo;
import com.viagging.core.services.ModuloService;

/**
 * The Class ModuloServiceImpl.
 */
@Service
public class ModuloServiceImpl implements ModuloService{

	/** The modulo dao. */
	@Autowired
	private ModuloDAO moduloDAO;

	/* (non-Javadoc)
	 * @see com.viagging.core.services.ModuloService#getModuloById(java.lang.Integer)
	 */
	@Override
	public Modulo getModuloById(Integer idModulo) {
		return moduloDAO.getModuloById(idModulo);
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.ModuloService#getAllModulos()
	 */
	@Override
	public List<Modulo> getAllModulos() {
		return moduloDAO.getAllModulos();
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.ModuloService#createModulo(com.viagging.core.model.Modulo)
	 */
	@Override
	public Modulo createModulo(Modulo modulo) {
		return moduloDAO.createModulo(modulo);
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.ModuloService#updateModulo(com.viagging.core.model.Modulo)
	 */
	@Override
	public Modulo updateModulo(Modulo modulo) {
		return moduloDAO.updateModulo(modulo);
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.ModuloService#deleteModulo(java.lang.Integer)
	 */
	@Override
	public Modulo deleteModulo(Integer idModulo) {
		return moduloDAO.deleteModulo(idModulo);
	}

}
