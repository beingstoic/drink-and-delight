package com.drinkanddelight.poms.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.drinkanddelight.poms.entity.DeliveryStatus;
import com.drinkanddelight.poms.entity.ProductOrderEntity;

@Repository
public interface ProductOrdersDAO extends JpaRepository<ProductOrderEntity,Long>{

	@Query("SELECT p FROM ProductOrderEntity p WHERE p.distributorId=:id and p.deliveryStatus=:status and p.dateOfOrder BETWEEN  :startDate and :endDate")
	List<ProductOrderEntity> findAllByInput(long id,DeliveryStatus status,LocalDate startDate,LocalDate endDate);
	
	@Query("SELECT p FROM ProductOrderEntity p WHERE p.distributorId=:id and p.deliveryStatus=:status")
	List<ProductOrderEntity> findAllByInput(long id,DeliveryStatus status);
	@Query("SELECT MAX(p.productOrderId) FROM ProductOrderEntity p ")
	Long getLastOrderId();
}
