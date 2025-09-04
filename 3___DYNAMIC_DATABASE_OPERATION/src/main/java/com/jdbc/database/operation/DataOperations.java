package com.jdbc.database.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataOperations {
	
		
	
	//DI
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	//INSERTING DATA
	public void addProduct()
	{	
		String query = "INSERT INTO product VALUES(?,?,?);";
		jdbcTemplate.update(query, 13, "iphone15rpo", 100);	
	}
	

	//DELETE DATA
	public void deleteProduct()
	{	
		String query = "DELETE FROM product WHERE pid=?;";
		jdbcTemplate.update(query, 13);	
	}
	

	//UPDATE DATA
	public void updateProduct()
	{	
		String query = "UPDATE product SET price=0 WHERE pid=?;";
		jdbcTemplate.update(query, 13);	
	}
	

	
	
	

}
