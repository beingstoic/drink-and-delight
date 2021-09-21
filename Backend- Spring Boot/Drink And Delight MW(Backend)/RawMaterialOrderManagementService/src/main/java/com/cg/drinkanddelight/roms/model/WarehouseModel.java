package com.cg.drinkanddelight.roms.model;

public class WarehouseModel {

	private Long warehouseId;
	private String warehouseName;
	private String warehouseLocation;
	private String personIncharge;
	private String contactNumber;
	
	
	
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long wid) {
		this.warehouseId = wid;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	public String getPersonIncharge() {
		return personIncharge;
	}
	public void setPersonIncharge(String personIncharge) {
		this.personIncharge = personIncharge;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
}
