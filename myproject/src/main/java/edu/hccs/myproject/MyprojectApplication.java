package edu.hccs.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class MyprojectApplication {

	private static void extracted(ConfigurableApplicationContext context) throws IOException {

		StudentController bookController = context.getBean(StudentController.class);
		System.out.println(" students "+ studentController.readData());
	}

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
		extracted(context);
	}

}
