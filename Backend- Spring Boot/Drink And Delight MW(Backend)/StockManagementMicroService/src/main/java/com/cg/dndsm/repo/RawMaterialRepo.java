package com.cg.dndsm.repo;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dndsm.entity.RawMaterialEntity;

public interface RawMaterialRepo extends JpaRepository<RawMaterialEntity, Long> {
	
	@Modifying
    @Transactional
	@Query("update RawMaterialEntity details set details.manufacturingDate=:mDate, details.expiryDate=:eDate, details.qualityCheck=:qCheck WHERE details.orderId=:orderId")
	void updateRMDetails(@Param("orderId") long orderId, @Param("mDate") LocalDate manufacturingDate,@Param("eDate") LocalDate expiryDate,@Param("qCheck") String qualityCheck);

}
