package com.canddella.dao;


import java.util.List;


import com.canddella.entity.Visits;

public interface VisitsDAO {

	List<Visits>findAll();
	int save(Visits visits);
	int update(Visits visits);
	int delete(Visits visits);
	Visits visitId(int id);
}
