package com.viagging.core.services;

import java.util.List;
import com.viagging.core.model.CuentaAcceso;


public interface CuentaAccesoService {

	CuentaAcceso createCuentaAcceso(CuentaAcceso cuentaAcceso);

	List<CuentaAcceso> getUsersAdminProv();

	CuentaAcceso findCuentaAccesoByUsuarioAndProfile(Integer usuarioId, String perfilId);

        List<CuentaAcceso> getAllCuentaAcceso();

}
