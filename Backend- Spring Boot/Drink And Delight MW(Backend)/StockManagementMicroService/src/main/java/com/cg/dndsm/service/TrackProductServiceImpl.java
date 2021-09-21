package com.cg.dndsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dndsm.entity.ProductEntity;
import com.cg.dndsm.model.ProductModel;
import com.cg.dndsm.model.ProductOrderModel;
//import com.cg.dndsm.repo.ProductOrderRepo;
import com.cg.dndsm.repo.ProductRepo;


@Service
public class TrackProductServiceImpl implements TrackProductService {
	 @Autowired
	 private ProductOrderManagementProxyService proxy;
	    
	
	@Autowired
	private ProductRepo repo;
	
//	@Autowired
//	private ProductOrderRepo porepo;
	
	
//	@Autowired
//	RawMaterialOrderProxyService  rmoProxyService;
	
	
	@Override
	public ProductModel findById(long orderId) {

		ProductModel result=null;
	            
	           // RawMaterialOrderModel typeSource = rmoProxyService.getRawMaterialOrder(orderId);
	           	ProductOrderModel typeSource = proxy.getProductOrder(orderId);
	           	if(typeSource!=null) {
	        	    result=new ProductModel();
	        	    result.setOrderId(typeSource.getOrderId());
	                result.setProductName(typeSource.getProductName());
	                result.setDistributorId(typeSource.getDistributorId());
	                result.setQuantityValue(typeSource.getQuantityValue());
	                //result.setQuantityUnit(typeSource.getQuantityUnit());
	                result.setDateOfOrder(typeSource.getDateOfOrder());
	                result.setDateOfDelivery(typeSource.getDateOfDelivery());
	                result.setPricePerUnit(typeSource.getPricePerUnit());
	                result.setTotalPrice(typeSource.getTotalPrice());
	                result.setDeliveryStatus(typeSource.getDeliveryStatus());
	                result.setWarehouseId(typeSource.getWarehouseId());
	                ProductEntity entity = repo.findById(orderId).orElse(null);
	                if(entity!= null) {
		            //result.setOrderId(entity.getOrderId());
		            result.setManufacturingDate(entity.getManufacturingDate());
		            result.setExpiryDate(entity.getExpiryDate());
		            result.setQualityCheck(entity.getQualityCheck());
		            result.setExitDate(entity.getExitDate());
	                }
	            }
		return result;
	}

}
