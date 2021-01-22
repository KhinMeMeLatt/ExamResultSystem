package controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import model.User;

/*
 * @author Khin Me Me Latt
 */

public class StudentController extends UserController implements MarksController {

	FileReaderController readMarks = new FileReaderController();
	@Override
	public void showMarks(String studentID) {
		try {
			readMarks.readMarks(studentID);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void showOptions(User student) {
		int choice;
		do {
			System.out.println("1. Show Marks");
			System.out.println("2. Logout");
			System.out.println("Enter 1 or 2");
			
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			switch(choice) {
				case 1:
					showMarks(student.getId());
					break;
				case 2:
					super.logout(student);
					break;
				default:
					System.out.println("Please Enter 1 or 2");
			}
		}while(choice != 2);
		
	}

}
