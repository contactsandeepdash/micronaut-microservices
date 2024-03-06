package com.dash;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.tree.JsonNode;
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
        Assertions.assertEquals("Welcome to Micronaut from service!", response);
    }

    @Test
    void helloWorldEndpointResponseWithProperContent() {
        String response = httpClient.toBlocking().retrieve("/hello");
        Assertions.assertEquals("Hello from service!", response);
    }

    @Test
    void welcomeEndpointResponseWithCodeAndProperContent() {
        var response = httpClient.toBlocking().exchange("/", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
        Assertions.assertEquals("Welcome to Micronaut from service!", response.getBody().get());
    }

    @Test
    void helloWorldEndpointResponseWithCodeAndProperContent() {
        var response = httpClient.toBlocking().exchange("/hello", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
        Assertions.assertEquals("Hello from service!", response.getBody().get());
    }

    @Test
    void helloFromConfigEndpointReturnsMessageFromConfigFile() {
        var response = httpClient.toBlocking().exchange("/config", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
        Assertions.assertEquals("Hello from application.yml", response.getBody().get());
    }

//    @Test
//    void helloTranslationEndpointReturnsMessage() {
//        var response = httpClient.toBlocking().exchange("/translation", JsonNode.class);
//        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
//        Assertions.assertEquals("{\"de\":\"Hallo Welt\",\"en\":\"Hello World\"}", String.valueOf(response.getBody().get()));
//    }
}
