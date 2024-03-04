package com.dash;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class HelloWorldControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void welcomeEndpointResponseWithProperContent() {
        String response = httpClient.toBlocking().retrieve("/");
        Assertions.assertEquals("Welcome to Micronaut from service!",response);
    }

    @Test
    void helloWorldEndpointResponseWithProperContent() {
        String response = httpClient.toBlocking().retrieve("/hello");
        Assertions.assertEquals("Hello from service!",response);
    }
}
