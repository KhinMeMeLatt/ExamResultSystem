package model;

/*
 * @author Khin Me Me Latt
 */

public class Student extends User {

	private int myanmarMark;
	private int english_Mark;
	private int maths_Mark;
	private int chemisty_Mark;
	private int physics_Mark;
	private int biology_Mark;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String password) {
		super(id, password);
	}
	public int getMyanmarMark() {
		return myanmarMark;
	}

	public void setMyanmarMark(int myanmarMark) {
		this.myanmarMark = myanmarMark;
	}

	public int getEnglish_Mark() {
		return english_Mark;
	}

	public void setEnglish_Mark(int english_Mark) {
		this.english_Mark = english_Mark;
	}

	public int getMaths_Mark() {
		return maths_Mark;
	}

	public void setMaths_Mark(int maths_Mark) {
		this.maths_Mark = maths_Mark;
	}

	public int getChemisty_Mark() {
		return chemisty_Mark;
	}

	public void setChemisty_Mark(int chemisty_Mark) {
		this.chemisty_Mark = chemisty_Mark;
	}

	public int getPhysics_Mark() {
		return physics_Mark;
	}

	public void setPhysics_Mark(int physics_Mark) {
		this.physics_Mark = physics_Mark;
	}

	public int getBiology_Mark() {
		return biology_Mark;
	}

	public void setBiology_Mark(int biology_Mark) {
		this.biology_Mark = biology_Mark;
	}
}
