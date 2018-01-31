package com.viagging.api.aspects;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.viagging.core.constant.ReportType;
import com.viagging.core.services.MovimientoService;
import com.viagging.rest.dto.ProductoDTO;
import com.viagging.util.ProductType;

@Aspect
public class ReportAspect {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(ReportAspect.class);
	
	private static final String SECRET_KEY = "secretKey";
	
	private static final String AUTHORIZATION_TOKEN_HEADER = "token";
	@Autowired
	private MovimientoService movimientoService;
    
    @AfterReturning(pointcut = "execution(* com.viagging.api.services.ProductsService.getProductById(..))",
    		returning= "result")
	public void afterQuery(JoinPoint joinPoint, Object result) {
    	String usuarioId = getUsuarioIdFromRequest();
    	
    	ProductoDTO product = (ProductoDTO) result;
		List<String> products = new ArrayList<>();
		products.add(product.getId().substring(1));
		if (product.getTipoProducto() == ProductType.SERVICIO) {
			movimientoService.createMovimientos(products, null, usuarioId, ReportType.QUERY.toString());
		} else{
			movimientoService.createMovimientos(null, products, usuarioId, ReportType.QUERY.toString());
		}
	}
    
    @SuppressWarnings("unchecked")
	@AfterReturning(pointcut = "execution(* com.viagging.api.services.ProductsService.findProducts(..))",
    		returning= "result")
	public void afterSearch(JoinPoint joinPoint, Object result) {
    	String usuarioId = getUsuarioIdFromRequest();
		List<ProductoDTO> products =  (List<ProductoDTO>) result;
		List<String> packages =  new ArrayList<>();
		List<String> services =  new ArrayList<>();
		for (ProductoDTO producto : products) {
			if (producto.getTipoProducto() == ProductType.SERVICIO) {
				services.add(producto.getId().substring(1));
			} else{
				packages.add(producto.getId().substring(1));
			}
		}
		movimientoService.createMovimientos(services, packages, usuarioId, ReportType.SEARCH.toString());
	}

    private String getUsuarioIdFromRequest(){
    	HttpServletRequest request = getRequest();
    	String token = request.getHeader(AUTHORIZATION_TOKEN_HEADER);
    	if(StringUtils.isEmpty(token)){
    		return null;
    	}
    	
    	try{
    		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    		return claims.get("usuarioId").toString();
    	} catch(Exception e){
    		LOGGER.info("Error getting JWT Token", e);
    		return null;
    	}    	
    }
    
    private HttpServletRequest getRequest(){
    	ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        if(request == null){
        	throw new IllegalStateException("http request not found!");
        }
        return request;
    }
}
