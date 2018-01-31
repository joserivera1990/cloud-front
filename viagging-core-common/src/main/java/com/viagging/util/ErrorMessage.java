package com.viagging.util;

public class ErrorMessage {
	
    private int code;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code){
    	this.code = code;
    }

    public int getCode(){
    	return code;
    }

    public void setMessage(String message){
    	this.message = message;
    }

    public String getMessage(){
    	return message;
    }	    
}