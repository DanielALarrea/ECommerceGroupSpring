package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	public Address getByStreetAndZipcode(String street, String zipcode) {
		String query = "select * from address where street = '" + street + "' and zip_code = '" + zipcode + "'";
		try {
			return template.queryForObject(query, new RowMapper<Address>(){

				@Override
				public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Address(rs.getInt("address_id"), rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getString("zip_code"));
				}

			});
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Address createAddress(Address a) {
		String query = "insert into address(street, city, state, zip_code) values('"
				+ a.getStreet() + "', '"
				+ a.getCity() + "', '" + a.getState() + "', '"
				+ a.getZipCode() + "')";
		template.update(query);
		return getByStreetAndZipcode(a.getStreet(), a.getZipCode());
	}

	@Override
	public Address editAddress(Address a) {
		String query = "update address set street='"+a.getStreet()
			+"', city='"+a.getCity()+"', state='"+a.getState()+"', zip_code='"+a.getZipCode()
			+"' where address_id=" + a.getAddressId();
		template.update(query);
		return getAddress(a.getAddressId());
	}

	@Override
	public boolean deleteAddress(int id) {
		String query = "delete from address where address_id=" + id;
		return template.update(query) != 0;
	}

}
