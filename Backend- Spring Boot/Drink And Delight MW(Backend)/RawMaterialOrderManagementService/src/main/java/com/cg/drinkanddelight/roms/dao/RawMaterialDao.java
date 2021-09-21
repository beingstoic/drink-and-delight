package com.cg.drinkanddelight.roms.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.drinkanddelight.roms.entity.*;



@Repository
public interface RawMaterialDao extends JpaRepository<RawMaterialOrderEntity,Long>{
	boolean existsBySupplierId(Long supplierId);
	boolean existsByOrderId(Long orderId);
	RawMaterialOrderEntity findByOrderId(Long orderId);
    @Transactional
	@Modifying
   @Query("SELECT p FROM RawMaterialOrderEntity p WHERE p.supplierId=:id and p.deliveryStatus=:status and p.dateOfOrder BETWEEN  :startDate and :endDate")
    List<RawMaterialOrderEntity> findAllByInput(Long id,DeliveryStatus status,LocalDate startDate,LocalDate endDate);
    
    @Query("SELECT p FROM RawMaterialOrderEntity p WHERE p.supplierId=:supplierId and p.deliveryStatus=:delStatus")
	List<RawMaterialOrderEntity> findAllByIn(Long  supplierId, DeliveryStatus delStatus);
    @Query("SELECT MAX(r.orderId) FROM RawMaterialOrderEntity r ")
	Long getLastOrderId();
}
