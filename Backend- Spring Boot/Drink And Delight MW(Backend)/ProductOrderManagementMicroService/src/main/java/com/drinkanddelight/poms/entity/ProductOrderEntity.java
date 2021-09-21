package com.drinkanddelight.poms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class ProductOrderEntity {
	  
	    @Id
	    @Column(name="order_id",nullable = false)
	    private long productOrderId;
        
	    @Column(name="",nullable = false)
		private String productName;
        
        @Column(name="distibutor_Id",nullable = false)
		private long distributorId;
        
        @Column(name="quantity",nullable = false)
		private double quantityValue;
        
        @DateTimeFormat(iso=ISO.DATE)
    	@Column(name="order_date",nullable = false)
		private LocalDate dateOfOrder;
        
        @DateTimeFormat(iso=ISO.DATE)
    	@Column(name="delivery_date",nullable = false)
        private LocalDate dateOfDelivery;
        
        @Column(name="ppu",nullable = false)
		private double pricePerUnit;
        
        @Column(name="total_price",nullable = false)
		private double totalPrice;
        
        @Column(name="warehouse_Id",nullable = false)
	    private long warehouseId;
        
        @Enumerated(EnumType.STRING)
        @Column(name="status")
	    private DeliveryStatus deliveryStatus;

        

		public long getProductOrderId() {
			return productOrderId;
		}

		public void setProductOrderId(long productOrderId) {
			this.productOrderId = productOrderId;
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
