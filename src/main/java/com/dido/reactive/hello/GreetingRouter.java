package com.dido.reactive.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        greetingHandler::helloGet)
                .andRoute(
                        RequestPredicates.POST("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        greetingHandler::helloPost)
                .andRoute(
                        RequestPredicates.POST("/hello")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        greetingHandler::helloPost)
                ;
    }
}