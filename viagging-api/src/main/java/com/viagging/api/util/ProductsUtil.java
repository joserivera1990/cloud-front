package com.viagging.api.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.viagging.util.ProductType;

@Component
public class ProductsUtil {
	
	public boolean isPaqueteProducto(String productId){
		return StringUtils.startsWithIgnoreCase(productId, ProductType.PAQUETE.getPrefix());
	}
	
	public boolean isServicioProducto(String productId){
		return StringUtils.startsWithIgnoreCase(productId, ProductType.SERVICIO.getPrefix());
	}
	
	public Integer getProductId(String productId){
		return Integer.parseInt(productId.replaceAll("[\\D]", ""));
	}

}
