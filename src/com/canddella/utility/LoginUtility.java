package com.canddella.utility;

import java.sql.SQLException;
import java.util.Scanner;

import com.canddella.dao.LoginDAO;

public class LoginUtility {
	
	public static void main(String[] args) {
		checkLogin();
	}

	public static void checkLogin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("**User Login Credentials*");
		System.out.println("-------------------------------");
		System.out.println();

		System.out.println("Enter the User Name :");
		String userName = scanner.nextLine();
		System.out.println("Enter the Password :");
		String password = scanner.nextLine();

		LoginDAO loginDao = new LoginDAO();
		boolean isLoginValid;
		try {
			isLoginValid = loginDao.findByUsernameAndPassword(userName, password);
			if (isLoginValid) {
				MainMenuUtility.MainMenu();
				
			} else {
				System.out.println("Incorrect Login credentials. Try again");
				System.out.println();
				checkLogin();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
	/*static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		checkLogin();
	}

	public static boolean checkLogin() {
		System.out.println("LOGIN");
		System.out.println("__________");
		System.out.println();
		
		System.out.println("User Name : ");
		String userName = scanner.nextLine();
		
		System.out.println("Password : ");
		String password = scanner.nextLine();
		
		if(userName.equals( "VET234")  && password.equals( "vet234")) {
			System.out.println("You are Logged In Successfully....");
			System.out.println();
			return true;
		}
		else {
			System.out.println("Incorrect UserName or Password...");
			System.out.println();
			return false;
		}
		
		
	}

}*/
