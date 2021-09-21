package com.cg.drinkanddelight.roms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drinkanddelight.roms.entity.RawMaterialSpecsEntity;

@Repository
public interface RawMaterialSpecsDao extends JpaRepository<RawMaterialSpecsEntity,Long>{

	boolean existsByMaterialName(String string);

	boolean existsByRmsId(Long id);

}

