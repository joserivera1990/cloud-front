package com.orange.viagging.builder.utils;

import java.util.ResourceBundle;

public class Utils {
    
	private Utils(){
	}
	
	public static String getAttributeConfiguration(String fileName, String key) {		
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		return rb.getString(key);
	}
	
}
