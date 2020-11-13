package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.beans.InvoiceProduct;


/**
 * The controller for invoice-product.
 * @author Lori White
 * @version v2 (11/13/2020)
 */
public class InvoiceProductDAOImpl implements InvoiceProductDAO {
	@Autowired
	JdbcTemplate conn;
	public void setTemplate(JdbcTemplate conn) {
		this.conn = conn;
	}
	/**
	 * Retrieves an invoice-product by id.
	 * @param id the invoice-product id to search for
	 * @return InvoiceProduct - the invoice-product found by id
	 */
	@Override
	public InvoiceProduct getById(Integer id) {
		return conn.queryForObject("select * from invoice_product where invoice_product_id = " + id, new Object[]{id},new BeanPropertyRowMapper<InvoiceProduct>(InvoiceProduct.class));
	}
	/**
	 * Retrieves a list of invoice-product objects by an invoice id.
	 * @param invoiceId the invoice id to search by
	 * @return List - the list of invoice-product objects by an invoice id
	 */
	@Override
	public List<InvoiceProduct> getByInvoiceId(Integer invoiceId) {
		return conn.query("select * from invoice_product where invoice_id = " + invoiceId, new RowMapper<InvoiceProduct>() {
			public InvoiceProduct mapRow(ResultSet rs, int row) throws SQLException {
	            return new InvoiceProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5), rs.getBoolean(6), rs.getInt(7));
			}
		});
	}
	/**
	 * Adds an invoice linked to a product.
	 * @param invoiceProduct the invoice linked to a product
	 * @return boolean - whether the added invoice linked to a product was added
	 */
	@Override
	public boolean add(InvoiceProduct invoiceProduct) {
		return conn.update("insert into invoice_product (`invoice_product_id`, `invoice_id`, `product_id`, `quantity`) values(" + invoiceProduct.getInvoiceProductId() + "," + invoiceProduct.getInvoiceId() + "," + invoiceProduct.getProductId() + "," + invoiceProduct.getQuantity() + ")") > 0 ? true : false;
	}
	/**
	 * Updates an invoice-product.
	 * @param invoiceProduct the invoice-product to update
	 * @param column the specific column to update or if null update all
	 * @return boolean - whether the invoice-product was updated
	 */
	@Override
	public boolean update(InvoiceProduct invoiceProduct, String column) {
		String sql = "update invoice_product set " + column + " = ";
		switch(column) {
			case "can_return":
				sql += invoiceProduct.getCanReturn();
			break;
			case "requested_return":
				sql += invoiceProduct.getRequestedReturn();
			break;
			case "amount_requested_return":
				sql += invoiceProduct.getAmountRequestedReturn();
			break;
		}
		sql += " where invoice_product_id = " + invoiceProduct.getInvoiceProductId();
		return conn.update(sql) > 0 ? true : false;
	}
	/**
	 * Updates an invoice-product based on giving the ok on a requested return.
	 * @param invoiceProduct the invoice-product to update
	 * @return boolean - whether the invoice-product was updated
	 */
	@Override
	public boolean requestedReturnValidated(InvoiceProduct invoiceProduct) {
		return conn.update("{call ok_return(" + invoiceProduct.getInvoiceProductId() + ")}") > 0 ? true : false;
	}
}
