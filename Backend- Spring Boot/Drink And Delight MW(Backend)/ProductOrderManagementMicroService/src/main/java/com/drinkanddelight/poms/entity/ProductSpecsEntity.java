package com.drinkanddelight.poms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_specs")
public class ProductSpecsEntity {

	@Id
	private long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="ppu")
	private double pricePerUnit;
	
	@Column(name="product_duration")
	private int productDuration;
	
	@Column(name="product_desc")
	private String productDescription;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int getProductDuration() {
		return productDuration;
	}

	public void setProductDuration(int productDuration) {
		this.productDuration = productDuration;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
}
