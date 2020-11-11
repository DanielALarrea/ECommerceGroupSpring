package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.beans.Product;

public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Product> getAllProducts() {
		return template.query("select * from products", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product p = new Product(rs.getString("productname"), rs.getString("productdescription"), 
										rs.getFloat("productprice"), rs.getString("productimagepath"));
				p.setId(rs.getInt("productid"));
	            return p;
			}
		});
	}

	public Product getProductById (int id) {
		String sql = "select * from products where productid=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));
	}

	public void addProduct(Product p) {
		String sql = "insert into products(productname, productdescription, productprice, productimagepath) "
				   + "values('" + p.getProductName() + "', '" + p.getProductDescription() + "', '" + p.getProductPrice() + "', '" +p.getProductImagePath() + "')";
		template.update(sql);
	}

	public void editProduct(Product p) {
		String sql = "update products set productname='" + p.getProductName() + "', productdescription='" + p.getProductDescription() 
				   + "', productprice=" + p.getProductPrice() + ", productimagepath='" + p.getProductImagePath() + "' where productid=" + p.getId();
		template.update(sql);
	}

	public void deleteProduct(int id) {
		String sql = "delete from products where productid="+id+"";
		template.update(sql);
	}

}
