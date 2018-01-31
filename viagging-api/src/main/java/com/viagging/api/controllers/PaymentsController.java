package com.viagging.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.Payment;
import com.viagging.api.model.PaymentProduct;
import com.viagging.api.services.PaymentsService;
import com.viagging.api.util.ProductsUtil;
import com.viagging.core.model.Orden;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.PaqueteService;
import com.viagging.core.services.ServicioService;
import com.viagging.exception.ProductCapabiltyException;

@RestController
public class PaymentsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsController.class); 
	
	@Autowired
	private PaymentsService paymentsService;
	
	@Autowired
	private ProductsUtil productsUtil;
	
	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private PaqueteService paqueteService;
	
	@RequestMapping(value="/payments/submit", method = RequestMethod.POST)
	public ResponseEntity<Orden> submitPayment(@RequestBody Payment payment){
		try{
			Orden orden = paymentsService.submitPayment(payment);
			updateNumeroAdquiridos(payment);
			
			return new ResponseEntity<>(orden, HttpStatus.OK);
		} catch(ProductCapabiltyException e){
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
		} catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

	private void updateNumeroAdquiridos(Payment payment) {
		List<PaymentProduct> productos = payment.getProductos();
		for(PaymentProduct producto : productos){
			Integer productId = productsUtil.getProductId(producto.getId());
			if(productsUtil.isServicioProducto(producto.getId())){
				Servicio servicio = new Servicio();
				servicio.setId(productId);
				servicio.setNumeroAdquiridos(producto.getCantidad());
				servicioService.updateServicio(servicio);
			} else if(productsUtil.isPaqueteProducto(producto.getId())){
				Paquete paquete = new Paquete();
				paquete.setId(productId);
				paquete.setNumeroAdquiridos(producto.getCantidad());
				paqueteService.updatePaquete(paquete);
			}
		}
	}

}
