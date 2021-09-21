package com.cg.dndsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dndsm.exception.ProductException;
import com.cg.dndsm.model.ProductModel;
import com.cg.dndsm.model.ProductOrderModel;
import com.cg.dndsm.service.ProductOrderManagementProxyService;
import com.cg.dndsm.service.ProductOrderService;
import com.cg.dndsm.service.UpdateProductService;

@RestController
@RequestMapping("/updateProduct")
@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	public UpdateProductService pService;
	
//	@Autowired
//	public ProductOrderService poService;
	
	 @Autowired
	 private ProductOrderManagementProxyService proxy;
	
	@PutMapping("/updateExitDate")
	public ResponseEntity<String> addExitDate(@RequestBody ProductModel model) throws ProductException{
		
		String st;
		
		
		st=pService.addExitDate(model);
		
		return new ResponseEntity<>(st,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{orderId}")
	public ResponseEntity<ProductOrderModel> findById(@PathVariable("orderId") long orderId) {
		ResponseEntity<ProductOrderModel> response = null;

		ProductOrderModel model = proxy.getProductOrder(orderId);

		if (model == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(model, HttpStatus.OK);
		}

		return response;
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateProductDetails(@RequestBody ProductModel model) throws ProductException {
		String st;
		st= pService.updateProductDetails(model);
		return new ResponseEntity<>(st, HttpStatus.OK);
	}
	
}
