package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * @author Khin Me Me Latt
 */

public class FileReaderController {

	protected Map<String, String[]> readAcc(String accType) throws IOException {
		File file = new File("src/assets/"+accType+".txt");
		if(file.exists()) {
			BufferedReader accountReader = new BufferedReader(new FileReader(file));
			String line;
			Map<String, String[]> account = new LinkedHashMap<String, String[]>();
			while((line = accountReader.readLine()) != null) {
				String[] accounts = line.split(",");
				account.put(accounts[0], new String[]{accounts[1], accounts[2]});
			}
			accountReader.close();
			return account;
		}
		System.out.println("Sorry! The account file doesn't exist!");
		return null;
	}
	
	protected void readMarks(String studentID) throws FileNotFoundException {
		File marksFile = new File("src/assets/marks.txt");
		Scanner scanner = new Scanner(marksFile);
		if(studentID == null) {
			System.out.println("ID Myanmar English Maths Chemistry Physics Biology");
		}
		
		while(scanner.hasNextLine()) {
			if(studentID == null) {
				System.out.println(scanner.nextLine().replace(",", " "));
			}
			else {
				String marksRecord = scanner.nextLine();
				if(marksRecord.contains(studentID)) {
					System.out.println(marksRecord);
					String[] marks = marksRecord.split(",");
					String[] colName = {"ID","Myanmar","English","Maths","Chemistry","Physics","Biology"};
					int index = 0;
					for(String mark : marks) {
						System.out.println(colName[index]+": "+mark);
						index++;
					}
				}
				break;
			}
		}
		scanner.close();
	}
}
