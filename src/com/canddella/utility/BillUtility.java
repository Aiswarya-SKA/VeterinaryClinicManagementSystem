package com.canddella.utility;

import java.util.List;
import java.util.Scanner;
import com.canddella.entity.Bill;
import com.canddella.entity.Visits;
import com.canddella.service.BillServiceImpl;
import com.canddella.service.VisitsServiceImpl;


public class BillUtility {

	public static void main(String[] args) {

//		getAllBill();
//		insertIntoBill();
//		getAllBill();
//		updateBill();
//		deleteBill();
		//searchBill();
		menudisplay();

	}

	private static void searchBill() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("********Searching into Bill********");
		System.out.println("Enter the Bill ID:");
		int billId = in.nextInt();
		in.nextLine();
		Bill bill = new Bill(billId,null,0,null,null);
		BillServiceImpl billService = new BillServiceImpl();
		bill = billService.billId(billId);
		if(bill!=null)
			System.out.println("Bill ID:"+ bill.getBillId()+"\nVisit ID :"+bill.getVisits().getVisitId()+"\nTotal Amount:"+bill.getTotalAmount()+
					"\nPayment Mode:"+bill.getPaymentMode()+"\nPayment Date :"+bill.getPaymentDate());
			else
				System.out.println("Id not found");
		
		
	}

	private static void insertIntoBill() {

		VisitsUtility.getAllVisits();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("**Inserting into Bill**");
		//System.out.println("Enter the Bill ID:");
		//int billId = scanner.nextInt();
		//scanner.nextLine();
		System.out.println("Enter the Visits ID:");
		int visitId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Total Amount:");
		int totalAmount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PaymentMode:");
		String paymentMode = scanner.nextLine();
		System.out.println("Enter the PaymentDate:");
		String paymentDate = scanner.nextLine();

		Bill bill = new Bill();
		
		Visits visits=new Visits();
		visits.setVisitId(visitId);
		bill.setVisits(visits);
		
        bill.setTotalAmount(totalAmount);
		bill.setPaymentMode(paymentMode);
		bill.setPaymentDate(paymentDate);

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		billServiceImpl.save(bill);

	}

	public static void getAllBill() {

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		List<Bill> billList = billServiceImpl.findAll();
		display();
		for (Bill bill : billList) {
			System.out.println(bill.getBillId() + "\t" + bill.getVisits().getVisitId() + " \t \t"
					+ bill.getTotalAmount()+ "\t\t" + bill.getPaymentMode() + "\t\t"
					+ bill.getPaymentDate());
		}
	}

	public static void display() {
		System.out.println("*************BILL TABLE*************");
		System.out.println("____________________________________________________________________________");
		System.out.println("BILL ID\tVISIT ID\tTOTAL AMOUNT\tPAYMENT MODE\tPAYMENT DATE");
        System.out.println("____________________________________________________________________________");
	}

	public static void updateBill() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updating into Bill********");
		System.out.println("Enter the BillID:");
		int billId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitID:");
		int visitId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Total Amount:");
		int totalAmount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PaymentMode:");
		String paymentMode = scanner.nextLine();
		System.out.println("Enter the PaymentDate:");
		String paymentDate = scanner.nextLine();
		
		Visits visits=new Visits();
		visits.setVisitId(visitId);
		Bill bill=new Bill();
		bill.setVisits(visits);
		
		
		
        bill.setTotalAmount(totalAmount);
		bill.setPaymentMode(paymentMode);
		bill.setPaymentDate(paymentDate);

		Bill bill1 = new Bill(billId, visits, totalAmount, paymentMode, paymentDate);
		BillServiceImpl billService = new BillServiceImpl();
		billService.update(bill);
	}

	public static void deleteBill() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting into Bill********");
		System.out.println("Enter the BillID:");
		int billId = scanner.nextInt();
		scanner.nextLine();
		Bill bill = new Bill(billId, null, 0, null, null);
		BillServiceImpl billService = new BillServiceImpl();
		billService.delete(bill);
	}

	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("*******BILL DETAILS*******\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Bill Details");
			System.out.println("2. Add new Bill");
			System.out.println("3. Edit Bill Details");
			System.out.println("4. Remove from Bill");
			System.out.println("5.Search using Id");
			System.out.println("6.Generate Bill ");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllBill();
				System.out.println("\n");
				break;

			case 2:
				getAllBill();
				/*do {
					// code to be executed
					System.out.println("Do you want to insert? (y/n)");
					response = in.next().charAt(0);

					if (response == 'n') {
						break;
					} else {*/

						insertIntoBill();
						getAllBill();
					/*}
				} while (response == 'y');*/

				break;

			case 3:
				getAllBill();
				/*do {
					System.out.println("Do you want to Update? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {*/
						updateBill();
						getAllBill();
					/*}
				} while (response == 'y');*/

				break;

			case 4:
				getAllBill();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						deleteBill();
						getAllBill();
					}
				} while (response == 'y');

				break;
				
			case 5:
				getAllBill();
				do {
					System.out.println("Do you want to  Search ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						searchBill();
						//getAllBill();
					}
				} while (response == 'y');

				break;
				
			case 6:
				
				
						BillPdfGenerator.GenerateBill();
						break;

			case 7:
				System.out.println("*****THANK YOU*****");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}

		} while (condition);
	}

}

