package com.dash.controller;

import com.dash.configuration.HelloWorldConfig;
import com.dash.configuration.HelloWorldTranslationConfig;
import com.dash.service.HelloWorldService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/")
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Inject
    HelloWorldService helloWorldService;

    @Inject
    HelloWorldConfig helloWorldConfig;

    @Inject
    HelloWorldTranslationConfig helloWorldTranslationConfig;


    @Get(produces = MediaType.TEXT_PLAIN)
    public String welcome() {
        logger.debug("Called the Welcome API!");
        return helloWorldService.welcomeFromService();
    }

    @Get(uri = "/hello", produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return helloWorldService.helloWorldFromService();
    }

    @Get(uri = "/config", produces = MediaType.TEXT_PLAIN)
    public String helloFromConfig() {
        logger.debug("Return Hello from config message: {}", helloWorldConfig.getMessage());
        return helloWorldConfig.getMessage();
    }

    @Get(uri = "/translation", produces = MediaType.APPLICATION_JSON)
    public HelloWorldTranslationConfig helloTranslation() {
        logger.debug("Return translated Hello from config message: {}", helloWorldTranslationConfig);
        return helloWorldTranslationConfig;
    }
}
