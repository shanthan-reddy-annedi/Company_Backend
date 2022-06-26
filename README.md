# Company UserData Application Using Spring Boot, Spring Security, JWT, JPA and MySql

## Requirements

1. Java > java 11

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/shanthan-reddy-annedi/Company_Backend.git
```


**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Running the application in the IDE**

+ after changing both the username and password as per your mysql installation
+ we can run it from NeatBeans or intellij IDEA or Eclipse

**5. Build and run the app using maven**

+ open the terminal in the project folder and run the folling commands.

```bash
mvn package
java -jar target/
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

We can see the API Documentation at <http://localhost:8080/swagger-ui.html>


You can test them using postman or any other rest client.

## Learn more

You can find the tutorial for this application on my blog -

<https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/>
