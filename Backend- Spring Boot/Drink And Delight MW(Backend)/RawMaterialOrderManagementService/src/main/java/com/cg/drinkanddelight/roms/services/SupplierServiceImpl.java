package com.cg.drinkanddelight.roms.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkanddelight.roms.dao.SupplierDao;
import com.cg.drinkanddelight.roms.entity.SupplierEntity;
import com.cg.drinkanddelight.roms.model.SupplierModel;


@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierDao repo;
	
	private SupplierModel of(SupplierEntity source)
	{
		SupplierModel result=null;
		if(source!=null)
		{ result= new SupplierModel();
		  result.setSupplierId(source.getSupplierId());
		  result.setSupplierName(source.getSupplierName());
		  result.setLocation(source.getAddress());
		  result.setPhoneNumber(source.getPhoneNumber());
		  result.setEmail(source.getEmail());
			
		}
		return result;
	}
	
	private SupplierEntity of(SupplierModel source)
	{
		SupplierEntity result=null;
		if(source!=null)
		{ result= new SupplierEntity();
		  result.setSupplierId(source.getSupplierId());
		  result.setSupplierName(source.getSupplierName());
		  result.setAddress(source.getLocation());
		  result.setPhoneNumber(source.getPhoneNumber());
		  result.setEmail(source.getEmail());
			
		}
		return result;
	}
	
	
	@Override
	public boolean isSupplierIDExists(Long id) {
		return repo.existsBySupplierId(id);
	}

	@Override
	public SupplierModel displaySupplier(Long supplierId) {
		return of(repo.findBySupplierId(supplierId));
	}

	@Override
	public List<Long> getSupplierIds() {
		return repo.getSupplierIds();
	}

	@Override
	public void addSupplier(SupplierModel sModel) {
		repo.save(of(sModel));	
	}

	public List<SupplierModel> fetchSupplierDetails() {
			 return repo.findAll().stream().map(p -> of(p)).collect(Collectors.toList());
	}
	
}
