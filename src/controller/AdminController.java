package controller;

import java.io.IOException;
import java.util.Scanner;
import model.User;

/*
 * @author Khin Me Me Latt
 */

public class AdminController extends UserController {
	
	Scanner scanner = new Scanner(System.in);

	@Override
	public boolean isValid(User user, String accType) {
		String id = user.getId();
		String password = user.getPassword();
		AdminPasswordManager adminLogin = new AdminPasswordManager();
		return adminLogin.isCredential(id, password);
	}
	
	@Override
	public void showOptions(User admin) {
		System.out.println("Hello Admin!");
		int choice;
		
		//Admin can create new teacher account or student account until logout
		do {
			System.out.println("1. Create New Teacher Account");
			System.out.println("2. Create New Student Account");
			System.out.println("3. Log out");
			System.out.println("Enter 1 or 2 or 3");
			
			choice = scanner.nextInt();
			switch(choice) {
				//Create New Teacher Account
				case 1:
					createNewAccount("Teacher", "teacherAcc");
					break;
				
				//Create New Student Account
				case 2:
					createNewAccount("Student","studentAcc");
					break;
					
				case 3:
					super.logout(admin);
					break;
				//Log out
				default:
					System.out.println("Please Enter a number between 1 and 3");
			}
		}while(choice != 3);
	}
	
	private void createNewAccount(String role, String fileName) {
		User user = new User();
		
		scanner.nextLine();
		System.out.println("Enter "+role+" ID");
		user.setId(scanner.nextLine());
		System.out.println("Enter "+role+" Name");
		user.setName(scanner.nextLine());
		System.out.println("Enter Default Password");
		user.setPassword(scanner.nextLine());
		
		try {
			FileWriterController newStudentAccount = new FileWriterController();
			newStudentAccount.createNewAcc(user, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//this class is for storage of admin id and password
	private class AdminPasswordManager {
		String id = "admin-1";
		String password = "admin";
		
		public boolean isCredential(String id, String password) {
			if(this.id.equals(id) && this.password.equals(password)) {
				return true;
			}
			return false;
		}
	}
}
