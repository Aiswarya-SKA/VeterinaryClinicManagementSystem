package com.canddella.service;

import java.util.List;

import com.canddella.dao.AnimalDAOImpl;
import com.canddella.entity.Animal;

public class AnimalServiceImpl implements AnimalService {

	@Override
	public List<Animal> findAll() {
		// TODO Auto-generated method stub
		AnimalDAOImpl animalDAOImpl = new AnimalDAOImpl();
		List<Animal> animalList = animalDAOImpl.findAll();
		return animalList;

	}

	@Override
	public void save(Animal animal) {
		
		AnimalDAOImpl animalDAOImpl = new AnimalDAOImpl();
		int row = animalDAOImpl.save(animal);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED DUPLICATE ID ENTRY!!!!!!!!!!!!");
	}

	@Override
	public void update(Animal animal) {
		// TODO Auto-generated method stub
	    AnimalDAOImpl animalDAOImpl = new AnimalDAOImpl();
		int row = animalDAOImpl.update(animal);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED NO CHANGES APPLIED!!!!!!!!!!!!");
	
	
		
	}

	@Override
	public int delete(Animal animal) {
		// TODO Auto-generated method stub
		
			AnimalDAOImpl animalDAOImpl = new AnimalDAOImpl();
			int row = animalDAOImpl.delete(animal);
			if (row == 1)
				System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
			else
				System.out.println("DELETION FAILED!!!!!!!!!!!!");
			return row;
		}

	@Override
	public Animal petId(int id) {
		// TODO Auto-generated method stub
		AnimalDAOImpl animalDAOImpl = new AnimalDAOImpl();
		Animal animal = animalDAOImpl.petId(id);
		
		return animal;
	}
		
	}
	
	


