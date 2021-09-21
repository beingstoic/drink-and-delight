package com.cg.drinkanddelight.roms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Supplier_Details")
public class SupplierEntity {

	@Id
	@Column(name="Supplier_Id")
	private Long supplierId;
	
	@Column(name="SupplierName")
	private String supplierName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
