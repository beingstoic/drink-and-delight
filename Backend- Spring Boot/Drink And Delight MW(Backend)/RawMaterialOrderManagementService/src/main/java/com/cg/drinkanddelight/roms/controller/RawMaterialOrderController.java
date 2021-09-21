package com.cg.drinkanddelight.roms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drinkanddelight.roms.entity.DeliveryStatus;
import com.cg.drinkanddelight.roms.exceptions.RawMaterialException;
import com.cg.drinkanddelight.roms.model.RawMaterialOrderModel;
import com.cg.drinkanddelight.roms.model.TrackModel;
import com.cg.drinkanddelight.roms.services.RawMaterialServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rawMaterialOrder")
public class RawMaterialOrderController{
	
	@Autowired 
	RawMaterialServiceImpl service;
	
	@PostMapping()
	public ResponseEntity<RawMaterialOrderModel> placeRawMaterialOrder(@RequestBody RawMaterialOrderModel model) throws RawMaterialException{
		if(service.isOrderIDExists(model.getOrderId()))
			throw new RawMaterialException("Order Id Already Exists");
		model=service.placeRawMaterialOrder(model);
		return new ResponseEntity<>(model, HttpStatus.CREATED);
	}
	
	@GetMapping("/nId")
	public ResponseEntity<Long> getNewOrderId()
	{
		ResponseEntity<Long> result;
		long id=service.getLastOrderId();
		if(id==0)
		  result=new ResponseEntity<>(id+10001,HttpStatus.OK);
		else
			result=new ResponseEntity<>(id+1,HttpStatus.OK);
		return result;
	}
	 
	
	@PostMapping("/display")
	public ResponseEntity<List<RawMaterialOrderModel>> displayRawMaterialOrder(@RequestBody TrackModel track){
		DeliveryStatus delStatus=DeliveryStatus.valueOf(track.getStatus());
		if(track.getStartDate()!=null) {
		List<RawMaterialOrderModel> display = service.displayRawMaterialOrder(track.getSupplierId(), delStatus,track.getStartDate(), track.getEndDate());
		return new ResponseEntity<>(display, HttpStatus.OK);
		}
		List<RawMaterialOrderModel> display = service.displayRawMaterialOrder(track.getSupplierId(), delStatus);
		return new ResponseEntity<>(display,HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody RawMaterialOrderModel model) throws RawMaterialException{
		if(!service.isOrderIDExists(model.getOrderId())) {
			throw new RawMaterialException("No order of this order ID found");
		}
		return new ResponseEntity<>(service.updateRawMaterialOrder(model.getOrderId(), model.getDeliveryStatus()),HttpStatus.OK);
		
	}
	
	 @GetMapping
	 public ResponseEntity<List<RawMaterialOrderModel>> trackProductOrder()
	 {
		 return null;
	 }
	 @GetMapping("/{id}")
		public ResponseEntity<RawMaterialOrderModel> trackRawMaterialOrder(@PathVariable("id") Long id) throws RawMaterialException{
		 ResponseEntity<RawMaterialOrderModel> result;
		 if(service.isOrderIDExists(id))
			 result =  new ResponseEntity<>( service.trackRawMaterialOrder(id),HttpStatus.OK);
		 else throw new RawMaterialException("Order Id does not exists");
		 return result;
	 }
	
	 
	
}
