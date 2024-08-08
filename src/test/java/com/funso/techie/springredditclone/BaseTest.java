package com.funso.techie.springredditclone;


import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import org.testcontainers.containers.MySQLContainer;

public abstract class BaseTest {


    static MySQLContainer<?> mysql = new MySQLContainer<>(
            "mysql:latest"
    );

    static {
        mysql.start();
        Runtime.getRuntime().addShutdownHook(new Thread(mysql::stop));
    }

    public static void configureRestAssured(Integer port) {
        RestAssured.baseURI = "http://localhost:" + port;
    }

//    @BeforeAll
//    static void beforeAll() {
//        postgres.start();
//    }

    @AfterAll
    static void afterAll() {
        mysql.stop();
    }

//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//    }

    @DynamicPropertySource
    public static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto",() -> "create");
    }

}
