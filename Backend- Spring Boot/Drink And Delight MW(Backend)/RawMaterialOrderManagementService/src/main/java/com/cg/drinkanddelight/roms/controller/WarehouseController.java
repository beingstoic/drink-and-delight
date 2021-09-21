package com.cg.drinkanddelight.roms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drinkanddelight.roms.exceptions.WarehouseException;
import com.cg.drinkanddelight.roms.model.WarehouseModel;
import com.cg.drinkanddelight.roms.services.WarehouseServiceImpl;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/warehouse")
public class WarehouseController {

	

	@Autowired
	private WarehouseServiceImpl service;
	
	@PostMapping
	public ResponseEntity<WarehouseModel> addWarehouse(@RequestBody WarehouseModel wModel )throws WarehouseException
	{
		
		if(service.isWarehouseIDExists(wModel.getWarehouseId()))
			throw new WarehouseException(" Id Already Exists");
		else 
			service.addWarehouse(wModel);
		return new ResponseEntity<>(wModel,HttpStatus.CREATED);
		
	}
	
	 

	 	
	@GetMapping("")
	 public ResponseEntity<List<WarehouseModel>> getWarehouses()
	 {
		 ResponseEntity<List<WarehouseModel>> result;
	        
		List<WarehouseModel> wModel = service.getWarehouseIds();
	        
	        if(wModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(wModel,HttpStatus.OK);
	        
	        return result;
	 }
}

