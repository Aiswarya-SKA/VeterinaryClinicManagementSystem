package com.canddella.service;

import java.util.List;

import com.canddella.dao.OwnerDAOImpl;
import com.canddella.dao.StaffDAOImpl;
import com.canddella.entity.Owner;
import com.canddella.entity.Staff;

public class StaffServiceImpl implements StaffService {

	@Override
	public List<Staff> findAll() {
		
		
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		List<Staff> staffList = staffDAOImpl.findAll();
		return staffList;

	}

	@Override
	public void save(Staff staff) {
		// TODO Auto-generated method stub
		
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.save(staff);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.update(staff);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		
	}

	@Override
	public int delete(Staff staff) {
		// TODO Auto-generated method stub
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		int row = staffDAOImpl.delete(staff);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	
	}

	@Override
	public Staff staffId(int id) {
		// TODO Auto-generated method stub
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		Staff staff = staffDAOImpl.staffId(id);
		return staff;
	}

	

}
