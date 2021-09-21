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

import com.cg.drinkanddelight.roms.exceptions.RawMaterialException;
import com.cg.drinkanddelight.roms.model.RawMaterialSpecsModel;
import com.cg.drinkanddelight.roms.services.RawMaterialSpecsServiceImpl;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/materials")
public class RawMaterialSpecController {

	
	@Autowired
	private RawMaterialSpecsServiceImpl service;
	
	 @GetMapping
	 public ResponseEntity<List<RawMaterialSpecsModel>> getRawMaterials()
	 {
		 ResponseEntity<List<RawMaterialSpecsModel>> result;
	        
		List<RawMaterialSpecsModel> rawMaterials = service.fetchNames();
	        
	        if(rawMaterials==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(rawMaterials,HttpStatus.OK);
	        
	        return result;
	 }
	 
	 @PostMapping
		public ResponseEntity<RawMaterialSpecsModel> addRawMaterial(@RequestBody RawMaterialSpecsModel RawMaterialModel )throws RawMaterialException
		{
			
			if(service.rmsIdExist(RawMaterialModel.getRmsId()) || service.materialNameExist(RawMaterialModel.getMaterialName()))
				throw new RawMaterialException("RawMaterial or Id Already Exists");
			else 
				RawMaterialModel= service.addRawMaterial(RawMaterialModel);
			return new ResponseEntity<>(RawMaterialModel,HttpStatus.CREATED);
			
		}
}
