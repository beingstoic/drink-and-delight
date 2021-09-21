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

import com.drinkanddelight.poms.exception.ProductException;
import com.drinkanddelight.poms.model.ProductSpecsModel;
import com.drinkanddelight.poms.service.ProductServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/products")
public class ProductSpecController {

	
	@Autowired
	private ProductServiceImpl prodService;
	
	@PostMapping
	public ResponseEntity<ProductSpecsModel> addProduct(@RequestBody ProductSpecsModel productModel )throws ProductException
	{
		
		if(prodService.productIdExist(productModel.getProductId()) || prodService.productNameExist(productModel.getProductName()))
			throw new ProductException("Product or Id Already Exists");
		else 
			productModel= prodService.addProduct(productModel);
		return new ResponseEntity<>(productModel,HttpStatus.CREATED);
		
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<ProductSpecsModel> getProductDetail(@PathVariable("id") long productId)
	 {
		 ResponseEntity<ProductSpecsModel> result;
	        
		 ProductSpecsModel productModel = prodService.fetchProductDetails(productId);
	        
	        if(productModel==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(productModel,HttpStatus.OK);
	        
	        return result;
	 }

	
	 @GetMapping
	 public ResponseEntity<List<ProductSpecsModel>> getProducts()
	 {
		 ResponseEntity<List<ProductSpecsModel>> result;
	        
		List<ProductSpecsModel> products = prodService.fetchProductNames();
	        
	        if(products==null)
	            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else
	            result = new ResponseEntity<>(products,HttpStatus.OK);
	        
	        return result;
	 }
}
