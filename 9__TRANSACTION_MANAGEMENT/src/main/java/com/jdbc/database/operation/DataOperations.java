package com.jdbc.database.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataOperations {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Transactional method
    @Transactional
    public void addCategoryAndProduct(int cid, String cname, int pid, String pname, int price) {
        try {
            String insertCategory = "INSERT INTO category (cid, cname) VALUES (?, ?)";
            jdbcTemplate.update(insertCategory, cid, cname);
            System.out.println("Category Added: " + cname);

            // Intentionally adding wrong price as negative to simulate failure
            if(price < 0) {
                throw new RuntimeException("Invalid price!");
            }

            String insertProduct = "INSERT INTO product (pid, pname, price, cid) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(insertProduct, pid, pname, price, cid);
            System.out.println("Product Added: " + pname);
        } catch (DataAccessException e) {
            System.err.println("Database error: " + e.getMessage());
            throw e;  // rollback transaction
        }
    }
}
