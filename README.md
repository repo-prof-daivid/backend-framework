# Kotlin, Spring Boot, MySQL, JPA, Hibernate Rest API

Build a Restful CRUD API using Kotlin, Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 11

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/Uni-Turmas-2023-1/backend-framework.git
```

**2. Create Mysql database**
```bash
create database management
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Running the App**

Type the following command in your terminal to run the app -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.



You can test them using postman or any other rest client.