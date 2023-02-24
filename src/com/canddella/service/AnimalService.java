package com.canddella.service;

import java.util.List;

import com.canddella.entity.Animal;


public interface AnimalService {
	
	List<Animal>findAll();
	void save(Animal animal);
	void update(Animal animal);
	int delete(Animal animal);
	Animal petId(int id);
}
