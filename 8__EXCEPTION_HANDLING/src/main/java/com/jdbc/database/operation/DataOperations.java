package com.jdbc.database.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataOperations {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Insert Category with exception handling
    public void addCategory(int cid, String cname) {
        String query = "INSERT INTO category (cid, cname) VALUES (?, ?)";
        try {
            jdbcTemplate.update(query, cid, cname);
            System.out.println(" Category Added: " + cname);
        } catch (DataAccessException e) {
            System.err.println(" Error adding category: " + e.getMessage());
            throw e;  // rethrow or handle as needed
        }
    }

    // Insert Product with exception handling
    public void addProduct(int pid, String pname, int price, int cid) {
        String query = "INSERT INTO product (pid, pname, price, cid) VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(query, pid, pname, price, cid);
            System.out.println(" Product Added: " + pname);
        } catch (DataAccessException e) {
            System.err.println(" Error adding product: " + e.getMessage());
            throw e;
        }
    }
}
