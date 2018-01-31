package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.Modulo;

/**
 * The Interface ModuloDAO.
 */
public interface ModuloDAO {

	/**
	 * Gets the modulo by id.
	 *
	 * @param idModulo the id modulo
	 * @return the modulo by id
	 */
	Modulo getModuloById(Integer idModulo);

	/**
	 * Gets the all modulos.
	 *
	 * @return the all modulos
	 */
	List<Modulo> getAllModulos();

	/**
	 * Creates the modulo.
	 *
	 * @param modulo the modulo
	 * @return the modulo
	 */
	Modulo createModulo(Modulo modulo);

	/**
	 * Update modulo.
	 *
	 * @param modulo the modulo
	 * @return the modulo
	 */
	Modulo updateModulo(Modulo modulo);

	/**
	 * Delete modulo.
	 *
	 * @param idModulo the id modulo
	 */
	Modulo deleteModulo(Integer idModulo);


}
