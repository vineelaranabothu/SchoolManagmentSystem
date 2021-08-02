package com.example.demo.school.Model;

public class Person {
	private String name;
    private int age;
    private String gender;
    private String contact;
    private String address;
    
	public Person() {
		
	}
	public Person(String name, int age, String gender, String contact, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
