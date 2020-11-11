package com.ecommerce.beans;

import javax.persistence.*;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private float addressId;
	
	private String streetName;
	private int apartmentNumber;
	private String cityName;
	private String stateName;
	
	public Address(String streetName, int apartmentNumber, String cityName, String stateName) {
		super();
		this.streetName = streetName;
		this.apartmentNumber = apartmentNumber;
		this.cityName = cityName;
		this.stateName = stateName;
	}

	public float getId() {
		return addressId;
	}

	public void setId(float id) {
		this.addressId = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
