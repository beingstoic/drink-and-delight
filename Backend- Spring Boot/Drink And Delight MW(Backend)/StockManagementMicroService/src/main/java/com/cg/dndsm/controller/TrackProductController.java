package com.cg.dndsm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dndsm.model.ProductModel;
import com.cg.dndsm.service.TrackProductService;



@RestController
@RequestMapping("/trackproduct")
@CrossOrigin(origins="*")
public class TrackProductController {
	
	@Autowired
	public TrackProductService tpService;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<ProductModel> findById( @PathVariable("orderId") long orderId) {
		ResponseEntity<ProductModel> response = null;
		ProductModel model = tpService.findById(orderId);

		if (model == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(model, HttpStatus.OK);
		}

		return response;
	}
	
}
