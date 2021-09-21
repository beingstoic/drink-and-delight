package com.cg.drinkanddelight.roms.model;


public class RawMaterialSpecsModel {
	
	private Long rmsId;
	
	private String materialName;
	
	private double pricePerUnit;
	
	private String duration;
	
	private String description;

	

	public Long getRmsId() {
		return rmsId;
	}

	public void setRmsId(Long rmsId) {
		this.rmsId = rmsId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String MaterialName) {
		this.materialName = MaterialName;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
