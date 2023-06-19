package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
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








 */