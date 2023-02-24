package com.canddella.utility;


import java.util.List;
import java.util.Scanner;
import com.canddella.entity.Animal;
import com.canddella.service.AnimalServiceImpl;


public class AnimalUtility {

	public static void main(String[] args) {
		
		menudisplay();
			
	}
	
	public static void menudisplay() {
		
		
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("*******ANIMAL DETAILS*******\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Animal Details");
				System.out.println("2. Add new Animal");
				System.out.println("3. Edit Animal Details");
				System.out.println("4. Remove from Animal");
				System.out.println("5.Search Using Id");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllAnimal();
					System.out.println("\n");
					break;

				case 2:
					//getAllAnimal();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoAnimal();
							getAllAnimal();
						}
					} while (response == 'y');

					break;

				case 3:
					//getAllAnimal();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateAnimal();
							getAllAnimal();
						}
					} while (response == 'y');

					break;

				case 4:
					//getAllAnimal();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteAnimal();
							getAllAnimal();
						}
					} while (response == 'y');

					break;
					
				case 5:
					//getAllAnimal();
					do {
						System.out.println("Do you want to  Search ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							searchAnimal();
							//getAllAnimal();
						}
					} while (response == 'y');

					break;

				case 6:
					System.out.println("*****THANK YOU*****");
					condition = false;
					break;

				default:
					System.out.println("Invalid option, try again.\n");
				}

			} while (condition);
		
		
	}
	
	/***
	 * To get all animal details from the animal table
	 */
	
	public static void getAllAnimal() {
	
		AnimalServiceImpl animalServiceImpl = new AnimalServiceImpl();
		List<Animal> animalList = animalServiceImpl.findAll();
		display();
		for(Animal animal : animalList)
		{
			System.out.println(animal.getPetId()+"   	"+animal.getAge()+"	  "+animal.getWeight()+"	  "+animal.getSpecies()+"          "+animal.getSex()+"             "+animal.getBreed()+"            "+animal.getPetCategory());
		}

	}
	
	public static void insertIntoAnimal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Animal********");
		//System.out.println("Enter the PetID:");
		//int petId = scanner.nextInt();
	   // scanner.nextLine();
		System.out.println("Enter the age:");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the weight:");
		Double weight = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter the Speciesname:");
		String species = scanner.nextLine();
		System.out.println("Enter the Sex:");
		String sex = scanner.nextLine();
		System.out.println("Enter the Breed Name:");
		String breed = scanner.nextLine();
		System.out.println("Enter the Category:");
		String petCategory = scanner.nextLine();
		Animal animal = new Animal(0,age,weight,species,sex,breed,petCategory);
		AnimalServiceImpl animalService = new AnimalServiceImpl();
		animalService.save(animal);
		//getAllAnimal();
		
	}
	
	
	private static void updateAnimal() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
  		System.out.println("*********************Updating Animal***********************");
  		System.out.println("Enter the PetID:");
  		int petId = scanner.nextInt();
  		scanner.nextLine();
  		System.out.println("Enter the age:");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the weight:");
		Double weight = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter the Speciesname:");
		String species = scanner.nextLine();
		System.out.println("Enter the Sex:");
		String sex = scanner.nextLine();
		System.out.println("Enter the Breed Name:");
		String breed = scanner.nextLine();
		System.out.println("Enter the Category:");
		String petCategory = scanner.nextLine();
 		Animal animal = new Animal(petId,age,weight,species,sex,breed,petCategory);
 		AnimalServiceImpl animalService = new AnimalServiceImpl();
 		animalService.update(animal);
 		//getAllAnimal();
		
		
	}
	
	private static void deleteAnimal() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting from Animal********");
		System.out.println("Enter the PetID:");
		int petId = scanner.nextInt();
		scanner.nextLine();
		Animal animal = new Animal(petId, 0, 0, null, null, null, null);
		AnimalServiceImpl animalService = new AnimalServiceImpl();
		animalService.delete(animal);
	}
	private static void searchAnimal() {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("********Searching into Animal********");
		System.out.println("Enter the PetID:");
		int petId = in.nextInt();
		in.nextLine();
		Animal animal = new Animal(petId, 0, 0, null, null, null, null);
		AnimalServiceImpl animalService = new AnimalServiceImpl();
		animal = animalService.petId(petId);
		if(animal!=null)
			System.out.println("Pet ID:"+ animal.getPetId()+"\nAge :"+animal.getAge()+
					"\nWeight:"+animal.getWeight()+"\nSpecies :"+animal.getSpecies()+"\nSex:"+animal.getSex()+"\nBreed:"+animal.getBreed()
					+"\nPet Category:"+animal.getPetCategory());
			else
				System.out.println("Id not found");
		
	}
	
	public static void display() {
		System.out.println("******************************ANIMAL TABLE******************************");
		System.out.println("________________________________________________________________________________________________");
		System.out.println("PET_ID\tAGE\tWEIGHT\t\tSPECIES\t\tSEX\t\t  BREED\t\tPET_CATEGORY");
		System.out.println("________________________________________________________________________________________________");
	}

}