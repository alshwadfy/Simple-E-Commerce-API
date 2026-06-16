# Simple E-Commerce REST API

A Spring Boot REST API for managing products, categories, and user authentication using JWT.

## Features

* User Registration & Login
* JWT Authentication
* Role-Based Authorization (ADMIN / CUSTOMER)
* Product Management
* Category Management
* Spring Security Integration
* RESTful API Design

## Tech Stack

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT (JSON Web Token)
* Maven
* MySQL
* ModelMapper

## Project Structure

```text
src/main/java/com/SimpleE_Commerce/Demo
│
├── Config
├── Controllers
├── DTO
├── Entity
├── Repository
├── Security
└── Service
```

## API Endpoints

### Authentication

| Method | Endpoint           | Description                 |
| ------ | ------------------ | --------------------------- |
| POST   | /api/auth/register | Register a new user         |
| POST   | /api/auth/login    | Login and receive JWT token |

### Products

| Method | Endpoint           | Access              |
| ------ | ------------------ | ------------------- |
| GET    | /api/products      | Authenticated Users |
| GET    | /api/products/{id} | Authenticated Users |
| POST   | /api/products      | ADMIN               |
| PUT    | /api/products/{id} | ADMIN               |
| DELETE | /api/products/{id} | ADMIN               |

### Categories

| Method | Endpoint             | Access              |
| ------ | -------------------- | ------------------- |
| GET    | /api/categories      | Authenticated Users |
| DELETE | /api/categories/{id} | ADMIN               |

## Security

The application uses JWT authentication.

After login, include the token in requests:

```http
Authorization: Bearer YOUR_JWT_TOKEN
```

## Running the Project

### Clone Repository

```bash
git clone <repository-url>
cd Simple-E-Commerce-API
```

### Configure Database

Update `application.properties` with your database credentials.

### Run Application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

## Example Login Request

```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

## Author

Ezz Al-din
