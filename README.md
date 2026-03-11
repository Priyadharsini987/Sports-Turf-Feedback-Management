# Sports Turf Feedback Management System

A backend-based web application that allows users to submit feedback for sports turf facilities. The system stores and manages feedback efficiently using a database and provides APIs for creating, viewing, updating, and deleting feedback.

## Features
- Submit feedback for sports turf facilities
- View all feedback entries
- Update existing feedback
- Delete feedback records
- RESTful API-based backend architecture
- Structured database storage using MySQL

## Tech Stack

**Backend**
- Java
- Spring Boot

**Database**
- MySQL
- SQL

**Tools**
- Maven
- Git

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| POST | /feedback | Submit new feedback |
| GET | /feedback | Retrieve all feedback |
| PUT | /feedback/{id} | Update feedback |
| DELETE | /feedback/{id} | Delete feedback |

## Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── model
 └── resources
```

## How to Run the Project

1. Clone the repository

```
git clone https://github.com/Priyadharsini987/Sports-Turf-Feedback-Management.git
```

2. Navigate to the project directory

```
cd Sports-Turf-Feedback-Management
```

3. Configure the database in `application.properties`

4. Run the Spring Boot application

```
mvn spring-boot:run
```

## Future Improvements
- User authentication
- Rating system (1–5 stars)
- Admin dashboard for managing feedback
- Analytics for feedback trends

## Author
Priyadharsini V  
B.E Computer Science Engineering
