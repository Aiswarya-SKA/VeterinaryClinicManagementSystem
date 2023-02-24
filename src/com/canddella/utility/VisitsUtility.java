package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Animal;
import com.canddella.entity.MedicalRecord;
import com.canddella.entity.Owner;
import com.canddella.entity.Visits;
import com.canddella.service.MedicalRecordServiceImpl;
import com.canddella.service.VisitsServiceImpl;

public class VisitsUtility {

	public static void main(String[] args) {
		//searchVisits();
		menudisplay();
	}
		


	public static void getAllVisits() {
		// TODO Auto-generated method stub
		VisitsServiceImpl visitsServiceImpl = new VisitsServiceImpl();
		List<Visits> visitsList = visitsServiceImpl.findAll();
		display();
		for (Visits visits:visitsList) {
			System.out.println(visits.getVisitId() + "\t\t" + visits.getAnimal().getPetId() + "\t"
					+ visits.getOwner().getOwnerId() + "\t\t" + visits.getVisitDate() + "\t"+ visits.getVisitTime());
		
	}
	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("*****************VISITS TABLE******************");
		System.out.println("_______________________________________________________________________");
		System.out.println("VISIT ID\tPET ID \tOWNER ID\tVISIT DATE\tVISIT TIME");
		System.out.println("_____________________________________________________________________________");
		
		
	}

	private static void insertIntoVisits() {
		// TODO Auto-generated method stub
		AnimalUtility.getAllAnimal();
		OwnerUtility.getAllOwner();
		Scanner scanner = new Scanner(System.in);
		System.out.println("**Inserting into Visits**");
		//System.out.println("Enter the VisitID:");
		//int visitId = scanner.nextInt();
		//scanner.nextLine();
		System.out.println("Enter the PetID:");
		int petId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the OwnerId:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitDate:");
		String visitDate = scanner.nextLine();
		System.out.println("Enter the VisitTime:");
		String visitTime = scanner.nextLine();

		Visits visits = new Visits();

		Animal animal = new Animal();
		visits.setAnimal(animal);
		animal.setPetId(petId);
		
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);
		visits.setOwner(owner);

		visits.setVisitDate(visitDate);
		visits.setVisitTime(visitTime);

		VisitsServiceImpl visitsServiceImpl = new VisitsServiceImpl();
		visitsServiceImpl.save(visits);

	}
	private static void updateVisits() {
		// TODO Auto-generated method stub
		AnimalUtility.getAllAnimal();
		OwnerUtility.getAllOwner();
		Scanner scanner = new Scanner(System.in);
		System.out.println("**Updating Visits**");
		System.out.println("Enter the VisitID:");
		int visitId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PetID:");
		int petId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the OwnerId:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitDate:");
		String paymentDate = scanner.nextLine();
		System.out.println("Enter the VisitTime:");
		String visitTime = scanner.nextLine();

		Visits visits = new Visits();

		Animal animal = new Animal();
		Owner owner = new Owner();
		animal.setPetId(petId);
		owner.setOwnerId(ownerId);
		visits.setAnimal(animal);
		visits.setOwner(owner);

		visits.setVisitDate(visitTime);
		visits.setVisitTime(visitTime);

		VisitsServiceImpl visitsServiceImpl = new VisitsServiceImpl();
		visitsServiceImpl.update(visits);

		
	}
	
	private static void deleteVisits() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting into Visits********");
		System.out.println("Enter the VisitID:");
		int visitId = scanner.nextInt();
		scanner.nextLine();
		Visits visits = new Visits(visitId, null, null, null, null);
		VisitsServiceImpl visitsService = new VisitsServiceImpl();
		visitsService.delete(visits);
	}
	
	private static void searchVisits() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("********Searching into Visits********");
		System.out.println("Enter the Visit ID:");
		int visitId = in.nextInt();
		in.nextLine();
		Visits visits = new Visits(visitId,null,null, null, null);
		VisitsServiceImpl visitsService = new VisitsServiceImpl();
		visits = visitsService.visitId(visitId);
		if(visits!=null)
			System.out.println("Visit ID:"+ visits.getVisitId()+"\nPet ID :"+visits.getAnimal().getPetId()+"\nOwner Id:"+visits.getOwner().getOwnerId()+
					"\nVisit Date:"+visits.getVisitDate()+"\nVisit Time :"+visits.getVisitTime());
			else
				System.out.println("Id not found");
		
		
	}


	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("*******VISITS DETAILS*******\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Visits Details");
			System.out.println("2. Add new Visit");
			System.out.println("3. Edit Visit Details");
			System.out.println("4. Remove from Visits");
			System.out.println("5.Search using Id");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllVisits();
				System.out.println("\n");
				break;

			case 2:
				//getAllVisits();
				do {
					// code to be executed
					System.out.println("Do you want to insert? (y/n)");
					response = in.next().charAt(0);

					if (response == 'n') {
						break;
					} else {

						insertIntoVisits();
						getAllVisits();
					}
				} while (response == 'y');

				break;

			case 3:
				//getAllVisits();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						updateVisits();
						getAllVisits();
					}
				} while (response == 'y');

				break;

			case 4:
				//getAllVisits();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						deleteVisits();
						getAllVisits();
					}
				} while (response == 'y');

				break;
				
			case 5:
				//getAllVisits();
				do {
					System.out.println("Do you want to  Search ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						searchVisits();
						//getAllVisits();
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


}
