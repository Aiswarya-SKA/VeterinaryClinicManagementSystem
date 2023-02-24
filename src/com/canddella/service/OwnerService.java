package com.canddella.service;

import java.util.List;

import com.canddella.entity.Owner;



public interface OwnerService {
	
	List<Owner>findAll();
	void save(Owner owner);
	void update(Owner owner);
	void delete(Owner owner);
	Owner ownerId(int id);

}
