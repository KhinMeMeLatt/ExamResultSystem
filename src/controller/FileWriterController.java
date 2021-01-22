package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.Student;
import model.User;

/*
 * @author Khin Me Me Latt
 */

public class FileWriterController {

	protected void createNewAcc(User user, String fileName) throws IOException {
		BufferedWriter accountWriter = new BufferedWriter(new FileWriter("src/assets/"+fileName+".txt",true));
		accountWriter.write(user.getId()+","+user.getName()+","+user.getPassword()+"\n");
		accountWriter.close();
		String role = (fileName.equals("studentAcc")) ? "Student" : "Teacher";
		System.out.println("New "+role+" Account Created Successfully!");
	}
	
	protected void insertMark(Student student) throws IOException {
		BufferedWriter marksWriter = new BufferedWriter(new FileWriter("src/assets/marks.txt",true));
		marksWriter.write(
				student.getId()+","+student.getMyanmarMark()+","
				+student.getEnglish_Mark()+","+student.getMaths_Mark()+","
				+student.getChemisty_Mark()+","+student.getPhysics_Mark()+","
				+student.getBiology_Mark()+"\n"
				);
		marksWriter.close();
		System.out.println("New record is saved!");
	}
	
}
