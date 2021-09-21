package com.cg.drinkanddelight.roms.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkanddelight.roms.dao.RawMaterialDao;
import com.cg.drinkanddelight.roms.entity.DeliveryStatus;
import com.cg.drinkanddelight.roms.entity.RawMaterialOrderEntity;
import com.cg.drinkanddelight.roms.exceptions.RawMaterialException;
import com.cg.drinkanddelight.roms.model.RawMaterialOrderModel;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{
	@Autowired
	RawMaterialDao repo;
	
	private RawMaterialOrderEntity of(RawMaterialOrderModel source) {
		RawMaterialOrderEntity raw = null;
		if(source!=null) {
			raw =new RawMaterialOrderEntity();
			raw.setOrderId(source.getOrderId());
			raw.setWarehouseID(source.getWarehouseId());
			raw.setDelDate(source.getDelDate());
			raw.setRawMaterialName(source.getRawMaterialName());
			raw.setTotalPrice(source.getTotalPrice());
			raw.setQuantityValue(source.getQuantityValue());
			raw.setQuantityUnit(source.getQuantityUnit());
			raw.setDeliveryStatus(source.getDeliveryStatus());
			raw.setDateOfOrder(source.getDateOfOrder());
			raw.setPricePerUnit(source.getPricePerUnit());
			raw.setSupplierId(source.getSupplierId());
		}
		return raw;
	}
	
	private RawMaterialOrderModel of(RawMaterialOrderEntity source) {
		RawMaterialOrderModel raw = null;
		if(source!=null) {
			raw =new RawMaterialOrderModel();
			raw.setOrderId(source.getOrderId());
			raw.setWarehouseId(source.getWarehouseID());
			raw.setDelDate(source.getDelDate());
			raw.setRawMaterialName(source.getRawMaterialName());
			raw.setTotalPrice(source.getTotalPrice());
			raw.setQuantityValue(source.getQuantityValue());
			raw.setQuantityUnit(source.getQuantityUnit());
			raw.setDeliveryStatus(source.getDeliveryStatus());
			raw.setDateOfOrder(source.getDateOfOrder());
			raw.setPricePerUnit(source.getPricePerUnit());
			raw.setSupplierId(source.getSupplierId());
		}
		return raw;
	}
	@Override
	public RawMaterialOrderModel placeRawMaterialOrder(RawMaterialOrderModel raw) {
		return of(repo.save(of(raw)));
	}

	@Override
	public boolean isOrderIDExists(Long orderId) {
		return repo.existsByOrderId(orderId);
	}

	@Override
	public boolean isSupplierIDExists(Long supplierId) {
		return repo.existsBySupplierId(supplierId);
	}

	@Override
	public RawMaterialOrderModel trackRawMaterialOrder(Long orderId) {
		return of(repo.findByOrderId(orderId));
	}

	@Override
	public String updateRawMaterialOrder(Long  id, DeliveryStatus status) throws RawMaterialException {
		RawMaterialOrderEntity entity =(repo.findByOrderId(id)); 
		if(entity!=null) {
				entity.setDeliveryStatus(status);
				repo.save(entity);
				return ("Order Updated Successfully");
				
		}
		return ("No Entity Exists");
	}

	@Override
	public List<RawMaterialOrderModel> displayRawMaterialOrder(Long  supplierId, DeliveryStatus delStatus, LocalDate startDate, LocalDate  endDate) {
		List<RawMaterialOrderModel> modelList=null;
		List<RawMaterialOrderEntity> entityList=repo.findAllByInput(supplierId, delStatus, startDate,  endDate);
		if(entityList!=null)
		{
			modelList=entityList.stream().map(p -> of(p)).collect(Collectors.toList());
			
		}
		return modelList; 
	}

	public List<RawMaterialOrderModel> displayRawMaterialOrder(Long supplierId, DeliveryStatus delStatus) {
		List<RawMaterialOrderModel> modelList=null;
		List<RawMaterialOrderEntity> entityList=repo.findAllByIn(supplierId, delStatus);
		if(entityList!=null)
		{
			modelList=entityList.stream().map(p -> of(p)).collect(Collectors.toList());
			
		}
		return modelList; 
	}
	
	public long getLastOrderId()
	{   
		Long lastId=repo.getLastOrderId();
		if(lastId==null)
			return 0;
		return lastId; 
	}
}
