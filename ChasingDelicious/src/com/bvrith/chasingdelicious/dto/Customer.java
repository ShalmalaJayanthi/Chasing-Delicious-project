package com.bvrith.chasingdelicious.dto;

public class Customer {
	private String name;
	private String id;
	private int phone;
	private String location;
	private String gender;
	private String gmail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhoneNo(int phoneNo) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	public Customer(String Name, String Id, int phone, String location, String gender, String gmail){
		this.name = Name;
		this.id = Id;
		this.location = location;
		this.gender = gender;
		this.gmail = gmail;
	}
	
	public Customer() {
		
	}
}
