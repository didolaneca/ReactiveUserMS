package com.dido.reactive;

import com.dido.reactive.hello.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);

		GreetingWebClient webClient = new GreetingWebClient();
		System.out.println(webClient.getResult());
	}

}
