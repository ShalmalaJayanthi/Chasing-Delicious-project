package com.bvrith.chasingdelicious.dto;

public class Hotel {
	private String hotelId ;
	private String status;
	private Admin id;
	private  String name ;
	private int phone;
	private String city;
	private  String street;
	private int pincode ;
	private  String district ;
	private  String flatno;
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getFlatno() {
		return flatno;
	}
	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Admin getId() {
		return id;
	}
	public void setId(Admin id) {
	this.id = id;
	}
	
	public Hotel(String hotelId, String name, int phone, String city, String street, int pincode, String district, String flatno, String status){
		this.hotelId = hotelId;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.street = street;
		this.flatno = flatno;
		this.pincode = pincode;
		this.status = status;
		this.district = district;
		
	}
	public Hotel() {}

}

