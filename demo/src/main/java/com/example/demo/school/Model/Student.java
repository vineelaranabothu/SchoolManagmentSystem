package com.example.demo.school.Model;

public class Student extends Person {
	private String rollno;
    private int grade;
  	
	public Student() {
		super();
	}
	public Student(String name, int age, String gender, String contact, String address ,String rollno ,int grade) {
		super(name, age, gender, contact, address);
		this.rollno = rollno;
		this.grade = grade;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
