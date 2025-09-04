package com.jdbc.database.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataOperations {
	
		
	
	//DI
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	//INSERTING DATA
	public void selectProduct()
	{	
		System.out.println();
		System.out.println("************************************************************");
		System.out.println();
		
		
//		String query = "SELECT * FROM product;";
//		List<Product_Details> allproducts = jdbcTemplate.query(query, new BeanPropertyRowMapper<Product_Details>(Product_Details.class));	

		String query = "SELECT * FROM product WHERE pid = ?;";
		List<Product_Details> allproducts = jdbcTemplate.query(query, new BeanPropertyRowMapper<Product_Details>(Product_Details.class), 12);	

		
		
		allproducts.forEach(product -> {
		
			
			System.out.print(product.getPid() + "  ");
			System.out.print(product.getPname() + "  ");
			System.out.print(product.getPrice());
			
			System.out.println();
			
		});
		
		System.out.println();
		System.out.println("************************************************************");
		System.out.println();
	
	}
	
	

}
