package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//All CRUD Database methods
}

//NOTES
/*
is long and Long different in java ?

Yes, long and Long are different in Java.

long is a primitive data type in Java that represents a 64-bit signed integer. It can hold integer values ranging from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807. It is a lowercase keyword in Java and is used to declare variables of the long type.

Long is a wrapper class in Java that serves as an object representation of the long primitive type. It provides utility methods and allows the long primitive to be used in collections and with other Java APIs that require objects. Long has methods to perform conversions, calculations, and other operations on long values. It also provides constants and static methods for working with long values.

 Here's an example to illustrate the difference:

long primitiveLong = 123456789L; // lowercase "long" is a primitive type
Long objectLong = Long.valueOf(987654321L); // "Long" is a wrapper class

In the example, primitiveLong is a variable of type long that holds a primitive long value. On the other hand, objectLong is a variable of type Long that holds an instance of the Long class, which wraps a long value.

In summary, long is a primitive data type, while Long is its corresponding wrapper class in Java.

 */