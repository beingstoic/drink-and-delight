package com.cg.drinkanddelight.roms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.drinkanddelight.roms.entity.SupplierEntity;

@Repository
public interface SupplierDao extends JpaRepository<SupplierEntity,Long>{

	@Query("SELECT s.supplierId FROM SupplierEntity s ")
	List<Long> getSupplierIds();
	
	boolean existsBySupplierId(Long supplierId);
	SupplierEntity findBySupplierId(Long supplierId);
}
