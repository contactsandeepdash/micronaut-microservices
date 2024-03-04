package com.dash.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class HelloWorldController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String welcome() {
        return "Welcome to Micronaut!";
    }

    @Get(uri = "hello", produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World!";
    }
}
