package com.ecommerce.dao;

import com.ecommerce.beans.Address;

public interface AddressDao {

	public Address getAddress(int id);
	public Address getByStreetAndZipcode(String street, String zipcode);
	public Address createAddress(Address address);
	public Address editAddress(Address address);
	public boolean deleteAddress(int id);
}
