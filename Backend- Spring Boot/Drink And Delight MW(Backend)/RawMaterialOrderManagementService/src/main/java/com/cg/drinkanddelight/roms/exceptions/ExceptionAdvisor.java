package com.cg.drinkanddelight.roms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdvisor {
	@ExceptionHandler(RawMaterialException.class)
	public ResponseEntity<String> handleProductException(RawMaterialException excep)
	{
		return new  ResponseEntity<String>(excep.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SupplierException.class)
	public ResponseEntity<String> handleProductException(SupplierException excep)
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

