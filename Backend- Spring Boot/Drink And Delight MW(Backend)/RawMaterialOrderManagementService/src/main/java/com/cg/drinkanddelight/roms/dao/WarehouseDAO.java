package com.cg.drinkanddelight.roms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.drinkanddelight.roms.entity.*;

@Repository
public interface WarehouseDAO extends JpaRepository<WarehouseEntity,Long> {

	@Query("SELECT w.warehouseId FROM WarehouseEntity w ")
	List<Long> getWarehouseIds();
	
	boolean existsByWarehouseId(Long id);
}
