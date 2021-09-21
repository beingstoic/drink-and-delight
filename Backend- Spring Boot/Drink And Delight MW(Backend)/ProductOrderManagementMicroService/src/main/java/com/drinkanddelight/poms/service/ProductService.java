package com.drinkanddelight.poms.service;

import java.time.LocalDate;
import java.util.List;

import com.drinkanddelight.poms.entity.DeliveryStatus;
import com.drinkanddelight.poms.model.DistributorModel;
import com.drinkanddelight.poms.model.ProductOrderModel;
import com.drinkanddelight.poms.model.ProductSpecsModel;
import com.drinkanddelight.poms.model.WarehouseModel;

public interface ProductService {

	
	ProductOrderModel placeProductOrder(ProductOrderModel productModel);
	ProductOrderModel getProductOrderDetails(long orderId);
	String updateProductOrder(long orderId,DeliveryStatus status);
	DistributorModel fetchDistributorDetails(long distributorId);
	List<ProductOrderModel> trackProductOrder(long id,DeliveryStatus status,LocalDate startDate,LocalDate endDate); 
	List<ProductOrderModel> trackProductOrder(long id,DeliveryStatus status);
	boolean doesProductOrderIdExists(long id);
	List<Long> fetchDistributorIds();
	List<Long> fetchWarehouseIds();
	List<ProductSpecsModel> fetchProductNames();
	
	
	//self implemented not mandatory
	ProductSpecsModel addProduct(ProductSpecsModel pModel);
	boolean productIdExist(long id);
    boolean productNameExist(String productName);
    ProductSpecsModel fetchProductDetails(long id);
    WarehouseModel addWarehouse(WarehouseModel wModel);
    WarehouseModel fetchWarehouseDetails(long id);
    List<WarehouseModel> fetchWarehouseDetails();
    boolean warehouseIdExist(long id);
    DistributorModel addDistributor(DistributorModel dModel);
    public boolean distributorIdExist(long id);
    public List<DistributorModel> fetchDistributorDetails();
    
}
