package com.canddella.service;

import java.util.List;

import com.canddella.entity.Staff;


public interface StaffService {
	
	List<Staff>findAll();
	void save(Staff staff);
	void update(Staff staff);
	int delete(Staff staff);
	Staff staffId(int id);

}
