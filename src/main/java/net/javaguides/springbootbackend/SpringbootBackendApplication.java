package net.javaguides.springbootbackend;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
}

//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Yeran");
//		employee.setLastName("Kods");
//		employee.setEmailId("yk@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Dwayne");
//		employee1.setLastName("Johnson");
//		employee1.setEmailId("dj@gmail.com");
//		employeeRepository.save(employee1);
//
//	}
//}


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


====================================================================================
Why is there three dots here ; (String... args)?

The three dots (...) in (String... args) represent varargs (variable arguments) in Java. It allows you to pass a variable number of arguments of the specified type to a method.

In the case of CommandLineRunner, the run() method accepts command-line arguments as input. The varargs parameter args allows you to pass multiple command-line arguments to the method.

Here's how it works:

When you run a Spring Boot application from the command line, you can pass additional arguments after the application name. For example:

java -jar myapp.jar arg1 arg2 arg3

The args parameter in the run() method is an array of strings that captures these command-line arguments. The varargs notation (String... args) indicates that you can pass zero or more strings as arguments.

If no additional command-line arguments are provided, args will be an empty array (args.length will be 0).
If command-line arguments are provided, they will be stored in the args array. Each argument will be represented as a separate element in the array.
For example, if you run your Spring Boot application as follows:

java -jar myapp.jar arg1 arg2 arg3


The args array in the run() method will be populated as ["arg1", "arg2", "arg3"].

By using varargs, you have the flexibility to handle different numbers of command-line arguments without explicitly specifying the size of the array. You can iterate over the args array or access specific elements based on your application's requirements.

Note: The varargs notation can be used with any type, not just String. For example, you can have a method with int... numbers to accept a variable number of integer arguments.



==============================================================================

When we want to hard code and create an employee we use the CommandLineRunner interface and implement its run method ;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}


	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Yeran");
		employee.setLastName("Kods");
		employee.setEmailId("yk@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Dwayne");
		employee1.setLastName("Johnson");
		employee1.setEmailId("dj@gmail.com");
		employeeRepository.save(employee1);

	}
}









*/
