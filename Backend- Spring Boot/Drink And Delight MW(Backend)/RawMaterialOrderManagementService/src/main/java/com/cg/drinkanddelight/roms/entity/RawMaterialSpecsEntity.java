package com.cg.drinkanddelight.roms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RawMaterialSpecs")
public class RawMaterialSpecsEntity {

	@Id
	@Column(name="rmsId")
	private Long rmsId;
	
	@Column(name="material_name")
	private String materialName;

	@Column(name="ppu")
	private double pricePerUnit;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="description")
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

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
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
