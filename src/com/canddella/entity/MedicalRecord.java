package com.canddella.entity;

public class MedicalRecord {
	private int recordId;
	private Animal animal; //HAS A 
	private Staff staff;
	private String disease;
	private String startDate;
	private String endDate;
	public MedicalRecord() {
		super();
	}
	public MedicalRecord(int recordId, Animal animal, Staff staff, String disease, String startDate, String endDate) {
		super();
		this.recordId = recordId;
		this.animal = animal;
		this.staff = staff;
		this.disease = disease;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

}
