package com.cg.dndsm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.dndsm.exception.ProductException;
import com.cg.dndsm.exception.RawMaterialException;

@RestControllerAdvice
public class ExceptionAdvice {
	
	
	@ExceptionHandler(RawMaterialException.class)
	public ResponseEntity<String> userExceptionHandler(RawMaterialException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<String> userExceptionHandler(ProductException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> otherExceptionHandler(Exception ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
