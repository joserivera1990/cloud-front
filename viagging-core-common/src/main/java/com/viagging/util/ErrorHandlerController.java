package com.viagging.util;

import javax.ws.rs.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlerController {

	public static final String SUCCESS = "success";
    public static final String CODE = "code";
    public static final String MESSAGE = "message";
	
	/*
		Exception								HTTP Status Code
		ConversionNotSupportedException			500 (Internal Server Error)
		HttpMediaTypeNotAcceptableException		406 (Not Acceptable)
		HttpMediaTypeNotSupportedException		415 (Unsupported Media Type)
		HttpMessageNotReadableException			400 (Bad Request)
		HttpMessageNotWritableException			500 (Internal Server Error)
		HttpRequestMethodNotSupportedException	405 (Method Not Allowed)
		MissingServletRequestParameterException	400 (Bad Request)
		NoSuchRequestHandlingMethodException	404 (Not Found)
		TypeMismatchException					400 (Bad Request)
		NotFoundException						404 (Not Found)
		*/
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND) 
	public ErrorMessage handleNotFoundException(NotFoundException ex) {

		return new ErrorMessage(404, ex.getMessage());
	}
}