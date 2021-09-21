package com.cg.dndsm.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dndsm.entity.RawMaterialEntity;
//import com.cg.dndsm.entity.RawMaterialOrderEntity;
import com.cg.dndsm.exception.RawMaterialException;
import com.cg.dndsm.model.RawMaterialModel;
import com.cg.dndsm.model.RawMaterialOrderModel;
//import com.cg.dndsm.repo.RawMaterialOrderRepo;
import com.cg.dndsm.repo.RawMaterialRepo;


@Service
public class UpdateRawMaterialServiceImpl implements RawMaterialOrderService, UpdateRawMaterialService {
	
	 @Autowired
	 private RawMaterialOrderProxyService proxy;
	 
	@Autowired
	private RawMaterialRepo rmrepo;
	
	//@Autowired
	//private RawMaterialOrderRepo rmorepo;
	
	
/*	private RawMaterialOrderModel ofOrder(RawMaterialOrderEntity source) {
		RawMaterialOrderModel result=null;
		if(source!=null) {
			result=new RawMaterialOrderModel();
			result.setOrderId(source.getOrderId());
			result.setRawMaterialName(source.getRawMaterialName());
			result.setSupplierId(source.getSupplierId());
			result.setQuantityValue(source.getQuantityValue());
			result.setQuantityUnit(source.getQuantityUnit());
			result.setDateOfOrder(source.getDateOfOrder());
			result.setDelDate(source.getDelDate());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setTotalPrice(source.getTotalPrice());
			result.setDeliveryStatus(source.getDeliveryStatus());
			result.setWarehouseId(source.getWarehouseId());
		}
		return result;
	}
	
	
	private RawMaterialOrderEntity ofOrder(RawMaterialOrderModel source) {
		RawMaterialOrderEntity result=null;
		if(source!=null) {
			result=new RawMaterialOrderEntity();
			result.setOrderId(source.getOrderId());
			result.setRawMaterialName(source.getRawMaterialName());
			result.setSupplierId(source.getSupplierId());
			result.setQuantityValue(source.getQuantityValue());
			result.setQuantityUnit(source.getQuantityUnit());
			result.setDateOfOrder(source.getDateOfOrder());
			result.setDelDate(source.getDelDate());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setTotalPrice(source.getTotalPrice());
			result.setDeliveryStatus(source.getDeliveryStatus());
			result.setWarehouseId(source.getWarehouseId());
		}
		return result;
	}
	
	*/
	
	private RawMaterialModel of(RawMaterialEntity source) {
		RawMaterialModel result=null;
		if(source!=null) {
			result=new RawMaterialModel();
			result.setOrderId(source.getOrderId());
			result.setProcessDate(source.getProcessDate());
			result.setManufacturingDate(source.getManufacturingDate());
			result.setQualityCheck(source.getQualityCheck());
			result.setExpiryDate(source.getExpiryDate());
		}
		return result;
	}
	private RawMaterialEntity of(RawMaterialModel source) {
		RawMaterialEntity result=null;
		if(source!=null) {
			result=new RawMaterialEntity();
			result.setOrderId(source.getOrderId());
			result.setProcessDate(source.getProcessDate());
			result.setManufacturingDate(source.getManufacturingDate());
			result.setQualityCheck(source.getQualityCheck());
			result.setExpiryDate(source.getExpiryDate());
		}
		return result;
	}
	
	

	@Override
	public String addProcessDate(RawMaterialModel model) throws RawMaterialException {
		
		if(model!=null) {
			if(this.processDateCheck(model)) {
				throw new RawMaterialException("There exists a raw material with the given ID");
			}
			else{
				if(model.getProcessDate().compareTo(LocalDate.now())<0) {
					model=of(rmrepo.save(of(model)));	
				}
				else
					return "Invalid Process Date";
				
			}
		}
		return "Process Date Updated";
	}

	
	
	@Override
	public String updateRawMaterialDetails(RawMaterialModel model) throws RawMaterialException {
			RawMaterialModel oldDetails=of(rmrepo.findById(model.getOrderId()).orElse(null));
			if(oldDetails==null) {
				throw new RawMaterialException("There does not exists a raw material in Stock with the given ID");
			}
			else {
					if(this.validateManufacturingDate(model.getManufacturingDate(),oldDetails.getProcessDate()) && this.validateExpiryDate(model.getManufacturingDate(), model.getExpiryDate())) {
						rmrepo.updateRMDetails(model.getOrderId(),model.getManufacturingDate(),model.getExpiryDate(),model.getQualityCheck());
						return "Details Updated";
					}
					else {
						return "Invalid Dates Entered";
					}
			}
		
	}
	
	
	
	
	@Override
	public RawMaterialOrderModel findById(long orderId) {
		return proxy.getRawMaterialOrder(orderId);
	//	return ofOrder(rmorepo.findById(orderId).orElse(null));
	}
	
	
	
	
	
	
	@Override
	public boolean processDateCheck(RawMaterialModel model) {
		
		if(rmrepo.existsById(model.getOrderId())) {
			return true;
		}
		return false;
	}


	public boolean validateManufacturingDate(LocalDate manufacturingDate, LocalDate processDate) {

		if(manufacturingDate.compareTo(processDate)>0 && manufacturingDate.compareTo(LocalDate.now())<0) {
			return true;
		}
		return false;
	}
	
	public boolean validateExpiryDate(LocalDate manufacturingDate, LocalDate expiryDate) {
		if(expiryDate.compareTo(manufacturingDate)>0 && expiryDate.compareTo(LocalDate.now())>0) {
			return true;
		}
		return false;
	}

}
