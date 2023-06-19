package net.javaguides.springbootbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;
    //if u didnt use the @Column, then the JPA will assign the property name as the column name.
}


//NOTES

/*
In the context of Hibernate and Spring, the @Table annotation is used to specify the details of the database table associated with an entity class. It is typically placed on the entity class itself or on its superclass if inheritance is involved. The @Table annotation allows you to customize the table name, schema, and other table-related properties.

Here are some common attributes of the @Table annotation:

name: This attribute specifies the name of the database table associated with the entity. By default, Hibernate uses the class name as the table name, but you can override it by providing a different name using the name attribute. For example: @Table(name = "users").

schema: If your database supports schemas, you can use the schema attribute to specify the schema name. For example: @Table(name = "users", schema = "public").

catalog: If your database supports catalogs, you can use the catalog attribute to specify the catalog name. For example: @Table(name = "users", catalog = "mydb").

uniqueConstraints: This attribute allows you to define unique constraints on the table. You can specify one or more columns that should have unique values using the @UniqueConstraint annotation. For example:

@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"}),
    @UniqueConstraint(columnNames = {"email"})
})

indexes: The indexes attribute allows you to define indexes on the table. You can specify one or more columns to be included in an index using the @Index annotation. For example:

@Table(name = "users", indexes = {
    @Index(columnList = "username"),
    @Index(columnList = "email")
})

These are some of the commonly used attributes of the @Table annotation. By using this annotation, you can customize the mapping between your entity class and the corresponding database table, including the table name, schema, unique constraints, and indexes.
======================================================================================


The @GeneratedValue annotation with GenerationType.IDENTITY strategy is typically used in Hibernate to generate primary key values for entities automatically. It is commonly applied to the field or property that represents the primary key of an entity class.

Here's an explanation of the @GeneratedValue(strategy = GenerationType.IDENTITY) annotation and its use:

@GeneratedValue: This annotation is used to indicate that the value of the annotated field or property should be automatically generated.

strategy: The strategy attribute specifies the strategy to be used for generating the primary key value. In this case, GenerationType.IDENTITY is used, which is specifically for databases that support auto-incrementing columns.

GenerationType.IDENTITY: This strategy relies on an auto-incrementing column in the database. When a new row is inserted into the table, the database generates a unique primary key value automatically, without the need for any additional logic or code in the application.

By using @GeneratedValue(strategy = GenerationType.IDENTITY), Hibernate will automatically assign a unique primary key value to the entity object when it is saved to the database. The actual generation of the primary key value is handled by the database itself.

Here's an example usage of @GeneratedValue(strategy = GenerationType.IDENTITY):

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields and getters/setters
}


The @GeneratedValue annotation with GenerationType.IDENTITY strategy is typically used in Hibernate to generate primary key values for entities automatically. It is commonly applied to the field or property that represents the primary key of an entity class.

Here's an explanation of the @GeneratedValue(strategy = GenerationType.IDENTITY) annotation and its use:

@GeneratedValue: This annotation is used to indicate that the value of the annotated field or property should be automatically generated.

strategy: The strategy attribute specifies the strategy to be used for generating the primary key value. In this case, GenerationType.IDENTITY is used, which is specifically for databases that support auto-incrementing columns.

GenerationType.IDENTITY: This strategy relies on an auto-incrementing column in the database. When a new row is inserted into the table, the database generates a unique primary key value automatically, without the need for any additional logic or code in the application.

By using @GeneratedValue(strategy = GenerationType.IDENTITY), Hibernate will automatically assign a unique primary key value to the entity object when it is saved to the database. The actual generation of the primary key value is handled by the database itself.

Here's an example usage of @GeneratedValue(strategy = GenerationType.IDENTITY):

java
Copy code
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields and getters/setters
}
In this example, the id field is annotated with @Id to indicate that it is the primary key. The @GeneratedValue(strategy = GenerationType.IDENTITY) annotation specifies that the primary key value will be automatically generated by the database using an auto-incrementing column.

This strategy is commonly used when working with databases like MySQL, PostgreSQL, and SQL Server that support auto-incrementing columns for primary keys.

=================================================================================
The @Column annotation is used in Hibernate to customize the mapping between an entity's field or property and the corresponding database column. It provides various attributes to specify properties such as column name, data type, length, nullable, and more.

Here are some common attributes of the @Column annotation:

name: This attribute allows you to specify the name of the database column. By default, Hibernate uses the field or property name as the column name. However, you can override it by providing a different name using the name attribute. For example: @Column(name = "first_name").

nullable: The nullable attribute indicates whether the column can contain null values. By default, it is set to true, meaning the column allows null values. If you want to enforce non-nullability, you can set it to false. For example: @Column(nullable = false).

length: This attribute is used to specify the maximum length of a string column. It is applicable to fields or properties of type String. For example: @Column(length = 50).

unique: The unique attribute indicates whether the column should have a unique constraint. If set to true, it ensures that each value in the column must be unique across all rows in the table. For example: @Column(unique = true).

columnDefinition: The columnDefinition attribute allows you to provide a custom SQL fragment that defines the column's data type, constraints, and other characteristics. This is useful when you need to specify non-standard column definitions. For example: `@Column(columnDefinition = "VARCHAR(100)

 */