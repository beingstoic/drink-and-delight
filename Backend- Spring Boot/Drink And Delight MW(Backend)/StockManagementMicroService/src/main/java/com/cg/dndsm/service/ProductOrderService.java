package com.cg.dndsm.service;

import com.cg.dndsm.model.ProductOrderModel;

public interface ProductOrderService {
	
	public ProductOrderModel findById(long orderId);

}
