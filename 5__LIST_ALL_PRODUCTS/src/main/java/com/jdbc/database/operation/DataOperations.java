package com.jdbc.database.operation;

import com.jdbc.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataOperations {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Fetch all products
    public List<Product> getAllProducts() {
        String query = "SELECT * FROM product";

        return jdbcTemplate.query(query, (rs, rowNum) ->
                new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getInt("price")
                )
        );
    }
}
