package com.canddella.entity;

public class Animal {
	
	private int petId;
	private int age ;
	private double weight;
	private String species;
	private String sex;
	private String breed;
	private String petCategory;
	
	public Animal() {
		super();
	}
	public Animal(int petId, int age, double weight, String species, String sex, String breed, String petCategory) {
		super();
		this.petId = petId;
		this.age = age;
		this.weight = weight;
		this.species = species;
		this.sex = sex;
		this.breed = breed;
		this.petCategory = petCategory;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getPetCategory() {
		return petCategory;
	}
	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	} 
	
	

}
