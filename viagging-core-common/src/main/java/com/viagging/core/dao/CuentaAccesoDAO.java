package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.CuentaAcceso;

public interface CuentaAccesoDAO {

	CuentaAcceso createCuentaAcceso(CuentaAcceso cuentaAcceso);

	List<CuentaAcceso> getUsersAdminProv();

        List<CuentaAcceso> getAllCuentaAcceso();

	CuentaAcceso findCuentaAccesoByUsuarioAndProfile(Integer usuarioId, String perfilId);

}

