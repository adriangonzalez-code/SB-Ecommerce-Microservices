# Ecommerce Application

## Overview

This is a Java-based ecommerce application built using Spring Boot and Jakarta EE. The application implements a RESTful
API architecture for managing users in an ecommerce system.

## Technical Stack

- Java 17
- Spring Boot
- Jakarta Persistence (JPA)
- Spring Web (REST)
- Lombok
- H2/MySQL Database

## Project Structure and Architecture

The application follows a layered architecture:

- Controllers: Handle HTTP requests and responses
- Services: Implement business logic
- Repositories: Handle data persistence
- DTOs: Data Transfer Objects for entity mapping

## Key Technical Concepts

### Jakarta Persistence (JPA)

- Entity mapping with `@Entity` annotation
- Primary key generation using `@Id` and `@GeneratedValue`
- Column mapping using `@Column`

### Spring REST Controllers

- REST endpoint mapping with `@RestController`
- Request mapping using `@RequestMapping`
- HTTP method handlers (`@GetMapping`, `@PostMapping`, `@PutMapping`)
- Response entity management with `ResponseEntity`

### Lombok

- Reduces boilerplate code with annotations
- `@Getter`, `@Setter` for automatic accessor methods
- `@NoArgsConstructor`, `@AllArgsConstructor` for constructors
- `@Builder` for builder pattern implementation
- `@RequiredArgsConstructor` for dependency injection

## API Endpoints

### User Management

- GET `/api/users` - Retrieve all users
- GET `/api/users/{id}` - Retrieve user by ID
- POST `/api/users` - Create new user
- PUT `/api/users/{id}` - Update existing user

## Setup and Installation

1. Clone the repository
2. Configure database properties in `application.properties`
3. Run `mvn clean install`
4. Start the application with `mvn spring-boot:run`

## Database Schema

### Users Table

- id (Long, Primary Key)
- first_name (String)
- last_name (String)
