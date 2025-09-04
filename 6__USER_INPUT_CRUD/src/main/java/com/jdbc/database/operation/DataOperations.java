package com.jdbc.database.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DataOperations {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // LIST ALL PRODUCTS
    public void listAllProducts() {
        String query = "SELECT * FROM product";

        // queryForList → List of Map (each row = one Map)
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        // Loop and print
        for (Map<String, Object> row : rows) {
            System.out.println(
                    "PID: " + row.get("pid") +
                    ", Name: " + row.get("pname") +
                    ", Price: " + row.get("price")
            );
        }
    }
}
