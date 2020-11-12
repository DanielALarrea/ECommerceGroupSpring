package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.beans.Invoice;

/**
 * The DAO for invoice.
 * @author Lori White
 * @version v2 (11/12/2020)
 */
public interface InvoiceDAO {
	/**
	 * Retrieves an invoice by id.
	 * @param id the invoice id to search by
	 * @return Invoice -  the invoice found by id
	 */
	public Invoice getById(Integer id);
	/**
	 * Finds whether an invoice exists by id. 
	 * @param id the invoice id to search by
	 * @return boolean - whether an invoice exists by id
	 */
	public boolean existsById(Integer id);
	/**
	 * Retrieves a list of invoices based on a customer's id.
	 * @param customerId the customer id to search by
	 * @return List - the list of invoices based on the customer's id
	 */
	public List<Invoice> getByCustomerId(Integer customerId);
	/**
	 * Adds an invoice.
	 * @param invoice the invoice to add
	 * @return boolean - whether the invoice was added
	 */
	public boolean add(Invoice invoice);
	/**
	 * Updates the sub total of the invoice.
	 * @param invoice the invoice to update
	 * @return boolean - whether the invoice was updated
	 */
	public boolean updateSubTotal(Invoice invoice);
}
