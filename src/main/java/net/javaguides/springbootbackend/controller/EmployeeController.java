package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //build CREATE employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //@RequestBody will basically convert a JSON into a java object

    //build GET employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " +id));
        return ResponseEntity.ok(employee);

    }
    /*
    @GetMapping("{id}"): This annotation specifies that the method handles HTTP GET requests for a specific URL pattern. In this case, the URL pattern includes a path variable {id} which represents the unique identifier of the employee.

public ResponseEntity<Employee> getEmployeeById(@PathVariable long id): This method accepts a long parameter id annotated with @PathVariable. The @PathVariable annotation is used to bind the value of the path variable from the URL to the id parameter.

Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));: This line retrieves the employee from the employeeRepository by calling the findById() method, passing in the id parameter. If the employee with the given id is not found, it throws a custom exception ResourceNotFoundException with a specific error message.

return ResponseEntity.ok(employee);: If the employee is found, this line returns a response with the HTTP status code 200 (OK) and the employee object in the response body. The ResponseEntity.ok() method is used to create a ResponseEntity instance with the specified body and status.

In summary, this controller method handles a GET request to retrieve an employee by their unique identifier. It fetches the employee from the repository based on the provided id, throws an exception if the employee is not found, and returns the employee object in the response if it exists. The response is wrapped in a ResponseEntity object, allowing you to set additional response headers and status codes if needed.

The ()-> syntax you see in the code snippet is part of a lambda expression in Java.

The ()-> represents an anonymous function or lambda function with no parameters. It's shorthand for declaring a functional interface (an interface with a single abstract method) and implementing its method on the fly.

The lambda expression is used as an argument to the orElseThrow() method, which is a method provided by the Optional class in Java. The purpose of orElseThrow() is to either return the value contained within the Optional if it exists or throw an exception if it's empty.

In this case, if the findById(id) method returns an empty Optional (meaning no employee was found with the given id), the lambda expression () -> new ResourceNotFoundException("Employee not exist with id: " + id) is executed. It creates a new instance of the ResourceNotFoundException class with a specific error message. This exception is then thrown, terminating the execution and indicating that the requested resource (employee) was not found.

The lambda expression syntax ()-> allows you to define a block of code as an inline function without explicitly creating a separate method or implementing an interface. It provides a concise way to define and use simple functions in Java.
     */


    //build UPDATE employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+ id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);

    }


    //build DELETE employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



//NOTES

/*

I have noticed many times that in @RequestMapping("/api/v1/employee")   ; the /api/v1 part is always there. whats the reason for that?


The /api/v1 part in the @RequestMapping annotation is often used as a prefix or a base path for defining API endpoints in a RESTful API. It helps to organize and version your API resources.


Here are a few reasons why the /api/v1 part is commonly used:

API Versioning: The /api/v1 prefix can indicate the version number of your API. By including the version in the URL, you can make changes to your API in a backward-compatible manner while still supporting older versions. For example, in the future, you may introduce /api/v2 for a new version of the API while keeping the existing /api/v1 endpoints intact.

Namespace: The /api/v1 prefix helps to distinguish API endpoints from other routes in your application. It provides a namespace or context for all API-related routes, making it easier to understand and maintain your codebase.

Consistency and Best Practices: Following a consistent pattern for API routes helps improve readability, maintainability, and adherence to best practices. Including the /api/v1 prefix in your routes can serve as a convention that developers can follow across different API endpoints.

Scalability and Extensibility: By using a versioned and namespaced approach like /api/v1, you can design your API in a way that allows for future expansions and additions. It provides a foundation for adding new endpoints, introducing new versions, or incorporating additional functionalities.

While the /api/v1 prefix is a common convention, it is not a strict requirement. You can choose a different prefix or omit it altogether based on your application's requirements and design decisions. The important thing is to be consistent and have a well-defined structure for your API routes.

=======================================================================

The @Autowired annotation is used in Spring to automatically wire or inject dependencies into a class. In your example, the @Autowired annotation is used to inject an instance of the EmployeeRepository interface into the employeeRepository field.

Here's how it works:

When Spring initializes the class containing the @Autowired annotation (typically a Spring-managed component or bean), it scans the application context for a bean that matches the type of the annotated field (EmployeeRepository in this case).

If a bean of the required type is found, Spring automatically wires or injects that bean into the annotated field. The injected instance can then be used to access the functionality provided by the EmployeeRepository.

Here's an example of how the @Autowired annotation is typically used:

@Repository // Assuming EmployeeRepository is annotated with @Repository
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Rest of the class

}


In this example, the EmployeeService class is annotated with @Repository, indicating that it is a Spring-managed repository component. The employeeRepository field is marked with @Autowired, and Spring injects an instance of the EmployeeRepository bean into it.

By using @Autowired, you can delegate the responsibility of instantiating and managing dependencies to the Spring framework. It helps to decouple components and enables easy integration of different parts of your application.


=============================================================================================

The @RequestBody annotation in Spring is used to bind the HTTP request body to a method parameter in a controller handler method. It is commonly used in RESTful web services to extract data from the request body and convert it into an object.

When a request is made to a Spring controller method, the @RequestBody annotation tells Spring to bind the contents of the request body to the annotated parameter. Spring automatically performs the conversion based on the content type of the request, such as JSON or XML.

Here's an example:

@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User user) {
    // Process the user object received from the request body
    // ...
    return ResponseEntity.ok(user);
}

In this example, the createUser method handles a POST request to the "/users" endpoint. The @RequestBody annotation is applied to the User parameter, indicating that the user data should be extracted from the request body and mapped to the User object.

When a POST request is sent to this endpoint with a JSON body containing user data, Spring automatically converts the JSON payload into a User object and binds it to the user parameter.

The @RequestBody annotation can be used with different types of parameters, such as custom Java objects, collections, or simple types like strings and numbers. It simplifies the process of extracting request data and avoids manual parsing and conversion.

It's important to note that the @RequestBody annotation is typically used in combination with other annotations, such as @PostMapping, to define the request mapping and HTTP method for the controller method.

Overall, @RequestBody helps in processing the request body data in a convenient and type-safe manner, allowing you to work with complex objects seamlessly in your Spring controllers.



 */