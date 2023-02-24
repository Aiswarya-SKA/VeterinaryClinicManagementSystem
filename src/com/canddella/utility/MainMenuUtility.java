package com.canddella.utility;

import java.util.Scanner;

public class MainMenuUtility {

	public static void main(String[] args) {
		
		LoginUtility.checkLogin();
		MainMenu();
	
		
	}
	public static void MainMenu() {
		 Scanner in = new Scanner(System.in);
		 boolean  value = true;
		    int num;
		    do {
		    System.out.println("*****WELCOME**\n\n"
		    		+ "***VETERINARY CLINIC MANAGEMENT SYSTEM****\n");	
		    System.out.println("1.ANIMAL_DETAILS\n2.OWNER_DETAILS\n3.STAFF_DETAILS\n4.VISITS_DETAILS"
		    		+ "\n5.MEDICAL RECORD_DETAILS\n6.BILL_DETAILS\n7.Exit");	
		    System.out.print("Enter a Choice: ");
		    num = in.nextInt();
		    
		    switch (num) {
		      case 1:
		    	  AnimalUtility.menudisplay();
		        break;
		      case 2:
		    	  OwnerUtility.menudisplay();
		        break;
		      case 3:
		    	  StaffUtility.menudisplay();
		        break;
		      case 4:
		    	  VisitsUtility.menudisplay();
		        break;
		      case 5:
		    	  MedicalRecordUtility.menudisplay();
		        break;
		      case 6:
		    	  BillUtility.menudisplay();
		        break;
		      
		      case 7:
		    	 System.out.println("*** THANK YOU***");
		    	 value = false;
		        break;
		      default:
		        System.out.println("**Wrong choioce Try again*****\n");
		    }
		    
		  }while(value);

	}


}
