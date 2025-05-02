package com.example.gateway.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerGatewayConfig {

    @Bean
    public GroupedOpenApi searchApi() {
        return GroupedOpenApi.builder()
                .group("searchModule")
                .pathsToMatch("/weather/**")
                .build();
    }

    @Bean
    public GroupedOpenApi detailsApi() {
        return GroupedOpenApi.builder()
                .group("detailsModule")
                .pathsToMatch("/details/**")
                .build();
    }

    @Bean
    public GroupedOpenApi studentManagementApi() {
        return GroupedOpenApi.builder()
                .group("studentManagementModule")
                .pathsToMatch("/students/**")
                .build();
    }

}