package com.cg.dndsm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.dndsm.model.ProductOrderModel;

import feign.Headers;

@FeignClient(name="product-order-service")
public interface ProductOrderManagementProxyService {
	//@Headers("Authorization: {token}")
	//@RequestMapping(method=RequestMethod.GET,value="/product/{id}")
	//@RequestLine("GET/product/{id}")
	@GetMapping("/product/{id}")
	public ProductOrderModel getProductOrder(@PathVariable(name="id") long id);
}
