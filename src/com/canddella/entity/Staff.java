package com.canddella.entity;

public class Staff {
	
	private int staffId;
	private String staffName;
	private String speciality;
	private String staffphoneNumber;
	private String staffEmail;
	
	
	public Staff() {
		super();
	}
	public Staff(int staffId, String staffName, String speciality, String staffphoneNumber, String staffEmail) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.speciality = speciality;
		this.staffphoneNumber = staffphoneNumber;
		this.staffEmail = staffEmail;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getStaffphoneNumber() {
		return staffphoneNumber;
	}
	public void setStaffphoneNumber(String staffphoneNumber) {
		this.staffphoneNumber = staffphoneNumber;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	
	

}
