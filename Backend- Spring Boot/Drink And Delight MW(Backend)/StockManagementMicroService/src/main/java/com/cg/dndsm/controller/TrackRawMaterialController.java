package com.cg.dndsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dndsm.model.RawMaterialModel;
import com.cg.dndsm.service.TrackRawMaterialService;


@RestController
@RequestMapping("/trackrawmaterial")
@CrossOrigin(origins="*")
public class TrackRawMaterialController {
	
	@Autowired
	public TrackRawMaterialService trmService;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<RawMaterialModel> findById(@PathVariable("orderId") long orderId) {
		ResponseEntity<RawMaterialModel> response = null;

		RawMaterialModel model = trmService.findById(orderId);

		if (model == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(model, HttpStatus.OK);
		}

		return response;
	}
	
}
