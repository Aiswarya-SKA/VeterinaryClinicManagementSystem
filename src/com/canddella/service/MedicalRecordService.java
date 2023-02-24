package com.canddella.service;


import java.util.List;


import com.canddella.entity.MedicalRecord;

public interface MedicalRecordService {
	List<MedicalRecord>findAll();
	int save(MedicalRecord medicalrecord);
    int update(MedicalRecord medicalrecord);
    int delete(MedicalRecord medicalrecord);
    MedicalRecord recordId(int id);
}
