package com.cg.drinkanddelight.roms.controller;

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

import com.cg.drinkanddelight.roms.exceptions.SupplierException;
import com.cg.drinkanddelight.roms.model.SupplierModel;
import com.cg.drinkanddelight.roms.services.SupplierServiceImpl;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	SupplierServiceImpl service;
	
	@PostMapping
	public ResponseEntity<SupplierModel> addSupplier(@RequestBody SupplierModel sModel )throws SupplierException
	{
		
		if(service.isSupplierIDExists(sModel.getSupplierId()))
			throw new SupplierException(" Id Already Exists");
		else 
			service.addSupplier(sModel);
		return new ResponseEntity<>(sModel,HttpStatus.CREATED);
		
	}
	 @GetMapping("/{id}")
	 public ResponseEntity<SupplierModel> getSupplierDetail(@PathVariable("id") Long supplierId)
	 {
		 ResponseEntity<SupplierModel> result;
	        
		 SupplierModel dModel = service.displaySupplier(supplierId);
	        
	        if(dModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(dModel,HttpStatus.OK);
	        
	        return result;
	 }
	
	 @GetMapping
	 public ResponseEntity<List<SupplierModel>> getSuppliers()
	 {
		 ResponseEntity<List<SupplierModel>> result;
	        
		List<SupplierModel> dModel = service.fetchSupplierDetails();
	        
	        if(dModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(dModel,HttpStatus.OK);
	        
	        return result;
	 }
	

}
