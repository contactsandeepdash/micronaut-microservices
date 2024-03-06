package com.dash.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.json.tree.JsonNode;

@ConfigurationProperties("hello.world")
public interface HelloWorldConfig {

    @NonNull
    String getMessage();

//    JsonNode getTranslation();

}
