package com.cg.dndsm.repo;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dndsm.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
	
	@Modifying
    @Transactional
	@Query("update ProductEntity details set details.manufacturingDate=:mDate, details.expiryDate=:eDate, details.qualityCheck=:qCheck WHERE details.orderId=:orderId")
	void updatePDetails(@Param("orderId") long orderId, @Param("mDate") LocalDate manufacturingDate,@Param("eDate") LocalDate expiryDate,@Param("qCheck") String qualityCheck);
	
	
	@Modifying
	@Transactional
	@Query("update ProductEntity date set date.exitDate=:exDate WHERE date.orderId=:orderId")
	void updateExitDate(@Param("orderId") long orderId, @Param("exDate") LocalDate exitDate);
	
}
