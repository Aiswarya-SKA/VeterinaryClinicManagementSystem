package com.canddella.service;

import java.util.List;

import com.canddella.dao.AnimalDAOImpl;
import com.canddella.dao.OwnerDAOImpl;
import com.canddella.dao.StaffDAOImpl;
import com.canddella.entity.Animal;
import com.canddella.entity.Owner;
import com.canddella.entity.Staff;


public class OwnerServiceImpl {
	
	
	//@Override
	public List<Owner> findAll() {
		// TODO Auto-generated method stub
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		List<Owner> ownerList = ownerDAOImpl.findAll();
		return ownerList;

	}

	//@Override
	public void save(Owner owner) {
		
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		int row = ownerDAOImpl.save(owner);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	}
	
	//@Override
	public void update(Owner owner) {
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		int row = ownerDAOImpl.update(owner);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		
	}
	public int delete(Owner owner) {
		// TODO Auto-generated method stub
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		int row = ownerDAOImpl.delete(owner);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	
	}
	
	public Owner ownerId(int id) {
		
		OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
		Owner owner = ownerDAOImpl.ownerId(id);
		
		return owner;
		
	}
	

}
