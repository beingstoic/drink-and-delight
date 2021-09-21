package com.drinkanddelight.poms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.drinkanddelight.poms.entity.WarehouseEntity;

public interface WarehouseDAO extends JpaRepository<WarehouseEntity,Long> {

	@Query("SELECT w.warehouseId FROM WarehouseEntity w ")
	List<Long> getWarehouseIds();
}
