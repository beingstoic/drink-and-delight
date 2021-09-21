package com.drinkanddelight.poms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distributor_detils")
public class DistributorEntity {

	@Id
	@Column(name="distributor_id")
	private long distributorId;
	
	@Column(name="distributor_name")
	private String distributorName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="phone")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;

	public long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(long distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
