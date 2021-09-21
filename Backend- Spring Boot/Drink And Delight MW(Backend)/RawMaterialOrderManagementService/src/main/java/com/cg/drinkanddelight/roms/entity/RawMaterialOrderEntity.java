package com.cg.drinkanddelight.roms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="RawMaterialOrder")
public class RawMaterialOrderEntity {
	
	@Column(name="name", nullable=false)
	private String rawMaterialName;
	
	@Column(name="warehouseId", nullable=false)
	private Long warehouseID;
	
	@Column(name="quantityUnit")
	private String quantityUnit;
	
	@Column(name="quantityValue",nullable=false)
	private double quantityValue;
	
	@Column(name="price",nullable=false)
	private double totalPrice;
	
	@Column(name="price_per_unit",nullable=false)
	private double pricePerUnit = 0;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="order_date")
	private LocalDate dateOfOrder;
    
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="delDate")
	private LocalDate delDate;
	
	@Enumerated(EnumType.STRING)
    @Column(name="status")
    private DeliveryStatus deliveryStatus;

	
	@Id
	@Column(name="orderId")
	private Long orderId;

	@Column(name="supplierId")
	Long supplierId;
	
	
	public Long getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(Long warehouseID) {
		this.warehouseID = warehouseID;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getRawMaterialName() {
		return rawMaterialName;
	}
	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}
	
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public LocalDate getDelDate() {
		return delDate;
	}
	public void setDelDate(LocalDate delDate) {
		this.delDate = delDate;
	}
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	
}