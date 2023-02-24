package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Animal;
import com.canddella.entity.Owner;
import com.canddella.entity.Staff;
import com.canddella.service.AnimalServiceImpl;
import com.canddella.service.OwnerServiceImpl;
import com.canddella.service.StaffServiceImpl;


public class OwnerUtility {
	
	public static void main(String[] args) {
		
		searchOwner();
		menudisplay();
		
	}
	
	public static void menudisplay() {
		// TODO Auto-generated method stub
		
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("*******OWNER DETAILS*******\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Owner Details");
				System.out.println("2. Add new Owner");
				System.out.println("3. Edit Owner Details");
				System.out.println("4. Remove from Owner");
				System.out.println("5.Search using ID");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllOwner();
					System.out.println("\n");
					break;

				case 2:
					//getAllOwner();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoOwner();
							getAllOwner();
						}
					} while (response == 'y');

					break;

				case 3:
					//getAllOwner();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateOwner();
							getAllOwner();
						}
					} while (response == 'y');

					break;

				case 4:
					//getAllOwner();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteOwner();
							getAllOwner();
						}
					} while (response == 'y');

					break;
				
				case 5:
					//getAllOwner();
					do {
						System.out.println("Do you want to  Search ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteOwner();
							//getAllOwner();
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
	 * To get all owner details from the owner table
	 */
	
	public static void getAllOwner() {
	
		OwnerServiceImpl ownerServiceImpl = new OwnerServiceImpl();
		List<Owner> ownerList = ownerServiceImpl.findAll();
		display();
		for(Owner owner : ownerList)
		{
			System.out.println(owner.getOwnerId()+"       "+owner.getOwnerName()+"         "+owner.getOwnerphoneNumber()+"         "+owner.getOwnerEmail()+"        "+owner.getOwnerAddress());
		}

	
	}
	
	public static void insertIntoOwner() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Owner********");
		System.out.println("Enter the OwnerID:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Ownername:");
		String ownerName = scanner.nextLine();
		System.out.println("Enter the Owner Phone Number:");
		String ownerphoneNumber = scanner.nextLine();
		System.out.println("Enter the Owner Email:");
		String ownerEmail = scanner.nextLine();
		System.out.println("Enter the Owner Address:");
		String ownerAddress = scanner.nextLine();
		Owner owner = new Owner(ownerId,ownerName,ownerphoneNumber,ownerEmail,ownerAddress);
		OwnerServiceImpl ownerService = new OwnerServiceImpl();
		ownerService.save(owner);

		
		
	}
	
	private static void updateOwner() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("******************UPDATING OWNER***********************");
		System.out.println("Enter the OwnerID:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Ownername:");
		String ownerName = scanner.nextLine();
		System.out.println("Enter the Owner Phone Number:");
		String ownerphoneNumber = scanner.nextLine();
		System.out.println("Enter the Owner Email:");
		String ownerEmail = scanner.nextLine();
		System.out.println("Enter the Owner Address:");
		String ownerAddress = scanner.nextLine();
		Owner owner = new Owner(ownerId,ownerName,ownerphoneNumber,ownerEmail,ownerAddress);
		OwnerServiceImpl ownerService = new OwnerServiceImpl();
		ownerService.update(owner);
		
	}
	
	private static void deleteOwner() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting from Owner********");
		System.out.println("Enter the OwnerID:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		Owner owner = new Owner(ownerId, null, null, null, null);
		OwnerServiceImpl ownerService = new OwnerServiceImpl();
		ownerService.delete(owner);
		
	}
	private static void searchOwner() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("********Searching into Owner********");
		System.out.println("Enter the OwnerID:");
		int ownerId = in.nextInt();
		in.nextLine();
		Owner owner = new Owner(ownerId,null,null, null, null);
		OwnerServiceImpl ownerService = new OwnerServiceImpl();
		owner = ownerService.ownerId(ownerId);
		if(owner!=null)
			System.out.println("Owner ID:"+ owner.getOwnerId()+"\nOwner Name :"+owner.getOwnerName()+"\nOwner PhoneNumber:"+owner.getOwnerphoneNumber()+
					"\nOwner Email:"+owner.getOwnerEmail()+"\nAddress :"+owner.getOwnerAddress());
			else
				System.out.println("Id not found");
		
		
	}
	
	
	public static void display() {
		System.out.println("******************************OWNER TABLE******************************");
		System.out.println("_____________________________________________________________________________________");
		System.out.println("OWNER_ID OWNER NAME OWNER PHONENUMBER     OWNER EMAIL\t    OWNER ADDRESS");
		System.out.println("_____________________________________________________________________________________");
	}

	

}
