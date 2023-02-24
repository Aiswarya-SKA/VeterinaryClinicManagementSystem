package com.canddella.dao;


import java.util.List;


import com.canddella.entity.MedicalRecord;
import com.canddella.entity.Staff;

public interface MedicalRecordDAO {
	
	List<MedicalRecord>findAll();
	int save(MedicalRecord medicalrecord);
	int update(MedicalRecord medicalrecord);
	int delete(MedicalRecord medicalrecord);
	MedicalRecord recordId(int id);

}
