package com.canddella.service;

import java.util.List;


import com.canddella.entity.Bill;

public interface BillService {

	List<Bill>findAll();
	int save(Bill bill);
	int update(Bill bill);
	int delete(Bill bill);
	Bill billId(int id);
}
