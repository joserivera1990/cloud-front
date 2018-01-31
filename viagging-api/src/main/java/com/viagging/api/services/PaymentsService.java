package com.viagging.api.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.api.model.Payment;
import com.viagging.api.model.PaymentProduct;
import com.viagging.api.util.ProductsUtil;
import com.viagging.core.constant.EstadoOrden;
import com.viagging.core.constant.EstadoTransaccion;
import com.viagging.core.model.Compra;
import com.viagging.core.model.Orden;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Transaccion;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.OrdenService;

@Service
public class PaymentsService {

	@Autowired
	private OrdenService ordenService;
	
	@Autowired
	private ProductsUtil productsUtil;
	
	public Orden submitPayment(Payment payment){
		Orden orden = buildOrdenFromPayment(payment);
		return ordenService.createOrden(orden);
	}
	
	private Orden buildOrdenFromPayment(Payment payment){
		Orden orden = new Orden();
		
		Usuario usuario = new Usuario();
		usuario.setId(payment.getIdUsuario());
		
		Transaccion transaccion = buildTransactionFromPayment(payment);
		List<Compra> compras = buildComprasFromProductos(payment.getProductos(), orden);
		
		orden.setEstado(EstadoOrden.PROCESSED);
		orden.setFechaCompra(new Date());
		orden.setUsuario(usuario);
		orden.setTransaccion(transaccion);
		orden.setCompras(compras);
		return orden;
	}
	
	private Transaccion buildTransactionFromPayment(Payment payment){
		Transaccion transaccion = new Transaccion();
		transaccion.setMedioPago(payment.getMedioPago());
		transaccion.setNombrePagador(payment.getNombrePagador());
		transaccion.setNumeroTarjeta(payment.getNumeroTarjeta());
		transaccion.setCodigoSeguridad(payment.getCodigoSeguridad());
		transaccion.setMesVencimiento(payment.getMesVencimiento());
		transaccion.setAnnoVencimiento(payment.getAnnoVencimiento());
		transaccion.setValor(new BigDecimal(payment.getValorTotal()));
		transaccion.setCuotas(payment.getCuotas());
		transaccion.setEstado(EstadoTransaccion.APPROVED);
		return transaccion;
	}
	
	private List<Compra> buildComprasFromProductos(List<PaymentProduct> productos, Orden orden){
		List<Compra> compras = new ArrayList<>();
		for(PaymentProduct producto : productos){
			String idProducto = producto.getId();
			Compra compra = new Compra();
			compra.setOrden(orden);
			compra.setCantidad(producto.getCantidad());
			Integer id = productsUtil.getProductId(idProducto);
			if(productsUtil.isPaqueteProducto(idProducto)){
				Paquete paquete = new Paquete();
				paquete.setId(id);
				compra.setPaquete(paquete);
			} else if(productsUtil.isServicioProducto(idProducto)){
				Servicio servicio = new Servicio();
				servicio.setId(id);
				compra.setServicio(servicio);
			}
			compras.add(compra);
		}
		return compras;
	}
	
}
