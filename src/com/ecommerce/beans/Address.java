package com.ecommerce.beans;

import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private float addressId;

	private String street;
	private int apartmentNumber;
	private String city;
	private String state;
	private String zipCode;
	
	public Address() {
		
	}

	public Address(String street, String city, String state, String zipCode, int apartmentNumber) {
		super();
		this.street = street;
		this.apartmentNumber = apartmentNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public Address(float addressId, String street, int apartmentNumber, String city, String state, String zipCode) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.apartmentNumber = apartmentNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public float getId() {
		return addressId;
	}

	public void setId(float id) {
		this.addressId = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
