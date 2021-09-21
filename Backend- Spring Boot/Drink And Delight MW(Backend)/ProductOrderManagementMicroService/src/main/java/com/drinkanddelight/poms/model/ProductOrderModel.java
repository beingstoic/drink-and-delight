package com.drinkanddelight.poms.model;

import java.time.LocalDate;

import com.drinkanddelight.poms.entity.DeliveryStatus;

public class ProductOrderModel {

	 private long orderId;
		private String productName;
		private long distributorId;
		private double quantityValue;
		LocalDate dateOfOrder;
		LocalDate dateOfDelivery;
		private double pricePerUnit;
		private double totalPrice;
	    private long warehouseId;
	    private DeliveryStatus deliveryStatus;
	    
	    
		public long getOrderId() {
			return orderId;
		}
		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public long getDistributorId() {
			return distributorId;
		}
		public void setDistributorId(long distributorId) {
			this.distributorId = distributorId;
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
		public LocalDate getDateOfDelivery() {
			return dateOfDelivery;
		}
		public void setDateOfDelivery(LocalDate dateOfDelivery) {
			this.dateOfDelivery = dateOfDelivery;
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
		public long getWarehouseId() {
			return warehouseId;
		}
		public void setWarehouseId(long warehouseId) {
			this.warehouseId = warehouseId;
		}
		public DeliveryStatus getDeliveryStatus() {
			return deliveryStatus;
		}
		public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
			this.deliveryStatus = deliveryStatus;
		}
	
}
