package com.canddella.service;

import java.util.List;

import com.canddella.dao.MedicalRecordDAOImpl;
import com.canddella.dao.VisitsDAOImpl;
import com.canddella.entity.MedicalRecord;
import com.canddella.entity.Visits;

public class VisitsServiceImpl implements VisitsService {

	@Override
	public int save(Visits visits) {
		// TODO Auto-generated method stub
		
		VisitsDAOImpl visitsDAOImpl = new VisitsDAOImpl();
		int row = visitsDAOImpl.save(visits);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	
		return 0;
	}

	@Override
	public List<Visits> findAll() {
		// TODO Auto-generated method stub
		VisitsDAOImpl visitsDAOImpl = new VisitsDAOImpl();
		List<Visits>visitList=visitsDAOImpl.findAll();
		return visitList;
	}

	@Override
	public int update(Visits visits) {
		// TODO Auto-generated method stub
		VisitsDAOImpl visitsDAOImpl = new VisitsDAOImpl();
		int row = visitsDAOImpl.update(visits);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;
		
	}

	@Override
	public int delete(Visits visits) {
		// TODO Auto-generated method stub
		VisitsDAOImpl visitsDAOImpl = new VisitsDAOImpl();
		int row = visitsDAOImpl.delete(visits);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	
	}

	@Override
	public Visits visitId(int id) {
		// TODO Auto-generated method stub
		VisitsDAOImpl visitsDAOImpl = new VisitsDAOImpl();
		Visits visits = visitsDAOImpl.visitId(id);

		
		
		return visits;
	}

}
