package com.canddella.service;


import java.util.List;

import com.canddella.dao.AnimalDAOImpl;
import com.canddella.dao.MedicalRecordDAOImpl;
import com.canddella.dao.StaffDAOImpl;
import com.canddella.dao.VisitsDAOImpl;
import com.canddella.entity.MedicalRecord;
import com.canddella.entity.Staff;
import com.canddella.entity.Visits;

public class MedicalRecordServiceImpl implements MedicalRecordService {

	@Override
	public int save(MedicalRecord medicalrecord) {
		// TODO Auto-generated method stub
		
		MedicalRecordDAOImpl medicalrecordDAOImpl = new MedicalRecordDAOImpl();
		int row = medicalrecordDAOImpl.save(medicalrecord);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
	
		return 0;
	}

	@Override
	public int update(MedicalRecord medicalrecord) {
		// TODO Auto-generated method stub
		
		MedicalRecordDAOImpl medicalrecordDAOImpl = new MedicalRecordDAOImpl();
		int row = medicalrecordDAOImpl.update(medicalrecord);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;
		
	}

	@Override
	public int delete(MedicalRecord medicalrecord) {
		// TODO Auto-generated method stub
		MedicalRecordDAOImpl medicalrecordDAOImpl = new MedicalRecordDAOImpl();
		int row = medicalrecordDAOImpl.delete(medicalrecord);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;

	}

	@Override
	public List<MedicalRecord> findAll() {
		// TODO Auto-generated method stub
		MedicalRecordDAOImpl medicalrecordDAOImpl = new MedicalRecordDAOImpl();
		List<MedicalRecord>medicalrecordList=medicalrecordDAOImpl.findAll();
		return medicalrecordList;
		
	}

	@Override
	public MedicalRecord recordId(int id) {
		// TODO Auto-generated method stub
		MedicalRecordDAOImpl medicalrecordDAOImpl = new MedicalRecordDAOImpl();
		MedicalRecord medicalrecord = medicalrecordDAOImpl.recordId(id);

		
		return medicalrecord;
	}

}
