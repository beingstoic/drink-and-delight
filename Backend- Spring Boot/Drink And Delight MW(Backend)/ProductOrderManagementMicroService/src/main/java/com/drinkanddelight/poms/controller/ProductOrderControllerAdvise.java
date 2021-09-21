package com.drinkanddelight.poms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.drinkanddelight.poms.exception.DistributorException;
import com.drinkanddelight.poms.exception.ProductException;
import com.drinkanddelight.poms.exception.WarehouseException;

@RestControllerAdvice
public class ProductOrderControllerAdvise {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<String> handleProductException(ProductException excep)
	{
		return new  ResponseEntity<String>(excep.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DistributorException.class)
	public ResponseEntity<String> handleProductException(DistributorException excep)
	{
		return new  ResponseEntity<String>(excep.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WarehouseException.class)
	public ResponseEntity<String> handleProductException(WarehouseException excep)
	{
		return new  ResponseEntity<String>(excep.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleOtherException(Exception exp)
	{
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
