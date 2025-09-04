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

    // Insert Category
    public void addCategory(int cid, String cname) {
        String query = "INSERT INTO category (cid, cname) VALUES (?, ?)";
        jdbcTemplate.update(query, cid, cname);
        System.out.println("Category Added: " + cname);
    }

    // Insert Product with category
    public void addProduct(int pid, String pname, int price, int cid) {
        String query = "INSERT INTO product (pid, pname, price, cid) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, pid, pname, price, cid);
        System.out.println("Product Added: " + pname);
    }

    // Select Products with JOIN
    public void listProductsWithCategory() {
        String query = "SELECT p.pid, p.pname, p.price, c.cname " +
                       "FROM product p INNER JOIN category c ON p.cid = c.cid";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        System.out.println("\n===== PRODUCTS WITH CATEGORY =====");
        for (Map<String, Object> row : rows) {
            System.out.println(
                "ID: " + row.get("pid") +
                " | Name: " + row.get("pname") +
                " | Price: " + row.get("price") +
                " | Category: " + row.get("cname")
            );
        }
    }
}
