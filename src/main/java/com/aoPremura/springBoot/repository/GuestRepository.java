package com.aoPremura.springBoot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aoPremura.springBoot.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long>{
	
	List<Guest> findByName(String name);
	
}
