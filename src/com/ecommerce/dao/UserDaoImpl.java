package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.beans.Address;
import com.ecommerce.beans.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private AddressDao addressDB;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<User> getAllUsers() {
		return template.query("select * from customer", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Address billingAddress = addressDB.getAddress(rs.getInt("address_id"));
				billingAddress.setAddressId(rs.getInt("address_id"));
				User u = new User(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("full_name"), rs.getString("email"),
						rs.getString("username"), rs.getString("password"), User.ROLE.valueOf(rs.getNString("role").toUpperCase()),
						billingAddress, rs.getString("phone_number"));
				u.setId(rs.getInt("customer_id"));
				return u;
			}

		});
	}

	@Override
	public User getUser(int userId) {
		String query = "select * from customer where customer_id=?";
		return template.queryForObject(query, new Object[] {userId}, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User getUser(String email) {
		String query = "select * from customer where email=?";
		return template.queryForObject(query, new Object[] {email}, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public boolean userExists(int id) {
		return getUser(id) != null;
	}

	@Override
	public User addUser(User u) {		
		String query = "insert into customer(username, password, first_name, last_name, email, phone_number, address_id, role) values('"
				+ u.getUsername() + "', '" + u.getUserPass() + "', '" + u.getFirstName() + "', '" + u.getLastName() + "', '" + u.getUserEmail() + "', '"
				+ u.getPhone() + "', " + u.getBillingAddress().getAddressId() + ", '" 
				+ u.getUserRole().toString().toLowerCase() + "')";
		template.update(query);
		return getUser(u.getUserEmail());
	}

	@Override
	public boolean editUser(User u, String column) {
		String query = "update customer set " + column + " = ";
		
		switch(column) {
			case "username":
				query += "'" + u.getUsername() + "'";
			break;
			case "password":
				query += "'" + u.getUserPass() + "'";
			break;
			case "first_name":
				query += "'" + u.getFirstName() + "'";
			break;
			case "last_name":
				query += "'" + u.getLastName() + "'";
			break;
			case "email":
				query += "'" + u.getUserEmail() + "'";
			break;
			case "phone_number":
				query += "'" + u.getPhone() + "'";
			break;
			case "address_id":
				query += u.getBillingAddress().getAddressId();
			break;
		}
		
		query += " where customer_id = " + u.getId();
		return template.update(query) != 0;
	}

	@Override
	public boolean deleteUser(int id) {
		String query = "delete from customer where customer_id=" + id;
//		addressDB.deleteAddress((int) user.getBillingAddress().getId());
		return template.update(query) != 0;
	}

}
