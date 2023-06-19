package net.javaguides.springbootbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}


//NOTES

/*
The CommandLineRunner interface in Spring Boot is used to run specific code after the Spring application context has been fully initialized. It provides a callback method run() that gets executed when the application starts.

Here's how you can use CommandLineRunner:

Implement the CommandLineRunner interface in a Spring component or bean. This can be done by creating a class and implementing the run() method.


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // Code to be executed after the application context has been initialized
        // This code will run when the application starts
        System.out.println("Application started!");
    }
}


In this example, the MyCommandLineRunner class implements the CommandLineRunner interface and overrides the run() method. The code inside the run() method will be executed when the application starts.

Spring will automatically detect the CommandLineRunner bean and execute the run() method.
The CommandLineRunner interface is useful in scenarios where you need to perform certain initialization tasks or execute specific code once the application context is fully set up. For example, you can use it to initialize database connections, load initial data, start background tasks, or perform any other operations that should happen during application startup.

You can have multiple implementations of the CommandLineRunner interface in your application, and they will be executed in the order defined by the @Order annotation or by implementing the Ordered interface.

Note: The CommandLineRunner interface is specific to Spring Boot and provides a convenient way to execute code during application startup. In regular Spring applications, you can use the ApplicationRunner interface, which has a similar purpose but provides a different callback method (run(ApplicationArguments args)) with additional functionality for parsing command-line arguments.
*/
