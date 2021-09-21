package com.drinkanddelight.poms.model;

public class ProductSpecsModel {

	/*
	*
	* model class for passing data between controller and client 
	*/
	private long productId;
	private String productName;
	private double pricePerUnit;
	//duration is in months
	private int productDuration;
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
