package com.example.unitteste.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    HelloWorldController helloWorldController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(helloWorldController).isNotNull();
    }

    @Test
    @DisplayName("Deveria retornar Hello World")
    void getMessage() {

        assertThat(this.restTemplate.getForObject("http://localhost:"+ port +"/hello",
                String.class)).contains("Hello World");
    }
}