package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Animal;
import com.canddella.entity.MedicalRecord;
import com.canddella.entity.Staff;
import com.canddella.service.MedicalRecordServiceImpl;
import com.canddella.service.StaffServiceImpl;



public class MedicalRecordUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		menudisplay();
	}

	
	private static void deleteMedicalRecord() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting into MedicalRecord********");
		System.out.println("Enter the Record ID:");
		int recordId = scanner.nextInt();
		scanner.nextLine();
		MedicalRecord medicalrecord=new MedicalRecord();
		MedicalRecordServiceImpl medicalrecordService=new MedicalRecordServiceImpl();
		medicalrecordService.delete(medicalrecord);
		
	}

	private static void updateMedicalRecord() {
		// TODO Auto-generated method stub
		AnimalUtility.getAllAnimal();
		StaffUtility.getAllStaff();
		Scanner scanner = new Scanner(System.in);
		System.out.println("**Updating MedicalRecord**");
		System.out.println("Enter the Record ID:");
		int recordId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PetID:");
		int petId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffId:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Disease:");
		String disease = scanner.nextLine();
		System.out.println("Enter the Start Date:");
		String startDate = scanner.nextLine();
		System.out.println("Enter the End Date:");
		String endDate = scanner.nextLine();

		MedicalRecord medicalrecord=new MedicalRecord();

		Animal animal = new Animal();
		Staff staff = new Staff();
		animal.setPetId(petId);
		staff.setStaffId(staffId);
		medicalrecord.setAnimal(animal);
		medicalrecord.setStaff(staff);

		medicalrecord.setDisease(disease);
		medicalrecord.setStartDate(startDate);
		medicalrecord.setEndDate(endDate);

		MedicalRecordServiceImpl medicalrecordServiceImpl = new MedicalRecordServiceImpl();
		medicalrecordServiceImpl.update(medicalrecord);

		
	}

	public static void getAllMedicalRecord() {
		// TODO Auto-generated method stub
		MedicalRecordServiceImpl medicalrecordServiceImpl = new MedicalRecordServiceImpl();
		List<MedicalRecord> medicalrecordList = medicalrecordServiceImpl.findAll();
		display();
		for (MedicalRecord medicalrecord:medicalrecordList) {
			System.out.println(medicalrecord.getRecordId() + "       \t" + medicalrecord.getAnimal().getPetId() + "  \t"
					+ medicalrecord.getStaff().getStaffId() + "\t" + medicalrecord.getDisease() +"\t" +medicalrecord.getStartDate()+"\t"+ medicalrecord.getEndDate());
		
	}
	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("*****************MEDICAL TABLES*****************");
		System.out.println("_____________________________________________________________________________________");
		System.out.println("RECORD ID   PET ID  STAFF ID\t DISEASE\tSTART DATE\tEND DATE");
		System.out.println("______________________________________________________________________________________");
		
	}

	private static void insertIntoMedicalRecord() {
		// TODO Auto-generated method stub
		AnimalUtility.getAllAnimal();
		StaffUtility.getAllStaff();
		Scanner scanner = new Scanner(System.in);
		System.out.println("**Updating MedicalRecord**");
		System.out.println("Enter the Record ID:");
		int recordId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PetID:");
		int petId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffId:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Disease:");
		String disease = scanner.nextLine();
		System.out.println("Enter the Start Date:");
		String startDate = scanner.nextLine();
		System.out.println("Enter the End Date:");
		String endDate = scanner.nextLine();

		MedicalRecord medicalrecord=new MedicalRecord();

		Animal animal = new Animal();
		Staff staff = new Staff();
		animal.setPetId(petId);
		staff.setStaffId(staffId);
		medicalrecord.setAnimal(animal);
		medicalrecord.setStaff(staff);

		medicalrecord.setDisease(disease);
		medicalrecord.setStartDate(startDate);
		medicalrecord.setEndDate(endDate);

		MedicalRecordServiceImpl medicalrecordServiceImpl = new MedicalRecordServiceImpl();
		medicalrecordServiceImpl.save(medicalrecord);

	}
	
	private static void searchRecord() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("********Searching into Medical Record********");
		System.out.println("Enter the Record ID:");
		int recordId = in.nextInt();
		in.nextLine();
		MedicalRecord medicalrecord = new MedicalRecord(recordId,null,null, null, null, null);
		MedicalRecordServiceImpl medicalrecordService = new MedicalRecordServiceImpl();
		medicalrecord  = medicalrecordService.recordId(recordId);
		if(medicalrecord!=null)
			System.out.println("Record ID:"+ medicalrecord.getRecordId()+"\nPet ID :"+medicalrecord.getAnimal().getPetId()+"\nStaff Id:"+medicalrecord.getStaff().getStaffId()+
					"\nDisease:"+medicalrecord.getDisease()+"\nStart Date :"+medicalrecord.getStartDate()+"\nEnd Date:"+medicalrecord.getEndDate());
			else
				System.out.println("Id not found");
		
		
		
	}

	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("*******MEDICALRECORD DETAILS*******\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show MedicalRecord Details");
			System.out.println("2. Add new MedicalRecord");
			System.out.println("3. Edit MedicalRecord Details");
			System.out.println("4. Remove from MedicalRecord");
			System.out.println("5.Search");
			System.out.println("6.Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllMedicalRecord();
				System.out.println("\n");
				break;

			case 2:
				getAllMedicalRecord();
				do {
					// code to be executed
					System.out.println("Do you want to insert? (y/n)");
					response = in.next().charAt(0);

					if (response == 'n') {
						break;
					} else {

						insertIntoMedicalRecord();
						getAllMedicalRecord();
					}
				} while (response == 'y');

				break;

			case 3:
				getAllMedicalRecord();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						updateMedicalRecord();
						getAllMedicalRecord();
					}
				} while (response == 'y');

				break;

			case 4:
				getAllMedicalRecord();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						deleteMedicalRecord();
						getAllMedicalRecord();
					}
				} while (response == 'y');

				break;
				
			case 5:
				//getAllMedicalRecord();
				do {
					System.out.println("Do you want to  Search ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						searchRecord();
						//getAllMedicalRecord();
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


