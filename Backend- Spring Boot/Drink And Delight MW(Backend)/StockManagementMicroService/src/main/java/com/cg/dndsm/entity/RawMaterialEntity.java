package com.cg.dndsm.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RawMaterialEntity {
	
	
	@Id
	private Long orderId;
	
	
	
	private LocalDate manufacturingDate;
	
	private LocalDate expiryDate;
	
	private String qualityCheck;
	
	private LocalDate processDate;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public LocalDate getProcessDate() {
		return processDate;
	}

	public void setProcessDate(LocalDate processDate) {
		this.processDate = processDate;
	}

	
}
