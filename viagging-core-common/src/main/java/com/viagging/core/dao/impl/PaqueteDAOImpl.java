package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.constant.EstadoItem;
import com.viagging.core.dao.PaqueteDAO;
import com.viagging.core.model.Paquete;
import com.viagging.exception.ProductCapabiltyException;

/**
 * The Class ModuloDAOImpl.
 */
@Transactional
@Repository
public class PaqueteDAOImpl implements PaqueteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Paquete getPaqueteById(Integer idPaquete){
		return entityManager.find(Paquete.class, idPaquete);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paquete> getAllPaquetes() {
		return (List<Paquete>) entityManager.createNamedQuery("Paquete.findAll").getResultList();
	}

	@Override
	public Paquete createPaquete(Paquete paquete){
		entityManager.persist(paquete);
		return paquete;
	}

	@Override
	public Paquete updatePaquete(Paquete paquete) {
		Paquete _paquete = entityManager.find(Paquete.class, paquete.getId());
		if(StringUtils.isNotEmpty(paquete.getNombrePaquete())){
			_paquete.setNombrePaquete(paquete.getNombrePaquete());
		}
		if(paquete.getDescripcion() != null){
			_paquete.setDescripcion(paquete.getDescripcion());
		}
		if(paquete.getPrecio() != null){
			_paquete.setPrecio(paquete.getPrecio());
		}
		if(paquete.getNumeroAdquiridos() != null){
			if(_paquete.getNumeroAdquiridos() != null){
				int numeroAdquiridosTotal = _paquete.getNumeroAdquiridos() + paquete.getNumeroAdquiridos();
				if(numeroAdquiridosTotal > _paquete.getCapacidad()){
					throw new ProductCapabiltyException("No hay suficiente disponibilidad de este servicio");
				}
				_paquete.setNumeroAdquiridos(numeroAdquiridosTotal);
			}else{
				_paquete.setNumeroAdquiridos(paquete.getNumeroAdquiridos());
			}
		}
		entityManager.persist(_paquete);
		return _paquete;
	}

	@Override
	public void deletePaquete(Integer idPaquete){
		Paquete _paquete = entityManager.find(Paquete.class, idPaquete);
		if (_paquete != null) {
			_paquete.setEstado(EstadoItem.ELIMINADO.getId());
			entityManager.persist(_paquete);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Paquete> getAllPaquetesByFiltro(String filtro,int idUsuario){
		if(filtro == null){
			filtro = "";
		}
		 Query query = entityManager
		            .createQuery("SELECT t from Paquete t where t.nombrePaquete LIKE :filtro and t.estado != :estado and t.usuario.id = :idUsuario");
		        query.setParameter("filtro", "%"+filtro+"%");
		        query.setParameter("estado",EstadoItem.ELIMINADO.getId());
		        query.setParameter("idUsuario",idUsuario);
				List<Paquete> listaPaquete =  query.getResultList(); 
		return listaPaquete;
	}

	@Override
	public List<Paquete> findAllByCriteria(Paquete paquete) {
		Query query = entityManager.createNamedQuery("Paquete.findAllByCriteria");
		query.setParameter("nombre", "%"+paquete.getNombrePaquete()+"%");
		query.setParameter("descripcion", "%"+paquete.getDescripcion()+"%");
		return (List<Paquete>) query.getResultList();
	}
	
	@Override
	public Paquete activatePaquete(Paquete paquete) {
		Paquete _paquete = entityManager.find(Paquete.class, paquete.getId());
		_paquete.setActivo(paquete.getActivo());
		entityManager.persist(_paquete);
		return _paquete;
	}

}