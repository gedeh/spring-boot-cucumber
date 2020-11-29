# Cucumber in Spring Boot using Dependency Injection

This code sample shows how to use Dependency Injection in Cucumber within a Spring Boot application.

## Run the Spring Boot app

```bash
mvn -q spring-boot:run
```

The server will be available in [http://localhost:8090/things](http://localhost:8090/things)

## Run the Cucumber test

```bash
mvn -q test -Dcucumber.filter.tags="not @wip"
```

Then see the report in [target/cucumber/bag.html](./target/cucumber/bag.html)

## Complete Instructions

You can find the complete instructions on this post at The Practical Developer site: [Cucumber Tests in Spring Boot with Dependency Injection](https://thepracticaldeveloper.com/2018/03/31/cucumber-tests-spring-boot-dependency-injection/)

![Cucumber and Dependency Injection in a Spring Boot App - The Practical Developer](images/cucumber-spring-boot.png)
