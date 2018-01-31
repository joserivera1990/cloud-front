package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.CuentaAccesoDAO;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.services.CuentaAccesoService;

@Service
public class CuentaAccesoServiceImpl implements  CuentaAccesoService  {

	@Autowired
	private CuentaAccesoDAO cuentaAccesoDAO;

	@Override
	public CuentaAcceso createCuentaAcceso(CuentaAcceso cuentaAcceso) {
		return cuentaAccesoDAO.createCuentaAcceso(cuentaAcceso);
    }

	@Override
	public List<CuentaAcceso> getUsersAdminProv(){
		return cuentaAccesoDAO.getUsersAdminProv();
	}

	@Override
	public CuentaAcceso findCuentaAccesoByUsuarioAndProfile(Integer usuarioId, String perfilId) {
		return cuentaAccesoDAO.findCuentaAccesoByUsuarioAndProfile(usuarioId, perfilId);
	}

        @Override
	public List<CuentaAcceso> getAllCuentaAcceso(){
		return cuentaAccesoDAO.getAllCuentaAcceso();	
	}


}
