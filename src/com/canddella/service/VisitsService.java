package com.canddella.service;

import java.util.List;

import com.canddella.entity.Visits;

public interface VisitsService {
	
	List<Visits>findAll();
	int save(Visits visits);
	int update(Visits visits);
	int delete(Visits visits);
	Visits visitId(int id);
}
