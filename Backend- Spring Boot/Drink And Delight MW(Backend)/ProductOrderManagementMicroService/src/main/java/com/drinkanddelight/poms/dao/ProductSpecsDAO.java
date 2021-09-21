package com.drinkanddelight.poms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.drinkanddelight.poms.entity.ProductSpecsEntity;

public interface ProductSpecsDAO extends JpaRepository<ProductSpecsEntity,Long>{

	boolean existsByProductName(String productName);
	@Query("SELECT p.productName FROM ProductSpecsEntity p ")
	List<String> findAllProductNames();
}
