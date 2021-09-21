package com.cg.drinkanddelight.roms.model;

import java.time.LocalDate;

import com.cg.drinkanddelight.roms.entity.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RawMaterialOrderModel {

	private Long orderId;
	private String rawMaterialName;
	private Long supplierId;
	private String quantityUnit;
	private double quantityValue;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate dateOfOrder;
	LocalDate delDate;
	private double pricePerUnit;
	private double totalPrice;
	private Long warehouseId;
	
    private DeliveryStatus deliveryStatus;
	
	
	public String getRawMaterialName() {
		return rawMaterialName;
	}
	public void setRawMaterialName(String RawMaterialName) {
		rawMaterialName = RawMaterialName;
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
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

}