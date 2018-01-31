package com.viagging.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

/**
 * Helper class to create and obtain cookies
 */
public final class CookieUtil {
	
	/** The cookie max age (60 seconds * 60 minuts * 24 hours * 30 days * 12 months)*/
	private static final int COOKIE_MAX_AGE = 60*60*24*30*12;

	/** The cookie path (Valid on any part of the application)*/
	private static final String COOKIE_PATH = "/";

	/**
	 * Create a cookie with the given name and value 
	 * @param name the name of the cookie to create
	 * @param value the value of the cookie to create
	 * @return the cookie
	 */
	public static Cookie createCookie(String name, String value){
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(""); // el cookie es valido para todos los dominios
		cookie.setPath(COOKIE_PATH); 
		//cookie.setMaxAge(COOKIE_MAX_AGE); 
//		cookie.setSecure(true);
//		cookie.setHttpOnly(true);
		return cookie;
	}
	
	/**
	 * Gets a cookie from the request with a given name
	 * Uses WebUtils.getCookie()
	 *
	 * @param request the request
	 * @param name the name
	 * @return the cookie
	 */
	public static Cookie getCookie(HttpServletRequest request, String name){
		return WebUtils.getCookie(request, name);
	}
}