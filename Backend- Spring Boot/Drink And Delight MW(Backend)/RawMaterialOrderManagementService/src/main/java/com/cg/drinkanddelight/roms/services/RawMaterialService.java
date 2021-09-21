package com.cg.drinkanddelight.roms.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.drinkanddelight.roms.entity.DeliveryStatus;
import com.cg.drinkanddelight.roms.exceptions.RawMaterialException;
import com.cg.drinkanddelight.roms.model.RawMaterialOrderModel;


public interface RawMaterialService {
	boolean isOrderIDExists(Long orderId);
	boolean isSupplierIDExists(Long id);
	RawMaterialOrderModel trackRawMaterialOrder(Long id);
	String updateRawMaterialOrder(Long id, DeliveryStatus status) throws RawMaterialException;
	RawMaterialOrderModel placeRawMaterialOrder(RawMaterialOrderModel raw);
	List<RawMaterialOrderModel> displayRawMaterialOrder(Long supplierId, DeliveryStatus delStatus,
			LocalDate startDate, LocalDate endDate);
}
