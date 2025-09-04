package com.jdbc;

import com.jdbc.database.operation.DataOperations;
import com.jdbc.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext container = SpringApplication.run(Application.class, args);

        DataOperations db = container.getBean(DataOperations.class);

        List<Product> products = db.getAllProducts();
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
