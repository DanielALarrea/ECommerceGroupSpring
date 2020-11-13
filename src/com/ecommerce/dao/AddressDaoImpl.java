package com.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.beans.Address;

public class AddressDaoImpl implements AddressDao {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Address getAddress(int id) {
		String query = "select * from address where address_id=";
		return template.queryForObject(query, new Object[] { id }, new BeanPropertyRowMapper<Address>(Address.class));
	}

	@Override
	public Address createAddress(Address a) {
		String query = "insert into address(street, city, state, zip_code) values("
				+ a.getStreetName() + " " + a.getApartmentNumber() + ","
				+ a.getCityName() + "," + a.getStateName() + ","
				+ a.getZipCode() + ")";
		template.update(query);
		return getAddress((int) a.getId());
	}

	@Override
	public Address editAddress(Address a) {
		String query = "update address set street='"+a.getStreetName()+" "+a.getApartmentNumber()
			+"', city='"+a.getCityName()+"', state='"+a.getStateName()+"', zip_code='"+a.getZipCode()
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
