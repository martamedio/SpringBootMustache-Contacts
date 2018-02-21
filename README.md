# Spring Boot CRUD with Mustache - Contacts Management

This is a Spring Boot (version 1.5.9) application that implements a simple way to delete and add contacts (Name - Phone) in a memory database (H2) with a frontend build with Mustache.

### Pre-requisities

You'll need:
```
* Java 1.8
* Maven
```

### Small Configuration
There's a file `application.properties` with configuration for get the application working: 
- `server.port`: Set the port for launch the API system
- `spring.datasource...`: H2 Memory Database configuration

## Running it!

In a terminal window, at the directory, type on the command line: `mvn spring-boot:run`, the application will launch on `http://localhost:9090/` (remember that you can change the port at `application.properties`)