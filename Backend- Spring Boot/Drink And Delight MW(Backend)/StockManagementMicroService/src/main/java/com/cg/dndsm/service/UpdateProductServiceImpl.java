package com.cg.dndsm.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dndsm.entity.ProductEntity;
//import com.cg.dndsm.entity.ProductOrderEntity;
import com.cg.dndsm.exception.ProductException;
import com.cg.dndsm.model.ProductModel;
import com.cg.dndsm.model.ProductOrderModel;
//import com.cg.dndsm.repo.ProductOrderRepo;
import com.cg.dndsm.repo.ProductRepo;


@Service
public class UpdateProductServiceImpl implements UpdateProductService {

	@Autowired
	 private ProductOrderManagementProxyService proxy;
	
	@Autowired
	private ProductRepo prepo;
	
	//@Autowired
	//private ProductOrderRepo porepo;
	
	
/*	private ProductOrderModel ofOrder(ProductOrderEntity source) {
		ProductOrderModel result=null;
		if(source!=null) {
			result=new ProductOrderModel();
			result.setOrderId(source.getOrderId());
			result.setProductName(source.getProductName());
			result.setDistributorId(source.getDistributorId());
			result.setQuantityValue(source.getQuantityValue());
			//result.setQuantityUnit(source.getQuantityUnit());
			result.setDateOfOrder(source.getDateOfOrder());
			result.setDateOfDelivery(source.getDateOfDelivery());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setTotalPrice(source.getTotalPrice());
			result.setDeliveryStatus(source.getDeliveryStatus());
			result.setWarehouseId(source.getWarehouseId());
		}
		return result;
	}
	
	
	private ProductOrderEntity ofOrder(ProductOrderModel source) {
		ProductOrderEntity result=null;
		if(source!=null) {
			result=new ProductOrderEntity();
			result.setOrderId(source.getOrderId());
			result.setProductName(source.getProductName());
			result.setDistributorId(source.getDistributorId());
			result.setQuantityValue(source.getQuantityValue());
			//result.setQuantityUnit(source.getQuantityUnit());
			result.setDateOfOrder(source.getDateOfOrder());
			result.setDateOfDelivery(source.getDateOfDelivery());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setTotalPrice(source.getTotalPrice());
			result.setDeliveryStatus(source.getDeliveryStatus());
			result.setWarehouseId(source.getWarehouseId());
		}
		return result;
	}
	*/
	
	
	
	private ProductModel of(ProductEntity source) {
		ProductModel result=null;
		if(source!=null) {
			result=new ProductModel();
			result.setOrderId(source.getOrderId());
			result.setExitDate(source.getExitDate());
			result.setManufacturingDate(source.getManufacturingDate());
			result.setQualityCheck(source.getQualityCheck());
			result.setExpiryDate(source.getExpiryDate());
		}
		return result;
	}
	private ProductEntity of(ProductModel source) {
		ProductEntity result=null;
		if(source!=null) {
			result=new ProductEntity();
			result.setOrderId(source.getOrderId());
			result.setExitDate(source.getExitDate());
			result.setManufacturingDate(source.getManufacturingDate());
			result.setQualityCheck(source.getQualityCheck());
			result.setExpiryDate(source.getExpiryDate());
		}
		return result;
	}
	
	

	@Override
	public String addExitDate(ProductModel model) throws ProductException {
		ProductModel oldDetails=of(prepo.findById(model.getOrderId()).orElse(null));
		if(oldDetails==null) {
			throw new ProductException("There does not exists a product stock with the given ID");
		}
		else {
			if(this.exitDateCheck(oldDetails)) {
				throw new ProductException("There already exists Exit Date for the given orderId");
			}
			else{
				if(model.getExitDate().compareTo(LocalDate.now())<0 && model.getExitDate().compareTo(oldDetails.getManufacturingDate())>0) {
					prepo.updateExitDate(model.getOrderId(), model.getExitDate());
					return "Exit date Updated";
				}
				else
					return "Invalid Exit Date";
				
			}
		}
	}

	
	
	@Override
	public String updateProductDetails(ProductModel model) throws ProductException {
		String st;
		
					if(prepo.existsById(model.getOrderId()) == false) {
						if(this.validateManufacturingDate(model.getManufacturingDate()) && this.validateExpiryDate(model.getManufacturingDate(), model.getExpiryDate())) {
							prepo.save(of(model));
							st= "Details Updated";
						}
						else {
							st="Invalid Dates Entered";
						}
					}
					else {
						if(this.validateManufacturingDate(model.getManufacturingDate()) && this.validateExpiryDate(model.getManufacturingDate(), model.getExpiryDate())) {
							prepo.updatePDetails(model.getOrderId(),model.getManufacturingDate(),model.getExpiryDate(),model.getQualityCheck());
							st= "Details Updated";
						}
						else {
							st= "Invalid Dates Entered";
						}
					}
					
					
		return st;
	}
	
	
	
	
/*	@Override
	public ProductOrderModel findById(long orderId,String token) {
		return proxy.getProductOrder(orderId,token);
		//return ofOrder(porepo.findById(orderId).orElse(null));
	}
	
	*/
	
	
	
	
	@Override
	public boolean exitDateCheck(ProductModel oldDetails) {
		
		if(oldDetails.getExitDate()!=null) {
			return true;
		}
		return false;
	}


	public boolean validateManufacturingDate(LocalDate manufacturingDate) {
		
		if(manufacturingDate.compareTo(LocalDate.now())<0) {
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
