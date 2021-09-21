package com.cg.drinkanddelight.roms.services;

import java.util.List;

import com.cg.drinkanddelight.roms.model.WarehouseModel;


public interface WarehouseService {
	boolean isWarehouseIDExists(Long id);
	List<WarehouseModel> getWarehouseIds();
	void addWarehouse(WarehouseModel wModel);
}
