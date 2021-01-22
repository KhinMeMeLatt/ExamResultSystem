package model;

/*
 * @author Khin Me Me Latt
 */

public class Teacher extends User{

	private String position;
	private String department;
	
	public Teacher(String id, String password) {
		super(id,password);
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
