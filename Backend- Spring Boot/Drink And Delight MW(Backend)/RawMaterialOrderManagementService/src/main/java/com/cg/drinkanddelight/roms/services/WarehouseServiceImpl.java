package com.cg.drinkanddelight.roms.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkanddelight.roms.dao.WarehouseDAO;
import com.cg.drinkanddelight.roms.entity.WarehouseEntity;
import com.cg.drinkanddelight.roms.model.WarehouseModel;


@Service
public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	WarehouseDAO repo;
	
	@Override
	public boolean isWarehouseIDExists(Long id) {
		return repo.existsByWarehouseId(id);
	}
	
	private WarehouseModel of(WarehouseEntity source)
	{
		WarehouseModel result=null;
		if(source!=null)
		{
			result=new WarehouseModel();
			result.setWarehouseId(source.getWarehouseId());
			result.setWarehouseName(source.getWarehouseName());
			result.setWarehouseLocation(source.getWarehouseLocation());
			result.setPersonIncharge(source.getPersonIncharge());
			result.setContactNumber(source.getContactNumber());
					
		}
		return result; 
	}
	private WarehouseEntity of(WarehouseModel source)
	{
		WarehouseEntity result=null;
		if(source!=null)
		{
			result=new WarehouseEntity();
			result.setWarehouseId(source.getWarehouseId());
			result.setWarehouseName(source.getWarehouseName());
			result.setWarehouseLocation(source.getWarehouseLocation());
			result.setPersonIncharge(source.getPersonIncharge());
			result.setContactNumber(source.getContactNumber());
					
		}
		return result; 
	}
	@Override
	public List<WarehouseModel> getWarehouseIds() {
		return repo.findAll().stream().map(w -> of(w)).collect(Collectors.toList());
	}
	public void add(WarehouseModel wModel) {
		repo.save(of(wModel));
	}

	@Override
	public void addWarehouse(WarehouseModel wModel) {
		repo.save(of(wModel));
		
	}
}
