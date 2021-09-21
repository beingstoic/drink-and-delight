package com.cg.dndsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dndsm.entity.RawMaterialEntity;
import com.cg.dndsm.model.RawMaterialModel;
import com.cg.dndsm.model.RawMaterialOrderModel;
//import com.cg.dndsm.repo.RawMaterialOrderRepo;
import com.cg.dndsm.repo.RawMaterialRepo;


@Service
public class TrackRawMaterialServiceImpl implements TrackRawMaterialService {
	
	@Autowired
	private RawMaterialRepo repo;
	
//	@Autowired
//	private RawMaterialOrderRepo rmorepo;
	
	 @Autowired
	 private RawMaterialOrderProxyService proxy;
	
	@Override
	public RawMaterialModel findById(long orderId) {

		RawMaterialModel result=null;
	
	           	RawMaterialOrderModel typeSource = proxy.getRawMaterialOrder(orderId);
	           	if(typeSource!=null) {
	        	    result=new RawMaterialModel();
	        	    result.setOrderId(typeSource.getOrderId());
	                result.setRawMaterialName(typeSource.getRawMaterialName());
	                result.setSupplierId(typeSource.getSupplierId());
	                result.setQuantityValue(typeSource.getQuantityValue());
	                result.setQuantityUnit(typeSource.getQuantityUnit());
	                result.setDateOfOrder(typeSource.getDateOfOrder());
	                result.setDelDate(typeSource.getDelDate());
	                result.setPricePerUnit(typeSource.getPricePerUnit());
	                result.setTotalPrice(typeSource.getTotalPrice());
	                result.setDeliveryStatus(typeSource.getDeliveryStatus());
	                result.setWarehouseId(typeSource.getWarehouseId());
	                RawMaterialEntity entity = repo.findById(orderId).orElse(null);
	                if(entity!= null) {
		            result.setManufacturingDate(entity.getManufacturingDate());
		            result.setExpiryDate(entity.getExpiryDate());
		            result.setQualityCheck(entity.getQualityCheck());
		            result.setProcessDate(entity.getProcessDate());
	                }
	            }
		return result;
	}

}
