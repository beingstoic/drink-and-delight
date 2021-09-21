package com.cg.dndsm.service;

import com.cg.dndsm.exception.ProductException;
import com.cg.dndsm.model.ProductModel;

public interface UpdateProductService {

	
	public String addExitDate(ProductModel model) throws ProductException;
	public String updateProductDetails(ProductModel model) throws ProductException;
	
	public boolean exitDateCheck(ProductModel oldDetails);
	
	
	
}
