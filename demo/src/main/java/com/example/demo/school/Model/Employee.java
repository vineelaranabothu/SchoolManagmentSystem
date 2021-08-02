package com.example.demo.school.Model;

public class Employee extends Person {
	private long empID;
	private String department;
    private long salary;
    private String designation;
	public Employee() {
		super();
		
	}
	public Employee(String name,int age,String gender,String contact,String address,long empID, String department, long salary, String designation) {
		super(name,age,gender,contact,address);
		this.empID = empID;
		this.department = department;
		this.salary = salary;
		this.designation = designation;
	}
	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
