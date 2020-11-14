package com.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.beans.Address;

public class AddressDaoImpl implements AddressDao {

	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Address getAddress(int id) {
		String query = "select * from address where address_id=?";
		return template.queryForObject(query, new Object[] { id }, new BeanPropertyRowMapper<Address>(Address.class));
	}
	
	@Override
	public Address getMostRecentAddress() {
		String query = "select * from address where address_id=(select MAX(address_id) from address)";
		return template.queryForObject(query, new BeanPropertyRowMapper<Address>(Address.class));
	}

	@Override
	public Address createAddress(Address a) {
		String query = "insert into address(street, city, state, zip_code) values('"
				+ a.getStreet() + " " + a.getApartmentNumber() + "', '"
				+ a.getCity() + "', '" + a.getState() + "', '"
				+ a.getZipCode() + "')";
		template.update(query);
		return getMostRecentAddress();
	}

	@Override
	public Address editAddress(Address a) {
		String query = "update address set street='"+a.getStreet()+" "+a.getApartmentNumber()
			+"', city='"+a.getCity()+"', state='"+a.getState()+"', zip_code='"+a.getZipCode()
			+"' where address_id=" + a.getId();
		template.update(query);
		return getAddress((int) a.getId());
	}

	@Override
	public boolean deleteAddress(int id) {
		String query = "delete from address where address_id=" + id;
		return template.update(query) != 0;
	}

}
