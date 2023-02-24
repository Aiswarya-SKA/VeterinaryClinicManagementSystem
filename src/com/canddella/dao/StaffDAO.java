package com.canddella.dao;

import java.util.List;


import com.canddella.entity.Staff;


public interface StaffDAO {
	List<Staff>findAll();
	int save(Staff staff);
	int update(Staff staff);
	int delete(Staff staff);
	Staff staffId(int id);

}
