package com.canddella.dao;

import java.util.List;


import com.canddella.entity.Bill;
import com.canddella.entity.MedicalRecord;

public interface BillDAO {
	
	List<Bill>findAll();
	int save(Bill bill);
	int update(Bill bill);
	int delete(Bill bill);
	Bill billId(int id);
}
