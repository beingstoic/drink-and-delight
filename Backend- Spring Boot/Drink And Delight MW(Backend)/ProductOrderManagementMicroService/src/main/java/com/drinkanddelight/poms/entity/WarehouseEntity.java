package com.drinkanddelight.poms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouse_details")
public class WarehouseEntity {

	@Id
	@Column(name="warehouse_id")
	private long warehouseId;
	
	@Column(name="wname")
	private String warehouseName;
	
	@Column(name="location")
	private String warehouseLocation;
	
	@Column(name="person_incharge")
	private String personIncharge;
	
	@Column(name="contact")
	private String contactNumber;

	public long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
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
