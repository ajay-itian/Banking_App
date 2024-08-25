package com.bankingapplication.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String houseName;
	private String streetName;
	private String Area;
	private String City;
	private String District;
	private String State;
	private String Country;
	private Long pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String houseName, String streetName, String area, String city, String district, String state,
			String country, Long pincode) {
		super();
		this.houseName = houseName;
		this.streetName = streetName;
		Area = area;
		City = city;
		District = district;
		State = state;
		Country = country;
		this.pincode = pincode;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [houseName=" + houseName + ", streetName=" + streetName + ", Area=" + Area + ", City=" + City
				+ ", District=" + District + ", State=" + State + ", Country=" + Country + ", pincode=" + pincode + "]";
	}
	
	
	
	

}
