package com.dash.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.SerdeImport;

@ConfigurationProperties("hello.world.translation")
@SerdeImport
public interface HelloWorldTranslationConfig {

    @NonNull
    String getDe();

    @NonNull
    String getEn();
}
