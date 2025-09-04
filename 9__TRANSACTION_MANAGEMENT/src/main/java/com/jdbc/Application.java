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
            db.addCategoryAndProduct(10, "Sports", 201, "Football", 5000);
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
