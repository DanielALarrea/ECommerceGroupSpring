package com.ecommerce.dao;

import com.ecommerce.beans.Address;

public interface AddressDao {

	public Address getAddress(int id);
	public Address createAddress(Address address);
	public boolean editAddress(Address address);
	public boolean deleteAddress(int id);
}
