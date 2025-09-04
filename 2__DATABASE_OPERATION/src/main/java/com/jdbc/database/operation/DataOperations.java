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
		String query = "INSERT INTO product VALUES(13,'iphone15rpo',100);";
		jdbcTemplate.update(query);	
	}
	
	
	//DELETING DATA
	public void deleteProduct()
	{
		String query = "DELETE FROM product WHERE pid = '12'";
		jdbcTemplate.update(query);	
	}
	
	//UPDATING DATA
	public void updatingProduct()
	{
		String query = "UPDATE product SET price = 1700 WHERE pid = 12";
		jdbcTemplate.update(query);	
	}
	
	
	
	

}
