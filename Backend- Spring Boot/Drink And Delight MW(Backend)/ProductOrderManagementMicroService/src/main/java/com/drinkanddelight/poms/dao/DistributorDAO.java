package com.drinkanddelight.poms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.drinkanddelight.poms.entity.DistributorEntity;

public interface DistributorDAO extends JpaRepository<DistributorEntity,Long>{

	@Query("SELECT d.distributorId FROM DistributorEntity d ")
	List<Long> getDistributorIds();
}
