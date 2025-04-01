# Spring Boot Microservices Project

**Student:** Armat  
**Branch:** main  
**Commit Hash:** 1bb0dba4579a9a876295c141898bad6d7076ca6e

## What I Built

### Eureka Server:

- **Eureka Server** is implemented using `spring-cloud-starter-netflix-eureka-server`. It provides service discovery for all microservices.
- **Port:** 8761
- **Functionality:** Registers microservices (like `student-service`, `employee-service`, and `address-service`) and allows them to communicate with each other dynamically.

### API Gateway:

- **API Gateway** is implemented using `spring-cloud-starter-gateway`. It routes requests to appropriate microservices based on predefined routes.
- **Port:** 8085
- **Route Configuration:**
  - `/students/**` → `student-service` at `http://localhost:9090`
  - `/employees/**` → `employee-service` at `http://localhost:9091`

### Student-Service:

- **Student-Service** is a RESTful service that provides information about students.
- **Port:** 9090
- **Endpoints:**
  - `/students/{id}` → Returns student details by ID (e.g., name, major, and hobby).
  - `/students/by-favorite-sport/{favoriteSport}` → Returns a list of students by their favorite sport.

### Employee-Service:

- **Employee-Service** is a RESTful service that provides information about employees.
- **Port:** 9091
- **Endpoints:**
  - `/employees/{id}` → Returns employee details by ID (e.g., name and favorite color).
  - `/employees/by-favorite-color/{favoriteColor}` → Returns a list of employees by their favorite color.
  - `/employees/{id}/address` → Returns the address of an employee by calling `Address-Service` using **FeignClient**.

### Address-Service:

- **Address-Service** provides address details for employees.
- **Port:** 9092
- **Endpoints:**
  - `/address/{employeeId}` → Returns the address of an employee by their ID.

### Unique Features:

- **Student-Service** has an additional endpoint `/students/by-favorite-sport/{favoriteSport}` to find students by their favorite sport.
- **Employee-Service** calls `Address-Service` to retrieve and display an employee's address.

## Why These Technologies

### Eureka Server:

- **Eureka** is used for service discovery. It allows microservices to automatically register and discover each other, facilitating communication between services.

### API Gateway:

- **API Gateway** simplifies routing, load balancing, and centralizes access control for various microservices. It acts as a reverse proxy, forwarding requests to appropriate backend services.

### FeignClient:

- **FeignClient** is used in `employee-service` to communicate with `address-service`. It abstracts the HTTP communication and makes it easier to call RESTful services.

### Why These Features Matter:

- The ability to route requests efficiently and dynamically discover services allows the system to scale and be flexible.
- **FeignClient** simplifies communication between services, reducing the amount of boilerplate code needed for making REST API calls.

## How to Run

1. **Ensure that Eureka Server is running on** `http://localhost:8761`:

   - Navigate to the **Eureka Server** directory and run:
     ```bash
     ./mvnw spring-boot:run
     ```

2. **Run Student-Service on port 9090**:

   - Navigate to the **Student-Service** directory and run:
     ```bash
     ./mvnw spring-boot:run
     ```

3. **Run Employee-Service on port 9091**:

   - Navigate to the **Employee-Service** directory and run:
     ```bash
     ./mvnw spring-boot:run
     ```

4. **Run Address-Service on port 9092**:

   - Navigate to the **Address-Service** directory and run:
     ```bash
     ./mvnw spring-boot:run
     ```

5. **Start API Gateway on port 8085**:

   - Navigate to the **API Gateway** directory and run:
     ```bash
     ./mvnw spring-boot:run
     ```

6. Once all services are running, you can test the endpoints using **Postman**.

## Test with Postman

You can test the **API Gateway** by sending requests to the following endpoints:

- `GET http://localhost:8085/api/students/{id}`
  - Returns the details of the student with the provided ID.
- `GET http://localhost:8085/api/students/by-favorite-sport/{favoriteSport}`

  - Returns a list of students who have the given favorite sport.

- `GET http://localhost:8085/api/employees/{id}`

  - Returns the details of the employee with the provided ID.

- `GET http://localhost:8085/api/employees/by-favorite-color/{favoriteColor}`

  - Returns a list of employees who have the given favorite color.

- `GET http://localhost:8085/api/employees/{id}/address`
  - Returns the address of the employee with the provided ID by calling **Address-Service**.
