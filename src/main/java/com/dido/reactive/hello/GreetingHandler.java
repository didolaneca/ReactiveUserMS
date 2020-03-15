package com.dido.reactive.hello;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> helloGet(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring! \n From Dido :)"));
    }
    public Mono<ServerResponse> helloPost(ServerRequest request) {
        Mono<String> body = request.bodyToMono(String.class);

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(body, String.class);
    }
    public Mono<ServerResponse> helloPostJson(ServerRequest request) {
        Mono<String> body = request.bodyToMono(String.class);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(body, String.class);
    }
}
