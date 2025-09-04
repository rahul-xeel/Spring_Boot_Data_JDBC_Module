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

        try {
            db.addCategory(1, "Electronics");
            db.addCategory(1, "Duplicate Category");  // This will cause duplicate key error
        } catch (Exception e) {
            System.out.println(" Exception caught in main: " + e.getMessage());
        }

        try {
            db.addProduct(101, "iPhone 16", 120000, 99);  // 99 is invalid category id, FK constraint fail
        } catch (Exception e) {
            System.out.println(" Exception caught in main: " + e.getMessage());
        }
    }
}
