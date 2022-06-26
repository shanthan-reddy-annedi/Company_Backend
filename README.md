# Company UserData Application Using Spring Boot, Spring Security, JWT, JPA and MySql

## Requirements

1. Java >= java 11

2. Maven - 3.x.x

3. Mysql - 5.x.x

4. lombok

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/shanthan-reddy-annedi/Company_Backend.git
```

**3. Change mysql username and password as per your Mysql installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Running the application in the IDE**

+ after changing both the username and password as per your mysql installation
+ we can run it from NeatBeans or intellij IDEA.

**5. Build and running the app using maven**

+ open the terminal in the project folder and run the following commands.

```bash
mvn package
java -jar target/CompanyDetails-0.0.1-SNAPSHOT
```

+ We can use below command to run the program. if there already exist a executable jar.

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080/>.

## Explore Rest APIs

+ We can see the API Documentation at

```bash
    http://localhost:8080/swagger-ui.html
```

+ we need to have privileges to run the other Api's.

## Creating New User.
+ We can Create a User To access our application using below endpoint. which needs to no privilege to access.

```bash
 POST http://localhost:8080/api/create/user
```

+ Body of the request is shown below.

```bash
{
    "username":"shanthan reddy",
    "password":"83355806",
    "authorities":"ADMIN"
}
```
+ authorities can be either READ or ADMIN only.
+ the password has to be 8-10 letters length

![img.png](https://user-images.githubusercontent.com/76593616/175810481-24e16bb6-8e0b-449f-9ca1-b917952321da.png)

## Accessing POST OR GET API'S

+ to access the post or get api's we need to have an JWT access token.

+ we can get that token when we log in to the server. using :

```bash
http://localhost:8080/login
```

![img_1.png](https://user-images.githubusercontent.com/76593616/175809616-e4b74a6a-ad44-45ce-aad0-6d073cb630f9.png)

+ after we get the token when we want to access to any API we need to send the token in Authorization header
+ value of Authorization has to start with Bearer. as shown

![img_2.png](https://user-images.githubusercontent.com/76593616/175809623-dfaa9b31-264b-435c-8aef-50dfecf682d8.png)

+ the body of the post request is: 
![img_3.png](https://user-images.githubusercontent.com/76593616/175809625-e92fe677-6e21-4807-ae1f-488eef039fd2.png)

+ Accessing the Api's without JWT token or privilege gives 403 error.
+ POST requests need to have ADMIN as privilege.
+ GET requests can have Both ADMIN or READ privilege.