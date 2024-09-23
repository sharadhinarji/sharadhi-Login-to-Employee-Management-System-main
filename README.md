Login to Employee Management System

Overview

The Employee Management System is a web-based application designed to streamline human resource functions by managing employee data efficiently. 
It allows businesses to manage employee records, such as employee id,employee name,employee email address ,employee password and track performance. It also offers the ability to assign unique IDs to employees manually.

Features:
Employee Management:

Add, update, and remove employees.
Manually assign employee IDs instead of auto-generating them.

Technologies Used:
Backend: Spring Boot
Frontend: HTML, CSS, JavaScript
IDE for Backend: IntelliJ IDEA
IDE for Frontend: Visual Studio Code
Database: MySQL

Getting Started:
Prerequisites:
Java 11 or higher
Maven
MySQL Database
IntelliJ IDEA (for backend development)
Visual Studio Code (for frontend development)

Configure Database Connection:
Open the src/main/resources/application.properties file.
Update the following properties for your MySQL setup:
Configure Database Connection**:
spring.application.name=RegisterLogin
server.port=1872
spring.datasource.url=jdbc:mysql://localhost:1872/dkdata?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQLDialect

Running the Application
Backend:

Open IntelliJ IDEA.
Import the project and ensure all dependencies are set up (you can use Spring Initializr to generate the initial project).
Open src\main\java\com\RegisterLogin\RegisterLogin\RegisterLoginApplication.java.
Run the Spring Boot application.
Frontend:

Open the index.html file in Visual Studio Code.
You can use Live Server or open the HTML file directly in a web browser to view the application.

