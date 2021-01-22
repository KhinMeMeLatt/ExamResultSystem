package controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import model.User;

/*
 * @author Khin Me Me Latt
 */

public abstract class UserController {

	public boolean isValid(User user, String accType) {
		Map<String, String[]> accountList = new LinkedHashMap<String, String[]>();
		try {
			FileReaderController account = new FileReaderController();
			
			//read entire accounts file
			//accType is file name
			if((accountList = account.readAcc(accType)) != null) {
				String[] accountDetail = accountList.get(user.getId());
				if((accountDetail != null ) && user.getPassword().equals(accountDetail[1])) {
					System.out.println("Hello "+accountDetail[0]);
					return true;
				}
				else {
					System.out.println("Credentials do not match");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void logout(User user) {
		//when user log out, system clears id, name and password of the user
		user.setId("");
		user.setName("");
		user.setPassword("");
		System.out.println("Bye Bye!");
	}
	
	abstract void showOptions(User user);
}
