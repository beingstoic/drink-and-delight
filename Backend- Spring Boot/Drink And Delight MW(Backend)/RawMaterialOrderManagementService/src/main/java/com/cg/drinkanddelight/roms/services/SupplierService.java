package com.cg.drinkanddelight.roms.services;

import java.util.List;

import com.cg.drinkanddelight.roms.model.SupplierModel;

public interface SupplierService {
	boolean isSupplierIDExists(Long id);
	public SupplierModel displaySupplier(Long supplierId);
	List<Long> getSupplierIds();
	void addSupplier(SupplierModel sModel);

}
