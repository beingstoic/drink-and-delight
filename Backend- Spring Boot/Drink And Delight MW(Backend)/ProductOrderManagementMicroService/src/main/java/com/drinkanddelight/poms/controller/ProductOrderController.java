package com.drinkanddelight.poms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drinkanddelight.poms.entity.DeliveryStatus;
import com.drinkanddelight.poms.exception.ProductException;
import com.drinkanddelight.poms.model.ProductOrderModel;
import com.drinkanddelight.poms.service.ProductServiceImpl;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping("/product")
public class ProductOrderController {

	@Autowired
	private ProductServiceImpl prodService;
	
	
	@PostMapping
	public  ResponseEntity<ProductOrderModel> placeProductOrder(@RequestBody ProductOrderModel productOrderModel) throws ProductException
	{
		if(prodService.doesProductOrderIdExists(productOrderModel.getOrderId()))
			throw new ProductException("Order already Exists");
		else
		 productOrderModel=prodService.placeProductOrder(productOrderModel);
		
		return new ResponseEntity<>(productOrderModel,HttpStatus.CREATED);
	}
	
	 @PutMapping
    public ResponseEntity<String> updateProductOrder(@RequestBody ProductOrderModel productOrderModel) throws ProductException{
		 if(!prodService.doesProductOrderIdExists(productOrderModel.getOrderId()))
			 throw new ProductException("This Order Does Not Exist");
        return new ResponseEntity<>(prodService.updateProductOrder(productOrderModel.getOrderId(), productOrderModel.getDeliveryStatus()),HttpStatus.OK);
    }
	 
	@GetMapping("/nId")
	public ResponseEntity<Long> getNewOrderId()
	{
		ResponseEntity<Long> result;
		long id=prodService.getLastOrderId();
		if(id==0)
		  result=new ResponseEntity<>(id+10001,HttpStatus.OK);
		else
			result=new ResponseEntity<>(id+1,HttpStatus.OK);
		return result;
	}
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<ProductOrderModel> productOrderDetails(@PathVariable("id") long orderId) throws ProductException
	 {
		 ResponseEntity<ProductOrderModel> result;
		 if(prodService.doesProductOrderIdExists(orderId))
			 result=new ResponseEntity<>(prodService.getProductOrderDetails(orderId),HttpStatus.OK);
		 else
			 throw new ProductException("Order Id does Not Exist");
			 
		 return result;
	 }

	 @GetMapping("/{id}/{status}/{startDate}/{endDate}")
	 public ResponseEntity<List<ProductOrderModel>> trackProductOrder(@PathVariable("id") long id,@PathVariable("status") DeliveryStatus status,
			 @PathVariable("startDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			 @PathVariable("endDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)throws ProductException
	 { 
		 List<ProductOrderModel> orderList=null;
	     ResponseEntity<List<ProductOrderModel>> result;
		 if(startDate==null && endDate==null)
		 {
			 orderList= prodService.trackProductOrder(id,status);
		 }
		 else
		 {
			orderList= prodService.trackProductOrder(id,status,startDate,endDate);
		 }
		 if(orderList!=null)
			 result=new ResponseEntity<>(orderList,HttpStatus.OK);
		 else
			 throw new ProductException("No records Found");
		 return result;
	 }
	 
	 @GetMapping("/{id}/{status}")
	 public ResponseEntity<List<ProductOrderModel>> trackProductOrder(@PathVariable("id") long id,
			 @PathVariable("status") DeliveryStatus status)throws ProductException
	 { 
		 List<ProductOrderModel> orderList=null;
	     ResponseEntity<List<ProductOrderModel>> result;
		 
		 orderList= prodService.trackProductOrder(id,status);
		 if(orderList!=null)
			 result=new ResponseEntity<>(orderList,HttpStatus.OK);
		 else
			 throw new ProductException("No records Found");
		 return result;
	 }
	 
}

