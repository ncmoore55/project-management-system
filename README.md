# Project Management System

A full-stack project management application built with **Java, Spring Boot, Angular, TypeScript, and PostgreSQL**.

This project was developed to strengthen my software engineering skills through hands-on experience building and integrating a REST API, relational database, and interactive frontend.

## Technologies Used

**Backend**
- Java 21
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL

**Frontend**
- Angular
- TypeScript
- HTML
- CSS

**Development Tools**
- IntelliJ IDEA
- Git and GitHub
- Postman

## Features

- Create new projects
- View existing projects
- Update project names, descriptions, and statuses
- Delete projects
- Track project status with dashboard statistics
- Responsive black-and-gold dashboard interface
- Persistent project storage using PostgreSQL

## Application Architecture

Angular Frontend → Spring Boot REST API → PostgreSQL Database

The Angular frontend communicates with the Spring Boot backend through HTTP requests. Spring Data JPA handles database operations.

## REST API Endpoints

The Spring Boot backend provides four REST API endpoints:

- **GET** `/api/projects` - Retrieve all projects
- **POST** `/api/projects` - Create a new project
- **PUT** `/api/projects/{id}` - Update an existing project
- **DELETE** `/api/projects/{id}` - Delete a project

## Running Locally

**Prerequisites:** Java 21, Node.js, npm, and PostgreSQL.

1. Create a PostgreSQL database named `project_management_db`.
2. Configure the backend database connection and `DB_PASSWORD` environment variable.
3. Start the Spring Boot application.
4. Navigate to the `frontend` directory.
5. Run `npm install`, followed by `npm start`.
6. Open `http://localhost:4200`.

The Spring Boot API runs on port `8080`.

## What I Learned

- Designing RESTful endpoints using Spring Boot
- Using JPA repositories for database operations
- Connecting Angular to a Java backend
- Handling asynchronous HTTP requests
- Implementing CRUD functionality
- Debugging API requests with Postman
- Using Git and GitHub to track development progress

## Future Improvements

- Automated backend and frontend tests
- Improved input validation and error handling
- Enhanced project editing interface
- Additional project management functionality
