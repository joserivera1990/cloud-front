package com.viagging.core.model.mapper;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.viagging.core.model.Movimiento;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Usuario;

@Component
public class MovimientoMapper<T> {
   
	public Movimiento  mapObject(T item,Usuario usuario,String accion) {
		Movimiento movimiento = new Movimiento();
		movimiento.setUsuario(usuario);
		movimiento.setFecha(new Date());
		movimiento.setAccion(accion);
		if(item instanceof Servicio){
		   movimiento.setServicio((Servicio)item); 	
		}else if(item instanceof Paquete){
			movimiento.setPaquete((Paquete)item);
		}
		return movimiento;
	}
}
