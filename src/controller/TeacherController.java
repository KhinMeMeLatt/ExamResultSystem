package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Student;
import model.User;

/*
 * @author Khin Me Me Latt
 */

public class TeacherController extends UserController implements MarksController{

	Scanner scanner = new Scanner(System.in);
	FileReaderController readFiles = new FileReaderController();
	
	@Override
	public void showMarks(String studentID) {
		try {
			readFiles.readMarks(studentID);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void showOptions(User teacher) {
		int choice;
		do {
			System.out.println("1. Insert Students' Marks");
			System.out.println("2. Show All Students' Marks");
			System.out.println("3. Search A Student Marks By ID");
			System.out.println("4. Logout");
			System.out.println("Enter a number between 1 and 4");
			
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
				case 1:
					insertMarks();
					break;
				case 2:
					showMarks(null);
					break;
				case 3:
					searchMarksByStudentID();
					break;
				case 4:
					super.logout(teacher);
					break;
				default:
					System.out.println("Please Enter a number between 1 and 4");
			}
		}while(choice != 4);
		
	}
	
	private void searchMarksByStudentID() {
		System.out.println("Enter Student ID");
		showMarks(scanner.nextLine());
	}

	public void insertMarks() {
		Student student = new Student();
		String hasNextRecord = "";
		do {
			System.out.println("Enter Student ID");
			student.setId(scanner.nextLine());
			System.out.println("Enter Myanmar Marks");
			student.setMyanmarMark(scanner.nextInt());
			System.out.println("Enter English Marks");
			student.setEnglish_Mark(scanner.nextInt());
			System.out.println("Enter Maths Marks");
			student.setMaths_Mark(scanner.nextInt());
			System.out.println("Enter Chemistry Marks");
			student.setChemisty_Mark(scanner.nextInt());
			System.out.println("Enter Physics Marks");
			student.setPhysics_Mark(scanner.nextInt());
			System.out.println("Enter Biology Marks");
			student.setBiology_Mark(scanner.nextInt());
			scanner.nextLine();
			FileWriterController marksWriter = new FileWriterController();
			try {
				marksWriter.insertMark(student);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to enter next record?(Y/N)");
			hasNextRecord = scanner.nextLine();
		}while(hasNextRecord.equalsIgnoreCase("Y"));
		
	}

}
