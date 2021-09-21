package com.cg.dndsm.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.dndsm.model.RawMaterialOrderModel;


@FeignClient(name="raw-material-order-service")
public interface RawMaterialOrderProxyService {
    @GetMapping("/rawMaterialOrder/{orderId}")
	public RawMaterialOrderModel getRawMaterialOrder(@PathVariable(name="orderId") long orderId);
}
