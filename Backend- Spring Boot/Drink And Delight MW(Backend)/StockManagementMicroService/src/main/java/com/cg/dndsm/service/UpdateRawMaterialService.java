package com.cg.dndsm.service;

import com.cg.dndsm.exception.RawMaterialException;
import com.cg.dndsm.model.RawMaterialModel;

public interface UpdateRawMaterialService {

	
	

	
	//public RawMaterialModel addProcessDate(RawMaterialModel model) throws RawMaterialException;
	
	public String addProcessDate(RawMaterialModel model) throws RawMaterialException;
	
	//public RawMaterialModel updateRawMaterialDetails(RawMaterialModel model) throws RawMaterialException;
	
	public String updateRawMaterialDetails(RawMaterialModel model) throws RawMaterialException;
	
	public boolean processDateCheck(RawMaterialModel model);
	
}
