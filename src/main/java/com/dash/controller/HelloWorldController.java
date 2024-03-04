package com.dash.controller;

import com.dash.service.HelloWorldService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/")
public class HelloWorldController {

    @Inject
    HelloWorldService helloWorldService;

    @Get(produces = MediaType.TEXT_PLAIN)
    public String welcome() {
        return helloWorldService.welcomeFromService();
    }

    @Get(uri = "hello", produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return helloWorldService.helloWorldFromService();
    }
}
