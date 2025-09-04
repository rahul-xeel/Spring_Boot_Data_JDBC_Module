package com.jdbc;

import java.awt.event.ContainerAdapter;

import com.jdbc.database.operation.DataOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    private final DataOperations dataOperations;

    Application(DataOperations dataOperations) {
        this.dataOperations = dataOperations;
    }

	public static void main(String[] args) {
		
		
	ApplicationContext container = 	SpringApplication.run(Application.class, args);

	      DataOperations db = (DataOperations)container.getBean("dataOperations");
	      
//	      db.addProduct();
//	      db.deleteProduct();
	      db.updateProduct();
	      
	      
	      
	
	}

}
