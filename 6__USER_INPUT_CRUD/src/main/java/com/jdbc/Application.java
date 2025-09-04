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

        // List all products
        db.listAllProducts();
    }
}
