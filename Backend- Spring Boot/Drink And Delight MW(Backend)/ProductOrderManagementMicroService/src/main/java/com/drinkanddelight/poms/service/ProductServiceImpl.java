package com.drinkanddelight.poms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drinkanddelight.poms.dao.DistributorDAO;
import com.drinkanddelight.poms.dao.ProductOrdersDAO;
import com.drinkanddelight.poms.dao.ProductSpecsDAO;
import com.drinkanddelight.poms.dao.WarehouseDAO;
import com.drinkanddelight.poms.entity.DeliveryStatus;
import com.drinkanddelight.poms.entity.DistributorEntity;
import com.drinkanddelight.poms.entity.ProductOrderEntity;
import com.drinkanddelight.poms.entity.ProductSpecsEntity;
import com.drinkanddelight.poms.entity.WarehouseEntity;
import com.drinkanddelight.poms.model.DistributorModel;
import com.drinkanddelight.poms.model.ProductOrderModel;
import com.drinkanddelight.poms.model.ProductSpecsModel;
import com.drinkanddelight.poms.model.WarehouseModel;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductOrdersDAO productOrderRepo;
	
	@Autowired
	private DistributorDAO distributorRepo;
	
	@Autowired
	private ProductSpecsDAO productRepo;
	
	@Autowired
	private WarehouseDAO warehouseRepo;
	
	
	private ProductOrderEntity convertProductOrder(ProductOrderModel model)
	{
		ProductOrderEntity entity=null;
		if(model!=null)
		{
			entity=new ProductOrderEntity();
			entity.setProductOrderId(model.getOrderId());
			entity.setProductName(model.getProductName());
			entity.setDateOfOrder(model.getDateOfOrder());
			entity.setDateOfDelivery(model.getDateOfDelivery());
			entity.setDistributorId(model.getDistributorId());
			entity.setPricePerUnit(model.getPricePerUnit());
			entity.setTotalPrice(model.getTotalPrice());
			entity.setWarehouseId(model.getWarehouseId());
			entity.setDeliveryStatus(model.getDeliveryStatus());
			entity.setQuantityValue(model.getQuantityValue());
			
		}
		return entity;
	}
	private ProductOrderModel convertProductOrder(ProductOrderEntity entity)
	{
		ProductOrderModel model=null;
		if(entity!=null)
		{
			model=new ProductOrderModel();
			model.setOrderId(entity.getProductOrderId());
			model.setProductName(entity.getProductName());
			model.setDateOfOrder(entity.getDateOfOrder());
			model.setDateOfDelivery(entity.getDateOfDelivery());
			model.setDistributorId(entity.getDistributorId());
			model.setPricePerUnit(entity.getPricePerUnit());
			model.setTotalPrice(entity.getTotalPrice());
			model.setWarehouseId(entity.getWarehouseId());
			model.setDeliveryStatus(entity.getDeliveryStatus());
			model.setQuantityValue(entity.getQuantityValue());
		
		}
		return model;
	}
	
	private DistributorModel convertDistributor(DistributorEntity source)
	{
		DistributorModel result=null;
		if(source!=null)
		{ result= new DistributorModel();
		  result.setDistributorId(source.getDistributorId());
		  result.setDistributorName(source.getDistributorName());
		  result.setLocation(source.getLocation());
		  result.setPhoneNumber(source.getPhoneNumber());
		  result.setEmail(source.getEmail());
			
		}
		return result;
	}
	
	private DistributorEntity convertDistributor(DistributorModel source)
	{
		DistributorEntity result=null;
		if(source!=null)
		{ result= new DistributorEntity();
		  result.setDistributorId(source.getDistributorId());
		  result.setDistributorName(source.getDistributorName());
		  result.setLocation(source.getLocation());
		  result.setPhoneNumber(source.getPhoneNumber());
		  result.setEmail(source.getEmail());
			
		}
		return result;
	}
	
	private WarehouseModel convertWarehouse(WarehouseEntity source)
	{
		WarehouseModel result=null;
		if(source!=null)
		{
			result=new WarehouseModel();
			result.setWarehouseId(source.getWarehouseId());
			result.setWarehouseName(source.getWarehouseName());
			result.setWarehouseLocation(source.getWarehouseLocation());
			result.setPersonIncharge(source.getPersonIncharge());
			result.setContactNumber(source.getContactNumber());
					
		}
		return result; 
	}
	private WarehouseEntity convertWarehouse(WarehouseModel source)
	{
		WarehouseEntity result=null;
		if(source!=null)
		{
			result=new WarehouseEntity();
			result.setWarehouseId(source.getWarehouseId());
			result.setWarehouseName(source.getWarehouseName());
			result.setWarehouseLocation(source.getWarehouseLocation());
			result.setPersonIncharge(source.getPersonIncharge());
			result.setContactNumber(source.getContactNumber());
					
		}
		return result; 
	}
	
	private ProductSpecsEntity convertProduct(ProductSpecsModel source)
	{
		ProductSpecsEntity result=null;
		if(source!=null)
		{
			result=new ProductSpecsEntity();
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductDuration(source.getProductDuration());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setProductDescription(source.getProductDescription());
		}
		return result;
	}
	
	private ProductSpecsModel convertProduct(ProductSpecsEntity source)
	{
		ProductSpecsModel result=null;
		if(source!=null)
		{
			result=new ProductSpecsModel();
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductDuration(source.getProductDuration());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setProductDescription(source.getProductDescription());
		}
		return result;
	}
    @Override
	public boolean  doesProductOrderIdExists(long id)
	{
		return productOrderRepo.existsById(id);
	}
    
	@Override
	public List<Long> fetchDistributorIds() {

		return distributorRepo.getDistributorIds();
	}
	
	@Override
	public List<Long> fetchWarehouseIds() {
		
		return warehouseRepo.getWarehouseIds();
	}
	
	@Override
	public List<ProductSpecsModel> fetchProductNames() {
		
		return productRepo.findAll().stream().map(p -> convertProduct(p)).collect(Collectors.toList());
	}
	@Override
	public ProductSpecsModel addProduct(ProductSpecsModel pModel)
	{
		return convertProduct(productRepo.save(convertProduct(pModel)));
	}
	@Override
	public boolean productIdExist(long id)
	{
	    return productRepo.existsById(id);
	}
	@Override
	public boolean productNameExist(String productName)
	{
		  return productRepo.existsByProductName(productName);
	}
   	
	@Override
	public ProductSpecsModel fetchProductDetails(long productId)
	{
		ProductSpecsModel model=null;
		ProductSpecsEntity entity=productRepo.findById(productId).orElse(null);
		if(entity!=null)
		{
			model= convertProduct(entity);
		}
		return model;
	}
	@Override
	public ProductOrderModel placeProductOrder(ProductOrderModel productModel) {
		
		return convertProductOrder(productOrderRepo.save(convertProductOrder(productModel)));
	
	}

	@Override
	public ProductOrderModel getProductOrderDetails(long orderId) {
		ProductOrderModel model=null;
		ProductOrderEntity entity=productOrderRepo.findById(orderId).orElse(null);
		if(entity!=null)
		{
			model= convertProductOrder(entity);
		}
		return model;
	}

	@Override
	public List<ProductOrderModel> trackProductOrder(long id,DeliveryStatus status,LocalDate startDate,LocalDate endDate) {
         
		List<ProductOrderModel> modelList=null;
		List<ProductOrderEntity> entityList=productOrderRepo.findAllByInput(id, status, startDate, endDate);
		if(entityList!=null)
		{
			modelList=entityList.stream().map(p -> convertProductOrder(p)).collect(Collectors.toList());
			
		}
		return modelList; 
	}
	
	
	public List<ProductOrderModel> trackProductOrder(long id,DeliveryStatus status) {
         
		List<ProductOrderModel> modelList=null;
		List<ProductOrderEntity> entityList=productOrderRepo.findAllByInput(id, status);
		if(entityList!=null)
		{
			modelList=entityList.stream().map(p -> convertProductOrder(p)).collect(Collectors.toList());
			
		}
		return modelList; 
	}

	@Override
	public String updateProductOrder(long orderId, DeliveryStatus deliveryStatus) {
        String updateStatus=null;
     ProductOrderEntity entity=productOrderRepo.findById(orderId).orElse(null);
     if(entity!=null)
     {
    	 entity.setDeliveryStatus(deliveryStatus);
    	 productOrderRepo.save(entity);
    		updateStatus="Order Updated Successfully";
     }
     else 
    	 updateStatus="Order Id Does Not Exist";
    return updateStatus;
	}

	@Override
	public DistributorModel fetchDistributorDetails(long distributorId) {
		DistributorModel dModel=null;
		DistributorEntity dEntity=distributorRepo.findById(distributorId).orElse(null);
		if(dEntity!=null)
		{
			dModel=convertDistributor(dEntity);
		}
		return dModel;
		
	}
	
	@Override
	public WarehouseModel fetchWarehouseDetails(long id)
	{
		WarehouseModel wModel=null;
		WarehouseEntity wEntity=warehouseRepo.findById(id).orElse(null);
		if(wEntity!=null)
		{
			wModel=convertWarehouse(wEntity);
		}
		return wModel;
	}
	@Override
	public List<WarehouseModel> fetchWarehouseDetails()
	{
		return warehouseRepo.findAll().stream().map(w -> convertWarehouse(w)).collect(Collectors.toList());
	}
	
	@Override
	public WarehouseModel addWarehouse(WarehouseModel wModel)
	{
		return convertWarehouse(warehouseRepo.save(convertWarehouse(wModel)));
	}
	
	@Override
	public boolean warehouseIdExist(long id)
	{
	    return warehouseRepo.existsById(id);
	}
	
	@Override
	public DistributorModel addDistributor(DistributorModel dModel)
	{
		return convertDistributor(distributorRepo.save(convertDistributor(dModel)));
	}
	
	@Override
	public boolean distributorIdExist(long id)
	{
	    return distributorRepo.existsById(id);
	}
	
	@Override
    public List<DistributorModel> fetchDistributorDetails()
    {
    	return distributorRepo.findAll().stream().map(d -> convertDistributor(d)).collect(Collectors.toList());
    }
	
	public long getLastOrderId()
	{   
		Long lastId=productOrderRepo.getLastOrderId();
		if(lastId==null)
			return 0;
		return lastId; 
	}
}














