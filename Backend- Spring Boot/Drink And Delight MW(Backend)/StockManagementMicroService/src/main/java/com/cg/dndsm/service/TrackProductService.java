package com.cg.dndsm.service;

import com.cg.dndsm.model.ProductModel;

public interface TrackProductService {
	public ProductModel findById(long orderId);
}
