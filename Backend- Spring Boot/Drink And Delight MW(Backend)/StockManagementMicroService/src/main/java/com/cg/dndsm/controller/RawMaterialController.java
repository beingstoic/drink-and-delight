package com.cg.dndsm.controller;

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

import com.cg.dndsm.exception.RawMaterialException;
import com.cg.dndsm.model.RawMaterialModel;
import com.cg.dndsm.model.RawMaterialOrderModel;
import com.cg.dndsm.service.RawMaterialOrderProxyService;
import com.cg.dndsm.service.RawMaterialOrderService;
import com.cg.dndsm.service.UpdateRawMaterialService;

@RestController
@RequestMapping("/updateRawMaterial")
@CrossOrigin(origins="*")
public class RawMaterialController {
	
	@Autowired
	public UpdateRawMaterialService rmService;
	
//	@Autowired
//	public RawMaterialOrderService rmoService;

	 @Autowired
	 private RawMaterialOrderProxyService proxy;
	 
	@PostMapping
	public ResponseEntity<String> addProcessDate(@RequestBody RawMaterialModel model) throws RawMaterialException{
		
		String st;
		
		
		st=rmService.addProcessDate(model);
		
		
		return new ResponseEntity<>(st,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{orderId}")
	public ResponseEntity<RawMaterialOrderModel> findById(@PathVariable("orderId") long orderId) {
		ResponseEntity<RawMaterialOrderModel> response = null;

		RawMaterialOrderModel model= proxy.getRawMaterialOrder(orderId);

		if (model == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(model, HttpStatus.OK);
		}

		return response;
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateRawMaterialDetails(@RequestBody RawMaterialModel model) throws RawMaterialException {
		String st;
		st= rmService.updateRawMaterialDetails(model);
		return new ResponseEntity<>(st, HttpStatus.OK);
	}
	
}
