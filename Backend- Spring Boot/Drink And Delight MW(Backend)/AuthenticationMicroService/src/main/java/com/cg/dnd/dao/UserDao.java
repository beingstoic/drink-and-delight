package com.cg.dnd.dao;

import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

import com.cg.dnd.entity.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	
}
