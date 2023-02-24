package com.canddella.entity;

public class Visits {
	
	private int visitId;
	private Animal animal; //HAS A 
	private Owner owner;//HAS A
	private String visitDate;
	private String visitTime;
	public Visits() {
		super();
	}
	public Visits(int visitId, Animal animal, Owner owner, String visitDate, String visitTime) {
		super();
		this.visitId = visitId;
		this.animal = animal;
		this.owner = owner;
		this.visitDate = visitDate;
		this.visitTime = visitTime;
	}
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	
	

}
