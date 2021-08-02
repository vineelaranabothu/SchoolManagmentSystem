package com.example.demo.school.Model;

public class Teacher extends Employee
{
	private String subject;

	public Teacher() {
		super();
		
	}
 
	public Teacher(String name,int age,String gender,String contact,String address,long empID, String department, long salary, String designation,String teacher, String subject) {
		super(name,age,gender,contact,address,empID,department,salary,designation);
		this.subject = subject;
		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
