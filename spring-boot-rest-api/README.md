# Spring Boot REST API for Client Management

This project is a RESTful API built with Spring Boot 3.4.3, designed for managing client information. It utilizes an H2 in-memory database and Spring Data JDBC for data persistence.

## Features

- CRUD operations for client management
- Attributes for clients include:
  - Name
  - Lastname
  - Phone
  - Age
  - DNI

## Project Structure

```
spring-boot-rest-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── cascara
│   │   │           └── app
│   │   │               ├── SpringBootRestApiApplication.java
│   │   │               ├── controller
│   │   │               │   └── ClientController.java
│   │   │               ├── model
│   │   │               │   └── Client.java
│   │   │               ├── repository
│   │   │               │   └── ClientRepository.java
│   │   │               └── service
│   │   │                   └── ClientService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test
│       └── java
│           └── com
│               └── cascara
│                   └── app
│                       └── SpringBootRestApiApplicationTests.java
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd spring-boot-rest-api
   ```

2. **Run the application:**
   ```
   ./mvnw spring-boot:run
   ```

3. **Access the API:**
   The API will be available at `http://localhost:8080`.

## Usage

- **Create a client:** `POST /clients`
- **Get all clients:** `GET /clients`
- **Get a client by ID:** `GET /clients/{id}`
- **Update a client:** `PUT /clients/{id}`
- **Delete a client:** `DELETE /clients/{id}`

## Database

The project uses an H2 in-memory database, which is initialized with the schema defined in `src/main/resources/schema.sql`. 

## Testing

Unit tests are included in the `src/test/java/com/cascara/app/SpringBootRestApiApplicationTests.java` file to ensure the application functions as expected.

## License

This project is licensed under the MIT License.