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
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Product> getAllProducts() {
		return template.query("select * from product", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product p = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("top_image"), rs.getString("description"),
										rs.getDouble("price"), rs.getInt("stock"), rs.getBoolean("in_stock"));
	            return p;
			}
		});
	}

	public Product getProductById (int id) {
		String sql = "select * from product where product_id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));
	}

	public void addProduct(Product p) {
		String sql = "insert into product(name, top_image, description, price, stock) "
				   + "values('" + p.getName() + "', '" + p.getImagePath() + "', '" + p.getDescription() 
				   + "', " + p.getPrice() + ", " + p.getStock() + ")";
		template.update(sql);
	}

	public void editProduct(Product p) {
		String sql = "update product set name='" + p.getName() + "', top_image='" + p.getImagePath() + "', description='" + p.getDescription()
			+ "', price=" + p.getPrice() + ", stock=" + p.getStock() + " where product_id=" + p.getId();
		template.update(sql);
	}

	public void deleteProduct(int id) {
		String sql = "delete from product where product_id="+id+"";
		template.update(sql);
	}

}
