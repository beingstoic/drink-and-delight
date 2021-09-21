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

import com.drinkanddelight.poms.exception.DistributorException;
import com.drinkanddelight.poms.model.DistributorModel;
import com.drinkanddelight.poms.service.ProductServiceImpl;

@RestController
@CrossOrigin()
@RequestMapping("/distributor")
public class DistributorController {

	
	@Autowired
	private ProductServiceImpl prodService;
	
	@PostMapping
	public ResponseEntity<DistributorModel> addDistributor(@RequestBody DistributorModel dModel )throws DistributorException
	{
		
		if(prodService.distributorIdExist(dModel.getDistributorId()))
			throw new DistributorException(" Id Already Exists");
		else 
			dModel= prodService.addDistributor(dModel);
		return new ResponseEntity<>(dModel,HttpStatus.CREATED);
		
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<DistributorModel> getDistributorDetail(@PathVariable("id") long distributorId)
	 {
		 ResponseEntity<DistributorModel> result;
	        
		 DistributorModel dModel = prodService.fetchDistributorDetails(distributorId);
	        
	        if(dModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(dModel,HttpStatus.OK);
	        
	        return result;
	 }

	 @GetMapping("/ids")
	 public ResponseEntity<List<Long>> fetchDistributorIds()
	 {
		 ResponseEntity<List<Long>> result;
		 List<Long> idList=prodService.fetchDistributorIds();
		 if(idList==null)
			 result=new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     else
	    	 result=new ResponseEntity<>(idList,HttpStatus.OK);
		 return result;
		 
	 }
	
	@GetMapping
	 public ResponseEntity<List<DistributorModel>> getDistributors()
	 {
		 ResponseEntity<List<DistributorModel>> result;
	        
		List<DistributorModel> dModel = prodService.fetchDistributorDetails();
	        
	        if(dModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(dModel,HttpStatus.OK);
	        
	        return result;
	 }
	
}
