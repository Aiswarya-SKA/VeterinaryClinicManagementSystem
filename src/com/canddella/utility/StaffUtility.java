package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Animal;
import com.canddella.entity.Owner;
import com.canddella.entity.Staff;
import com.canddella.service.AnimalServiceImpl;
import com.canddella.service.OwnerServiceImpl;
import com.canddella.service.StaffServiceImpl;


public class StaffUtility {
	
	public static void main(String[] args) {
		
		searchStaff();
		menudisplay();
		
	}
	
	public static void menudisplay() {
		// TODO Auto-generated method stub
		
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("*******STAFF DETAILS*******\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Staff Details");
				System.out.println("2. Add new Staff");
				System.out.println("3. Edit Staff Details");
				System.out.println("4. Remove from Staff");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllStaff();
					System.out.println("\n");
					break;

				case 2:
					//getAllStaff();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoStaff();
							getAllStaff();
						}
					} while (response == 'y');

					break;

				case 3:
					//getAllStaff();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateStaff();
							getAllStaff();
						}
					} while (response == 'y');

					break;

				case 4:
					//getAllStaff();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteStaff();
							getAllStaff();
						}
					} while (response == 'y');

					break;

				case 5:
					System.out.println("*****THANK YOU*****");
					condition = false;
					break;

				default:
					System.out.println("Invalid option, try again.\n");
				}

			} while (condition);
		
		
	}
	
	/***
	 * To get all staff details from the staff table
	 */
	
	public static void getAllStaff() {
	
		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		List<Staff> staffList = staffServiceImpl.findAll();
		display();
		for(Staff staff : staffList)
		{
			System.out.println(staff.getStaffId()+"        "+staff.getStaffName()+"         "+staff.getSpeciality()+"       "+staff.getStaffphoneNumber()+"         "+staff.getStaffEmail());
		}

	
    }
	public static void insertIntoStaff() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Staff********");
		System.out.println("Enter the Staff ID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Staff name:");
		String staffName = scanner.nextLine();
		System.out.println("Enter the Speciality:");
		String speciality = scanner.nextLine();
		System.out.println("Enter the Staff Phone Number:");
		String staffphoneNumber = scanner.nextLine();
		System.out.println("Enter the Staff Email:");
		String staffEmail = scanner.nextLine();
		Staff staff = new Staff(staffId,staffName,speciality,staffphoneNumber,staffEmail);
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.save(staff);

		
		
	}
	
	private static void updateStaff() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("********UPDATING STAFF********");
		System.out.println("Enter the Staff ID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Staff name:");
		String staffName = scanner.nextLine();
		System.out.println("Enter the Speciality:");
		String speciality = scanner.nextLine();
		System.out.println("Enter the Staff Phone Number:");
		String staffphoneNumber = scanner.nextLine();
		System.out.println("Enter the Staff Email:");
		String staffEmail = scanner.nextLine();
		Staff staff = new Staff(staffId,staffName,speciality,staffphoneNumber,staffEmail);
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.update(staff);

		
	}
	
	private static void deleteStaff() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting from staff********");
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		Staff staff = new Staff(staffId,null, null, null, null );
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.delete(staff);
	}
	
	private static void searchStaff() {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("********Searching into Staff********");
		System.out.println("Enter the StaffID:");
		int staffId = in.nextInt();
		in.nextLine();
		Staff staff = new Staff(staffId,null,null, null, null);
		StaffServiceImpl staffService = new StaffServiceImpl();
		staff = staffService.staffId(staffId);
		if(staff!=null)
			System.out.println("Staff ID:"+ staff.getStaffId()+"\nStaff Name :"+staff.getStaffName()+"\nSpeciality:"+staff.getSpeciality()+
					"\nOwner Phone Number:"+staff.getStaffphoneNumber()+"\nEmail :"+staff.getStaffEmail());
			else
				System.out.println("Id not found");
		
		
		
	}
	
	
	public static void display() {
		System.out.println("******************************STAFF TABLE******************************");
		System.out.println("_____________________________________________________________________________________");
		System.out.println("STAFF_ID STAFF NAME  SPECIALITY\tSTAFF PHONENUMBER  STAFF EMAIL");
		System.out.println("_____________________________________________________________________________________");
	}



}
