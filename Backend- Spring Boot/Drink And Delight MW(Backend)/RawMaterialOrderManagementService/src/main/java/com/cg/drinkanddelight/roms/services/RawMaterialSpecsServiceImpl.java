package com.cg.drinkanddelight.roms.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkanddelight.roms.dao.RawMaterialSpecsDao;
import com.cg.drinkanddelight.roms.entity.RawMaterialSpecsEntity;
import com.cg.drinkanddelight.roms.model.RawMaterialSpecsModel;
@Service
public class RawMaterialSpecsServiceImpl implements RawMaterialSpecsService{
	
	@Autowired
	RawMaterialSpecsDao repo;
	
	private RawMaterialSpecsEntity of(RawMaterialSpecsModel source)
	{
		RawMaterialSpecsEntity result=null;
		if(source!=null)
		{
			result=new RawMaterialSpecsEntity();
			result.setRmsId(source.getRmsId());
			result.setMaterialName(source.getMaterialName());
			result.setDuration(source.getDuration());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setDescription(source.getDescription());
		}
		return result;
	}
	
	private RawMaterialSpecsModel of(RawMaterialSpecsEntity source)
	{
		RawMaterialSpecsModel result=null;
		if(source!=null)
		{
			result=new RawMaterialSpecsModel();
			result.setRmsId(source.getRmsId());
			result.setMaterialName(source.getMaterialName());
			result.setDuration(source.getDuration());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setDescription(source.getDescription());
		}
		return result;
	}

	@Override
	public List<RawMaterialSpecsModel> fetchNames() {
		return repo.findAll().stream().map(r -> of(r)).collect(Collectors.toList());
	}

	
	@Override
	public boolean rmsIdExist(Long id)
	{
	    return repo.existsByRmsId(id);
	}
	@Override
	public boolean materialNameExist(String string)
	{
		  return repo.existsByMaterialName(string);
	}

	public RawMaterialSpecsModel addRawMaterial(RawMaterialSpecsModel rawMaterialModel) {
		return of(repo.save(of(rawMaterialModel)));
	}
	
	
}
