# Company UserData Application Using Spring Boot, Spring Security, JWT, JPA and MySql

## Requirements

1. Java >= java 11

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
+ we can run it from NeatBeans or intellij IDEA.

**5. Build and run the app using maven**

+ open the terminal in the project folder and run the folling commands.

```bash
mvn package
java -jar target/
```

+ Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

+ We can see the API Documentation at


    http://localhost:8080/swagger-ui.html

+ we need to have privileges to run the Api's.

## Creating New User.
+ We can Create an User To access our application using below endpoint. which can be accessed by all.

```bash
 POST http://localhost:8080/api/create/user
```

+ Body of the request can be. authorities can be either read or admin only.

```bash
{
    "username":"shanthan reddy",
    "password":"83355806",
    "authorities":"ADMIN"
}
```



![img.png](https://user-images.githubusercontent.com/76593616/175810481-24e16bb6-8e0b-449f-9ca1-b917952321da.png)

+ the password has to be 8-10 letters length

## Accessing POST OR GET API'S

+ to access the post or get api's we need to have an JWT access token
+ we can get that token when we login to the server. using :


    http://localhost:8080/login

![img_1.png](https://user-images.githubusercontent.com/76593616/175809616-e4b74a6a-ad44-45ce-aad0-6d073cb630f9.png)

+ after we get the token when we want to access to any API we need to send the token in Authorization header
+ value of Authorization has to start with Bearer. as shown

![img_2.png](https://user-images.githubusercontent.com/76593616/175809623-dfaa9b31-264b-435c-8aef-50dfecf682d8.png)

+ the body of the post request is: 
![img_3.png](https://user-images.githubusercontent.com/76593616/175809625-e92fe677-6e21-4807-ae1f-488eef039fd2.png)

+ 