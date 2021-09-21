package com.drinkanddelight.poms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drinkanddelight.poms.exception.WarehouseException;
import com.drinkanddelight.poms.model.WarehouseModel;
import com.drinkanddelight.poms.service.ProductServiceImpl;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/warehouse")
public class WarehouseController {

	

	@Autowired
	private ProductServiceImpl prodService;
	
	@PostMapping
	public ResponseEntity<WarehouseModel> addWarehouse(@RequestBody WarehouseModel wModel )throws WarehouseException
	{
		
		if(prodService.warehouseIdExist(wModel.getWarehouseId()))
			throw new WarehouseException(" Id Already Exists");
		else 
			wModel= prodService.addWarehouse(wModel);
		return new ResponseEntity<>(wModel,HttpStatus.CREATED);
		
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<WarehouseModel> getWarehouseDetail(@PathVariable("id") long warehouseId)
	 {
		 ResponseEntity<WarehouseModel> result;
	        
		 WarehouseModel wModel = prodService.fetchWarehouseDetails(warehouseId);
	        
	        if(wModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(wModel,HttpStatus.OK);
	        
	        return result;
	 }

	
	@GetMapping
	 public ResponseEntity<List<WarehouseModel>> getWarehouses()
	 {
		 ResponseEntity<List<WarehouseModel>> result;
	        
		List<WarehouseModel> wModel = prodService.fetchWarehouseDetails();
	        
	        if(wModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(wModel,HttpStatus.OK);
	        
	        return result;
	 }
}
