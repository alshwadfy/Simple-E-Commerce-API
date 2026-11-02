# Simple E-Commerce REST API

A Spring Boot RESTful backend for managing products, categories, and user authentication with JWT security and role-based access control.

---

## Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Language** | Java 21 |
| **Framework** | Spring Boot 3 |
| **Security** | Spring Security + JWT |
| **Database** | MySQL |
| **ORM** | Spring Data JPA / Hibernate |
| **Build Tool** | Maven |
| **Object Mapping** | ModelMapper |

---

## Features

- **Stateless Authentication**: JWT token issuance with BCrypt password hashing.
- **Role-Based Access Control (RBAC)**: Fine-grained method security (`@PreAuthorize`) separating `ADMIN` from authenticated `CUSTOMER` operations.
- **Product Management**: Full CRUD operations with category association and DTO conversion.
- **Category Management**: Category listing and administrative deletion.
- **Global Exception Handling**: Custom exceptions mapped to clear HTTP error responses.

---

## API Endpoints

### 🔐 Authentication

| Method | Endpoint | Access | Description |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/auth/register` | Public | Register a new user account |
| `POST` | `/api/auth/login` | Public | Authenticate credentials and receive JWT Bearer token |

### 📦 Products

| Method | Endpoint | Access | Description |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/products` | Authenticated | Retrieve all products |
| `GET` | `/api/products/{id}` | Authenticated | Retrieve product details by ID |
| `POST` | `/api/products` | `ADMIN` only | Create a new product |
| `PUT` | `/api/products/{id}` | `ADMIN` only | Update product details |
| `DELETE` | `/api/products/{id}` | `ADMIN` only | Delete a product |

### 🗂️ Categories

| Method | Endpoint | Access | Description |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/categories` | Authenticated | Retrieve all categories |
| `DELETE` | `/api/categories/{id}` | `ADMIN` only | Delete a category by ID |

---

## Getting Started

### Prerequisites
- Java 21+
- MySQL 8+
- Maven

### 1. Database Setup
Create a MySQL database:
```sql
CREATE DATABASE ecommerce_db;
```

Update your `src/main/resources/application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 2. Build & Run
```bash
# Clone the repository
git clone https://github.com/alshwadfy/Simple-E-Commerce-API.git
cd Simple-E-Commerce-API

# Run with Maven Wrapper
./mvnw spring-boot:run
```

API will be available at `http://localhost:8080`.

### 3. Authentication Flow
Send a POST request to `/api/auth/login`:
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

Include the returned token in subsequent requests:
```http
Authorization: Bearer <your-jwt-token>
```