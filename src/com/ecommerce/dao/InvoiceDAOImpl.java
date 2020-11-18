package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.beans.Invoice;

/**
 * The controller for invoice.
 * @author Lori White
 * @version v2 (11/13/2020)
 */
public class InvoiceDAOImpl implements InvoiceDAO {
	@Autowired
	JdbcTemplate conn;
	public void setTemplate(JdbcTemplate conn) {
		this.conn = conn;
	}
	/**
	 * Retrieves an invoice by id.
	 * @param id the invoice id to search by
	 * @return Invoice -  the invoice found by id
	 */
	@Override
	public Invoice getById(Integer id) {
		return conn.queryForObject("select * from invoice where invoice_id = ?", new Object[]{id},new BeanPropertyRowMapper<Invoice>(Invoice.class));
	}
	/**
	 * Finds whether an invoice exists by id. 
	 * @param id the invoice id to search by
	 * @return boolean - whether an invoice exists by id
	 */
	@Override
	public boolean existsById(Integer id) {
		return (getById(id) != null);
	}
	/**
	 * Retrieves a list of invoices based on a customer's id.
	 * @param customerId the customer id to search by
	 * @return List - the list of invoices based on the customer's id
	 */
	@Override
	public List<Invoice> getByCustomerId(Integer customerId) {
		return conn.query("select * from invoice where customer_id = " + customerId, new RowMapper<Invoice>() {
			public Invoice mapRow(ResultSet rs, int row) throws SQLException {
	            return new Invoice(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
			}
		});
	}
	/**
	 * Adds an invoice.
	 * @param invoice the invoice to add
	 * @return boolean - whether the invoice was added
	 */
	@Override
	public boolean add(Invoice invoice) {
		int val = conn.update("insert into invoice (`invoice_id`, `customer_id`, `order_date`) values(" + invoice.getInvoiceId() + "," + invoice.getCustomerId() + "," + invoice.getOrderDate() + ")");
		
		if(val > 0) {
			return conn.update("{call set_tax_rate(" + invoice.getCustomerId() + ")}") > 0 ? true : false;
		}
		
		return false;
	}
	/**
	 * Updates the sub total of the invoice.
	 * @param invoice the invoice to update
	 * @return boolean - whether the invoice was updated
	 */
	@Override
	public boolean updateSubTotal(Invoice invoice) {
		return conn.update("{call set_sub_total(" + invoice.getInvoiceId() + ")}") > 0 ? true : false;
	}
}
