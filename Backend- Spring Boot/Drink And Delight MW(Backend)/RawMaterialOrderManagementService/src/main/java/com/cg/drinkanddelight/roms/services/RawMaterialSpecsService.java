package com.cg.drinkanddelight.roms.services;

import java.util.List;

import com.cg.drinkanddelight.roms.model.RawMaterialSpecsModel;


public interface RawMaterialSpecsService {
	List<RawMaterialSpecsModel> fetchNames();

	boolean materialNameExist(String name);

	boolean rmsIdExist(Long id);
	
}
