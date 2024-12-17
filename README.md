# **Quiz App - Spring Boot🚀**

## **Overview**
This project is a RESTful API-based **Quiz Application** built using **Spring Boot**, an in-memory **H2 Database**, and standard JPA/Hibernate for persistence. The application allows users to start a quiz session, fetch random questions, submit answers, and retrieve a detailed quiz summary. 

The implementation is designed for simplicity, clarity, and extensibility, adhering to **clean code principles** and industry best practices.

---

## **Features**
1. **Start New Quiz Session**: Allows a user to start a fresh quiz session.
2. **Fetch Random Questions**: Retrieves random multiple-choice questions without revealing the correct answer.
3. **Submit Answers**: Tracks user answers and evaluates correctness.
4. **View Quiz Summary**: Displays the total questions answered, correct answers, correctness percentage, and a detailed breakdown of correct/incorrect submissions.
5. **Pre-seeded Data**: A set of programming-related questions is preloaded into the in-memory H2 database for immediate testing.

---

## **Technologies Used**
- **Java 17**: The project is implemented using Java 17 features.
- **Spring Boot 3.4.0**: Provides a lightweight and fast RESTful API development framework.
- **Spring Data JPA**: Simplifies database interactions and ORM.
- **H2 Database**: An in-memory database for rapid development and testing.
- **Maven**: Dependency and build management tool.
- **Postman**: Used for API testing and validation.
- **JUnit**: Unit testing framework for service and repository layers.

---

## **Architecture**

The application follows a **layered architecture** for maintainability:

1. **Controller Layer**: Exposes RESTful endpoints.
2. **Service Layer**: Implements business logic.
3. **Repository Layer**: Communicates with the H2 database using JPA.
4. **Entity Layer**: Defines the database schema.
5. **DTO Layer**: Encapsulates data transferred between layers.

---

## **Endpoints**

| **Method** | **Endpoint**                   | **Description**                           | **Parameters**               |
|------------|--------------------------------|-------------------------------------------|------------------------------|
| **POST**   | `/api/quiz/start`              | Start a new quiz session                  | `userId` (Query Param)       |
| **GET**    | `/api/quiz/question`           | Fetch a random multiple-choice question   | None                         |
| **POST**   | `/api/quiz/submit`             | Submit an answer to a question            | `userId`, `questionId`, `option` |
| **GET**    | `/api/quiz/summary`            | Retrieve quiz summary and answer details  | `userId` (Query Param)       |

---

## **Setup and Installation**

### **Prerequisites**
- **Java 17** or higher
- **Maven** (for build management)
- Postman or any REST API testing tool.

---

### **Steps to Run Locally**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Apocalypse96/QuizApp-API.git
   cd quiz-app-spring-boot
   ```

2. **Build and Run the Project**
   ```bash
   ./mvnw clean package
   ./mvnw spring-boot:run
   ```

3. **Access the APIs**
   - Base URL: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
     - **JDBC URL**: `jdbc:h2:mem:testdb`
     - **Username**: `sa`  
     - **Password**: (leave blank)

---

### **Database Configuration**

The H2 database is pre-populated with programming-related questions using `data.sql` and the schema defined in `schema.sql`.

**Sample Questions**:
1. What does JVM stand for?
2. Which keyword is used to define a constant in Java?
3. Which data structure uses LIFO?
4. What is the time complexity of binary search?
5. Who is the creator of Python?

---

## **Testing**

### **Postman Testing Steps**
1. **Start a Quiz Session**:
   - `POST /api/quiz/start?userId=1`
2. **Fetch a Random Question**:
   - `GET /api/quiz/question`
3. **Submit an Answer**:
   - `POST /api/quiz/submit?userId=1&questionId=1&option=B`
4. **Retrieve Quiz Summary**:
   - `GET /api/quiz/summary?userId=1`

---

### **Example Quiz Summary Response**

```json
{
    "totalQuestionsInDB": 5,
    "totalQuestionsAnswered": 3,
    "correctAnswers": 2,
    "correctAnswerPercentage": 66.67,
    "questionResults": {
        "1": "Correct",
        "2": "Incorrect",
        "3": "Correct"
    }
}
```

---

## **Assumptions**

1. Each **userId** represents a unique user. Sessions are tracked per user.
2. The database is **reset** on each application startup using the H2 in-memory database.
3. Questions are **pre-seeded** using `data.sql` for immediate testing.
4. Each user can only answer a question once per session.

---

## **Enhancements**

The following enhancements can be added for future improvements:
1. **User Management**: Support for user registration and login.
2. **Dynamic Question Creation**: APIs to add, edit, or delete questions.
3. **Pagination**: Fetch questions in a paginated manner for large databases.
4. **Detailed Metrics**: Include metrics like average response time, skipped questions, etc.
5. **Swagger Documentation**: Integrate Swagger UI for better API documentation.

---

## **Project Structure**

```
quiz-app-spring-boot/
│
├── src/main/java/org/example/quiz
│   ├── controller        # REST Controller
│   ├── dto               # Data Transfer Objects
│   ├── entity            # JPA Entities
│   ├── repository        # Data Repositories
│   ├── service           # Business Logic
│   └── QuizApplication.java # Main Spring Boot Application
│
├── src/main/resources
│   ├── application.properties # Configuration
│   ├── schema.sql             # DB Schema
│   ├── data.sql               # Pre-seeded Questions
│
├── src/test/java/org/example/quiz
│   └── QuizApplicationTests.java # Unit Tests
│
├── pom.xml                  # Maven Dependencies
└── README.md                # Project Documentation
```

---

 
