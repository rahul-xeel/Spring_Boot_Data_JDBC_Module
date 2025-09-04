package com.jdbc;

import com.jdbc.database.operation.DataOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext container = SpringApplication.run(Application.class, args);
        DataOperations db = container.getBean(DataOperations.class);

        // Sample operations
        db.addCategory(1, "Electronics");
        db.addCategory(2, "Clothing");

        db.addProduct(101, "iPhone 16", 120000, 1);
        db.addProduct(102, "T-Shirt", 1500, 2);

        db.listProductsWithCategory();
    }
}
