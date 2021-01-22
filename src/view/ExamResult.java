package view;

import java.util.Scanner;

import controller.AdminController;
import controller.StudentController;
import controller.TeacherController;
import model.Admin;
import model.Student;
import model.Teacher;
import model.User;

/*
 * @author Khin Me Me Latt
 */

public class ExamResult {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to Exam Result System");
		System.out.println("Roles");
		System.out.println("1. Admin");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		System.out.println("Enter 1 or 2 or 3");
		
		int choice = scanner.nextInt();
		
		scanner.nextLine();
		System.out.println("Enter ID");
		String id = scanner.nextLine();
		System.out.println("Enter Password");
		String password = scanner.nextLine();
		
		if(choice == 1) {
			chooseAdmin(id, password);
		}
		else if(choice == 2) {
			chooseTeacher(id, password);
		}
		else {
			chooseStudent(id, password);
		}
	}
	
	private static  void chooseAdmin(String id, String password) {
		AdminController adminController = new AdminController();
		Admin admin = new Admin(id, password);

		// check admin is credential or not. Admin id and password are stored in private class within AdminController
		if(adminController.isValid(admin, "admin")) {
			adminController.showOptions(admin);
		}
		else {
			System.out.println("Sorry! You are not an admin!");
		}
	}
	
	private static void chooseTeacher(String id, String password) {
		User teacher = new Teacher(id,password);
		TeacherController teacherController = new TeacherController();
		if(teacherController.isValid(teacher, "teacherAcc")) {
			teacherController.showOptions(teacher);
		}
	}
	
	private static void chooseStudent(String id, String password) {
		User student = new Student(id, password);
		StudentController studentController = new StudentController();
		if(studentController.isValid(student,"studentAcc")) {
			studentController.showOptions(student);
		}
	}

}
