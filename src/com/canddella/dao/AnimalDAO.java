package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Animal;


public interface AnimalDAO {
	
	List<Animal>findAll();
	int save(Animal animal);
	int update(Animal animal);
	int delete(Animal animal);
	Animal petId(int id);

}
