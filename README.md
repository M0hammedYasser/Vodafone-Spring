# Employee Management API 🚀

A comprehensive Spring Boot application for managing employees with full CRUD operations, featuring a modern Angular frontend and enterprise-grade architecture.

## 📋 Table of Contents
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [API Documentation](#-api-documentation)
- [Quick Start](#-quick-start)
- [API Endpoints](#-api-endpoints)
- [Frontend Setup](#-frontend-setup)
- [Configuration](#-configuration)
- [Contributing](#-contributing)

## ✨ Features

- **Complete CRUD Operations** - Create, Read, Update, and Delete employees
- **RESTful API Design** - Following REST principles and best practices
- **DTO Pattern Implementation** - Clean separation between entities and API contracts
- **Global Exception Handling** - Centralized error management
- **Interactive API Documentation** - Swagger/OpenAPI 3.0 integration
- **Modern Frontend** - Angular 17 with Bootstrap 5 styling
- **User Experience** - SweetAlert2 for elegant notifications
- **Data Validation** - Input validation and error handling
- **Responsive Design** - Mobile-friendly interface

## 🛠 Tech Stack

### Backend
- **Framework:** Spring Boot 3.2+
- **Data Access:** Spring Data JPA
- **Database:** MySQL 8.0+
- **Documentation:** springdoc-openapi 2.0+
- **Build Tool:** Maven 3.8+
- **Java Version:** 17+

### Frontend
- **Framework:** Angular 17
- **UI Framework:** Bootstrap 5
- **Notifications:** SweetAlert2
- **HTTP Client:** Angular HttpClient

## 📚 API Documentation

### Swagger UI Access
Once the application is running, access the interactive API documentation:

**Local Environment:**
```
http://localhost:8080/swagger-ui/index.html
```

**OpenAPI JSON:**
```
http://localhost:8080/v3/api-docs
```

### API Base URL
```
http://localhost:8080/api/v1
```

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.8+
- MySQL 8.0+
- Node.js 18+ (for frontend)
- Angular CLI 17+

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/M0hammedYasser/Vodafone-Spring.git
   cd Vodafone-Spring
   ```

2. **Configure database**
   ```bash
   # Create MySQL database
   mysql -u root -p
   CREATE DATABASE vodafone;
   ```

3. **Update application properties**
   ```properties
   # src/main/resources/application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/vodafone
   spring.datasource.username=root
   spring.datasource.password=root
   ```

4. **Run the application**
   ```bash
   # Using Maven
   mvn clean install
   mvn spring-boot:run
   
   # Or using Maven wrapper
   ./mvnw spring-boot:run
   ```

5. **Verify installation**
    - Application: http://localhost:8080
    - Swagger UI: http://localhost:8080/swagger-ui/index.html
    - Health Check: http://localhost:8080/actuator/health

## 🔗 API Endpoints

### Employee Management

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/api/v1/employees` | Retrieve all employees | - | `List<EmployeeDTO>` |
| `GET` | `/api/v1/employees/{id}` | Get employee by ID | - | `EmployeeDTO` |
| `POST` | `/api/v1/employees` | Create new employee | `EmployeeCreateDTO` | `EmployeeDTO` |
| `PUT` | `/api/v1/employees/{id}` | Update existing employee | `EmployeeUpdateDTO` | `EmployeeDTO` |
| `DELETE` | `/api/v1/employees/{id}` | Delete employee | - | `204 No Content` |

### Sample Request/Response

#### Create Employee
**POST** `/api/v1/employees`
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@company.com",
  "position": "Software Developer"
}
```

**Response:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@company.com",
  "position": "Software Developer"
}
```

## 🎨 Frontend Setup

### Prerequisites
- Node.js 18+
- Angular CLI 17+

### Installation Steps

1. **Navigate to frontend directory**
   ```bash
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Configure API endpoint**
   ```typescript
   // src/environments/environment.ts
   export const environment = {
     url: 'http://localhost:8080/'
   };
   ```

4. **Run development server**
   ```bash
   ng serve
   ```

5. **Access application**
   ```
   http://localhost:4200
   ```

## ⚙️ Configuration

### Database Configuration
```properties
# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/${database:vodafone}?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=${password:root}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
